/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

/**
 *
 * @author stafoxter
 */
public class CostoVariable {
    private ProductoTerminado productoTerminado;
    private double costoManoObra;
    private double costoMateriales;

    public double getCostoManoObra() {
        return costoManoObra;
    }

    public void setCostoManoObra(double costoManoObra) {
        this.costoManoObra = costoManoObra;
    }

    public double getCostoMateriales() {
        return costoMateriales;
    }

    public void setCostoMateriales(double costoMateriales) {
        this.costoMateriales = costoMateriales;
    }

    public ProductoTerminado getProductoTerminado() {
        return productoTerminado;
    }

    public void setProductoTerminado(ProductoTerminado productoTerminado) {
        this.productoTerminado = productoTerminado;
    }
    
    
}
