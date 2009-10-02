

package sgvet.entidades;


public class Stock {

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
