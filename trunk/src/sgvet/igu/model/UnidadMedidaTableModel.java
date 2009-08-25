package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */

public class UnidadMedidaTableModel extends DefaultComboBoxModel  {
   
    private static final long serialVersionUID = 1L;
    
    private List<String> nodos;

   /**
     * Constructor por defecto
     * 
     */
    public UnidadMedidaTableModel() {
        this.nodos = new ArrayList<String>();
        inicializar();
    }
    
    private void inicializar(){
        nodos.add(" ");
        nodos.add("cm");
        nodos.add("m");
        nodos.add("cm2");
        nodos.add("m2");
        nodos.add("cm3");
        nodos.add("m3");
        nodos.add("l");
        nodos.add("gr");
        nodos.add("Kg");
        nodos.add("unid");

    }
   /**
     * Constructor
     * 
     * @param elementos Cantidad de elementos iniciales
     */
    public UnidadMedidaTableModel(int elementos) {
        this.nodos = new ArrayList<String>(elementos > 0 ? elementos : 0);
    }

   /**
     * Devuelve la cantidad elementos
     * 
     * @return Cantidad de elementos
     */
    @Override
    public int getSize() {
        return nodos.size();
    }

   /**
     * Devuelve el valor del elemento indicado
     * 
     * @param index Indice de elementos
     * @return Devuelve el valor del elemento indicado
     */
    @Override
    public Object getElementAt(int index) {
        Object resultado = null;
        resultado = nodos.get(index);
        
        return resultado;
    }
    
    public String getNodo(int index) {
        String resultado = null;
        resultado = nodos.get(index);
        
        return resultado;
    }
    
   /**
     * Agrega una instancia de NodoRuta al modelo
     * 
     * @param nodo NodoRuta a agregar

     */
    public void agregarElemento(String nodo) {
        nodos.add(nodo);
        fireIntervalAdded(this, nodos.size(), nodos.size());
    }
    
    /**
     * Agrega una lista compuesta de varias instancias de NodoRuta al modelo
     * 
     * @param nodos List de nodos a agregar

     */
    public void agregarElementos(List<String> nodoNuevo) {
        if(nodoNuevo != null){
            nodos.addAll(nodoNuevo);
            fireIntervalAdded(this, nodos.size()-nodoNuevo.size(), nodos.size());
        }
    }
    
   /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = nodos.size();
        
        nodos = nodos.subList(0, cantidad);
        
        fireIntervalRemoved(this, cantidad, cantidadAnterior);
    }
    
   /**
     * Devuelve todos los elementos del modelo
     * 
     * @return Todos los elementos del modelo
     */
    public List<String> getElementos() {     
        
        return new ArrayList<String>(nodos);
    }
    
   /**
     * Elimina un elemento del modelo
     * 
     * @param indice Indice del elemento a eliminar
     */    
    public void eliminarElemento(int indice){        
        nodos.remove(indice);
        fireIntervalRemoved(this, indice, indice);       
    }


    


}