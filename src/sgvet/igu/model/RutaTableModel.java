package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.RutaFabricacion;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */

public class RutaTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    
    private static final String[] NOMBRE_COLUMNAS = {"Nombre", "Codigo"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class};
    
    private List<RutaFabricacion> rutas;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public RutaTableModel(int filas) {
        this.rutas = new ArrayList<RutaFabricacion>(filas > 0 ? filas : 0);
    }
    
    /**
     * Constructor
     * 
     */
    public RutaTableModel() {
        this.rutas = new ArrayList<RutaFabricacion>(0);
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
        return rutas.size();
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
                resultado = rutas.get(fila).getNombre();
                break;
            case 1:
                resultado = rutas.get(fila).getCodigo();
                break;
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(RutaFabricacion _Rutas) {
        rutas.add(_Rutas);
        
        fireTableRowsInserted(rutas.size(), rutas.size());
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = rutas.size();
        
        rutas = rutas.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<RutaFabricacion> getFilas() {
        return rutas;
    }
    
    public RutaFabricacion getFila(int indice){
        return rutas.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        rutas.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel() {
        int tamanio = rutas.size();
        rutas.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }
    
    public void imprimirModel(){
        
        for (int i = 0; i < rutas.size(); i++) {
            System.out.println(rutas.get(i).getNombre()+"    "+
                    rutas.get(i).getCodigo()+"    "+ 
                    rutas.get(i).getId()); //TODO getUbicacion     
        }
        System.out.println("\n");
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
    public void agregarFilas(List<RutaFabricacion> rutasNuevas) {
        if(rutasNuevas != null){
            rutas.addAll(rutasNuevas);
            fireTableRowsInserted(rutas.size()-rutasNuevas.size(), rutas.size());
        }
    }
}