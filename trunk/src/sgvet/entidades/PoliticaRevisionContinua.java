/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.entidades;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Clase para trabajar con los parametros necesarios para las politicas de revicion continua.
 *
 * @author Lisandro
 */
@Entity
@DiscriminatorValue("Q")
public class PoliticaRevisionContinua extends Politica implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String id;
    private double prediccionDemanda;

    /**
     * Constructor
     */
    public PoliticaRevisionContinua() {
        setId(UUID.randomUUID().toString());
    }

    /**
     * @return the prediccionDemanda
     */
    public double getPrediccionDemanda() {
        return prediccionDemanda;
    }

    /**
     * @param prediccionDemanda the prediccionDemanda to set
     */
    public void setPrediccionDemanda(double prediccionDemanda) {
        this.prediccionDemanda = prediccionDemanda;
    }

    @Id
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
