package sgvet.gestores;

import sgvet.entidades.PoliticaRevisionPeriodica;
import sgvet.entidades.ProductoComponente;

/**
 *
 * @author Luciano, Lisandro
 */
public class GestorRevisionPeriodica extends GestorStock implements IObservadorFecha{

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

        politica = (PoliticaRevisionPeriodica) prod.getPolitica();
        producto = prod;

    }

    private double getStockDeSeguridad() {

        double stockSeguridad = 0;

        stockSeguridad = getDesviacionEstandarDemanda() * getFactorDeSeguridad(politica.getNivelServicio());

        return stockSeguridad;

    }

    private double getDesviacionEstandarDemanda() {

        double desviacion;
        double periodoRevision;

        periodoRevision = getPeriodoDeRevision();

        desviacion = politica.getTiempoEntrega() * periodoRevision / politica.getDesviacionEstandarDemanda();

        return desviacion;

    }

    /**
     * Devuelve el stock disponible. Si el perido de revision es mayor que cero lo utiliza pero si es menor lo calcula.
     * 
     * @return
     */
    public double getPuntoPedido() {

        double puntoPedido;
        double tiempoEntrega;
        double periodoRevision;

        tiempoEntrega = politica.getTiempoEntrega();
        periodoRevision = getPeriodoDeRevision();

        puntoPedido = getPrediccionDemanda(producto, tiempoEntrega + periodoRevision) + getStockDeSeguridad();

        return puntoPedido;

    }

    /**
     * Devuelve el stock disponible (S).
     *
     * @return
     */
    public double getStockDisponible() {

        double stockDisponible;

        stockDisponible = producto.getStock() + getStockPendiente(producto); //- stockComprometido

        return stockDisponible;

    }

    public double getPeriodoDeRevision() {

        double periodoDeRevision;
        if (politica.getPeridoDeRevision() > 0) {
            periodoDeRevision = politica.getPeridoDeRevision();
        } else {
            periodoDeRevision = getQOptimo(producto) / producto.getDemandaAnual();
        }

        return periodoDeRevision;

    }

    public double getCantidadAPedir() {
        double cantidad;

        cantidad = getPuntoPedido() - getStockDisponible();

        return cantidad;

    }

    @Override
    public void actualizar() {
        
    }
}

