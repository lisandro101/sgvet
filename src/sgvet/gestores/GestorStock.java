/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;


public class GestorStock {
    
    private static GestorStock instance;

public synchronized static GestorStock getInstancia(){
        if (instance == null){
            instance = new GestorStock();
        }
        return instance;
    }


}


