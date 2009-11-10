/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.ArrayList;
import java.util.List;
import sgvet.entidades.DetalleOrdenCompra;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.OrdenCompra.EstadoOrdenCompra;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.auxiliares.DTOPedidos;
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

        for (DetalleOrdenCompra detalle : orden.getDetallesOrdenCompra()) {
            cantNueva = detalle.getCantidad();
            productoComponente = (ProductoComponente) detalle.getComponente();
            cantStock = productoComponente.getStock() + cantNueva;
            productoComponente.setStock(cantStock);
            productoComponente.setSeRealizoPedido(false);
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

    public void comprarPedido(List<DTOPedidos> pedidos) {

        OrdenCompra ordenCompra;
        DetalleOrdenCompra detalleOC;
        List<DetalleOrdenCompra> detalles;

        for (DTOPedidos pedido : pedidos) {
                ordenCompra = new OrdenCompra();
                detalleOC = new DetalleOrdenCompra();
                detalles = new ArrayList<DetalleOrdenCompra>();

                detalleOC.setBorrado(false);
                detalleOC.setCantidad(pedido.getCantidadOptima());
                detalleOC.setComponente(pedido.getProducto());
                detalleOC.setOrdenCompra(ordenCompra);
                detalles.add(detalleOC);

                ordenCompra.setProveedor(pedido.getProducto().getProveedores().get(0));
                ordenCompra.setDetallesOrdenCompra(detalles);
                ordenCompra.setFecha(GestorFecha.getInstancia().getFechaHoy());
                ordenCompra.setNroOrdenCompra(Integer.parseInt(GestorOrdenCompra.getInstancia().obtenerNroOrden()));

                GestorOrdenCompra.getInstancia().procesarOrden(ordenCompra);
                pedido.getProducto().setSeRealizoPedido(true);
                pedido.getProducto().setFechaUltimaRevision(GestorFecha.getInstancia().getFechaHoy());
                FachadaPersistencia.getInstancia().actualizar(ordenCompra, true);
                FachadaPersistencia.getInstancia().actualizar(pedido.getProducto(), true);
        }
    }
    
}
