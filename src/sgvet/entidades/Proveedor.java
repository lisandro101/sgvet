package sgvet.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene los datos de un proveedor
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = Arrays.asList(
            "nombre", "codigo");
    
    private String id;
    private String direccion;
    private Date fechaInicioActividad;
    private String mail;
    private String nombreContacto;
    private String codigo;
    private String nombre;
    private String telefono;
    private List<OrdenCompra> ordenesCompra;
    private List<Componente> componentes;
    private boolean borrado;

    /**
     * Constructor
     */
    public Proveedor(){
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

    @Column(name="direccion", length=100)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name="fecha_inicio_actividad")
    @Temporal(TemporalType.DATE)
    public Date getFechaInicioActividad() {
        return fechaInicioActividad;
    }

    public void setFechaInicioActividad(Date fechaInicioActividad) {
        this.fechaInicioActividad = fechaInicioActividad;
    }

    @Column(name="mail", length=100)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name="nombre_contacto", length=100)
    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    @Column(name="codigo", length=20)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name="nombre", length=100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="telefono", length=15)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @ManyToMany(targetEntity=Componente.class, cascade=CascadeType.ALL,
    mappedBy="proveedores")
    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    @OneToMany(targetEntity=OrdenCompra.class, cascade=CascadeType.ALL,
    mappedBy="proveedor")
    public List<OrdenCompra> getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(List<OrdenCompra> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proveedor other = (Proveedor) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 79 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nombre;
    }

}