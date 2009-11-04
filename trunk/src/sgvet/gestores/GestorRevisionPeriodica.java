package sgvet.gestores;

/**
 *
 * @author Luciano
 */
public class GestorRevisionPeriodica {

    /**********************************************************************************
    StockDisponible = StockRealEnAlmacen + StockPendienteDeEntrega - StockComprometido
    Q: Cantidad a Ordenar(ya esta determinada)
    Punto de Pedido: Cuando llega a este punto hay que hacer el Pedido.
    Tiempo de Demora(Hasta el Almacen): Faltante Esperado.
    Te: Tiempo de Entrega.
    s: Punto de Pedido.
    SS: Stock de Seguridad.
    Xe: Demanda Durante el tiempo de Espera.
    f: Funcion Densidad.
    Moo: Demanda Esperada durante el tiempo de Entrega.
    Omega: Desviacion Estandar durante el Tiempo de entrega.
    Cf: Costo Unitario por faltante.
    CGE: Costo Anual de Gestion Esperado.
    Nivel de Servicio: Tabla de doble entrada, la dio la Profe.
     **********************************************************************************/
    private double NumeroDeOrdenes;
    private double D;
    private double Q;
    private double A;
    private double CostoAnualEmision;
    private double Moo;
    private double s;
    private double H;
    private double CostoAnualAlmacenamiento;
    private double DesviacionEstandar;
    private double K;
    private double SS;
    private double R;
    private static GestorRevisionPeriodica instancia;

    public synchronized static GestorRevisionPeriodica getInstancia() {
        if (instancia == null) {
            instancia = new GestorRevisionPeriodica();
        }
        return instancia;
    }

    private GestorRevisionPeriodica() {
    }

    public double NumeroDeOrdenes(double demandaAnual, double tamanioLote) {
        D = demandaAnual;
        Q = tamanioLote;
        if (Q == 0) {
            System.out.println("DIVISION Sobre ZERO");
            Q = 999999999;
        } else {
            NumeroDeOrdenes = D / Q;
        }
        return NumeroDeOrdenes;
    }

    public double CostoAnualEmision(double costoEmision, double demandaAnual,
            double tamanioLote) {
        A = costoEmision;
        D = demandaAnual;
        Q = tamanioLote;
        if (Q == 0) {
            System.out.println("DIVISION Sobre ZERO");
            Q = 999999999;
        } else {
            CostoAnualEmision = A * (D / Q);

        }
        return CostoAnualEmision;
    }

    public double CostoAnualAlmacenamiento(double tamanioLote,
            double puntoDePedido, double demandaEsperada,
            double costoAlmacenamiento) {
        Q = tamanioLote;
        s = puntoDePedido;
        Moo = demandaEsperada;
        H = costoAlmacenamiento;
        CostoAnualAlmacenamiento = ((Q / 2) + s - Moo) * H;
        return CostoAnualAlmacenamiento;
    }

    public double SSSinDemoras(double KEsperada,
            double desviacionEstandarEsperada) {
        DesviacionEstandar = desviacionEstandarEsperada;
        K = KEsperada;
        SS = K * DesviacionEstandar;
        return SS;

    }

    public double SSinDemorada(double demandaAnualEsperada,
            double nivelDeServicio, double desviacionEstandarEsperada) {
        Moo = demandaAnualEsperada;
        K = nivelDeServicio;
        DesviacionEstandar = desviacionEstandarEsperada;
        s = Moo + (K * DesviacionEstandar);
        return s;
    }

    public double SSConDemoras(double KEsperada, double desviacionEstandar_R_Te) {
        K = KEsperada;
        DesviacionEstandar = desviacionEstandar_R_Te;
        SS = K * (DesviacionEstandar);
        return SS;

    }

    public double SConDemorada(double demandaAnualEsperada_R_Te, double SS_R_Te) {
        SS = SS_R_Te;
        Moo = demandaAnualEsperada_R_Te;

        s = Moo + (SS);
        return s;
    }
}

