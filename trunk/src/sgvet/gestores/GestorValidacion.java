/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextField;

/**
 *
 * @author Seba
 */
public class GestorValidacion {

    private static GestorValidacion instance;

    public synchronized static GestorValidacion getInstancia() {
        if (instance == null) {
            instance = new GestorValidacion();
        }
        return instance;
    }
    private GestorValidacion(){
        
    }

    public  boolean isCamposNumericosValidos(Container contenedor) {
        int resultado = 0;

        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                if ((((JTextField) componente).getText().trim().length() == 0) ||
                        (!esNumeroPositivo(((JTextField) componente).getText()))) {

                    resultado++;
                }
            } else if (componente instanceof Container) {
                if (!isCamposNumericosValidos((Container) componente)) {
                    resultado++;

                }
            }
        }
        if (resultado == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * El valor cero lo considero como valor positivo
     * @param numero
     * @return
     */
    public  boolean esPositivo(String numero) {
        double valor = Double.parseDouble(numero);

        if (valor < 0) {
            return false;
        } else {
            return true;
        }
    }

    public  boolean esNumeroPositivo(String valor) {
        valor = valor.trim();
        boolean resul = true;

        for (int i = 0; i < valor.length(); i++) {
            if (!Character.isDigit(valor.charAt(i)) && valor.charAt(i) != '.') {
                resul = false;
            }
        }

        if (resul) {
            resul = esPositivo(valor);
        }
        return resul;
    }
}
