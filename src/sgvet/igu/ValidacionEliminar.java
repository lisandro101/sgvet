/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.igu;

import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Cargo;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.Empleado;
import sgvet.entidades.EstructuraDeProducto;
import sgvet.entidades.HoraLaboral;
import sgvet.entidades.MateriaPrima;
import sgvet.entidades.OrdenProduccion.EstadoOrdenProd;
import sgvet.entidades.ParteDeEstructura;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.ProductoTerminado;
import sgvet.entidades.RutaFabricacion;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class ValidacionEliminar {
    private static ValidacionEliminar instancia;
    
    public synchronized static ValidacionEliminar getInstancia(){
        if (instancia == null){
            instancia = new ValidacionEliminar();
        }
        return instancia;            
    }
    private ValidacionEliminar(){ 
    }
    
    public boolean cargoEstaRelacionado(Cargo cargo){
        boolean resultado;
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM Empleado a " +
                "WHERE a.cargo = :cargo AND a.borrado=false" );
        consulta.setParameter("cargo", cargo);
        
        if(FachadaPersistencia.getInstancia().buscar(Empleado.class, consulta).size()==0){
            resultado=false;
        }else{
            resultado=true;
        }

        return resultado;
    }
    
    public boolean empleadoEstaRelacionado(Empleado empleado){
        boolean resultado;
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM HoraLaboral a " +
                "WHERE a.empleado = :empleado AND a.borrado=false" );
        consulta.setParameter("empleado", empleado);
        
        if(FachadaPersistencia.getInstancia().buscar(HoraLaboral.class, consulta).size()==0){
            resultado=false;
        }else{
            resultado=true;
        }

        return resultado;
    }

    public boolean rutaEstaRelacionada(RutaFabricacion ruta){
        boolean resultado;

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM DetalleOrdenProduccion a " +
                "WHERE a.ordenProduccion.estado IN (:suspendido, :procesando) " +
                "AND a.ordenProduccion.borrado = false " +
                "AND a.productoTerminado = :producto" );
        consulta.setParameter("suspendido", EstadoOrdenProd.SUSPENDIDO);
        consulta.setParameter("procesando", EstadoOrdenProd.PROCESANDO);
        consulta.setParameter("producto", ruta.getProductoTerminado());


        if(FachadaPersistencia.getInstancia().buscar(DetalleOrdenProduccion.class, consulta).size()>0){
            resultado=true;
        }else{
            resultado=false;
        }

        return resultado;
    }

    boolean estructuraEstaRelacionada(EstructuraDeProducto estructuraDeProducto) {
       boolean resultado;

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM RutaFabricacion a WHERE a.borrado = false " +
                "AND a.productoTerminado = :producto" );
        consulta.setParameter("producto", estructuraDeProducto.getProductoTerminado());


        if(FachadaPersistencia.getInstancia().buscar(RutaFabricacion.class, consulta).size()>0){
            resultado=true;
        }else{
            resultado=false;
        }

        return resultado;
    }
    
    public boolean materiaPrimaEstaRelacionada(MateriaPrima materiaPrima){
        boolean resultado;
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM ParteDeEstructura a " +
                "WHERE a.componente = :materiaPrima AND a.borrado=false" );
        consulta.setParameter("materiaPrima", materiaPrima);
        
        if(FachadaPersistencia.getInstancia().buscar(ParteDeEstructura.class, consulta).size()==0){
            resultado=false;
        }else{
            resultado=true;
        }

        return resultado;
    }

    public boolean productoComponenteEstaRelacionada(ProductoComponente productoComponente){
        boolean resultado;
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM ParteDeEstructura a " +
                "WHERE a.componente = :componente AND a.borrado=false" );
        consulta.setParameter("componente", productoComponente);
        
        if(FachadaPersistencia.getInstancia().buscar(ParteDeEstructura.class, consulta).size()==0){
            resultado=false;
        }else{
            resultado=true;
        }

        return resultado;
    }
    
    public void eliminarRutaEstructuraAsociados(ProductoTerminado productoTerminado){
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM RutaFabricacion a " +
                "WHERE a.productoTerminado = :producto and a.borrado=false" );
        consulta.setParameter("producto", productoTerminado);
        
        List<RutaFabricacion> rutas= FachadaPersistencia.getInstancia().buscar(RutaFabricacion.class, consulta);
        
        if(rutas.size()>0){
            FachadaPersistencia.getInstancia().comenzarTransaccion();
            for (RutaFabricacion rutaFabricacion : rutas) {
                FachadaPersistencia.getInstancia().borrar(rutaFabricacion, false);
            }
            FachadaPersistencia.getInstancia().finalizarTransaccion();
        }
        
        consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM EstructuraDeProducto a " +
                "WHERE a.productoTerminado = :producto AND a.borrado=false" );
        consulta.setParameter("producto", productoTerminado);
        
        List<EstructuraDeProducto> estructuras= FachadaPersistencia.getInstancia().buscar(EstructuraDeProducto.class, consulta);
        
        if(estructuras.size()>1){
            FachadaPersistencia.getInstancia().comenzarTransaccion();
            for (EstructuraDeProducto estructura : estructuras) {
                FachadaPersistencia.getInstancia().borrar(estructura, false);
            }
            FachadaPersistencia.getInstancia().finalizarTransaccion();
        }
        
    }
            
}
