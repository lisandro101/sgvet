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

    private ProductoComponente producto;
    private double equivalencia;

    public double getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(double equivalencia) {
        this.equivalencia = equivalencia;
    }

    public ProductoComponente getProductoTerminado() {
        return producto;
    }

    public void setProductoTerminado(ProductoComponente productoTerminado) {
        this.producto = productoTerminado;
    }
}
