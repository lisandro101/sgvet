package sgvet.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock implements Serializable {

    private String id;
    private int disponible;
    private int faltante;
    private int puntoReposicion;


    public Stock() {
        
    }

    @Id
    @Column(name="id", length=36)
    public String getId() {
        return id;
    }

    @Column(name="disponible")
    public int getDisponible() {
        return disponible;
    }

    @Column(name="faltante")
    public int getFaltante() {
        return faltante;
    }

    @Column(name="punto_reposicion")
    public int getPuntoReposicion() {
        return puntoReposicion;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public void setFaltante(int faltante) {
        this.faltante = faltante;
    }

    public void setPuntoReposicion(int puntoReposicion) {
        this.puntoReposicion = puntoReposicion;
    }

}
