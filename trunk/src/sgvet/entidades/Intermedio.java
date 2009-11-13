package sgvet.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Contiene los datos de un producto
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="intermedios")
@DiscriminatorValue("P")
public abstract class Intermedio extends Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    
//    private String condicionesEmbalaje;
    //private String numeroPlano;
    private String politicaCompra;
    private String unidadMedida;
    private String estado;
    
    private boolean borrado;

//    @Column(name="condiciones_embalaje", length=255)
//    public String getCondicionesEmbalaje() {
//        return condicionesEmbalaje;
//    }
//
//    public void setCondicionesEmbalaje(String condicionesEmbalaje) {
//        this.condicionesEmbalaje = condicionesEmbalaje;
//    }

//    @Column(name="numero_plano", length=20)
//    public String getNumeroPlano() {
//        return numeroPlano;
//    }
//
//    public void setNumeroPlano(String numeroPlano) {
//        this.numeroPlano = numeroPlano;
//    }

    @Column(name="politica_compra", length=255)
    public String getPoliticaCompra() {
        return politicaCompra;
    }

    public void setPoliticaCompra(String politicaCompra) {
        this.politicaCompra = politicaCompra;
    }

    @Column(name="unidad_medida", length=20)
    @Override
    public String getUnidadMedida() {
        return unidadMedida;
    }

    @Override
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    @Column(name="estado", length=20)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Column(name="borrado")
    @Override
    public boolean isBorrado() {
        return borrado;
    }

    @Override
    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
}