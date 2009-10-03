

package sgvet.entidades;

import java.io.Serializable;
//import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
@DiscriminatorValue("S")
public class Stock implements Serializable {

    public Stock() {
    }

    @Id
    private int disponible;
    private int faltante;
    private int puntoReposicion;

    public int getDisponible() {
        return disponible;
    }

    public int getFaltante() {
        return faltante;
    }

    public int getPuntoReposicion() {
        return puntoReposicion;
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
