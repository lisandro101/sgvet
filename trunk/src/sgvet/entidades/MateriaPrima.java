package sgvet.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Contiene los datos de la materia prima
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="materias_primas")
@DiscriminatorValue("M")
public class MateriaPrima extends Componente implements Serializable {
    
    public enum Estado {
        VIGENTE ("Vigente"),
        NO_VIGENTE ("No vigente");
        
        private String nombre;
        
        private Estado(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
    
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = Arrays.asList("nombre", "codigo");
    

    private Estado estado;

    @Column(name="estado")
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
