package sgvet.gestores;

import java.util.ArrayList;
import java.util.List;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.Politica;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Venta;
import sgvet.entidades.auxiliares.DTOPedidos;

/**
 *
 * @author Luciano. Lisandro
 */
public class GestorRevisionContinua extends GestorStock {

    private static GestorRevisionContinua instancia;
    ProductoComponente producto;
    Politica politica;

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

        politica = prod.getPolitica();
        producto = prod;

    }

    private double getStockDeSeguridad() {

        double stockSeguridad = 0.0;

        stockSeguridad = politica.getDesviacionEstandarDemanda() * getFactorDeSeguridad(politica.getNivelServicio());

        return stockSeguridad;

    }

    /**
     * Devuelve el punto de pedido (s). Si la prediccion de la demanda es mayor que cero la utiliza pero si es menor la calcula.
     * 
     * @return
     */
    public double getPuntoDePedido() {

        double puntoDePedido = 0.0;

        puntoDePedido = getPrediccionDemanda(producto, politica.getTiempoEntrega()) + getStockDeSeguridad();

        return puntoDePedido;
    }

    /**
     *
     * @param venta
     * @return
     */
    public List<DTOPedidos> getPedidosRevisionContinua(Venta venta) {

        Politica pol;
        List<DTOPedidos> pedidos = new ArrayList<DTOPedidos>();
        DTOPedidos pedido;

        for (DetalleOrdenProduccion detalle : venta.getDetallesOrdenProduccion()) {
            pol = detalle.getProducto().getPolitica();
            if (pol != null) {
                if (pol.getTipoPolitica() != null) {
                    if (pol.getTipoPolitica().equals(Politica.TipoPolitica.CONTINUA)) {
                        cargarGestorRevisionContinua(detalle.getProducto());
                        if (getStockDisponible() <= getPuntoDePedido()) {
                            if (!detalle.getProducto().isSeRealizoPedido()) {
                                pedido = new DTOPedidos(detalle.getProducto(), getQOptimo(producto));
                                pedidos.add(pedido);
                            }
                        }
                    }
                }
            }
        }

        return pedidos;

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
}
