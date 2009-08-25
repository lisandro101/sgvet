package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.PuntoEquilibrio;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PuntoEquilibrioTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Producto", "Equivalencia"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, Double.class};
    
    private List<PuntoEquilibrio> puntosEquilibrio;
    
    
    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public PuntoEquilibrioTableModel(int filas) {
        this.puntosEquilibrio = new ArrayList<PuntoEquilibrio>(filas > 0 ? filas : 0);
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
        return puntosEquilibrio.size();
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
                resultado = puntosEquilibrio.get(fila).getProductoTerminado().getNombre();
                break;
            case 1:
                resultado = puntosEquilibrio.get(fila).getEquivalencia();
                break;

        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(PuntoEquilibrio cargo) {
        puntosEquilibrio.add(cargo);
        
        fireTableRowsInserted(puntosEquilibrio.size(), puntosEquilibrio.size());
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = puntosEquilibrio.size();
        
        puntosEquilibrio = puntosEquilibrio.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<PuntoEquilibrio> getFilas() {
        return puntosEquilibrio;
    }
    
    public PuntoEquilibrio getFila(int indice){
        return puntosEquilibrio.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        puntosEquilibrio.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){        
        int tamanio = puntosEquilibrio.size();
        puntosEquilibrio.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
    public void agregarFilas(List<PuntoEquilibrio> puntosNuevos) {
        limpiarTableModel();
        if (puntosNuevos != null) {
            puntosEquilibrio.addAll(puntosNuevos);
            fireTableRowsInserted(puntosEquilibrio.size() - puntosNuevos.size(), puntosEquilibrio.size());
        }
    }
}
