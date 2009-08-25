package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.CostoVariable;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class CostoVariableTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Producto", "Costo MO", "Costo Materiles", "Costo Total"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, Double.class, Double.class, Double.class};
    
    private List<CostoVariable> costos;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public CostoVariableTableModel(int filas) {
        this.costos = new ArrayList<CostoVariable>(filas > 0 ? filas : 0);
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
        return costos.size();
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
                resultado = costos.get(fila).getProductoTerminado().getNombre();
                break;
            case 1:
                resultado = costos.get(fila).getCostoManoObra();
                break;
            case 2:
                resultado = costos.get(fila).getCostoMateriales();
                break;
            case 3:
                resultado = costos.get(fila).getCostoManoObra()+ costos.get(fila).getCostoMateriales();
                break;    
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(CostoVariable cargo) {
        costos.add(cargo);
        
        fireTableRowsInserted(costos.size(), costos.size());
    }
    
    
    public void agregarFilas(List<CostoVariable> costoNuevo) {
        if(costoNuevo != null){
            costos.addAll(costoNuevo);
            fireTableRowsInserted(costos.size()-costoNuevo.size(), costos.size());
        }
    }
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = costos.size();
        
        costos = costos.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<CostoVariable> getFilas() {
        return costos;
    }
    
    public CostoVariable getFila(int indice){
        return costos.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        costos.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){        
        int tamanio = costos.size();
        costos.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
//    public void imprimirModel(){
//        
//        for (int i = 0; i < cargos.size(); i++) {
//            System.out.println(cargos.get(i).getNombreCargo()+"    "+
//                    cargos.get(i).get()+"    "+ 
//                    cargos.get(i).getNombreContacto());     
//        }
//        System.out.println("\n");
//    }
}
