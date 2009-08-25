package sgvet.igu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.Cargo;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.OrdenProduccion;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class BuscarOrdenProduccionTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Nro Orden", "Cliente", "Fecha Emisión", "Fecha Entrega", "Estado"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class, Date.class, Date.class, String.class};
    
    private List<OrdenProduccion> ordenes;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public BuscarOrdenProduccionTableModel(int filas) {
        this.ordenes = new ArrayList<OrdenProduccion>(filas > 0 ? filas : 0);
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
        return ordenes.size();
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
                resultado = ordenes.get(fila).getNroOrdenProduccion();
                break;
            case 1:
                resultado = ordenes.get(fila).getNombreCliente();
                break;
            case 2:
                resultado = ordenes.get(fila).getFecha();
                break;
            case 3:
                resultado = ordenes.get(fila).getFechaEstimadaEntrega();
                break;  
            case 4:
                resultado = ordenes.get(fila).getEstado().toString();
                break;     
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(OrdenProduccion cargo) {
        ordenes.add(cargo);
        
        fireTableRowsInserted(ordenes.size(), ordenes.size());
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = ordenes.size();
        
        ordenes = ordenes.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<OrdenProduccion> getFilas() {
        return ordenes;
    }
    
    public OrdenProduccion getFila(int indice){
        return ordenes.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        ordenes.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){        
        int tamanio = ordenes.size();
        ordenes.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
    
}
