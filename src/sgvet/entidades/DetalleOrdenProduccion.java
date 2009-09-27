package sgvet.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene una línea de detalle de la orden de producción
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
@Entity
@Table(name="detalles_ordenes_de_produccion")
public class DetalleOrdenProduccion implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = new ArrayList<String>(0);
    
    private String id;
    private int cantidad;
    private ProductoComponente producto;
    private boolean borrado;
    private Venta venta;
    
    /**
     * Constructor
     */
    public DetalleOrdenProduccion() {
        setId(UUID.randomUUID().toString());
    }

    /**
     * Devuelve el identificador único de la clase
     * 
     * @return El identificador único de la clase
     */
    @Id
    @Column(name="id", length=36)
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único de la clase
     * 
     * @param id Nuevo valor del identificador único de la clase
     */
    public void setId(String id) {
        this.id = id;
    }

    @Column(name="cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @JoinColumn(name="producto_componente_id")
    @ManyToOne(targetEntity=ProductoComponente.class, cascade=CascadeType.ALL)
    public ProductoComponente getProducto() {
        return producto;
    }

    public void setProducto(ProductoComponente productoComponente) {
        this.producto = productoComponente;
    }

    @Column(name="borrado")
    public boolean isBorrado() {
        return borrado;
    }

    @Override
    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
    
    
    @JoinColumn(name="orden_de_produccion_id")
    @ManyToOne(targetEntity=Venta.class, cascade=CascadeType.ALL)
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    @Transient
    public List<String> getCamposUnicos() {
        return CAMPOS_UNICOS;
    }
}