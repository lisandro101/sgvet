package sgvet.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Lisandro
 * @version 1.0
 * @created 21-oct-2008 12:47:04 a.m.
 */
@Entity
@Table(name="productos_componente")
@DiscriminatorValue("C")
public class ProductoComponente extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
}
