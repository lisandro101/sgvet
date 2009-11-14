/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author Lisandro
 */
@Entity
public class Configuracion implements Serializable, IPersistente {
    
    private static final long serialVersionUID = 1L;

    private String id;    
    private Date ultimaSenialRastreo;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the ultimaSenialRastreo
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getUltimaSenialRastreo() {
        return ultimaSenialRastreo;
    }

    /**
     * @param ultimaSenialRastreo the ultimaSenialRastreo to set
     */
    public void setUltimaSenialRastreo(Date ultimaSenialRastreo) {
        this.ultimaSenialRastreo = ultimaSenialRastreo;
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
