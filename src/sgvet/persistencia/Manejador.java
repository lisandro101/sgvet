package sgvet.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Clase que contiene un manejador de persistencia
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
class Manejador {
    
    private EntityManager em;
    
    Manejador(EntityManager em) {
        this.em = em;
    }
    
    void grabar(Object obj, boolean transaccion) {
        if(transaccion) {
            comenzarTransaccion();
            em.merge(obj);
            finalizarTransaccion();
        } else {
            em.persist(obj);
        }
    }
    
    <T extends IPersistente> T actualizar(T obj, boolean transaccion) {
        T result = null;
        
        if(transaccion) {
            comenzarTransaccion();
            em.merge(obj);
            finalizarTransaccion();
        } else {
            em.merge(obj);
        }
        
        return result;
    }
    
    void borrar(IPersistente obj, boolean transaccion) {
        obj.setBorrado(true);
        
        actualizar(obj, transaccion);
    }
    
    <T> T buscar(Class<T> clase, Object id) {
        return em.find(clase, id);
    }
    
    <T> List<T> buscar(Class<T> clase, String query) {
        return buscar(clase, em.createQuery(query));
    }
    
    <T> List<T> buscar(Class<T> clase, Query query) {
        List<T> result = null;
        List tmp = query.getResultList();
        
        if(tmp != null) {
            result = new ArrayList<T>();
            
            for (Object object : tmp) {
                result.add(clase.cast(object));
            }
        }
        
        return result;
    }
    
    <T> T obtenerPrimero(Class<T> clase, Query query) {
        query.setMaxResults(1);
        
        List list = query.getResultList();
        
        return list.size() > 0 ? clase.cast(list.get(0)) : null;
    }
    
    <T> T obtenerPrimero(Class<T> clase, String consulta) {
        return obtenerPrimero(clase, em.createQuery(consulta));
    }
    
    Query crearConsulta(String query) {
        return em.createQuery(query);
    }
    
    void comenzarTransaccion() {
        if(em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        
        em.getTransaction().begin();
    }
    
    void finalizarTransaccion() {
        em.getTransaction().commit();
    }
    
    void borrarFisico(IPersistente obj, boolean transaccion) {
          
        if(transaccion) {
            comenzarTransaccion();
            em.remove(obj);
            finalizarTransaccion();
        } else {
            em.remove(obj);  
            
        }        
    }        
}