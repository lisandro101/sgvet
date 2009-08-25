package sgvet.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase para fabricar manejadores
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
class FabricaManejadores {
    private static final int CANTIDAD_MANEJADORES = 10;
    private static FabricaManejadores instancia;
    
    private EntityManagerFactory emf;
    private Map<Long, Manejador> manejadores;
    
    private FabricaManejadores() {
        emf = Persistence.createEntityManagerFactory("radiadoresPU");
        manejadores = new HashMap<Long, Manejador>(CANTIDAD_MANEJADORES);
    }
    
    static synchronized FabricaManejadores getInstancia() {
        if(instancia == null) {
            instancia = new FabricaManejadores();
        }
        
        return instancia;
    }
    
    Manejador getManejador() {
        Manejador manejador = null;
        long numeroHilo = Thread.currentThread().getId();
        
        if(manejadores.containsKey(numeroHilo)) {
            manejador = manejadores.get(numeroHilo);
        } else {
            manejador = new Manejador(emf.createEntityManager());
            manejadores.put(numeroHilo, manejador);
        }
        
        if(manejadores.size() > CANTIDAD_MANEJADORES) {
            new Thread("Mantenimiento Manejadores") {
                
                @Override
                public void run() {
                    mantener();
                }
            }.start();
        }
        
        return manejador;
    }
    
    private synchronized void mantener() {
        Thread[] hilos = new Thread[Thread.activeCount()];
        List<Long> aEliminar = new ArrayList<Long>(manejadores.keySet());
        
        Thread.enumerate(hilos);
        
        for (Thread hilo : hilos) {
            if(!aEliminar.contains(hilo.getId())) {
                aEliminar.remove(hilo.getId());
            }
        }
        
        for (Long eliminar : aEliminar) {
            manejadores.remove(eliminar);
        }
    }
}