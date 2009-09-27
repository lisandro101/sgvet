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
    private Date mes;
    private int totalVentas;

    public DemandaXPeriodo(Date periodo, int total) {
        mes = periodo;
        totalVentas= total;
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

    

}
