/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

import java.util.Date;

/**
 *
 * @author stafoxter
 */
public class Demanda {

    private ProductoTerminado productoTerminado;
    private Date periodo;
    private double demandaReal;
    private double pM;
    private double PMP;
    private double pMSE;
    private double ponderacionPMP;

    public double getDemandaReal() {
        return demandaReal;
    }

    public void setDemandaReal(double demandaReal) {
        this.demandaReal = demandaReal;
    }

    public double getPM() {
        return pM;
    }

    public void setPM(double pM) {
        this.pM = pM;
    }

    public double getPonderacionPMP() {
        return ponderacionPMP;
    }

    public void setPonderacionPMP(double pMP) {
        this.ponderacionPMP = pMP;
    }

    public double getPMSE() {
        return pMSE;
    }

    public void setPMSE(double pMSE) {
        this.pMSE = pMSE;
    }

    public ProductoTerminado getProductoTerminado() {
        return productoTerminado;
    }

    public void setProductoTerminado(ProductoTerminado productoTerminado) {
        this.productoTerminado = productoTerminado;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public double getPMP() {
        return PMP;
    }

    public void setPMP(double PMP) {
        this.PMP = PMP;
    }


    
}
