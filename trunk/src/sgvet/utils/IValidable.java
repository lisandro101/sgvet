package sgvet.utils;

import java.awt.Component;
import java.util.List;

/**
 * Interfaz que deben implementar los objetos gráficos que se quieren validar
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public interface IValidable {
    /**
     * Devuelve una lista con los componentes que son obbligatorios de completar
     * en el container
     * 
     * @return Una lista con los componentes que son obbligatorios de completar
     * en el container
     */
    public List<Component> getComponentesObligatorios();
}