package sgvet.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Contiene la información específica de los productos terminados
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="productos_terminados")
@DiscriminatorValue("T")
public class ProductoTerminado extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private double precioVenta;
    
    @Column(name="precio_venta")
    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}