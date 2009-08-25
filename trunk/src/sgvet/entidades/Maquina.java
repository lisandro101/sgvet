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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene los datos de una máquina
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="maquinas")
public class Maquina implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = Arrays.asList(
            "nombre", "codigo");
    
    private String id;
    private String codigo;
    private Date fechaAntiguedad;
    private Date proximoMantenimiento;
    private Date fechaDeFabricacion;
    private String nombre;
    private CentroDeTrabajo centroDeTrabajo;
    private Sector sector;
    private Edificio edificio;
    private boolean borrado;

    /**
     * Constructor
     */
    public Maquina() {
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

    @Column(name="codigo", length=20)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name="fecha_antiguedad")
    @Temporal(TemporalType.DATE)
    public Date getFechaAntiguedad() {
        return fechaAntiguedad;
    }

    public void setFechaAntiguedad(Date fechaAntiguedad) {
        this.fechaAntiguedad = fechaAntiguedad;
    }

    @Column(name="proximo_mantenimiento")
    @Temporal(TemporalType.DATE)
    public Date getProximoMantenimiento() {
        return proximoMantenimiento;
    }

    public void setProximoMantenimiento(Date proximoMantenimiento) {
        this.proximoMantenimiento = proximoMantenimiento;
    }
    
    
    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JoinColumn(name="centro_de_trabajo_id")
    @ManyToOne(targetEntity=CentroDeTrabajo.class, cascade=CascadeType.ALL)
    public CentroDeTrabajo getCentroDeTrabajo() {
        return centroDeTrabajo;
    }

    public void setCentroDeTrabajo(CentroDeTrabajo centroDeTrabajo) {
        this.centroDeTrabajo = centroDeTrabajo;
    }

    @JoinColumn(name="sector_id")
    @ManyToOne(targetEntity=Sector.class, cascade=CascadeType.ALL)
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @JoinColumn(name="edificio_id")
    @ManyToOne(targetEntity=Edificio.class, cascade=CascadeType.ALL)
    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
    
    @Column(name="borrado")
    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    @Transient
    public List<String> getCamposUnicos() {
        return CAMPOS_UNICOS;
    }

    @Column(name="fecha_fabricacion")
    @Temporal(TemporalType.DATE)
    public Date getFechaDeFabricacion() {
        return fechaDeFabricacion;
    }

    public void setFechaDeFabricacion(Date fechaDeFabricacion) {
        this.fechaDeFabricacion = fechaDeFabricacion;
    }
}