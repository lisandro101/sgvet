package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorSenialRastreo;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class SenialRastreoTableModel extends AbstractTableModel implements IModeloReiniciable {

    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {
        "Producto", "Categoria", "L", "SR"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false, false};
    private static final Class[] CLASE_COLUMNAS = {String.class, String.class, Double.class, Double.class};
    private List<ProductoComponente> productos;
    private GestorSenialRastreo gsr = GestorSenialRastreo.getInstancia();

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public SenialRastreoTableModel(int filas) {
        this.productos = new ArrayList<ProductoComponente>(filas > 0 ? filas : 0);
    }

    /**
     * Devuelve el nombre de la columna
     * 
     * @param columna Indice de la columna
     * @return El nombre de la columna
     */
    @Override
    public String getColumnName(int columna) {
        return NOMBRE_COLUMNAS[columna];
    }

    /**
     * Devuelve la clase de la columna indicada
     * 
     * @param columna Indice de la columna de la que se quiere averiguar la clase
     * @return La clase de la columna indicada
     */
    @Override
    public Class<?> getColumnClass(int columna) {
        return CLASE_COLUMNAS[columna];
    }

    /**
     * Devuelve si la celda es o no editable
     * 
     * @param fila Indice de la fila
     * @param columna Indice de la columna
     * @return True si la celda es editable
     */
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return COLUMNAS_EDITABLES[columna];
    }

    /**
     * Devuelve la cantidad de filas
     * 
     * @return La cantidad de filas
     */
    @Override
    public int getRowCount() {
        return productos.size();
    }

    /**
     * Devuelve la cantidad de columnas
     * 
     * @return La cantidad de columnas
     */
    @Override
    public int getColumnCount() {
        return NOMBRE_COLUMNAS.length;
    }

    /**
     * Devuelve el valor de la celda indicada
     * 
     * @param fila Indice de la fila
     * @param columna Indice de la columna
     * @return Devuelve el valor de la celda indicada
     */
    @Override
    public Object getValueAt(int fila, int columna) {
        Object resultado = null;

        switch (columna) {
            case 0:
                resultado = productos.get(fila).getNombre();
                break;
            case 1:
                resultado = productos.get(fila).getCategoria();
                break;
            case 2:
                resultado = Double.valueOf(productos.get(fila).getCategoria().getL());
                break;
            case 3:
                resultado = gsr.calcularSenialRastreo(productos.get(fila));
                break;
        }
        return resultado;
    }

    /**
     * Agrega Proveedor al modelo
     * 
     * @param prod
     */
    public void agregarFila(ProductoComponente prod) {

        productos.add(prod);
        fireTableRowsInserted(productos.size(), productos.size());

    }

    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {

        int cantidadAnterior = productos.size();

        productos = productos.subList(0, cantidad);
        fireTableRowsDeleted(cantidad, cantidadAnterior);

    }

    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<ProductoComponente> getFilas() {
        return productos;
    }

    public ProductoComponente getFila(int indice) {

        return productos.get(indice);

    }

    public void eliminarFila(int indice) {

        productos.remove(indice);
        fireTableRowsDeleted(indice, indice);

    }

    public void limpiarTableModel() {

        int tamanio = productos.size();

        productos.clear();
        fireTableRowsDeleted(0, tamanio);

    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }

    public boolean agregarFilas(List<ProductoComponente> prod) {
        boolean faltanFilas = false;
        limpiarTableModel();
        if (prod != null) {
            for (ProductoComponente productoComponente : prod) {
                if (gsr.calcularSenialRastreo(productoComponente) != Double.NaN) {
                    productos.add(productoComponente);
                } else {
                    faltanFilas = true;
                }
            }
            fireTableRowsInserted(productos.size() - prod.size(), productos.size());
        }
        return faltanFilas;
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
    }
}
