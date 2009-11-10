/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author stafoxter
 */
@Entity
@DiscriminatorValue("R")
public class PoliticaRevisionPeriodica extends Politica implements Serializable, IPersistente{

    private static final long serialVersionUID = 1L;

    private int peridoDeRevision;

    /**
     * @return the peridoDeRevision
     */
    public int getPeridoDeRevision() {
        return peridoDeRevision;
    }

    @Override
    public String toString(){
        return "Politica Revision Periodca S/R";
    }
    /**
     * @param peridoDeRevision the peridoDeRevision to set
     */
    public void setPeridoDeRevision(int peridoDeRevision) {
        this.peridoDeRevision = peridoDeRevision;
    }

    @Override
    public List<String> getCamposUnicos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBorrado(boolean borrado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
