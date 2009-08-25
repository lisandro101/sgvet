/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

/**
 *
 * @author stafoxter
 */
public class PuntoEquilibrio {

    private ProductoTerminado productoTerminado;
    private double equivalencia;

    public double getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(double equivalencia) {
        this.equivalencia = equivalencia;
    }

    public ProductoTerminado getProductoTerminado() {
        return productoTerminado;
    }

    public void setProductoTerminado(ProductoTerminado productoTerminado) {
        this.productoTerminado = productoTerminado;
    }
}
