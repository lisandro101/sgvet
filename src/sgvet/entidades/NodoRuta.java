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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene la información del nodo de la ruta
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="nodos_ruta")
public class NodoRuta implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = new ArrayList<String>(0);
    
    private String id;
    private List<ParteDeNodo> materiales;
    private List<HoraLaboral> horasTrabajadas;
    private CentroDeTrabajo centroTrabajo;
    private RutaFabricacion rutaFabricacion;
    private boolean borrado;

    /**
     * Constructor
     */
    public NodoRuta(){
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

    
    @OneToMany(targetEntity=ParteDeNodo.class, cascade=CascadeType.ALL,
    mappedBy="nodoRuta")
    public List<ParteDeNodo> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<ParteDeNodo> materiales) {
        this.materiales = materiales;
    }
    
    @JoinColumn(name="centro_de_trabajo")
    @ManyToOne(targetEntity=CentroDeTrabajo.class, cascade=CascadeType.ALL)
    public CentroDeTrabajo getCentroTrabajo() {
        return centroTrabajo;
    }

    public void setCentroTrabajo(CentroDeTrabajo centroTrabajo) {
        this.centroTrabajo = centroTrabajo;
    }

    @JoinColumn(name="ruta_fabricacion_id")
    @ManyToOne(targetEntity=RutaFabricacion.class, cascade=CascadeType.ALL)
    public RutaFabricacion getRutaFabricacion() {
        return rutaFabricacion;
    }

    public void setRutaFabricacion(RutaFabricacion rutaFabricacion) {
        this.rutaFabricacion = rutaFabricacion;
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

    @OneToMany(targetEntity=HoraLaboral.class, cascade=CascadeType.ALL,
    mappedBy="nodoRuta")
    public List<HoraLaboral> getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(List<HoraLaboral> horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodoRuta other = (NodoRuta) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}