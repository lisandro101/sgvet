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
 * Contiene los datos de una pieza de la estructura de un producto
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="partes_de_estructura")
public class ParteDeEstructura implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = new ArrayList<String>(0);
    
    private String id;
    private EstructuraDeProducto estructura;
    private Componente componente;
    private double cantidad;
    private boolean borrado;
    
    /**
     * Constructor
     */
    public ParteDeEstructura() {
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

    @JoinColumn(name="estructura_de_producto_id")
    @ManyToOne(targetEntity=EstructuraDeProducto.class, cascade=CascadeType.ALL)
    public EstructuraDeProducto getEstructura() {
        return estructura;
    }

    public void setEstructura(EstructuraDeProducto estructura) {
        this.estructura = estructura;
    }

    @JoinColumn(name="componente_id")
    @ManyToOne(targetEntity=Componente.class)  //, cascade=CascadeType.ALL) //TODO: quite el borrado en cascada para poder eliminar partes de estructuras fisicamente sin eliminar Componentes
    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    @Column(name="cantidad")
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
}