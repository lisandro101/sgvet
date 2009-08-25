package sgvet.igu.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import sgvet.entidades.NodoRuta;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class RutaListModel extends AbstractListModel implements IModeloReiniciable {
    
    private static final long serialVersionUID = 1L;
    private List<NodoRuta> nodos;

   /**
     * Constructor por defecto
     * 
     */
    public RutaListModel() {
        this.nodos = new ArrayList<NodoRuta>(0);
    }
    
   /**
     * Constructor
     * 
     * @param elementos Cantidad de elementos iniciales
     */
    public RutaListModel(int elementos) {
        this.nodos = new ArrayList<NodoRuta>(elementos > 0 ? elementos : 0);
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
        resultado = nodos.get(index).getCentroTrabajo().getNombre();
        
        return resultado;
    }
    
    public NodoRuta getNodo(int index) {
        NodoRuta resultado = null;
        resultado = nodos.get(index);
        
        return resultado;
    }
    
   /**
     * Agrega una instancia de NodoRuta al modelo
     * 
     * @param nodo NodoRuta a agregar

     */
    public void agregarElemento(NodoRuta nodo) {
        if(nodos.contains(nodo)) {
            nodos.remove(nodo);
        }
        
        nodos.add(nodo);
        fireIntervalAdded(this, nodos.size(), nodos.size());
    }
    
    /**
     * Agrega una lista compuesta de varias instancias de NodoRuta al modelo
     * 
     * @param nodos List de nodos a agregar

     */
    public void agregarElementos(List<NodoRuta> nodoNuevo) {
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
    public List<NodoRuta> getElementos() {     
        
        return new ArrayList<NodoRuta>(nodos);
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

    @Override
    public void reiniciar() {
        int tamanio = nodos.size();
        nodos.clear();
        
        fireIntervalRemoved(this, 0, tamanio);
    }

}
