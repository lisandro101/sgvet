/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Proveedor;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorProveedor {

    private static GestorProveedor instancia;

    public synchronized static GestorProveedor getInstancia() {
        if (instancia == null) {
            instancia = new GestorProveedor();
        }
        return instancia;
    }

    private GestorProveedor() {
    }

    public boolean sePuedeEliminar(Proveedor proveedor) {
        Query consulta;
        List<Proveedor> proveedores;
//        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from OrdenCompra a where a.proveedor = :prov and a.borrado=false");
//        consulta.setParameter("prov", proveedor);
//        proveedores = FachadaPersistencia.getInstancia().buscar(Proveedor.class, consulta);
//        
//        if(proveedores.size()>=1){
//            return false;
//        }

        consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "Select a from ProductoComponente a where a.borrado=false");
        List<ProductoComponente> componentes = FachadaPersistencia.getInstancia().buscar(
                ProductoComponente.class, consulta);

        for (ProductoComponente com : componentes) {
            proveedores = com.getProveedores();

            for (Proveedor prov : proveedores) {
                if (prov.getNombre().equals(proveedor.getNombre())) {
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

}
