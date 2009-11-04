/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import sgvet.persistencia.IPersistente;

/**
 * Clase que almacena los tipos de producto que existen segun su demanda (A, B o C).
 * @author Lisandro
 */
@Entity
@Table(name="clases_demanda")
public class ClaseDemanda implements Serializable, IPersistente {

    private static final long serialVersionUID = 1L;
    private String clase;
    private double L;
    private int numeroClase;

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the numeroClase
     */
    @Id
    public int getNumeroClase() {
        return numeroClase;
    }

    /**
     * @param numeroClase the numeroClase to set
     */
    public void setNumeroClase(int numeroClase) {
        this.numeroClase = numeroClase;
    }

    /**
     * @return the L
     */
    public double getL() {
        return L;
    }

    /**
     * @param L the L to set
     */
    public void setL(double L) {
        this.L = L;
    }

    @Override
    public List<String> getCamposUnicos() {
        return (new ArrayList<String>());
    }

    @Override
    public void setBorrado(boolean borrado) {
    }

    @Override
    public String toString(){
        return getClase();
    }

}
