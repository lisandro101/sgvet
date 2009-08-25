/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;


import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Empleado;
import sgvet.entidades.HoraLaboral;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorPersonal {
    
    private static GestorPersonal instancia;
    
    public synchronized static GestorPersonal getInstancia(){
        if (instancia == null){
            instancia = new GestorPersonal();
        }
        return instancia;            
    }
    private GestorPersonal(){
        
    }
    
    public boolean verificarMaxHoras(Empleado empleado, int cantHoras){
        Query consulta;
        List<HoraLaboral> horas;
        int total=0;

        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from HoraLaboral a where a.empleado = :emp and a.borrado=false");
        consulta.setParameter("emp", empleado);
        horas = FachadaPersistencia.getInstancia().buscar(HoraLaboral.class, consulta);

        if(horas.size()>=0){
            for (HoraLaboral horaLaboral : horas) {
                total += horaLaboral.getCantidad();
            }
            if((total+cantHoras)<= empleado.getCargo().getHorasPorMes()){
                return true;
            }else{
                return false;
            }
        }
        if(cantHoras <= empleado.getCargo().getHorasPorMes()){
            return true;
        }else{
            return false;
        }

    }
    
}
