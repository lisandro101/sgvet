/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.Empleado;

/**
 *
 * @author stafoxter
 */


public class EmpleadoTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Nombre", "Código", "Cargo"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class, String.class};
    
    private List<Empleado> empleados;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public EmpleadoTableModel(int filas) {
        this.empleados = new ArrayList<Empleado>(filas > 0 ? filas : 0);
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
        return empleados.size();
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
                resultado = empleados.get(fila).getNombre();
                break;
            case 1:
                resultado = empleados.get(fila).getCodigo();
                break;
            case 2:
                resultado = empleados.get(fila).getCargo().getNombre();
                break;
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(Empleado proveedor) {
        empleados.add(proveedor);
        
        fireTableRowsInserted(empleados.size(), empleados.size());
    }
    
    
    public void agregarFilas(List<Empleado> proveedoresNuevo) {
        if(proveedoresNuevo != null){
            empleados.addAll(proveedoresNuevo);
            fireTableRowsInserted(empleados.size()-proveedoresNuevo.size(), empleados.size());
        }
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = empleados.size();
        
        empleados = empleados.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<Empleado> getFilas() {
        return empleados;
    }
    
    public Empleado getFila(int indice){
        return empleados.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        empleados.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){
        int tamanio = empleados.size();
        empleados.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }
    
    

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
}
