package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.ProductoTerminado;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class OrdenProduccionTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS =
        {"Codigo", "Producto", "Cantidad", "Precio"};
    private static final boolean[] COLUMNAS_EDITABLES =
        {false, false, true, true};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class, Integer.class, Double.class};
    
    private List<DetalleOrdenProduccion> detallesOrdenProduccion;
    
    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public OrdenProduccionTableModel(int filas) {
        this.detallesOrdenProduccion = new ArrayList<DetalleOrdenProduccion>(filas > 0 ? filas : 0);
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
        return detallesOrdenProduccion.size();
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
                resultado = detallesOrdenProduccion.get(fila).getProductoTerminado().getCodigo();
                break;
            case 1:
                resultado = detallesOrdenProduccion.get(fila).getProductoTerminado().getNombre();
                break;
            case 2:
                resultado = detallesOrdenProduccion.get(fila).getCantidad();
                break;
            case 3:
                resultado = detallesOrdenProduccion.get(fila).getProductoTerminado().getPrecioVenta();
                break;    
        }
        return resultado;
    }
    
    /**
     * Agrega el producto al modelo
     * 
     * @param productoTerminado Producto a agregar

     */
    public void agregarFila(DetalleOrdenProduccion productoTerminado) {
        detallesOrdenProduccion.add(productoTerminado);
        
        fireTableRowsInserted(detallesOrdenProduccion.size(), detallesOrdenProduccion.size());
    }
    
    
    public void agregarFilas(List<DetalleOrdenProduccion> proveedoresNuevo) {
        if(proveedoresNuevo != null){
            detallesOrdenProduccion.addAll(proveedoresNuevo);
            fireTableRowsInserted(detallesOrdenProduccion.size()-proveedoresNuevo.size(), detallesOrdenProduccion.size());
        }
    }
    
    
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = detallesOrdenProduccion.size();
        
        detallesOrdenProduccion = detallesOrdenProduccion.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<DetalleOrdenProduccion> getFilas() {
        return detallesOrdenProduccion;
    }
    
    public DetalleOrdenProduccion getFila(int indice){
        return detallesOrdenProduccion.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        detallesOrdenProduccion.remove(indice);
        
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){        
        int tamanio = detallesOrdenProduccion.size();
        detallesOrdenProduccion.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        if(columna == 3) {
            detallesOrdenProduccion.get(fila).getProductoTerminado().setPrecioVenta((Double)valor);
        }else if(columna == 2) {
            detallesOrdenProduccion.get(fila).setCantidad((Integer)valor);
        }
    }
}