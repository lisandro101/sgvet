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

        double cantidadPendiente = 0.0;
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
        } else if (nivelServicio > 50 && nivelServicio <= 60) {
            factorSeguridad = 0.25;
        } else if (nivelServicio > 60 && nivelServicio <= 70) {
            factorSeguridad = 0.52;
        } else if (nivelServicio > 70 && nivelServicio <= 80) {
            factorSeguridad = 0.84;
        } else if (nivelServicio > 80 && nivelServicio <= 90) {
            factorSeguridad = 1.28;
        } else if (nivelServicio > 90 && nivelServicio <= 95) {
            factorSeguridad = 1.64;
        } else if (nivelServicio > 95 && nivelServicio <= 97.5) {
            factorSeguridad = 1.96;
        } else if (nivelServicio > 97.5 && nivelServicio <= 99.9) {
            factorSeguridad = 3.08;
        } else if (nivelServicio > 99.9 && nivelServicio <= 100) {
            factorSeguridad = 3.6;
        }
        if(nivelServicio < 0 || nivelServicio >100){
            System.out.println("\n\n\n Nivel de servicio fuera de rango \n\n");
        }
        
        return factorSeguridad;
    }

    protected double getPrediccionDemanda(ProductoComponente prod, double tiempoEntrega) {

        GestorDemanda gd = GestorDemanda.getInstancia();
        GestorFecha gf = GestorFecha.getInstancia();
        List<DemandaXPeriodo> demandas;
        int periodoSiguiente;
        int anio=0;
        double prediccion = 0.0;
        double prediccionDemanda;

//        demandas = gd.calcularPrediccionDemandaXPeriodo(prod);
        
        anio = gf.getAnio(gf.getFechaHoy());
        if(gf.aQuePeriodoCorrespondeLaFecha(gf.getFechaHoy()) != 13){
            periodoSiguiente = gf.aQuePeriodoCorrespondeLaFecha(gf.getFechaHoy()) + 1;
        }else{
            periodoSiguiente = 1;
            ++anio;
        }

//        for (DemandaXPeriodo demanda : demandas) {
//
//            if (gf.getAnio(demanda.getAnio()) == anio && demanda.getNroPeriodo() == periodoSiguiente) {
//                prediccion = demanda.getPrediccionVenta();
//            }
//            if(periodoSiguiente == 1 && (gf.getAnio(demanda.getAnio())+1) == anio
//                    && demanda.getNroPeriodo() == periodoSiguiente){
//                prediccion = demanda.getPrediccionVenta();
//            }
//
//        }

        prediccion = gd.predecirDemanda(prod, anio, periodoSiguiente);

        System.out.println("Resultado de la prediccion: "+ prediccion );

        prediccionDemanda = prediccion / 28 * tiempoEntrega;

        System.out.println("Resultado de la prediccion demanda: "+ prediccionDemanda );

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
