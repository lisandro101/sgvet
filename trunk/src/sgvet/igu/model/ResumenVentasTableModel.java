package sgvet.igu.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sgvet.entidades.auxiliares.DemandaXPeriodo;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class ResumenVentasTableModel extends AbstractTableModel implements IModeloReiniciable {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Periodo", "Fecha Inicio", "Fecha Cierre", "Total Ventas"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {int.class, Date.class, Date.class, int.class};
    
    private List<DemandaXPeriodo> demandas;
    
    
    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public ResumenVentasTableModel(int filas) {
        this.demandas = new ArrayList<DemandaXPeriodo>(filas > 0 ? filas : 0);
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
                resultado = demandas.get(fila).getNroPeriodo();
                break;
            case 1:
                resultado = formatearFecha(demandas.get(fila).getFechaInicio());
                break;
            case 2:
                resultado = formatearFecha(demandas.get(fila).getFechaFin());
                break;
            case 3:
                resultado = demandas.get(fila).getVentas();
                break;    
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
//    public void agregarFila(DemandaXPeriodo cargo) {
//        demandas.add(cargo);
//
//        fireTableRowsInserted(demandas.size(), demandas.size());
//    }
//
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
    public List<DemandaXPeriodo> getFilas() {
        return demandas;
    }
    
    public DemandaXPeriodo getFila(int indice){
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
    
    public void agregarFilas(List<DemandaXPeriodo> demandasNuevas) {
        limpiarTableModel();
        if (demandasNuevas != null) {
            demandas.addAll(demandasNuevas);
            fireTableRowsInserted(demandas.size() - demandasNuevas.size(), demandas.size());
        }
    }

    


    public String formatearFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    

}
