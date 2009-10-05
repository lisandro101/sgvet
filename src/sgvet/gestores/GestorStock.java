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

    public List<ProductoComponente> calcularStockDisponible() {

        List<ProductoComponente> prodOrd = new ArrayList<ProductoComponente>();
        ProductoComponente stockMayor = null;

        for (int i = 0; i < cantElem; i++) {
            stockMayor = productos.get(0);

            for (ProductoComponente producto : productos) {

                if (producto.getStock() >= stockMayor.getStock()) {
                    stockMayor = producto;
                }
                prodOrd.add(stockMayor);
                productos.remove(stockMayor);
            }
        // stock = producto.getStockProducto();
        // System.out.println("El producto " + producto.getNombre() + " tiene " + /*stock.getDisponible()*/producto.getStock() + " unidades en disponibilidad");

        }
        return prodOrd;
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
/*
    public List<ProductoComponente> calcularStockReserva() {

        List<ProductoComponente> prodOrd = new ArrayList<ProductoComponente>();
        ProductoComponente stockMayorReserva = null;

        for (int i = 0; i < cantElem; i++) {
            stockMayorReserva = productos.get(0);

            for (ProductoComponente producto : productos) {

                if (producto.getStockReserva() >= stockMayorReserva.getStockReserva()) {
                    stockMayorReserva = producto;
                }
                prodOrd.add(stockMayorReserva);
                productos.remove(stockMayorReserva);
            }


        }
        return prodOrd;
    }

     public List<ProductoComponente> obtenerPuntoReposicion() {

        List<ProductoComponente> prodOrd = new ArrayList<ProductoComponente>();
        ProductoComponente puntoRepMayor = null;

        for (int i = 0; i < cantElem; i++) {
            puntoRepMayor = productos.get(0);

            for (ProductoComponente producto : productos) {

                if (producto.getStockProducto().getPuntoReposicion() >= puntoRepMayor.getStockProducto().getPuntoReposicion()) {
                    puntoRepMayor = producto;
                }
                prodOrd.add(puntoRepMayor);
                productos.remove(puntoRepMayor);
            }


        }
        return prodOrd;
    }

      public List<ProductoComponente> MostrarFaltanteStock() {

        List<ProductoComponente> prodOrd = new ArrayList<ProductoComponente>();
        ProductoComponente faltanteMayor = null;

        for (int i = 0; i < cantElem; i++) {
            faltanteMayor = productos.get(0);

            for (ProductoComponente producto : productos) {

                if (producto.getStockProducto().getFaltante()>= faltanteMayor.getStockProducto().getFaltante()) {
                    faltanteMayor = producto;
                }
                prodOrd.add(faltanteMayor);
                productos.remove(faltanteMayor);
            }


        }
        return prodOrd;
    }
      */


}


