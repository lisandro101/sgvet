

package sgvet.gestores;

import java.util.List;
import sgvet.entidades.Demanda;






public class GestorABC {

    private static GestorABC instance;

    public synchronized static GestorABC getInstancia(){
        if (instance == null){
            instance = new GestorABC();
        }
        return instance;
    }
    private GestorABC() {

    }
    public void calcularABC(List<Demanda> demandas){

    }

}
