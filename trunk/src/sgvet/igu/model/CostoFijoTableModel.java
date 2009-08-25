package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.Cargo;
import sgvet.entidades.CostoFijo;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class CostoFijoTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Concepto", "Importe", "Vigente"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, Double.class, Boolean.class};
    
    private List<CostoFijo> costo;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public CostoFijoTableModel(int filas) {
        this.costo = new ArrayList<CostoFijo>(filas > 0 ? filas : 0);
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
        return costo.size();
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
                resultado = costo.get(fila).getConcepto();
                break;
            case 1:
                resultado = costo.get(fila).getImporte();
                break;
            case 2:
                resultado = costo.get(fila).isVigente();
                break;
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(CostoFijo cargo) {
        costo.add(cargo);
        
        fireTableRowsInserted(costo.size(), costo.size());
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = costo.size();
        
        costo = costo.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<CostoFijo> getFilas() {
        return costo;
    }
    
    public CostoFijo getFila(int indice){
        return costo.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        costo.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){        
        int tamanio = costo.size();
        costo.clear();
        
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
