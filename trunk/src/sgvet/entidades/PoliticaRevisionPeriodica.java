/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author stafoxter
 */
@Entity
@DiscriminatorValue("R")
public class PoliticaRevisionPeriodica extends Politica{

    private static final long serialVersionUID = 1L;

    private int peridoDeRevision;

    /**
     * @return the peridoDeRevision
     */
    public int getPeridoDeRevision() {
        return peridoDeRevision;
    }

    /**
     * @param peridoDeRevision the peridoDeRevision to set
     */
    public void setPeridoDeRevision(int peridoDeRevision) {
        this.peridoDeRevision = peridoDeRevision;
    }

}
