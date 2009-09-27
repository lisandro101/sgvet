/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.Venta;
import sgvet.entidades.Venta.EstadoOrdenProd;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorOrdenProduccion {

    private static GestorOrdenProduccion instancia;
    boolean actualizar = false;

    public synchronized static GestorOrdenProduccion getInstancia() {
        if (instancia == null) {
            instancia = new GestorOrdenProduccion();
        }
        return instancia;
    }

    private GestorOrdenProduccion() {
    }

    public void procesarOrden(Venta orden) {

        if(existenProductos(orden)){
                descontarStock(orden);
        }
    }

    public boolean anularOrden(Venta orden) {
        if (orden.getEstado() == EstadoOrdenProd.SUSPENDIDO) {
            orden.setEstado(EstadoOrdenProd.ANULADO);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean terminarOrden(Venta orden) {
        if (orden.getEstado() == EstadoOrdenProd.PROCESANDO) {
            orden.setEstado(EstadoOrdenProd.TERMINADO);
            sumarProductoTerminado(orden);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }

    public String obtenerNroOrden() {
        int ultimaOrden;
        Venta orden = FachadaPersistencia.getInstancia().obtenerPrimero(Venta.class, "SELECT o FROM Venta o ORDER BY o.nroOrdenProduccion DESC");

        ultimaOrden = orden != null ? orden.getNroOrdenProduccion() : 0;

        return Integer.toString(ultimaOrden + 1);
    }

    @Deprecated
    public void revisarOrdenesSuspendidas(){
        Query consulta;
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from Venta a where a.estado = :estado and a.borrado=false");
        consulta.setParameter("estado", Venta.EstadoOrdenProd.SUSPENDIDO);
        List<Venta> ordenes = FachadaPersistencia.getInstancia().buscar(Venta.class, consulta);

        for (Venta venta : ordenes) {
            procesarOrden(venta);
            if(actualizar){
                FachadaPersistencia.getInstancia().actualizar(venta, true);
            }

        }
    }

    private void descontarStock(Venta orden) {

        for (DetalleOrdenProduccion detalle : orden.getDetallesOrdenProduccion()) {
            ProductoComponente prod = detalle.getProducto();
            prod.setStock(prod.getStock() - detalle.getCantidad());
            FachadaPersistencia.getInstancia().actualizar(prod, true);
        }
    }

    private boolean existenProductos(Venta venta) {
        boolean existen = true;

        for (DetalleOrdenProduccion detalle : venta.getDetallesOrdenProduccion()) {
            if (detalle.getProducto().getStock() < detalle.getCantidad())
                existen = false;
        }

        return existen;
    }

    @Deprecated
    private void sumarProductoTerminado(Venta venta){
        List<DetalleOrdenProduccion> detalle= venta.getDetallesOrdenProduccion();
        ProductoComponente producto;
        double stockAnterior;
        for (DetalleOrdenProduccion detalleOrdenProduccion : detalle) {
            producto= detalleOrdenProduccion.getProducto();
            stockAnterior= producto.getStock();
            producto.setStock(stockAnterior+ detalleOrdenProduccion.getCantidad());
            FachadaPersistencia.getInstancia().actualizar(producto, true);

        }

    }
}
