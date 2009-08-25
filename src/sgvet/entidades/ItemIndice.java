package sgvet.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author franco
 */
@Entity
@Table(name="items_indices")
public class ItemIndice implements IPersistente, Serializable {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = Arrays.asList("concepto");

    private String id;
    private String concepto;
    private double valor;
    private boolean borrado;

    public ItemIndice() {
        this(null, 0.0);
    }

    public ItemIndice(String concepto, double valor) {
        setId(UUID.randomUUID().toString());
        this.concepto = concepto;
        this.valor = valor;
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

    @Column(name="concepto", length=100)
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Column(name="valor")
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Column(name="borrado")
    public boolean isBorrado() {
        return borrado;
    }

    @Override
    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    public List<String> getCamposUnicos() {
        return CAMPOS_UNICOS;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemIndice other = (ItemIndice) obj;
        if ((this.concepto == null) ? (other.concepto != null) : !this.concepto.equals(other.concepto)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.concepto != null ? this.concepto.hashCode() : 0);
        return hash;
    }
}