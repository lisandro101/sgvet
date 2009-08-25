package sgvet.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene los datos del cargo de un empleado
 * 
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="cargos")
public class Cargo implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = Arrays.asList("nombre");
    
    private String id;
    private int horasPorMes;
    private String nombre;
    private double valorHora;
    private boolean borrado;

    //TODO: agregar atributos: codigo y estado
    
    /**
     * Constructor
     */
    public Cargo(){
        setId(UUID.randomUUID().toString());
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

    @Column(name="horas_por_mes")
    public int getHorasPorMes() {
        return horasPorMes;
    }

    public void setHorasPorMes(int horasPorMes) {
        this.horasPorMes = horasPorMes;
    }

    @Column(name="nombre", length=30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreCargo) {
        this.nombre = nombreCargo;
    }

    @Column(name="valor_hora")
    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Column(name="borrado")
    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Override
    @Transient
    public List<String> getCamposUnicos() {
        return CAMPOS_UNICOS;
    }
}