/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.List;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.Venta;
import sgvet.entidades.Venta.EstadoVenta;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.auxiliares.DTOPedidos;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorVenta {

    private static GestorVenta instancia;
    boolean actualizar = false;

    public synchronized static GestorVenta getInstancia() {
        if (instancia == null) {
            instancia = new GestorVenta();
        }
        return instancia;
    }

    private GestorVenta() {
    }

    /**
     * Si existe stock suficiente, se descuenta el stock.
     * @param venta 
     * @return
     */
    public boolean procesarOrden(Venta venta) {

        boolean resultado = false;

        if (existenProductos(venta)) {
            descontarStock(venta);
            resultado = true;
        }

        return resultado;
    }

    public boolean anularOrden(Venta orden) {
        if (orden.getEstado() == EstadoVenta.SUSPENDIDO) {
            orden.setEstado(EstadoVenta.ANULADO);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean terminarOrden(Venta orden) {
        if (orden.getEstado() == EstadoVenta.PROCESANDO) {
            orden.setEstado(EstadoVenta.TERMINADO);
            sumarProductoTerminado(orden);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }

    public String obtenerNroOrden() {
        int ultimaOrden;
        Venta orden = FachadaPersistencia.getInstancia().obtenerPrimero(
                Venta.class,
                "SELECT o FROM Venta o ORDER BY o.nroOrdenProduccion DESC");

        ultimaOrden = orden != null ? orden.getNroOrdenProduccion() : 0;

        return Integer.toString(ultimaOrden + 1);
    }

    private void descontarStock(Venta venta) {

        for (DetalleOrdenProduccion detalle : venta.getDetallesOrdenProduccion()) {
            ProductoComponente prod = detalle.getProducto();
            prod.setStock(prod.getStock() - detalle.getCantidad());
            FachadaPersistencia.getInstancia().actualizar(prod, true);
        }

    }

    private boolean existenProductos(Venta venta) {
        boolean existen = true;

        for (DetalleOrdenProduccion detalle : venta.getDetallesOrdenProduccion()) {
            if (detalle.getProducto().getStock() < detalle.getCantidad()) {
                existen = false;
            }
        }

        return existen;
    }

    @Deprecated
    private void sumarProductoTerminado(Venta venta) {
        List<DetalleOrdenProduccion> detalle = venta.getDetallesOrdenProduccion();
        ProductoComponente producto;
        double stockAnterior;
        for (DetalleOrdenProduccion detalleOrdenProduccion : detalle) {
            producto = detalleOrdenProduccion.getProducto();
            stockAnterior = producto.getStock();
            producto.setStock(
                    stockAnterior + detalleOrdenProduccion.getCantidad());
            FachadaPersistencia.getInstancia().actualizar(producto, true);

        }

    }

}
