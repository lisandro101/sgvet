

package sgvet.gestores;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Demanda;
import sgvet.entidades.ItemABC;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;

public class GestorABC {

    private static GestorABC instance;

    public synchronized static GestorABC getInstancia(){
        if (instance == null){
            instance = new GestorABC();
        }
        return instance;
    }
    private GestorABC() {

    }
    @Deprecated
    public void calcularABC(List<Demanda> demandas){

    }

    public void calcularCurvaABC(){

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a " +
                "FROM ProductoComponente a " +
                "WHERE a.borrado = false");
        List<ProductoComponente> productos =
                FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, consulta);

        List<ItemABC> itemsABC = new ArrayList<ItemABC>();

        for (ProductoComponente producto : productos) {
            double demanda = producto.getDemandaAnual();
            double precio = producto.getPrecioVenta();
            double demandaVal =  demanda * precio;
            ItemABC itemAbc = new ItemABC(producto, demandaVal);
            itemsABC.add(itemAbc);
        }

        ItemABC itemMayor = null;
        List<ItemABC> curvaABC = new ArrayList<ItemABC>();

        for (int i = 0; i < itemsABC.size()-1; i++) {
            for (int j = i+1; j < itemsABC.size(); j++) {
                if (itemsABC.get(i).getDemandaValorizada() > itemsABC.get(j).getDemandaValorizada())
                    itemMayor = itemsABC.get(i);
                else
                    itemMayor = itemsABC.get(j);
            }
            curvaABC.add(itemMayor);
        }

        for (ProductoComponente p : productos) {
            System.out.println("Producto: " + p.getNombre() + " " + p.getDemandaAnual() + " " + p.getPrecioVenta());
        }
        for (ItemABC itemABC : curvaABC) {
            System.out.println("Demanda: " + itemABC.getDemandaValorizada() + " " + itemABC.getProducto().getNombre());
        }
    }

}
