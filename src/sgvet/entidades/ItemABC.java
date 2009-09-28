/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

/**
 *
 * @author Seba
 */
public class ItemABC {
    private ProductoComponente producto;
    private double demandaValorizada;
    private double demandaAcumulada;

    public ItemABC(ProductoComponente prod, double deman){
        this.producto = prod;
        this.demandaValorizada = deman;
    }

    /**
     * @return the producto
     */
    public ProductoComponente getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductoComponente producto) {
        this.producto = producto;
    }

    /**
     * @return the demandaValorizada
     */
    public double getDemandaValorizada() {
        return demandaValorizada;
    }

    /**
     * @param demandaValorizada the demandaValorizada to set
     */
    public void setDemandaValorizada(double demandaValorizada) {
        this.demandaValorizada = demandaValorizada;
    }

    /**
     * @return the demandaAcumulada
     */
    public double getDemandaAcumulada() {
        return demandaAcumulada;
    }

    /**
     * @param demandaAcumulada the demandaAcumulada to set
     */
    public void setDemandaAcumulada(double demandaAcumulada) {
        this.demandaAcumulada = demandaAcumulada;
    }
}
