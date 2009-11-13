/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.entidades;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author stafoxter
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("X")
public abstract class Politica implements Serializable {

    private String id;
    private double nivelServicio;
    private int tiempoEntrega;
    private double desviacionEstandarDemanda;
    private double costoEmision;
    private double tasaAnualAlmacenamiento;

    /**
     * Constructor
     */
    public Politica() {
        setId(UUID.randomUUID().toString());
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nivelServicio
     */
    public double getNivelServicio() {
        return nivelServicio;
    }

    /**
     * @param nivelServicio the nivelServicio to set
     */
    public void setNivelServicio(double nivelServicio) {
        this.nivelServicio = nivelServicio;
    }

    /**
     * @return the tiempoEntrega
     */
    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    /**
     * @param tiempoEntrega the tiempoEntrega to set
     */
    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    /**
     * @return the desviacionEstandarDemanda
     */
    public double getDesviacionEstandarDemanda() {
        return desviacionEstandarDemanda;
    }

    /**
     * @param desviacionEstandarDemanda the desviacionEstandarDemanda to set
     */
    public void setDesviacionEstandarDemanda(double desviacionEstandarDemanda) {
        this.desviacionEstandarDemanda = desviacionEstandarDemanda;
    }

    /**
     * @return the costoEmision
     */
    public double getCostoEmision() {
        return costoEmision;
    }

    /**
     * @param costoEmision the costoEmision to set
     */
    public void setCostoEmision(double costoEmision) {
        this.costoEmision = costoEmision;
    }


    /**
     * @return the tasaAnualAlmacenamiento
     */
    public double getTasaAnualAlmacenamiento() {
        return tasaAnualAlmacenamiento;
    }

    /**
     * @param tasaAnualAlmacenamiento the tasaAnualAlmacenamiento to set
     */
    public void setTasaAnualAlmacenamiento(double tasaAnualAlmacenamiento) {
        this.tasaAnualAlmacenamiento = tasaAnualAlmacenamiento;
    }
    
}
