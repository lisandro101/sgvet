/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JTextField;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;

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
    /**
     * Devuelve un codigo de producto. El codigo inicial es de 2-1
     * @return
     */
    public String generarCodigoProducto() {
        String codigo = "";
        int mayor = 0;
        String temp;
        List<ProductoComponente> productos;
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "Select a from ProductoComponente a where a.borrado=false");

        productos = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, consulta);

        if (productos.size() == 0) {
            codigo = "1";
        }
        if (productos.size() > 0) {
            for (ProductoComponente prod : productos) {
                temp = quitarPrefijo(prod.getCodigo());
                if (!(temp.equals("")) && !(temp.equals(" "))) {
                    if (mayor < Integer.parseInt(temp)) {
                        mayor = Integer.parseInt(temp);
                    }
                }
            }
            codigo = (mayor + 1) + "";
        }
        return agregarPrefijo(codigo);
    }

    private String agregarPrefijo(String nro) {
        return "2-" + nro;
    }

    private String quitarPrefijo(String nro) {
        return nro.substring(2, nro.length());
    }
}
