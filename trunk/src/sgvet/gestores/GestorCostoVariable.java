/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Componente;
import sgvet.entidades.CostoFijo;
import sgvet.entidades.CostoVariable;
import sgvet.entidades.EstructuraDeProducto;
import sgvet.entidades.HoraLaboral;
import sgvet.entidades.MateriaPrima;
import sgvet.entidades.NodoRuta;
import sgvet.entidades.ParteDeEstructura;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.ProductoTerminado;
import sgvet.entidades.RutaFabricacion;
import sgvet.igu.model.CostoFijoTableModel;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorCostoVariable {
    
    private static GestorCostoVariable instancia;
    
    public synchronized static GestorCostoVariable getInstancia(){
        if (instancia == null){
            instancia = new GestorCostoVariable();
        }
        return instancia;            
    }
    private GestorCostoVariable(){
        
    }

    public List<CostoVariable> calcularCostoVariable(){
        List<CostoVariable> costos = new ArrayList<CostoVariable>();
        List<ProductoTerminado> productoTerminados;
        CostoVariable costoVariable;
        
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from ProductoTerminado a where  a.borrado=false" );
        productoTerminados = FachadaPersistencia.getInstancia().buscar(ProductoTerminado.class, consulta);

        for (ProductoTerminado productoTerminado : productoTerminados) {
            costoVariable = new CostoVariable();
            
            costoVariable.setProductoTerminado(productoTerminado);
            costoVariable.setCostoManoObra(calcularCostoMO(productoTerminado));
            costoVariable.setCostoMateriales(calcularCostoMateriales(productoTerminado));
            
            costos.add(costoVariable);
        }
        
        return costos;
    }
    
    
    private double calcularCostoMO(ProductoTerminado productoTerminado){
        RutaFabricacion ruta;
        double costoMO=0.0;
        List<NodoRuta> nodos;
        List<HoraLaboral> horasLaborales;
        int cantMinutosLaborales;
        
        Query consulta;
        
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from RutaFabricacion a where a.productoTerminado= :terminado and a.borrado=false" );
        consulta.setParameter("terminado", productoTerminado);
        
        List<RutaFabricacion> rutasFabricacion = FachadaPersistencia.getInstancia().buscar(RutaFabricacion.class, consulta);
        
        if(rutasFabricacion.size()>=1){
            ruta= rutasFabricacion.get(0);   
            nodos= ruta.getNodosRuta();
            
            for (NodoRuta nodoRuta : nodos) {
                horasLaborales= nodoRuta.getHorasTrabajadas();
                
                for (HoraLaboral horaLaboral : horasLaborales) {
                    cantMinutosLaborales= horaLaboral.getCantidad();
                    costoMO += (horaLaboral.getEmpleado().getCargo().getValorHora()/60)*cantMinutosLaborales;
                     
                } 
            }
        }
        return costoMO;
    }
    
    
    private double calcularCostoMateriales(ProductoTerminado productoTerminado){
        EstructuraDeProducto estructuraDeProducto;
        List<ParteDeEstructura> partes;
        double resultado= 0.0;
        double costoMaterial=0.0;
        Componente componente;
        
        Query consulta;
        
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from EstructuraDeProducto a where a.productoTerminado= :terminado and a.borrado=false" );
        consulta.setParameter("terminado", productoTerminado);
        List<EstructuraDeProducto> estructurasDeProducto = FachadaPersistencia.getInstancia().buscar(EstructuraDeProducto.class, consulta);
        
        if(estructurasDeProducto.size() >= 1){
            estructuraDeProducto = estructurasDeProducto.get(0);
            partes= estructuraDeProducto.getPartes();
            
            for (ParteDeEstructura parte : partes) {
                componente= parte.getComponente();
                
                if(componente instanceof MateriaPrima){
                    costoMaterial = ((MateriaPrima)componente).getPrecioBase();
//                    costoMaterial += ((MateriaPrima)componente).getCostoAlmacenamiento();
//                    costoMaterial += ((MateriaPrima)componente).getCostoUnitario();
                }else if(componente instanceof ProductoComponente){
                    costoMaterial = ((ProductoComponente)componente).getPrecioBase();
//                    costoMaterial += ((ProductoComponente)componente).getCostoAlmacenamiento();
//                    costoMaterial += ((ProductoComponente)componente).getCostoUnitario();
                    //costoMaterial += ((ProductoComponente)componente).getCostoPedido();
                }

                resultado += parte.getCantidad()* costoMaterial;
                
            }
            
        }
        
        
        return resultado;
    }
}
