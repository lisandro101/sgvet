/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Demanda;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Stock;
import sgvet.persistencia.FachadaPersistencia;

public class GestorStock {

    private static GestorStock instance;
    // private Stock stock;

    public synchronized static GestorStock getInstancia() {
        if (instance == null) {
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
    private Stock stock;
    private int demandaReal;

    public void calcularStockDisponible() {
        for (ProductoComponente producto : productos) {
            stock = producto.getStockProducto();
            System.out.println("El producto " + producto.getNombre() + " tiene " + /*stock.getDisponible()*/ producto.getStock() + " unidades en disponibilidad");
            System.out.println("LLEGA!!!!");
        }
    }

    public List<ProductoComponente> calcularStockDemandaAnual() {
        List<ProductoComponente> prodOrd = new ArrayList<ProductoComponente>();
        ProductoComponente prodAnualMayor = null;
        for (int i = 0; i < cantElem; i++) {
            prodAnualMayor = productos.get(0);

            for (ProductoComponente producto : productos) {
                if (producto.getDemandaAnual() >= prodAnualMayor.getDemandaAnual()) {
                    prodAnualMayor = producto;
                }
            }
            prodOrd.add(prodAnualMayor);
            productos.remove(prodAnualMayor);




        }
        return prodOrd;
    }

    public List<ProductoComponente> calcularStockDemandaReal() {

        List<ProductoComponente> prodOrd = new ArrayList<ProductoComponente>();
        ProductoComponente prod = null;

        for (int i = 0; i < cantElem; i++) {
            prod = productos.get(0);

            for (ProductoComponente producto : productos) {
                List<Demanda> demandas = producto.getDemandas();
                int demandaRealMayor = 0;

                for (Demanda demanda : demandas) {
                    demandaReal = +demanda.getDemandaReal();
                }

                if (demandaReal >= demandaRealMayor) {
                    demandaRealMayor = demandaReal;
                    if (demandaReal == demandaRealMayor) {
                        prodOrd.add(prod);
                        productos.remove(prod);
                    }
                }
            }



        }
        return prodOrd;
    }

    




}


