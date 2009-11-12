package sgvet.gestores;

/**
 * Interface que deben implementar todas las clases que quieran saber cdo se modifica la fecha actual
 * @author Lisandro
 */
public interface IObservadorFecha {

    /**
     * Este metodo se debe sobreescribir con lo que se desea realizar cuando cambie la fecha.
     */
    public void actualizar();

}
