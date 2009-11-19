package sgvet;

import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorCargaInicial;
import sgvet.igu.PantallaPrincipal;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
// Simple - vital Can Vitamina 200gm
// Con tendencia - PURINA Vitamina 200gm
// Con estacionalidad - Protect Garrapaticida aerosol
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


        final PantallaPrincipal p = new PantallaPrincipal();
        final GestorCargaInicial gcarga = GestorCargaInicial.getInstancia();

        p.setLocationRelativeTo(null);
        p.setStatus("Inicializando el sistema...");
        System.out.println("Inicializando el sistema...");
        p.setVisible(true);

        new Thread() {

            @Override
            public void run() {
                List<ProductoComponente> prod = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class,
                        "SELECT c FROM ProductoComponente c");
                if (prod.size() <= 0) {
                    gcarga.cargarTodo(p);
                }
                p.setStatus("Sistema listo.");
                System.out.println("Sistema listo.");
            }
        }.start();

    }
}
