/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

import java.util.Date;

/**
 *
 * @author Seba
 */
public class DemandaXPeriodo {
    private int nroPeriodo; // son 13 perioodos- del 1 al 13
    private Date anio;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean cerrado; // false si el periodo esta abierto (POR DEFECTO), true si esta cerrado

    private Date mes;
    private int totalVentas;
    private int prediccionVenta;

    public DemandaXPeriodo(Date periodo, int total) {
        mes = periodo;
        totalVentas= total;
    }

    public DemandaXPeriodo() {

    }
    /**
     * @return the mes
     */
    public Date getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(Date mes) {
        this.mes = mes;
    }

    /**
     * @return the ventas
     */
    public int getVentas() {
        return totalVentas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(int ventas) {
        this.totalVentas = ventas;
    }

    /**
     * @return the prediccionVenta
     */
    public int getPrediccionVenta() {
        return prediccionVenta;
    }

    /**
     * @param prediccionVenta the prediccionVenta to set
     */
    public void setPrediccionVenta(int prediccionVenta) {
        this.prediccionVenta = prediccionVenta;
    }

    /**
     * @return the nroPeriodo
     */
    public int getNroPeriodo() {
        return nroPeriodo;
    }

    /**
     * @param nroPeriodo the nroPeriodo to set
     */
    public void setNroPeriodo(int nroPeriodo) {
        this.nroPeriodo = nroPeriodo;
    }

    /**
     * @return the anio
     */
    public Date getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Date anio) {
        this.anio = anio;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the cerrado
     */
    public boolean isCerrado() {
        return cerrado;
    }

    /**
     * @param cerrado the cerrado to set
     */
    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    

}
