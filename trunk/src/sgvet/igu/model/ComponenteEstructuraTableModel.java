/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.HoraLaboral;
import sgvet.entidades.ParteDeEstructura;
import sgvet.entidades.ParteDeNodo;

/**
 *
 * @author stafoxter
 */

public class ComponenteEstructuraTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Componente", "Unidad Medida", "Cantidad"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, true};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class, Double.class};
    
    private List<ParteDeEstructura> partesDeEstructura;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public ComponenteEstructuraTableModel(int filas) {
        this.partesDeEstructura = new ArrayList<ParteDeEstructura>(filas > 0 ? filas : 0);
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
        return partesDeEstructura.size();
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
                resultado = partesDeEstructura.get(fila).getComponente().getNombre();
                break;
            case 1:
                resultado = partesDeEstructura.get(fila).getComponente().getUnidadMedida();
                break;
            case 2:
                resultado = partesDeEstructura.get(fila).getCantidad();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        if(columna == 2) {
            partesDeEstructura.get(fila).setCantidad((Double)valor);
        }
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(ParteDeEstructura hora) {
        partesDeEstructura.add(hora);
        
        fireTableRowsInserted(partesDeEstructura.size(), partesDeEstructura.size());
    }
    
    
    public void agregarFilas(List<ParteDeEstructura> proveedoresNuevo) {
        if(proveedoresNuevo != null){
            partesDeEstructura.addAll(proveedoresNuevo);
            fireTableRowsInserted(partesDeEstructura.size()-proveedoresNuevo.size(), partesDeEstructura.size());
        }
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = partesDeEstructura.size();
        
        partesDeEstructura = partesDeEstructura.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<ParteDeEstructura> getFilas() {
        return partesDeEstructura;
    }
    
    public ParteDeEstructura getFila(int indice){
        return partesDeEstructura.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        partesDeEstructura.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){
        int tamanio = partesDeEstructura.size();
        partesDeEstructura.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }
    
    
    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
}
