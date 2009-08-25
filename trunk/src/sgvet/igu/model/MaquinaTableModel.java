package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.Maquina;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */

public class MaquinaTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Nombre", "Codigo", "Ubicacion"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, String.class, String.class};
    
    private List<Maquina> maquinas;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public MaquinaTableModel(int filas) {
        this.maquinas = new ArrayList<Maquina>(filas > 0 ? filas : 0);
    }
    
    /**
     * Constructor
     * 
     */
    public MaquinaTableModel() {
        this.maquinas = new ArrayList<Maquina>(0);
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
        return maquinas.size();
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
                resultado = maquinas.get(fila).getNombre();
                break;
            case 1:
                resultado = maquinas.get(fila).getCodigo();
                break;
            case 2:
                resultado = maquinas.get(fila).getSector().getNombre();
                break;
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(Maquina _maquina) {
        maquinas.add(_maquina);
        
        fireTableRowsInserted(maquinas.size(), maquinas.size());
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = maquinas.size();
        
        maquinas = maquinas.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<Maquina> getFilas() {
        return maquinas;
    }
    
    public Maquina getFila(int indice){
        return maquinas.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        maquinas.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel() {
        int tamanio = maquinas.size();
        maquinas.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }
    
    public void imprimirModel(){
        
        for (int i = 0; i < maquinas.size(); i++) {
            System.out.println(maquinas.get(i).getNombre()+"    "+
                    maquinas.get(i).getCodigo()+"    "+ 
                    maquinas.get(i).getId()); //TODO getUbicacion     
        }
        System.out.println("\n");
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
    public void agregarFilas(List<Maquina> maquinasNuevas) {
        if(maquinasNuevas != null){
            maquinas.addAll(maquinasNuevas);
            fireTableRowsInserted(maquinas.size()-maquinasNuevas.size(), maquinas.size());
        }
    }
}