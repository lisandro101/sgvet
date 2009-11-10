package sgvet.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Lisandro
 * @version 1.0
 * @created 21-oct-2008 12:47:04 a.m.
 */
@Entity
@Table(name = "productos_componente")
@DiscriminatorValue("C")
public class ProductoComponente extends Intermedio implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Demanda> demandas;
    private double precioVenta;
    private String tipoPrediccion;
    private ClaseDemanda categoria;
    private boolean seRealizoPedido;
    private Date fechaUltimaRevision;

    @Column(name = "precio_venta")
    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Column(name = "tipo_prediccion", length = 20)
    public String getTipoPrediccion() {
        return tipoPrediccion;
    }

    public void setTipoPrediccion(String tipoPrediccion) {
        this.tipoPrediccion = tipoPrediccion;
    }

    @OneToMany(targetEntity = Demanda.class, cascade = CascadeType.ALL,
    mappedBy = "producto")
    public List<Demanda> getDemandas() {
        return demandas;
    }

    public void setDemandas(List<Demanda> demandas) {
        this.demandas = demandas;
    }

    /**
     * @return the categoria
     */
    @OneToOne(targetEntity = ClaseDemanda.class, cascade = CascadeType.ALL)
    public ClaseDemanda getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(ClaseDemanda categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the seRealizoPedido
     */
    public boolean isSeRealizoPedido() {
        return seRealizoPedido;
    }

    /**
     * @param seRealizoPedido the seRealizoPedido to set
     */
    public void setSeRealizoPedido(boolean seRealizoPedido) {
        this.seRealizoPedido = seRealizoPedido;
    }

    /**
     * @return the fechaUltimaRevision
     */
    @Column(name="fecha_ultima_revision")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFechaUltimaRevision() {
        return fechaUltimaRevision;
    }

    /**
     * @param fechaUltimaRevision the fechaUltimaRevision to set
     */
    public void setFechaUltimaRevision(Date fechaUltimaRevision) {
        this.fechaUltimaRevision = fechaUltimaRevision;
    }
}
