package sgvet.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

    private List<Demanda> demandas;
    private double precioVenta;
    private String tipoPrediccion;

    @Column(name="precio_venta")
    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Column(name="tipo_prediccion", length=20)
    public String getTipoPrediccion() {
        return tipoPrediccion;
    }

    public void setTipoPrediccion(String tipoPrediccion) {
        this.tipoPrediccion = tipoPrediccion;
    }

    @OneToMany(targetEntity=Demanda.class, cascade=CascadeType.ALL,
    mappedBy="producto")
    public List<Demanda> getDemandas() {
        return demandas;
    }

    public void setDemandas(List<Demanda> demandas) {
        this.demandas = demandas;
    }
}