/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.entidades.auxiliares;

import sgvet.entidades.ProductoComponente;

/**
 *
 * @author Lisandro
 */
public class DTOPedidos {

    private ProductoComponente producto;
    private double cantidadOptima;

    public DTOPedidos(ProductoComponente producto,
            double cantidadOptima) {
        this.producto = producto;
        this.cantidadOptima = cantidadOptima;
    }

    /**
     * @return the cantidadOptima
     */
    public double getCantidadOptima() {
        return cantidadOptima;
    }

    /**
     * @param cantidadOptima the cantidadOptima to set
     */
    public void setCantidadOptima(double cantidadOptima) {
        this.cantidadOptima = cantidadOptima;
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
}
