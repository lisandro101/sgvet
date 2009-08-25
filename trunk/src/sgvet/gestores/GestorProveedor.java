/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;


import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Componente;
import sgvet.entidades.MateriaPrima;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Proveedor;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorProveedor {
    
    private static GestorProveedor instancia;
    
    public synchronized static GestorProveedor getInstancia(){
        if (instancia == null){
            instancia = new GestorProveedor();
        }
        return instancia;            
    }
    private GestorProveedor(){
        
    }
    
    public boolean sePuedeEliminar(Proveedor proveedor){
        Query consulta;
        List<Proveedor> proveedores;
//        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from OrdenCompra a where a.proveedor = :prov and a.borrado=false");
//        consulta.setParameter("prov", proveedor);
//        proveedores = FachadaPersistencia.getInstancia().buscar(Proveedor.class, consulta);
//        
//        if(proveedores.size()>=1){
//            return false;
//        }
        
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from MateriaPrima a where a.borrado=false");
        List<MateriaPrima> materias = FachadaPersistencia.getInstancia().buscar(MateriaPrima.class, consulta);
        
        for (MateriaPrima materiaPrima : materias) {
            proveedores= materiaPrima.getProveedores();
            
            for (Proveedor prov : proveedores) {
                if(prov.getNombre().equals(proveedor.getNombre())){
                    return false;
                }
            }
            
//            if(proveedores.contains(proveedor)){
//                System.out.println("entro, lo contiene una materia prima");
//                return false;
//            }
        }

        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from ProductoComponente a where a.borrado=false");
        List<ProductoComponente> componentes = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, consulta);
        
        for (ProductoComponente com : componentes) {
            proveedores= com.getProveedores();
            
            for (Proveedor prov : proveedores) {
                if(prov.getNombre().equals(proveedor.getNombre())){
                    return false;
                }
            }

//            if(proveedores.contains(proveedor)){
//                System.out.println("entro, lo contiene un producto compenente");
//                return false;
//            }
        }

        return true;
    }

    public boolean proveeComponente(Componente componente, Proveedor proveedor){
        Query consulta;
        if(componente.getTipo()=='M'){
            MateriaPrima materiaPrima =  FachadaPersistencia.getInstancia().buscar(MateriaPrima.class, (Object)componente.getId());
            if(proveedor.getComponentes().contains(materiaPrima)){
                return true;
            }
        }else{
            ProductoComponente prodComp =  FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, (Object)componente.getId());
            if(proveedor.getComponentes().contains(prodComp)){
                return true;
            }
        }
        
        return false;
    }
    
}
