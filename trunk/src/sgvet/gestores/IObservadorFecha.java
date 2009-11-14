package sgvet.gestores;

import java.awt.Frame;

/**
 * Interface que deben implementar todas las clases que quieran saber cdo se modifica la fecha actual
 * @author Lisandro
 */
public interface IObservadorFecha {

    /**
     * Este metodo se debe sobreescribir con lo que se desea realizar cuando cambie la fecha.
     * @param panel
     */

    public void actualizar(Frame panel);

}
