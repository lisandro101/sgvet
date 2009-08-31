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
    private int demandaReal;
    private double pM;
    private double PMP;
    private double pMSE;
    private int prediccionSES;

    public int getDemandaReal() {
        return demandaReal;
    }

    public void setDemandaReal(int demandaReal) {
        this.demandaReal = demandaReal;
    }

    public double getPM() {
        return pM;
    }

    public void setPM(double pM) {
        this.pM = pM;
    }

    public double getPrediccionSES() {
        return prediccionSES;
    }

    public void setPrediccionSES(int pMP) {
        this.prediccionSES = pMP;
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
