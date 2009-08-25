/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.Proveedor;

/**
 *
 * @author stafoxter
 */

public class ProveedorTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Nombre", "Telefono", "Contacto"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class, String.class};
    
    private List<Proveedor> proveedores;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public ProveedorTableModel(int filas) {
        this.proveedores = new ArrayList<Proveedor>(filas > 0 ? filas : 0);
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
        return proveedores.size();
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
                resultado = proveedores.get(fila).getNombre();
                break;
            case 1:
                resultado = proveedores.get(fila).getTelefono();
                break;
            case 2:
                resultado = proveedores.get(fila).getNombreContacto();
                break;
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(Proveedor proveedor) {
        proveedores.add(proveedor);
        
        fireTableRowsInserted(proveedores.size(), proveedores.size());
    }
    
    
    public void agregarFilas(List<Proveedor> proveedoresNuevo) {
        if(proveedoresNuevo != null){
            proveedores.addAll(proveedoresNuevo);
            fireTableRowsInserted(proveedores.size()-proveedoresNuevo.size(), proveedores.size());
        }
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = proveedores.size();
        
        proveedores = proveedores.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<Proveedor> getFilas() {
        return proveedores;
    }
    
    public Proveedor getFila(int indice){
        return proveedores.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        proveedores.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){
        int tamanio = proveedores.size();
        proveedores.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }
    
    public void imprimirModel(){
        
        for (int i = 0; i < proveedores.size(); i++) {
            System.out.println(proveedores.get(i).getNombre()+"    "+
                    proveedores.get(i).getTelefono()+"    "+ 
                    proveedores.get(i).getNombreContacto());     
        }
        System.out.println("\n");
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
}