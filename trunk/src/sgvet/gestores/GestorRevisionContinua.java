package sgvet.gestores;

import sgvet.entidades.ProductoComponente;

/**
 *
 * @author Luciano
 */
public class GestorRevisionContinua {

    /***************************************************************************************************
    D: demanda anual. (unidad de ítem/año)
    A: costo de emisión (unidad monetaria)
    C: costo unitario; el valor del ítem en el inventario. (unidad monetaria / unidad de ítem)
    r: tasa anual de recargo por almacenamiento.
    H: Costo anual de almacenamiento de cada unidad de ítem. H = r *C (unidad monetaria/unidad de ítem)
    Q: Cantidad a ordenar o tamaño del lote. (unidad de ítem)
    CTG: Costo Total anual de Gestión; no incluye el costo del ítem. (unidad monetaria / año)
    CT: Costo total anual; incluye el costo del ítem. CT = C D + CTG (unidad monetaria/ año)
    N: número de pedidos o ciclos de producción por año.
    Número de pedidos en un año = N = D/Q
    Costo total anual de emisión = A N = A D/Q
    Costo total anual de almacenamiento = H = r*C
    CTG = A D/Q + H Q/2
     ***************************************************************************************************/

    double A;
    double D;
    double Q;
    double N;
    double AN;
    double H;
    double r;
    double C;
    double CTG;
    double QOptimo;
    double CTGOptimo;
    double NOptimo;
    double TAnual;
    private static GestorRevisionContinua instancia;

    public synchronized static GestorRevisionContinua getInstancia() {
        if (instancia == null) {
            instancia = new GestorRevisionContinua();
        }
        return instancia;
    }

    private GestorRevisionContinua() {
    }

    public double CTG(double costoEmision, double demandaAnual,
            double costoAnualMant, double tamanioLote) {
        A = costoEmision;
        D = demandaAnual;
        H = costoAnualMant;
        Q = tamanioLote;
        double CTG1, CTG2;
        CTG1 = A * (D / Q);
        CTG2 = H * (Q / 2);
        return CTG = CTG1 + CTG2;

    }

    public double N(double demandaAnual, double tamanioLote) {
        D = demandaAnual;
        Q = tamanioLote;
        return N = D / Q;
    }

    public double CostoTotalAnualEmision(double costoEmision,
            double demandaAnual, double tamanioLote) {

        A = costoEmision;
        D = demandaAnual;
        Q = tamanioLote;
        return AN = A * (D / Q);
    }

    public double H(double tasaAnual, double costoUnitario) {
        r = tasaAnual;
        C = costoUnitario;
        return H = r * C;

    }

    public double QOptimo(double costoEmision, double demandaAnual,
            double costoAnualMant) {
        A = costoEmision;
        H = costoAnualMant;
        D = demandaAnual;
        QOptimo = Math.sqrt((2 * A * D) / (H));
        return QOptimo;
    }

    public double CTGOptimo(double costoEmision, double demandaAnual,
            double costoAnualMant) {
        A = costoEmision;
        D = demandaAnual;
        H = costoAnualMant;
        CTGOptimo = Math.sqrt(2 * A * D * H);
        return CTGOptimo;
    }

    public double NOptimo(double CostoEmision, double DemandaAnual,
            double CostoAnualMant) {
        A = CostoEmision;
        D = DemandaAnual;
        H = CostoAnualMant;
        NOptimo = Math.sqrt((D * H) / (2 * A));
        return NOptimo;
    }

    public double TAnual(double demandaAnual, double tamanioLote) {
        D = demandaAnual;
        Q = tamanioLote;
        TAnual = Q / D;
        return TAnual;
    }

    public double TMensual(double demandaAnual, double tamanioLote) {
        D = demandaAnual;
        Q = tamanioLote;
        double TMensual = (Q / D) * 12;
        return TMensual;
    }

    public double TSemanal(double demandaAnual, double tamanioLote) {
        D = demandaAnual;
        Q = tamanioLote;
        double TSemanal = (Q / D) * 12;
        return TSemanal;
    }

    /**
     *
     * @param prod
     */
    public void calcularPoliticaSQ(ProductoComponente prod) {

        double stockDisponible = prod.getStock();
        

    }
}






