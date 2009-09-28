package sgvet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sgvet.entidades.Cargo;
import sgvet.entidades.ItemIndice;
import sgvet.entidades.ProductoComponente;
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
        
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        
        new Thread() {
            @Override
            public void run() {
                List<ProductoComponente> prod = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class,
                        "SELECT c FROM ProductoComponente c");
                if(prod.size()<=0) {
                    System.out.println("Realizando Carga Inicial....");
                    GestorCargaInicial.getInstancia().cargarProductos(GestorCargaInicial.getInstancia().cargarProveedores());
                    System.out.println("Finalizada Carga Inicial.");
                }
            }
            
        }.start();

        cargarValoresIniciales();
    }

    private static void cargarValoresIniciales() {
        List<IPersistente> objetos = new ArrayList<IPersistente>();

        objetos.add(new ItemIndice("Disponibilidad", 20000));
        objetos.add(new ItemIndice("Realizable a corto plazo", 5000));
        objetos.add(new ItemIndice("Pasivo corriente", 1500));
        objetos.add(new ItemIndice("Cuentas por cobrar", 2500));
        objetos.add(new ItemIndice("Promedio de cobro", 1000));
        objetos.add(new ItemIndice("Pasivo a corto plazo", 21600));
        objetos.add(new ItemIndice("Deudas que contraigo por día", 720));
        objetos.add(new ItemIndice("Ventas", 90533));
        objetos.add(new ItemIndice("Activo total", 54600));
        objetos.add(new ItemIndice("Utilidades", 32000));
        objetos.add(new ItemIndice("Ventas del producto (a)", 3));
        objetos.add(new ItemIndice("Ventas del producto (b)", 2));
        objetos.add(new ItemIndice("Ventas del producto (c)", 2));
        objetos.add(new ItemIndice("Ventas totales", 45));
        objetos.add(new ItemIndice("Unidades rechazadas", 0));
        objetos.add(new ItemIndice("Unidades totales producidas", 45));
        objetos.add(new ItemIndice("Número de bajas voluntarias", 1));
        objetos.add(new ItemIndice("Total de personal", 6));


        FachadaPersistencia.getInstancia().comenzarTransaccion();

        for (IPersistente objeto : objetos) {
            FachadaPersistencia.getInstancia().grabar(objeto, false);
        }

        FachadaPersistencia.getInstancia().finalizarTransaccion();
    }
}