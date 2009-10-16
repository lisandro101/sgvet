package sgvet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorABC;
import sgvet.gestores.GestorCargaInicial;
import sgvet.igu.PantallaPrincipal;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class Main {

    /**
     * 
     * @param args
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {


        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        System.setProperty("apple.laf.useScreenMenuBar", "true");


        PantallaPrincipal p = new PantallaPrincipal();
        final GestorCargaInicial gcarga = GestorCargaInicial.getInstancia();

        p.setLocationRelativeTo(null);
        p.setVisible(true);

        new Thread() {

            @Override
            public void run() {
                List<ProductoComponente> prod = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class,
                        "SELECT c FROM ProductoComponente c");
                if (prod.size() <= 0) {
                    gcarga.cargarTodo();
                }
            }
        }.start();

    }
}