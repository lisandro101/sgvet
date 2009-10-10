/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import java.util.List;
import sgvet.entidades.ClaseDemanda;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author Lisandro
 */
public class GestorConfiguracion {

    private static GestorConfiguracion instance;

    public synchronized static GestorConfiguracion getInstancia() {
        if (instance == null) {
            instance = new GestorConfiguracion();
        }
        return instance;
    }

    /**
     * Devuelve una clase de demanda en base al string pasado como parametro.
     * @param clase
     * @return ClaseDemanda
     */
    public ClaseDemanda getClaseDemanda(String clase){
        if (clase.equalsIgnoreCase("Clase A")) {
            return getClaseDemanda(1);
        }
        else if (clase.equalsIgnoreCase("Clase B")){
            return getClaseDemanda(2);
        }
        else if (clase.equalsIgnoreCase("Clase C")){
            return getClaseDemanda(3);
        }
        else {
            return null;
        }
    }

    /**
     * Devuelve una clase de demanda en base al id de clase pasado como 
     * parametro.
     * @param idClase 
     * @return ClaseDemanda
     */
    public ClaseDemanda getClaseDemanda(int idClase){
        
        List<ClaseDemanda> clases =
                FachadaPersistencia.getInstancia().buscar(ClaseDemanda.class,
                "SELECT a FROM ClaseDemanda a ORDER BY a.numeroClase");

        if (idClase == 1) {
            return clases.get(0);
        }
        else if (idClase == 2){
            return clases.get(1);
        }
        else if (idClase == 3){
            return clases.get(2);
        }
        else {
            return null;
        }
    }

}
