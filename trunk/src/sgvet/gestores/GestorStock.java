/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;
//import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Stock;
import sgvet.persistencia.FachadaPersistencia;

public class GestorStock {
    
    private static GestorStock instance;
    private Stock stock;

public synchronized static GestorStock getInstancia(){
        if (instance == null){
            instance = new GestorStock();
        }
        return instance;
    }
 Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a " +
                "FROM ProductoComponente a " +
                "WHERE a.borrado = false");
List<ProductoComponente> productos = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, consulta);
int cantElem = productos.size();
public void calcularStock(){
        for (ProductoComponente producto : productos) {
            this.stock = producto.getStockProducto();
            System.out.println("El producto " + producto + "tiene " + stock.getDisponible() + "en disponibilidad");
           
        }
}


}


