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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene los datos de una venta
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name = "ordenes_de_produccion")
public class Venta implements Serializable, IPersistente {

    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = new ArrayList<String>(0);
    private String id;
    private Date fecha;
    private String nombreCliente;
    private List<DetalleOrdenProduccion> detallesOrdenProduccion;
    private boolean borrado;
    private int nroOrdenProduccion;
    private EstadoVenta estado;

    /**
     * Representa el estado de una venta
     */
    public enum EstadoVenta {

        PROCESANDO("Procesando"),
        TERMINADO("Terminado"),
        ANULADO("Anulado"),
        SUSPENDIDO("Suspendido");
        private String nombre;

        private EstadoVenta(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Devuelve el EstadoVenta correspondiente a la cadena recibida
         * @param estado 
         * @return
         */
        public EstadoVenta obtenerEstado(String estado) {

            EstadoVenta resultado = null;

            if (estado.equals("Procesando")) {
                resultado = EstadoVenta.PROCESANDO;
            } else if (estado.equals("Terminado")) {
                resultado = EstadoVenta.TERMINADO;
            } else if (estado.equals("Anulado")) {
                resultado = EstadoVenta.ANULADO;
            } else if (estado.equals("Suspendido")) {
                resultado = EstadoVenta.SUSPENDIDO;
            }

            return resultado;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    /**
     * Constructor
     */
    public Venta() {
        setId(UUID.randomUUID().toString());
    }

    /**
     * Devuelve el identificador único de la clase
     * 
     * @return El identificador único de la clase
     */
    @Id
    @Column(name = "id", length = 36)
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

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "nombre_cliente", length = 100)
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @OneToMany(targetEntity = DetalleOrdenProduccion.class,
    cascade = CascadeType.ALL, mappedBy = "venta")
    public List<DetalleOrdenProduccion> getDetallesOrdenProduccion() {
        return detallesOrdenProduccion;
    }

    public void setDetallesOrdenProduccion(List<DetalleOrdenProduccion> detalles) {
        this.detallesOrdenProduccion = detalles;
    }

    @Column(name = "borrado")
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

    @Column(name = "nro_orden_produccion")
    public int getNroOrdenProduccion() {
        return nroOrdenProduccion;
    }

    public void setNroOrdenProduccion(int nroOrden) {
        this.nroOrdenProduccion = nroOrden;
    }

    @Column(name = "estado")
    public EstadoVenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return id;
    }
}
