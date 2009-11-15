package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.auxiliares.DTOPedidos;
import sgvet.gestores.GestorRevisionContinua;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PedidosContinuaTableModel extends AbstractTableModel implements IModeloReiniciable {

    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {
        "Producto", "Stock Disponible", "Cantidad a Pedir"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false};
    private static final Class[] CLASE_COLUMNAS = {String.class, Double.class, Double.class};
    private List<DTOPedidos> pedidos;
    private GestorRevisionContinua grc = GestorRevisionContinua.getInstancia();

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public PedidosContinuaTableModel(int filas) {
        this.pedidos = new ArrayList<DTOPedidos>(filas > 0 ? filas : 0);
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
        return pedidos.size();
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
        grc.cargarGestorRevisionContinua(pedidos.get(fila).getProducto());

        switch (columna) {
            case 0:
                resultado = pedidos.get(fila).getProducto().getNombre();
                break;
            case 1:
                resultado = grc.getStockDisponible();
                break;
            case 2:
                resultado = grc.getQOptimo(pedidos.get(fila).getProducto());
                break;
        }

        return resultado;

    }

    /**
     * Agrega Proveedor al modelo
     * 
     * @param pedido
     */
    public void agregarFila(DTOPedidos pedido) {

        pedidos.add(pedido);
        fireTableRowsInserted(pedidos.size(), pedidos.size());

    }

    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {

        int cantidadAnterior = pedidos.size();

        pedidos = pedidos.subList(0, cantidad);
        fireTableRowsDeleted(cantidad, cantidadAnterior);

    }

    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<DTOPedidos> getFilas() {
        return pedidos;
    }

    public DTOPedidos getFila(int indice) {

        return pedidos.get(indice);

    }

    public void eliminarFila(int indice) {

        pedidos.remove(indice);
        fireTableRowsDeleted(indice, indice);

    }

    public void limpiarTableModel() {

        int tamanio = pedidos.size();

        pedidos.clear();
        fireTableRowsDeleted(0, tamanio);

    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }

    /**
     * 
     * @param pedidos
     */
    public void agregarFilas(List<DTOPedidos> pedidos) {

        limpiarTableModel();

        if (pedidos != null) {
            this.pedidos.addAll(pedidos);
            fireTableRowsInserted(this.pedidos.size() - pedidos.size(), this.pedidos.size());
        }

    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
    }
}
