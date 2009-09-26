/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.OrdenProduccion;
import sgvet.entidades.OrdenProduccion.EstadoOrdenProd;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorOrdenProduccion {

    private static GestorOrdenProduccion instancia;
    boolean actualizar=false;
    
    public synchronized static GestorOrdenProduccion getInstancia() {
        if (instancia == null) {
            instancia = new GestorOrdenProduccion();
        }
        return instancia;
    }

    private GestorOrdenProduccion() {
    }

    public void procesarOrden(OrdenProduccion orden) {
//        int valor = existenMateriales(orden);
//
//        if(valor != 1){
//            if (valor==2) {
//                restarMateriales(orden);
//                orden.setEstado(EstadoOrdenProd.PROCESANDO);
//                actualizar=true;
//            } else {
//                orden.setEstado(EstadoOrdenProd.SUSPENDIDO);
//                actualizar=false;
//            }
//        }
    }

    public boolean anularOrden(OrdenProduccion orden) {
        if (orden.getEstado() == EstadoOrdenProd.SUSPENDIDO) {
            orden.setEstado(EstadoOrdenProd.ANULADO);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }

    public boolean terminarOrden(OrdenProduccion orden) {
        if (orden.getEstado() == EstadoOrdenProd.PROCESANDO) {
            orden.setEstado(EstadoOrdenProd.TERMINADO);
            sumarProductoTerminado(orden);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }
// devuelve: 1 si no tiene estructura, 2 si existe materiales y 3 si no existen materiales
//    private int existenMateriales(OrdenProduccion orden) {
//
//        double cantStock;
//        double cantNecesaria;
//
//        Query consulta;
//
//        for (DetalleOrdenProduccion detalle : orden.getDetallesOrdenProduccion()) {
//            consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from EstructuraDeProducto a where a.productoTerminado = :producto and a.borrado=false");
//            consulta.setParameter("producto", detalle.getProducto());
//            List<EstructuraDeProducto> estructuras = FachadaPersistencia.getInstancia().buscar(EstructuraDeProducto.class, consulta);
//
//            if (estructuras.size() == 0) {
//                JOptionPane.showMessageDialog(null, "No exite estructura para el producto");
//                return 1;
//            } else {
//                estructura = estructuras.get(0);
//                for (ParteDeEstructura parte : estructura.getPartes()) {
//                    cantStock = parte.getComponente().getStock();
//                    cantNecesaria = parte.getCantidad() * detalle.getCantidad();
//
//                    if ((cantStock - cantNecesaria) < 0) {
//                        return 3;
//                    }
//                }
//            }
//        }
//
//        return 2;
//    }

//    private void restarMateriales(OrdenProduccion orden) {
//
//        double cantStock;
//        double cantNecesaria;
//
//
//        for (DetalleOrdenProduccion detalle : orden.getDetallesOrdenProduccion()) {
//            if (estructura != null) {
//                for (ParteDeEstructura parte : estructura.getPartes()) {
//                    cantStock = parte.getComponente().getStock();
//                    cantNecesaria = parte.getCantidad() * detalle.getCantidad();
//
//                    cantStock = cantStock - cantNecesaria;
//                    parte.getComponente().setStock(cantStock);
//
//                    if (parte.getComponente().getTipo() == 'M') {
//                        FachadaPersistencia.getInstancia().actualizar((MateriaPrima) parte.getComponente(), true);
//                    } else {
//                        FachadaPersistencia.getInstancia().actualizar((ProductoComponente) parte.getComponente(), true);
//                    }
//                }
//            }
//        }
//    }

    public String obtenerNroOrden() {
        int ultimaOrden;
        OrdenProduccion orden = FachadaPersistencia.getInstancia().obtenerPrimero(OrdenProduccion.class, "SELECT o FROM OrdenProduccion o ORDER BY o.nroOrdenProduccion DESC");

        ultimaOrden = orden != null ? orden.getNroOrdenProduccion() : 0;
        
        return Integer.toString(ultimaOrden + 1);
    }
    
    public void revisarOrdenesSuspendidas(){
        Query consulta;
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from OrdenProduccion a where a.estado = :estado and a.borrado=false");
        consulta.setParameter("estado", OrdenProduccion.EstadoOrdenProd.SUSPENDIDO);
        List<OrdenProduccion> ordenes = FachadaPersistencia.getInstancia().buscar(OrdenProduccion.class, consulta);
        
        for (OrdenProduccion ordenProduccion : ordenes) {
            procesarOrden(ordenProduccion);
            if(actualizar){
                FachadaPersistencia.getInstancia().actualizar(ordenProduccion, true);
            }
            
        }
    }
    
    private void sumarProductoTerminado(OrdenProduccion orden){
        List<DetalleOrdenProduccion> detalle= orden.getDetallesOrdenProduccion();
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
