

package sgvet.gestores;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Demanda;
import sgvet.entidades.ItemABC;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.persistencia.IPersistente;

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
            itemsABC.add(new ItemABC(producto, producto.getDemandaAnual() * producto.getPrecioVenta()));
        }

        List<ItemABC> curvaABC = new ArrayList<ItemABC>();       
        int cantElem = itemsABC.size();
        ItemABC itemMayor = null;

        for (int i = 0; i < cantElem; i++) {

            itemMayor=itemsABC.get(0);
            for (ItemABC item : itemsABC) {
                if(itemMayor.getDemandaValorizada()<=item.getDemandaValorizada()){
                    itemMayor=item;
                }

            }
            curvaABC.add(itemMayor);
            itemsABC.remove(itemMayor);

        }

        double demandaAcumulada = 0;

        for (ItemABC itemABC : curvaABC) {
            demandaAcumulada += itemABC.getDemandaValorizada();
            itemABC.setDemandaAcumulada(demandaAcumulada);
        }

        double demandaClaseA = 0.8 * demandaAcumulada;
        double demandaClaseB = 0.9 * demandaAcumulada;
        List<ProductoComponente> productosActualizados = new ArrayList<ProductoComponente>();

        for (ItemABC itemABC : curvaABC) {
            if(itemABC.getDemandaAcumulada() <= demandaClaseA) {
                itemABC.getProducto().setCategoria("Curva A");
                productosActualizados.add(itemABC.getProducto());
            }
            else if(itemABC.getDemandaAcumulada() <= demandaClaseB) {
                itemABC.getProducto().setCategoria("Curva B");
                productosActualizados.add(itemABC.getProducto());
            }
            else {
                itemABC.getProducto().setCategoria("Curva C");
                productosActualizados.add(itemABC.getProducto());
            }
        }

        persistir(productosActualizados);

        for (ItemABC itemABC : curvaABC) {
            System.out.println("Demanda: " + itemABC.getDemandaValorizada() 
                    + " " + itemABC.getProducto().getNombre()
                    + " " + itemABC.getDemandaAcumulada()
                    + " " + itemABC.getProducto().getCategoria());
        }
    }

    public void persistir(List<ProductoComponente> prods) {

        FachadaPersistencia.getInstancia().comenzarTransaccion();

        for (ProductoComponente prod : prods) {
            FachadaPersistencia.getInstancia().actualizar(prod, false);
        }

        FachadaPersistencia.getInstancia().finalizarTransaccion();
    }

}
