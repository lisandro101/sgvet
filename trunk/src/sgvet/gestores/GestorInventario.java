/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import sgvet.entidades.Componente;

/**
 *
 * @author Lisandro
 */
public class GestorInventario {

    private static GestorInventario instancia;

    public synchronized static GestorInventario getInstancia(){
        if (instancia == null){
            instancia = new GestorInventario();
        }
        return instancia;
    }

    private GestorInventario(){

    }

    public double calcularLoteOptimo(Componente componente){
        return Math.sqrt(2*componente.getDemandaAnual()*componente.getCostoPedido()/componente.getCostoAlmacenamiento());
    }

    public double calcularNumeroDePedido(Componente componente){
        return componente.getDemandaAnual()/calcularLoteOptimo(componente);
    }

    public double calcularTiempoEntrePedidos(Componente componente){
        return 365/calcularNumeroDePedido(componente);
    }

    public double calcularCGI(Componente componente){
        return Math.sqrt(2*componente.getDemandaAnual()*componente.getCostoPedido()*componente.getCostoAlmacenamiento());
    }

    public double calcularCostoTotal(Componente componente){
        return Math.sqrt(componente.getDemandaAnual()*componente.getCostoUnitario()+calcularCGI(componente));
    }

    public double calcularStockDeSeguridad(Componente componente){
        return Math.sqrt(calcularTiempoEntrePedidos(componente));
    }

    public double calcularPuntoDePedido(Componente componente){
        return componente.getDemandaAnual()/365*calcularTiempoEntrePedidos(componente)*calcularStockDeSeguridad(componente);
    }

    public double calcularMaximoDeInventario(Componente componente){
        return calcularLoteOptimo(componente)+calcularStockDeSeguridad(componente);
    }

}
