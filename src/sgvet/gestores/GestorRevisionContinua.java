package sgvet.gestores;

import sgvet.entidades.ProductoComponente;
import sgvet.entidades.PoliticaRevisionContinua;

/**
 *
 * @author Luciano. Lisandro
 */
public class GestorRevisionContinua {

    private static GestorRevisionContinua instancia;
    ProductoComponente producto;
    PoliticaRevisionContinua politica;

    public synchronized static GestorRevisionContinua getInstancia() {
        if (instancia == null) {
            instancia = new GestorRevisionContinua();
        }
        return instancia;
    }

    private GestorRevisionContinua() {
    }

    /**
     * Carga el gestor con la informacion de la interfaz.
     * 
     * @param prod
     */
    public void cargarGestorRevisionContinua(ProductoComponente prod) {

        politica = (PoliticaRevisionContinua) prod.getProveedores().get(0).getPolitica();
        producto = prod;

    }
    
    private double getStockDeSeguridad() {

        GestorStock gs = GestorStock.getInstancia();
        double stockSeguridad = 0;

        stockSeguridad = politica.getDesviacionEstandarDemanda() * gs.getFactorDeSeguridad(politica.getNivelServicio());

        return stockSeguridad;

    }

    /**
     * Devuelve el punto de pedido (s). Si la prediccion de la demanda es mayor que cero la utiliza pero si es menor la calcula.
     * 
     * @return
     */
    public double getPuntoDePedido() {

        GestorStock gs = GestorStock.getInstancia();
        double puntoDePedido = 0;

        if (politica.getPrediccionDemanda() > 0) {
            puntoDePedido = politica.getPrediccionDemanda() + getStockDeSeguridad();
        } else {
            puntoDePedido = gs.getPrediccionDemanda(producto, politica.getTiempoEntrega()) + getStockDeSeguridad();
        }

        return puntoDePedido;
    }

    /**
     * Devuelve el stock disponible (S).
     * 
     * @return
     */
    public double getStockDisponible() {

        GestorStock gs = GestorStock.getInstancia();
        double stockDisponible;

        stockDisponible = producto.getStock() + gs.getStockPendiente(producto); //- stockComprometido

        return stockDisponible;

    }
}