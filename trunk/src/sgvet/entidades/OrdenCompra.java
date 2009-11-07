package sgvet.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene los datos de una orden de compra
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="ordenes_de_compra")
public class OrdenCompra implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = new ArrayList<String>(0);
    
    private String id;
    private Proveedor proveedor;
    private Date fecha;
    private List<DetalleOrdenCompra> detallesOrdenCompra;
    private int nroOrdenCompra;
    private boolean borrado;
    private EstadoOrdenCompra estado;

    public enum EstadoOrdenCompra {
        PENDIENTE ("Pendiente"),
        TERMINADO ("Terminado"),
        ANULADO ("Anulado");

        private String nombre;

        private EstadoOrdenCompra(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
 
    /**
     * Constructor
     */
    public OrdenCompra(){
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
    
    @JoinColumn(name="proveedor_id")
    @ManyToOne(targetEntity=Proveedor.class, cascade=CascadeType.ALL)
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Column(name="fecha")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @OneToMany(targetEntity=DetalleOrdenCompra.class, cascade=CascadeType.ALL,
    mappedBy="ordenCompra")
    public List<DetalleOrdenCompra> getDetallesOrdenCompra() {
        return detallesOrdenCompra;
    }

    public void setDetallesOrdenCompra(List<DetalleOrdenCompra> detallesOrdenCompra) {
        this.detallesOrdenCompra = detallesOrdenCompra;
    }
    
    @Column(name="nro_orden_compra")
    public int getNroOrdenCompra() {
        return nroOrdenCompra;
    }

    public void setNroOrdenCompra(int NroOrdenCompra) {
        this.nroOrdenCompra = NroOrdenCompra;
    }
    
    
    
    @Column(name="borrado")
    public boolean isBorrado() {
        return borrado;
    }

    @Override
    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    @Transient
    public List<String> getCamposUnicos() {
        return CAMPOS_UNICOS;
    }

    @Override
    public String toString() {
        return id;
    }

    @Column(name="estado")
    public EstadoOrdenCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrdenCompra estado) {
        this.estado = estado;
    }
    
}