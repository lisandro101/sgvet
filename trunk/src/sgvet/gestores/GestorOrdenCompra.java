/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import sgvet.entidades.DetalleOrdenCompra;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.OrdenCompra.EstadoOrdenCompra;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorOrdenCompra {

    private static GestorOrdenCompra instancia;
    private FachadaPersistencia gp;

    public synchronized static GestorOrdenCompra getInstancia() {
        if (instancia == null) {
            instancia = new GestorOrdenCompra();
        }
        return instancia;
    }

    public GestorOrdenCompra() {

        inicializar();
        
    }

    private void inicializar() {

        gp = FachadaPersistencia.getInstancia();

    }

    public void procesarOrden(OrdenCompra orden) {

        orden.setEstado(EstadoOrdenCompra.PENDIENTE);
        gp.actualizar(orden, true);

    }

    public boolean terminarOrden(OrdenCompra orden) {

        boolean resultado = false;

        if (orden.getEstado() == EstadoOrdenCompra.PENDIENTE) {
            aumentarStock(orden);
            orden.setEstado(EstadoOrdenCompra.TERMINADO);
            gp.actualizar(orden, true);
            resultado = true;
        }

        return resultado;

    }

    private void aumentarStock(OrdenCompra orden) {

        double cantStock;
        double cantNueva;
        ProductoComponente productoComponente;
        Object id;

        for (DetalleOrdenCompra detalle : orden.getDetallesOrdenCompra()) {
            cantNueva = detalle.getCantidad();
            id = (Object) detalle.getComponente().getId();
            productoComponente = gp.buscar(ProductoComponente.class, id);
            cantStock = productoComponente.getStock() + cantNueva;
            productoComponente.setStock(cantStock);
            gp.actualizar(productoComponente, true);

        }
    }

    public String obtenerNroOrden() {
        int ultimaOrden;
        OrdenCompra orden = gp.obtenerPrimero(OrdenCompra.class,
                "SELECT o FROM OrdenCompra o ORDER BY o.nroOrdenCompra DESC");

        ultimaOrden = orden != null ? orden.getNroOrdenCompra() : 0;

        return Integer.toString(ultimaOrden + 1);
    }
}
