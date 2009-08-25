/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Componente;
import sgvet.entidades.DetalleOrdenCompra;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.EstructuraDeProducto;
import sgvet.entidades.MateriaPrima;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.OrdenCompra.EstadoOrdenCompra;
import sgvet.entidades.OrdenProduccion;
import sgvet.entidades.OrdenProduccion.EstadoOrdenProd;
import sgvet.entidades.ParteDeEstructura;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.ProductoTerminado;
import sgvet.igu.model.OrdenCompraTableModel;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorOrdenCompra {
    private EstructuraDeProducto estructura;
    
    private static GestorOrdenCompra instancia;
    
    public synchronized static GestorOrdenCompra getInstancia(){
        if (instancia == null){
            instancia = new GestorOrdenCompra();
        }
        return instancia;            
    }
    private GestorOrdenCompra(){
        
    }
    
    public void procesarOrden(OrdenCompra orden){
        orden.setEstado(EstadoOrdenCompra.PENDIENTE);
    }
    
    public boolean anularOrden(OrdenCompra orden){
        if(orden.getEstado()==EstadoOrdenCompra.PENDIENTE){
            orden.setEstado(EstadoOrdenCompra.ANULADO);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }
    
    public boolean terminarOrden(OrdenCompra orden){
        if(orden.getEstado()==EstadoOrdenCompra.PENDIENTE){
            sumarMateriales(orden);
            orden.setEstado(EstadoOrdenCompra.TERMINADO);
            FachadaPersistencia.getInstancia().actualizar(orden, true);
            return true;
        }
        return false;
    }
    
    
    private void sumarMateriales(OrdenCompra orden){

        double cantStock;
        double cantNueva;
        MateriaPrima materiaPrima;
        ProductoComponente productoComponente;
        
        for (DetalleOrdenCompra detalle : orden.getDetallesOrdenCompra()) {
            cantNueva= detalle.getCantidad();
            if(detalle.getComponente().getTipo()=='M'){
                materiaPrima =  FachadaPersistencia.getInstancia().buscar(MateriaPrima.class, (Object)detalle.getComponente().getId());
                cantStock= materiaPrima.getStock()+ cantNueva;
                materiaPrima.setStock(cantStock);
                FachadaPersistencia.getInstancia().actualizar(materiaPrima, true);
                
            }else{
                productoComponente = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, (Object)detalle.getComponente().getId());
                cantStock= productoComponente.getStock() + cantNueva;
                productoComponente.setStock(cantStock);
                FachadaPersistencia.getInstancia().actualizar(productoComponente, true);
            }
        } 
    }
    
    
    public String obtenerNroOrden() {
        int ultimaOrden;
        OrdenCompra orden = FachadaPersistencia.getInstancia().obtenerPrimero(OrdenCompra.class, "SELECT o FROM OrdenCompra o ORDER BY o.nroOrdenCompra DESC");

        ultimaOrden = orden != null ? orden.getNroOrdenCompra() : 0;
        
        return Integer.toString(ultimaOrden + 1);
    }

    public void generarOrdenAutomatica(OrdenCompraTableModel tm){
        Query consulta;
        List<Componente> componentes;
        double stockNecesario;
                
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from Componente a where  a.borrado=false and a.tipo IN (:tipo1, :tipo2)");
        consulta.setParameter("tipo1", 'C');
        consulta.setParameter("tipo2", 'M');
        componentes= FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);     
        
        for (Componente componente : componentes) {
            stockNecesario = componente.getStockReserva() + calcularOrdenProdSuspendida(componente)
                    - calcularOrdenesCompraPendientes(componente) - componente.getStock();

            if (stockNecesario > 0) {
                DetalleOrdenCompra detalle = new DetalleOrdenCompra();
                detalle.setComponente(componente);
                detalle.setCantidad(stockNecesario);
                tm.agregarFila(detalle);
            }
        }
    }

 
    private double calcularOrdenProdSuspendida(Componente componente){
        double resultado=0.0;
        
        Query consulta;
        //List<Componente> componentes;
        List<ParteDeEstructura> partes;
        ProductoTerminado productoTerminado;
        List<DetalleOrdenProduccion> detallesOrdenProduccionTemp;
       // List<DetalleOrdenProduccion> detallesOrdenProduccion = new ArrayList<DetalleOrdenProduccion>();
        
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from ParteDeEstructura a where a.componente= :comp and  a.borrado=false");
        consulta.setParameter("comp", componente);
        partes= FachadaPersistencia.getInstancia().buscar(ParteDeEstructura.class, consulta);
        
        for (ParteDeEstructura parteDeEstructura : partes) {
            productoTerminado= parteDeEstructura.getEstructura().getProductoTerminado();
            
            consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from DetalleOrdenProduccion a where a.productoTerminado= :terminado and  a.borrado=false");
            consulta.setParameter("terminado", productoTerminado);
            detallesOrdenProduccionTemp= FachadaPersistencia.getInstancia().buscar(DetalleOrdenProduccion.class, consulta);
            
            for (DetalleOrdenProduccion detalleOrdenProduccion : detallesOrdenProduccionTemp) {
                if(detalleOrdenProduccion.getOrdenProduccion().getEstado()== EstadoOrdenProd.SUSPENDIDO){
                    //detallesOrdenProduccion.add(detalleOrdenProduccion); //al pedo
                    resultado += detalleOrdenProduccion.getCantidad();
                    
                } 
            }
            
            
            
        }
        
        //componentes= FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);  
        
        
        return resultado;
    }
    
    private double calcularOrdenesCompraPendientes(Componente componente){
        double resultado=0.0;
        List<DetalleOrdenCompra> detalleOrdenCompras;
        Query consulta;
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from DetalleOrdenCompra a where a.componente= :com and  a.borrado=false");
        consulta.setParameter("com", componente);
        detalleOrdenCompras = FachadaPersistencia.getInstancia().buscar(DetalleOrdenCompra.class, consulta);
        
        for (DetalleOrdenCompra detalleOrdenCompra : detalleOrdenCompras) {
            if(detalleOrdenCompra.getOrdenCompra().getEstado()== EstadoOrdenCompra.PENDIENTE){
                resultado += detalleOrdenCompra.getCantidad();
            }
        }
        
        return resultado;
    }
            
}
