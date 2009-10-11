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

    public GestorSenialRastreo() {
        /*
        demandaReal= new double[13];
        pronostico=new double[13];
        alfa=0.1 ;
        error=new double[13];
        errorPromedio=new double[13];
        MSE=new double[13];
        desviacionEstandar=new double[13];
        senialRastreo=new double[13];
         */
    }

    public GestorSenialRastreo(double[] DemandaRealX, double[] PronosticoX, double GammaX, double[] ErrorX, double[] ErrorPromedioX, double[] MSEX, double[] DesviacionEstandarX, double[] SenialRastreoX) {
        /*Atener en cuanta, Hay 13 periodos de 28 y de ellos tiene que existir un pronostico
        por cada periodo, para cada producto. La senial de Rastreo se calcula a cierre del periodo */
        demandaReal = DemandaRealX;
        pronostico = PronosticoX;
        alfa = GammaX;
        //error=new double[13];
        errorPromedio = ErrorPromedioX;
        MSE = MSEX;
        desviacionEstandar = DesviacionEstandarX;
        senialRastreo = SenialRastreoX;
    }

    public double[] Error(double[] DemandaReal, double[] Pronostico) {
        // demandaReal=DemandaRealX;
        error = new double[DemandaReal.length];
        //pronostico=demandaReal;
        for (int i = 0; i < DemandaReal.length; i++) {
            if (i == 0) {

                error[i] = 0;
            } else {
                error[i] = Pronostico[i] - DemandaReal[i];

            }
            //System.out.println(error[i]);
        }
        return error;
    }

    public double[] ErrorPromedio(double Gamma1, double[] Error1) {
        errorPromedio = new double[Error1.length];
        error = Error1;
        alfa = Gamma1;
        for (int i = 0; i < Error1.length; i++) {
            if (i == 0) {
                errorPromedio[i] = 0;
            } else {
                errorPromedio[i] = ((alfa * error[i]) + (1 - alfa) * errorPromedio[i - 1]);
            }
            //System.out.println(errorPromedio[i]);
        }

        return errorPromedio;
    }

    public double[] MSE(double Gamma, double[] Error1) {
        MSE = new double[Error1.length];
        error = Error1;
        for (int i = 0; i < Error1.length; i++) {
            if (i == 0) {
                MSE[i] = 0;
            } else {
                MSE[i] = ((Gamma * (error[i] * error[i])) + ((1 - Gamma) * MSE[i - 1]));
            }

            // System.out.println(MSE[i]);
        }

        return MSE;
    }

    public double[] DesviacionEstandar(double Gamma, double[] MSE1) {
        desviacionEstandar = new double[MSE1.length];
        MSE = MSE1;
        for (int i = 0; i < MSE1.length; i++) {
            if (i == 0) {
                desviacionEstandar[i] = 0;
            } else {
                // desviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
                desviacionEstandar[i] = (Math.sqrt(MSE[i]) * Math.sqrt(Gamma) / (2 - Gamma));

            }
            //System.out.println(desviacionEstandar[i]);
        }

        return desviacionEstandar;
    }

    public double[] SenialRastreoFinal(double[] DesviacionEstandar1, double[] ErrorPromedio1) {
        desviacionEstandar = DesviacionEstandar1;
        errorPromedio = ErrorPromedio1;
        senialRastreo = new double[DesviacionEstandar1.length];
        for (int i = 0; i < DesviacionEstandar1.length; i++) {
            if (i == 0) {
                senialRastreo[i] = 0;
            } else {
                senialRastreo[i] = errorPromedio[i] / desviacionEstandar[i];
            }
            System.out.println(senialRastreo[i]);
            //System.out.println(errorPromedio[i]);
            //System.out.println(desviacionEstandar[i]);
        }

        return senialRastreo;
    }

    public double[] SenialRastreoFinalFull(double[] _demandaReal, double[] _pronostico) {
        demandaReal = _demandaReal;
        pronostico = _pronostico;
        error = new double[_demandaReal.length];
        errorPromedio = new double[_demandaReal.length];
        MSE = new double[_demandaReal.length];
        desviacionEstandar = new double[_demandaReal.length];
        senialRastreo = new double[_demandaReal.length];

        for (int i = 0; i < _demandaReal.length; i++) {
            if (i == 0) {
                error[i] = 0;
            } else {
                error[i] = pronostico[i] - demandaReal[i];
            }
            //System.out.println(error[i]);
        }

        for (int i = 0; i < _demandaReal.length; i++) {
            if (i == 0) {
                errorPromedio[i] = 0;
            } else {
                errorPromedio[i] = ((alfa * error[i]) + (1 - alfa) * errorPromedio[i - 1]);
            }

            //System.out.println(errorPromedio[i]);
        }

        for (int i = 0; i < _demandaReal.length; i++) {
            if (i == 0) {
                MSE[i] = 0;
            } else {
                MSE[i] = ((alfa * (error[i] * error[i])) + ((1 - alfa) * MSE[i - 1]));
            }
        }

        for (int i = 0; i < _demandaReal.length; i++) {

            if (i == 0) {
                desviacionEstandar[i] = 0;
            } else {
                // desviacionEstandar[i]=1;math//=+RAIZ(F9)*RAIZ($G$2)/(2-$G$2)
                desviacionEstandar[i] = (Math.sqrt(MSE[i]) * Math.sqrt(alfa) / (2 - alfa));

            }
        }

        for (int i = 0; i < _demandaReal.length; i++) {
            if (i == 0) {
                senialRastreo[i] = 0;
            } else {
                senialRastreo[i] = errorPromedio[i] / desviacionEstandar[i];
            }
            System.out.println(senialRastreo[i]);
            //System.out.println(errorPromedio[i]);
            //System.out.println(desviacionEstandar[i]);
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
        }
        else{
            return false;
        }

    }

    /**
     * Devuelve la senial de rastreo de un producto para el año actual.
     * @param producto 
     * @return senialRastreo
     */
    public double calcularSenialRastreo(ProductoComponente producto){

        GestorFecha gf = GestorFecha.getInstancia();
        GestorDemanda gd = GestorDemanda.getInstancia();
        List<DemandaXPeriodo> todas = gd.calcularPrediccionDemandaXPeriodo(producto);
        List<DemandaXPeriodo> demandas = new ArrayList<DemandaXPeriodo>();

        for (DemandaXPeriodo demandaXPeriodo : todas) {
            if(gf.getAnio(demandaXPeriodo.getAnio()) == gf.getAnio(new Date())){
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

        return senial[senial.length];

    }
}
