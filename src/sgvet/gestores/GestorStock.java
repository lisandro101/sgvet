/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.DetalleOrdenCompra;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;

public class GestorStock {

    private static GestorStock instance;

    public synchronized static GestorStock getInstancia() {
        if (instance == null) {
            instance = new GestorStock();
        }
        return instance;
    }

    private double calcularStockPendiente(ProductoComponente prod) {

        double cantidadPendiente = 0;
        List<DetalleOrdenCompra> detalles;

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM DetalleOrdenCompra a WHERE a.componente=:producto AND a.borrado=false");
        consulta.setParameter("producto", prod);
        detalles = FachadaPersistencia.getInstancia().buscar(DetalleOrdenCompra.class,
                consulta);

        for (DetalleOrdenCompra detalle : detalles) {
            if(!detalle.getOrdenCompra().isBorrado() && detalle.getOrdenCompra().getEstado().equals(
                    OrdenCompra.EstadoOrdenCompra.PENDIENTE)) {
                cantidadPendiente += detalle.getCantidad();
            }
        }

        return cantidadPendiente;
    }

    private double calcularStockDisponible(ProductoComponente prod){

        double stockDisponible;

        stockDisponible = prod.getStock() + calcularStockPendiente(prod); //- stockComprometido

        return stockDisponible;
        
    }
}