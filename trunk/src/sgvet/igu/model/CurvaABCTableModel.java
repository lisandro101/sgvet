package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.auxiliares.ItemABC;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class CurvaABCTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {
        "Producto", "Demanda Valorizada", "Demanda Acumulada", "Categoria"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, Double.class, Double.class, String.class};
    
    private List<ItemABC> curvaABC;
    
    
    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public CurvaABCTableModel(int filas) {
        this.curvaABC = new ArrayList<ItemABC>(filas > 0 ? filas : 0);
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
        return curvaABC.size();
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
        
        switch(columna) {
            case 0:
                resultado = curvaABC.get(fila).getProducto().getNombre();
                break;
            case 1:
                resultado = Double.valueOf(curvaABC.get(fila).getDemandaValorizada());
                break;
            case 2:
                resultado = Double.valueOf(curvaABC.get(fila).getDemandaAcumulada());
                break;
            case 3:
                resultado = curvaABC.get(fila).getProducto().getCategoria();
                break;    
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param item

     */
    public void agregarFila(ItemABC item) {
        
        curvaABC.add(item);
        fireTableRowsInserted(curvaABC.size(), curvaABC.size());

    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {

        int cantidadAnterior = curvaABC.size();

        curvaABC = curvaABC.subList(0, cantidad);
        fireTableRowsDeleted(cantidad, cantidadAnterior);

    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<ItemABC> getFilas() {
        return curvaABC;
    }
    
    public ItemABC getFila(int indice){

        return curvaABC.get(indice);
        
    }
    
    public void eliminarFila(int indice){

        curvaABC.remove(indice);
        fireTableRowsDeleted(indice, indice);

    }
    
    public void limpiarTableModel(){

        int tamanio = curvaABC.size();

        curvaABC.clear();
        fireTableRowsDeleted(0, tamanio);

    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
    public void agregarFilas(List<ItemABC> items) {
        limpiarTableModel();
        if (items != null) {
            curvaABC.addAll(items);
            fireTableRowsInserted(curvaABC.size() - items.size(), curvaABC.size());
        }
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        
    }

}
