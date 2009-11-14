/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author stafoxter
 */
@Entity
public class Politica implements Serializable,IPersistente {

    private static final long serialVersionUID = 1L;
    private String id;
    private double nivelServicio;
    private int tiempoEntrega;
    private double desviacionEstandarDemanda;
    private double costoEmision;
    private double tasaAnualAlmacenamiento;
    private TipoPolitica politica;

    @Override
    public List<String> getCamposUnicos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBorrado(boolean borrado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Representa el tipo de politica
     */
    public enum TipoPolitica {

        CONTINUA("Continua"),
        PERIODICA("Periodica");
        private String nombre;

        private TipoPolitica(String nombre) {
            this.nombre = nombre;
        }
    }

    /**
     * Devuelve el Tipo de Politica correspondiente a la cadena recibida
     * @param estado
     * @return
     */
    public TipoPolitica obtenerEstado(String estado) {

        TipoPolitica resultado = null;

        if (estado.equals("Continua")) {
            resultado = TipoPolitica.CONTINUA;
        } else if (estado.equals("Periodica")) {
            resultado = TipoPolitica.PERIODICA;
        }

        return resultado;
    }

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

    public TipoPolitica getTipoPolitica() {
        return politica;
    }

    public void setTipoPolitica(TipoPolitica politica) {
        this.politica = politica;
    }
}
