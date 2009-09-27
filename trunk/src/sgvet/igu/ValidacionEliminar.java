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
import sgvet.entidades.Venta.EstadoOrdenProd;
import sgvet.entidades.ProductoComponente;
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
    
//    public boolean empleadoEstaRelacionado(Empleado empleado){
//        boolean resultado;
//        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
//                "SELECT a FROM HoraLaboral a " +
//                "WHERE a.empleado = :empleado AND a.borrado=false" );
//        consulta.setParameter("empleado", empleado);
//
//        if(FachadaPersistencia.getInstancia().buscar(HoraLaboral.class, consulta).size()==0){
//            resultado=false;
//        }else{
//            resultado=true;
//        }
//
//        return resultado;
//    }
//
//    public boolean productoComponenteEstaRelacionada(ProductoComponente productoComponente){
//        boolean resultado;
//        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
//                "SELECT a FROM ParteDeEstructura a " +
//                "WHERE a.componente = :componente AND a.borrado=false" );
//        consulta.setParameter("componente", productoComponente);
//
//        if(FachadaPersistencia.getInstancia().buscar(ParteDeEstructura.class, consulta).size()==0){
//            resultado=false;
//        }else{
//            resultado=true;
//        }
//
//        return resultado;
//    }

            
}
