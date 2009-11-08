package sgvet.gestores;

import sgvet.entidades.PoliticaRevisionPeriodica;
import sgvet.entidades.ProductoComponente;

/**
 *
 * @author Luciano, Lisandro
 */
public class GestorRevisionPeriodica {

    private static GestorRevisionPeriodica instancia;
    ProductoComponente producto;
    PoliticaRevisionPeriodica politica;

    public synchronized static GestorRevisionPeriodica getInstancia() {
        if (instancia == null) {
            instancia = new GestorRevisionPeriodica();
        }
        return instancia;
    }

    private GestorRevisionPeriodica() {
    }

    /**
     * Carga el gestor con la informacion de la interfaz.
     *
     * @param prod
     */
    public void cargarGestorRevisionPeriodica(ProductoComponente prod) {

        politica = (PoliticaRevisionPeriodica) prod.getProveedores().get(0).getPolitica();
        producto = prod;

    }

    private double getStockDeSeguridad() {

        GestorStock gs = GestorStock.getInstancia();
        double stockSeguridad = 0;

        stockSeguridad = getDesviacionEstandarDemanda() * gs.getFactorDeSeguridad(politica.getNivelServicio());

        return stockSeguridad;

    }

    private double getDesviacionEstandarDemanda() {

        double desviacion;
        double periodoRevision;

        if (politica.getPeridoDeRevision() > 0) {
            periodoRevision = politica.getPeridoDeRevision();
        } else {
            periodoRevision = getPeriodoDeRevision();
        }

        desviacion = politica.getTiempoEntrega() * periodoRevision / politica.getDesviacionEstandarDemanda();

        return desviacion;
    }

    /**
     * Devuelve el stock disponible. Si el perido de revision es mayor que cero lo utiliza pero si es menor lo calcula.
     * 
     * @return
     */
    public double getStockDisponible() {

        GestorStock gs = GestorStock.getInstancia();
        double stockDisponible;
        double tiempoEntrega;
        double periodoRevision;

        tiempoEntrega = politica.getTiempoEntrega();

        if (politica.getPeridoDeRevision() > 0) {
            periodoRevision = politica.getPeridoDeRevision();
        } else {
            periodoRevision = getPeriodoDeRevision();
        }

        stockDisponible = gs.getPrediccionDemanda(producto, tiempoEntrega + periodoRevision) + getStockDeSeguridad();

        return stockDisponible;

    }

    private double getPeriodoDeRevision() {

        GestorStock gs = GestorStock.getInstancia();
        double periodoDeRevision;

        periodoDeRevision = gs.getQOptimo(producto) / producto.getDemandaAnual();

        return periodoDeRevision;

    }
}
