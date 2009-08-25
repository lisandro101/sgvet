package sgvet.igu.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.Demanda;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class DemandaTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Periodo", "Demanda Real", "Ponderación PMP", "PMSE"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, true, true, false};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, Double.class, Object.class, Double.class};
    
    private List<Demanda> demandas;
    
    
    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public DemandaTableModel(int filas) {
        this.demandas = new ArrayList<Demanda>(filas > 0 ? filas : 0);
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
        return demandas.size();
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
                resultado = formatearPeriodo(demandas.get(fila).getPeriodo());
                break;
            case 1:
                resultado = demandas.get(fila).getDemandaReal();
                break;
            case 2:
                resultado = demandas.get(fila).getPonderacionPMP();
                break;
            case 3:
                resultado = demandas.get(fila).getPMSE();
                break;    
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(Demanda cargo) {
        demandas.add(cargo);
        
        fireTableRowsInserted(demandas.size(), demandas.size());
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = demandas.size();
        
        demandas = demandas.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<Demanda> getFilas() {
        return demandas;
    }
    
    public Demanda getFila(int indice){
        return demandas.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        demandas.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){        
        int tamanio = demandas.size();
        demandas.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }

    @Override
    public void reiniciar() {
        limpiarTableModel();
    }
    
    public void agregarFilas(List<Demanda> puntosNuevos) {
        limpiarTableModel();
        if (puntosNuevos != null) {
            demandas.addAll(puntosNuevos);
            fireTableRowsInserted(demandas.size() - puntosNuevos.size(), demandas.size());
        }
    }
    private String formatearPeriodo(Date peri){
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        return df.format(peri);  
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        if(columna == 1) {
            demandas.get(fila).setDemandaReal((Double)valor);
        }else if(columna == 2) {
            demandas.get(fila).setPonderacionPMP(Double.valueOf((String)valor));
        }
    }

}
