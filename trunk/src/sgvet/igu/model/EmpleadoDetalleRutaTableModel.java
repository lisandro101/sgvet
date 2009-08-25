/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.HoraLaboral;

/**
 *
 * @author stafoxter
 */

public class EmpleadoDetalleRutaTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Empleado", "Cargo", "horas"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class, Integer.class};
    
    private List<HoraLaboral> horasLaborales;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public EmpleadoDetalleRutaTableModel(int filas) {
        this.horasLaborales = new ArrayList<HoraLaboral>(filas > 0 ? filas : 0);
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
        return horasLaborales.size();
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
                resultado = horasLaborales.get(fila).getEmpleado().getNombre();
                break;
            case 1:
                resultado = horasLaborales.get(fila).getEmpleado().getCargo().getNombre();
                break;
            case 2:
                resultado = horasLaborales.get(fila).getCantidad();
                break;
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(HoraLaboral hora) {
        horasLaborales.add(hora);
        
        fireTableRowsInserted(horasLaborales.size(), horasLaborales.size());
    }
    
    
    public void agregarFilas(List<HoraLaboral> proveedoresNuevo) {
        if(proveedoresNuevo != null){
            horasLaborales.addAll(proveedoresNuevo);
            fireTableRowsInserted(horasLaborales.size()-proveedoresNuevo.size(), horasLaborales.size());
        }
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = horasLaborales.size();
        
        horasLaborales = horasLaborales.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<HoraLaboral> getFilas() {
        return horasLaborales;
    }
    
    public HoraLaboral getFila(int indice){
        return horasLaborales.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        horasLaborales.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){
        int tamanio = horasLaborales.size();
        horasLaborales.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }
    
    
    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
}
