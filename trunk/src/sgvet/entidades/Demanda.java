/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author Stafoxter,Lisandro
 */
@Entity
@Table(name="demandas")
public class Demanda implements Serializable, IPersistente{
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = new ArrayList<String>(0);

    private String id;
    private ProductoComponente producto;
    private Date periodo;
    private int demandaReal;
    private double pM;
    private double PMP;
    private double pMSE;
    private int prediccionSES;
    private boolean borrado;

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

    @Column(name="demanda_real")
    public int getDemandaReal() {
        return demandaReal;
    }

    public void setDemandaReal(int demandaReal) {
        this.demandaReal = demandaReal;
    }

    @Column(name="PM")
    public double getPM() {
        return pM;
    }

    public void setPM(double pM) {
        this.pM = pM;
    }

    @Column(name="prediccionSES")
    public int getPrediccionSES() {
        return prediccionSES;
    }

    public void setPrediccionSES(int prediccionSES) {
        this.prediccionSES = prediccionSES;
    }

    @Column(name="PMSE")
    public double getPMSE() {
        return pMSE;
    }

    public void setPMSE(double pMSE) {
        this.pMSE = pMSE;
    }

    @Column(name="periodo")
    @Temporal(TemporalType.DATE)
    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    @Column(name="PMP")
    public double getPMP() {
        return PMP;
    }

    public void setPMP(double PMP) {
        this.PMP = PMP;
    }

    @JoinColumn(name="producto_id")
    @ManyToOne(targetEntity=ProductoComponente.class, cascade=CascadeType.ALL)
    public ProductoComponente getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductoComponente producto) {
        this.producto = producto;
    }

    @Override
    public List<String> getCamposUnicos() {
        return CAMPOS_UNICOS;
    }

    @Override
    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }


    
}
