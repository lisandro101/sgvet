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

public abstract class GestorStock {

    protected double getStockPendiente(ProductoComponente prod) {

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

    protected double getFactorDeSeguridad(double nivelServicio) {

        double factorSeguridad = 0;

        if (nivelServicio <= 50) {
            factorSeguridad = 0;
        } else if (nivelServicio <= 60) {
            factorSeguridad = 0.25;
        } else if (nivelServicio <= 70) {
            factorSeguridad = 0.52;
        } else if (nivelServicio <= 80) {
            factorSeguridad = 0.84;
        } else if (nivelServicio <= 90) {
            factorSeguridad = 1.28;
        } else if (nivelServicio <= 95) {
            factorSeguridad = 1.64;
        } else if (nivelServicio <= 97.5) {
            factorSeguridad = 1.96;
        } else if (nivelServicio <= 99.9) {
            factorSeguridad = 3.08;
        } else if (nivelServicio <= 100) {
            factorSeguridad = 3.6;
        }
        
        return factorSeguridad;
    }

    protected double getPrediccionDemanda(ProductoComponente prod, double tiempoEntrega) {

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

        politica = producto.getPolitica();


        demandaAnual = producto.getDemandaAnual();

        QOptimo = Math.sqrt((2 * politica.getCostoEmision() * demandaAnual) / getCostoAnualAlmacenamiento(producto));

        return QOptimo;

    }

    protected double getCostoAnualAlmacenamiento(ProductoComponente producto) {

        double costoUnitario;
        double costoAnualAlmacenamiento;
        Politica politica;

        politica = producto.getPolitica();

        costoUnitario = producto.getCostoUnitario();
        costoAnualAlmacenamiento = politica.getTasaAnualAlmacenamiento() * costoUnitario;

        return costoAnualAlmacenamiento;

    }
}
