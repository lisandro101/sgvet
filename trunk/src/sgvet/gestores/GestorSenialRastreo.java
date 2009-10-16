package sgvet.gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.auxiliares.DemandaXPeriodo;

/**
 *
 * @author LUCIANO
 */
public class GestorSenialRastreo {

    private double[] demandaReal;
    private double[] pronostico;
    private double alfa;
    private double[] error;
    private double[] errorPromedio;
    private double[] MSE;
    private double[] desviacionEstandar;
    private double[] senialRastreo;
    private static GestorSenialRastreo instancia;

    public synchronized static GestorSenialRastreo getInstancia() {
        if (instancia == null) {
            instancia = new GestorSenialRastreo();
        }
        return instancia;
    }

    private GestorSenialRastreo() {
    }

    public GestorSenialRastreo(double[] demandaRealX, double[] pronosticoX,
            double gammaX, double[] errorX, double[] errorPromedioX,
            double[] MSEX, double[] desviacionEstandarX, double[] senialRastreoX) {
        /*Atener en cuanta, Hay 13 periodos de 28 y de ellos tiene que existir un pronostico
        por cada periodo, para cada producto. La senial de Rastreo se calcula a cierre del periodo */
        demandaReal = demandaRealX;
        pronostico = pronosticoX;
        alfa = gammaX;
        //error=new double[13];
        errorPromedio = errorPromedioX;
        MSE = MSEX;
        desviacionEstandar = desviacionEstandarX;
        senialRastreo = senialRastreoX;
    }

    public double[] Error(double[] demandaReal, double[] pronostico) {
        // demandaReal=DemandaRealX;
        error = new double[demandaReal.length];
        //pronostico=demandaReal;
        for (int i = 0; i < demandaReal.length; i++) {
            if (i == 0) {

                error[i] = 0;
            } else {
                error[i] = pronostico[i] - demandaReal[i];

            }
        }
        return error;
    }

    public double[] ErrorPromedio(double alfa, double[] error) {
        errorPromedio = new double[error.length];
        for (int i = 0; i < error.length; i++) {
            if (i == 0) {
                errorPromedio[i] = 0;
            } else {
                errorPromedio[i] = ((alfa * error[i]) + (1 - alfa) * errorPromedio[i - 1]);
            }
        }

        return errorPromedio;
    }

    public double[] MSE(double gamma, double[] error) {
        MSE = new double[error.length];
        for (int i = 0; i < error.length; i++) {
            if (i == 0) {
                MSE[i] = 0;
            } else {
                MSE[i] = ((gamma * (error[i] * error[i])) + ((1 - gamma) * MSE[i - 1]));
            }
        }

        return MSE;
    }

    public double[] DesviacionEstandar(double gamma, double[] MSE) {
        desviacionEstandar = new double[MSE.length];
        for (int i = 0; i < MSE.length; i++) {
            if (i == 0) {
                desviacionEstandar[i] = 0;
            } else {
                // desviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
                if ((2 - gamma) != 0) {
                    desviacionEstandar[i] = (Math.sqrt(MSE[i]) * Math.sqrt(gamma) / (2 - gamma));
                } else {
                    desviacionEstandar[i] = 0;
                }

            }
        //System.out.println(desviacionEstandar[i]);
        }

        return desviacionEstandar;
    }

    public double[] SenialRastreoFinal(double[] desviacionEstandar, double[] errorPromedio) {
        senialRastreo = new double[desviacionEstandar.length];
        for (int i = 0; i < desviacionEstandar.length; i++) {
            if (i == 0) {
                senialRastreo[i] = 0;
            } else {
                if (desviacionEstandar[i] != 0) {
                    senialRastreo[i] = errorPromedio[i] / desviacionEstandar[i];
                } else {
                    senialRastreo[i] = 0;
                }
            }
        }

        return senialRastreo;
    }

    public double[] SenialRastreoFinalFull(double[] demandaReal, double[] pronostico) {
        error = new double[demandaReal.length];
        errorPromedio = new double[demandaReal.length];
        MSE = new double[demandaReal.length];
        desviacionEstandar = new double[demandaReal.length];
        senialRastreo = new double[demandaReal.length];

        for (int i = 0; i < demandaReal.length; i++) {
            if (i == 0) {
                error[i] = 0;
            } else {
                error[i] = pronostico[i] - demandaReal[i];
            }
        }

        for (int i = 0; i < demandaReal.length; i++) {
            if (i == 0) {
                errorPromedio[i] = 0;
            } else {
                errorPromedio[i] = ((alfa * error[i]) + (1 - alfa) * errorPromedio[i - 1]);
            }
        }

        for (int i = 0; i < demandaReal.length; i++) {
            if (i == 0) {
                MSE[i] = 0;
            } else {
                MSE[i] = ((alfa * (error[i] * error[i])) + ((1 - alfa) * MSE[i - 1]));
            }
        }

        for (int i = 0; i < demandaReal.length; i++) {

            if (i == 0) {
                desviacionEstandar[i] = 0;
            } else {
                // desviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
                if ((2 - alfa) != 0) {
                    desviacionEstandar[i] = (Math.sqrt(MSE[i]) * Math.sqrt(alfa) / (2 - alfa));
                } else {
                    desviacionEstandar[i] = 0;
                }
            }
        }

        for (int i = 0; i < demandaReal.length; i++) {
            if (i == 0) {
                senialRastreo[i] = 0;
            } else {
                if (desviacionEstandar[i] != 0) {
                    senialRastreo[i] = errorPromedio[i] / desviacionEstandar[i];
                } else {
                    senialRastreo[i] = 0;
                }
            }
        }

        return senialRastreo;

    }

    /**
     * Devuelve true si la señal de rastreo del producto se encuentra fuera
     * de los limites definidos por su clase.
     * @param producto
     * @return true si esta fuera del rango y false en su defecto.
     */
    public boolean senialRastreoFueraRango(ProductoComponente producto) {

        double sr = calcularSenialRastreo(producto);

        if (Math.abs(sr) > producto.getCategoria().getL()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Devuelve la senial de rastreo de un producto para el año actual.
     * @param producto 
     * @return senialRastreo
     */
    public double calcularSenialRastreo(ProductoComponente producto) {

        GestorFecha gf = GestorFecha.getInstancia();
        GestorDemanda gd = GestorDemanda.getInstancia();
        List<DemandaXPeriodo> todas = gd.calcularPrediccionDemandaXPeriodo(producto);
        List<DemandaXPeriodo> demandas = new ArrayList<DemandaXPeriodo>();

        if (todas.size() > 0) {
            for (DemandaXPeriodo demandaXPeriodo : todas) {
                if (gf.getAnio(demandaXPeriodo.getAnio()) == gf.getAnio(new Date())) {
                    demandas.add(demandaXPeriodo);
                }
            }

            demandaReal = new double[demandas.size()];
            pronostico = new double[demandas.size()];

            for (int i = 0; i < demandas.size(); i++) {
                demandaReal[i] = demandas.get(i).getVentas();
                pronostico[i] = demandas.get(i).getPrediccionVenta();
            }

            double[] senial = SenialRastreoFinalFull(demandaReal, pronostico);
            
            System.out.println("Size " + senial.length);

            for (int i = 0; i < senial.length; i++) {
                System.out.println("i " + senial[i]);

            }
            return senial[senial.length - 1];
        } else {
            return -1;
        }

    }
}
