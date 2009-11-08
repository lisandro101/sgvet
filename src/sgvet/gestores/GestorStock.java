/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.DetalleOrdenCompra;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.Politica;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.auxiliares.DemandaXPeriodo;
import sgvet.persistencia.FachadaPersistencia;

public class GestorStock {

    private static GestorStock instance;

    public synchronized static GestorStock getInstancia() {
        if (instance == null) {
            instance = new GestorStock();
        }
        return instance;
    }

    public double getStockPendiente(ProductoComponente prod) {

        double cantidadPendiente = 0;
        List<DetalleOrdenCompra> detalles;

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM DetalleOrdenCompra a WHERE a.componente=:producto AND a.borrado=false");
        consulta.setParameter("producto", prod);
        detalles = FachadaPersistencia.getInstancia().buscar(DetalleOrdenCompra.class,
                consulta);

        for (DetalleOrdenCompra detalle : detalles) {

            if (!detalle.getOrdenCompra().isBorrado() && detalle.getOrdenCompra().getEstado().equals(
                    OrdenCompra.EstadoOrdenCompra.PENDIENTE)) {
                cantidadPendiente += detalle.getCantidad();
            }

        }

        return cantidadPendiente;
    }

    public double getFactorDeSeguridad(int nivelServicio) {

        double K = 0;

        switch (nivelServicio) {
            case 5: {
                K = 0;
                break;
            }
            case 6: {
                K = 0.25;
                break;
            }
            case 7: {
                K = 0.52;
                break;
            }
            case 8: {
                K = 0.84;
                break;
            }
            case 9: {
                K = 1.24;
                break;
            }
            case 95: {
                K = 1.64;
                break;
            }
            case 99: {
                K = 0.84;
                break;
            }
            default: {
                K = 99999999;
                System.out.println("PORCENTAJE FUERA DE RANGO");
            }
        }
        return K;
    }

    public double getPrediccionDemanda(ProductoComponente prod, double tiempoEntrega) {

        GestorDemanda gd = GestorDemanda.getInstancia();
        GestorFecha gf = GestorFecha.getInstancia();
        List<DemandaXPeriodo> demandas;
        int periodoSiguiente;
        int anio;
        double prediccion = 0;
        double prediccionDemanda;

        demandas = gd.calcularPrediccionDemandaXPeriodo(prod);
        periodoSiguiente = gf.aQuePeriodoCorrespondeLaFecha(gf.getFechaHoy()) + 1;
        anio = gf.getAnio(gf.getFechaHoy());

        for (DemandaXPeriodo demanda : demandas) {

            if (gf.getAnio(demanda.getAnio()) == anio && demanda.getNroPeriodo() == periodoSiguiente) {
                prediccion = demanda.getPrediccionVenta();
            }

        }

        prediccionDemanda = prediccion / 28 * tiempoEntrega;

        return prediccionDemanda;

    }

    public double getQOptimo(ProductoComponente producto) {

        double demandaAnual;
        double QOptimo;
        Politica politica;

        politica = producto.getProveedores().get(0).getPolitica();


        demandaAnual = producto.getDemandaAnual();

        QOptimo = Math.sqrt((2 * politica.getCostoEmision() * demandaAnual) / getCostoAnualAlmacenamiento(producto));

        return QOptimo;

    }

    private double getCostoAnualAlmacenamiento(ProductoComponente producto) {

        double costoUnitario;
        double costoAnualAlmacenamiento;
        Politica politica;

        politica = producto.getProveedores().get(0).getPolitica();

        costoUnitario = producto.getCostoUnitario();
        costoAnualAlmacenamiento = politica.getTasaAnualAlmacenamiento() * costoUnitario;

        return costoAnualAlmacenamiento;

    }
}
