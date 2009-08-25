package sgvet.persistencia;

import java.util.List;
import javax.persistence.Query;

/**
 * Fachada para acceder a los métodos de la persistencia
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
public class FachadaPersistencia {
    private static FachadaPersistencia instancia;
    
    private FachadaPersistencia() {
    }
    
    /**
     * Devuelve una instancia de la clase
     * 
     * @return Una instancia de la clase
     */
    public static synchronized FachadaPersistencia getInstancia() {
        if(instancia == null) {
            instancia = new FachadaPersistencia();
        }
        
        return instancia;
    }
    
    public void grabar(IPersistente obj, boolean transaccion) {
        FabricaManejadores.getInstancia().getManejador().grabar(obj, transaccion);
    }
    
    public <T extends IPersistente> T actualizar(T obj, boolean transaccion) {
        return FabricaManejadores.getInstancia().getManejador().actualizar(
                obj, transaccion);
    }
    
    public void borrar(IPersistente obj, boolean transaccion) {
        FabricaManejadores.getInstancia().getManejador().borrar(
                obj, transaccion);
    }
    
    public <T extends IPersistente> T buscar(Class<T> clase, Object id) {
        return FabricaManejadores.getInstancia().getManejador().buscar(
                clase, id);
    }
    
    public <T extends IPersistente> List<T> buscar(Class<T> clase,
            String query) {
        return FabricaManejadores.getInstancia().getManejador().buscar(
                clase, query);
    }
    
    public <T extends IPersistente> List<T> buscar(Class<T> clase,
            Query query) {
        return FabricaManejadores.getInstancia().getManejador().buscar(
                clase, query);
    }
    
    public <T extends IPersistente> T obtenerPrimero(
            Class<T> clase, Query query) {
        return FabricaManejadores.getInstancia().getManejador().obtenerPrimero(
                clase, query);
    }
    
    public <T extends IPersistente> T obtenerPrimero(
            Class<T> clase, String consulta) {
        return FabricaManejadores.getInstancia().getManejador().obtenerPrimero(
                clase, consulta);
    }
    
    public Query crearConsulta(String query) {
        return FabricaManejadores.getInstancia().getManejador().crearConsulta(
                query);
    }
    
    public void comenzarTransaccion() {
        FabricaManejadores.getInstancia().getManejador().comenzarTransaccion();
    }
    
    public void finalizarTransaccion() {
        FabricaManejadores.getInstancia().getManejador().finalizarTransaccion();
    }
    
    public void borrarFisico(IPersistente obj, boolean transaccion) {
        FabricaManejadores.getInstancia().getManejador().borrarFisico(
                obj, transaccion);
    }
}