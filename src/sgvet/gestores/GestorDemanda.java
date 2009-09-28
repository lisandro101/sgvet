/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.swing.table.TableModel;
import sgvet.entidades.Demanda;
import sgvet.entidades.DemandaXPeriodo;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.Venta;
import sgvet.entidades.ProductoComponente;
import sgvet.igu.PanelDemanda;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author stafoxter
 */
public class GestorDemanda {

//    private List <DetalleOrdenProduccion> detallesOrdenes;
    private static GestorDemanda instancia;
    
    public synchronized static GestorDemanda getInstancia(){
        if (instancia == null){
            instancia = new GestorDemanda();
        }
        return instancia;            
    }
    private GestorDemanda(){
        
    }

    public double calcularPM(List<Demanda> demandas){
        int n=0;
        double total=0.0;
//        for (Demanda demanda : demandas) {
//            total += demanda.getDemandaReal();
//            ++n;
//        }
        demandas.get(0).setPM(demandas.get(0).getDemandaReal());
        for (int i = 1; i < demandas.size(); i++) {
            for (int j = 1; j <= i; j++) {
                total += demandas.get(j).getDemandaReal();
                ++n;
            }
            demandas.get(i).setPM(total/n);
            if(i != (demandas.size()-1)){
                total=0;
                n=0;
            }

        }
        return (total/n);
    }

    public double calcularPMP(List<Demanda> demandas){
        double total=0.0;
//        for (Demanda demanda : demandas) {
//            total += demanda.getDemandaReal()* demanda.getPonderacionPMP();
//        }
        demandas.get(0).setPM(demandas.get(0).getDemandaReal());
        for (int i = 1; i < demandas.size(); i++) {
            for (int j = 1; j <= i; j++) {
                total += demandas.get(j).getDemandaReal()* demandas.get(j).getPrediccionSES();
            }
            demandas.get(i).setPMP(total);
            if(i != (demandas.size()-1)){
                total=0;
            }

        }


        return total;
    }
    
    public double calcularPMSE(List<Demanda> demandas, double alfa){
        double valorF=0;
        double resultado=0;
        int max= demandas.size()-1;
        demandas.get(0).setPMSE(demandas.get(0).getDemandaReal());

        for (int i = 1; i < demandas.size(); i++) {
            valorF = demandas.get(i-1).getPMSE();
            resultado = valorF + alfa*(demandas.get(i-1).getDemandaReal()-valorF);
            demandas.get(i).setPMSE(resultado);

        }

        valorF = demandas.get(max).getPMSE();
        resultado = valorF + alfa*(demandas.get(max).getDemandaReal()-valorF);

        return resultado;
    }

    public boolean validarConstanteAlfa(double constante){
        if(constante>=0 && constante<=1){
            return true;
        }
        return false;
    }

    public boolean validarPonderaciones(List<Demanda> demandas) {
        double total = 0.0;
        for (Demanda demanda : demandas) {
            total += demanda.getPrediccionSES();
        }
        if (total == 1) {
            return true;
        }
        return false;
    }

    public double[] calcularErrores(List<Demanda> demandasHist,Demanda demandaPred, double demandaReal, PanelDemanda.Error error){
        double[] errores = new double[3];
        int n=0;
//        double resultado=0;

        if(error == PanelDemanda.Error.ERROR_MEDIO){
            errores[0]= Math.abs(demandaReal-demandaPred.getPM());
            errores[1]= Math.abs(demandaReal-demandaPred.getPMP());
            errores[2]= Math.abs(demandaReal-demandaPred.getPMSE());
        }else if(error == PanelDemanda.Error.ERROR_MEDIO_ABSOLUTO){
            for (Demanda dema : demandasHist) {
                errores[0] += Math.abs(dema.getDemandaReal()-dema.getPM());
                errores[1] += Math.abs(dema.getDemandaReal()-dema.getPMP());
                errores[2] += Math.abs(dema.getDemandaReal()-dema.getPMSE());
                ++n;
            }
            errores[0] = errores[0]/n;
            errores[1] = errores[1]/n;
            errores[2] = errores[2]/n;

        }else if(error == PanelDemanda.Error.ERROR_CUADRADO_MEDIO){
            for (Demanda dema : demandasHist) {
                errores[0] += Math.pow((dema.getDemandaReal()-dema.getPM()),2);
                errores[1] += Math.pow((dema.getDemandaReal()-dema.getPMP()),2);
                errores[2] += Math.pow((dema.getDemandaReal()-dema.getPMSE()),2);
                ++n;
            }
            errores[0] = errores[0]/n;
            errores[1] = errores[1]/n;
            errores[2] = errores[2]/n;
        }else{
            for (Demanda dema : demandasHist) {
                errores[0] += (Math.abs(dema.getDemandaReal()-dema.getPM()))/dema.getDemandaReal();
                errores[1] += (Math.abs(dema.getDemandaReal()-dema.getPMP()))/dema.getDemandaReal();
                errores[2] += (Math.abs(dema.getDemandaReal()-dema.getPMSE()))/dema.getDemandaReal();
                ++n;
            }
            errores[0] = (errores[0]/n)*100;
            errores[1] = (errores[1]/n)*100;
            errores[2] = (errores[2]/n)*100;
        }
        return errores;
    }

     //..................realiza el suavizamiento exponencial simple.................................
    @Deprecated
    public void suavizarES(double alfa, int periodo, int demandaActual){

        double [] vectorXDemanda = null;
        //busqueda de datos históricos o la última media en la base de datos según el periodo especificado....
        double promActual = inicializarES(alfa,vectorXDemanda);
        System.out.println("El promedio actual es: "+ promActual);
       
    }
    @Deprecated
    public void suavizarES(float alfa, double promDemanda, double demandaActual){
        
        double promActual=actualizarES((float) alfa,promDemanda,demandaActual);
        System.out.println("El promedio actual es: "+ promActual);


    }


    //------------------------------------------------------------------------------------------------
    @Deprecated
    public double inicializarES(double alfa, double vectorXDemanda[]){
        //Este método calcula el nuevo promedio de distintos valores de Xn para un mismo periodo............
        double promActual = 0;
        double promAnterior = 0;
        for(int i=0;i<vectorXDemanda.length;i++){
            promActual += alfa * vectorXDemanda[i] + (1-alfa) * promAnterior;
            promAnterior = promActual;
        }
        return promActual;
    }


    //------------------------------------------------------------------------------------------------
    @Deprecated
    public double actualizarES(float alfa, double promDemanda, double demandaActual){
        //este método calcula el nuevo promedio a partir del ultimo promedio
        double promActual = alfa * demandaActual + (1-alfa) * promDemanda;
        return promActual;
    }

    //------------------------------------------------------------------------------------------------
   

    // Calcula el suavizamiento exponencial simple para un arreglo de demandas a predecir
    @Deprecated
    public List<Demanda> calcularES(double alfa, List<Demanda> demandas){
        int temp=0;
        int demandaReal=0;
        int demandaPre=0;
        //demandas.get(0).setPrediccionSES(demandaEspActual);
        demandas.get(0).setPrediccionSES(demandas.get(0).getDemandaReal());

        for (int i = 1; i < demandas.size(); i++) {
            if(demandas.get(i).getDemandaReal() != 0){
                demandaReal= demandas.get(i).getDemandaReal();

            }else if(demandas.get(i).getDemandaReal() == 0){
                ++temp;
            }
            if(temp<=1){
                demandaPre= (int) demandas.get(i - 1).getPrediccionSES();
            }

            demandas.get(i).setPrediccionSES((int)(alfa * demandaReal + (1 - alfa)
                    * demandaPre));
        }

        return demandas;
    }

    public int calcularESNew(double alfa, List<DemandaXPeriodo> ventas){
        int temp=0;
        int demandaReal=0;
        int demandaPre=0;
        ventas.get(0).setPrediccionVenta(ventas.get(0).getVentas());

        for (int i = 1; i < ventas.size(); i++) {
            if(ventas.get(i).getVentas() != 0){
                demandaReal= ventas.get(i).getVentas();
            }else if(ventas.get(i).getVentas() == 0){
                ++temp;
            }
            if(temp<=1){
                demandaPre= (int) ventas.get(i - 1).getPrediccionVenta();
            }
            ventas.get(i).setPrediccionVenta((int)(alfa * demandaReal + (1 - alfa)
                    * demandaPre));
        }
        return ventas.get(ventas.size()-1).getPrediccionVenta();
    }

    public void calcularDemandaConEstacionalidad(TableModel tModel, double alfa, double gamma){
        double indiceEsta1[] = new double[tModel.getRowCount()];
        double demanPromedio1[] = new double[tModel.getRowCount()];
        double indiceEsta2[] = new double[tModel.getRowCount()];
        double demanPromedio2[] = new double[tModel.getRowCount()];
        int totaldemanPromedio1=0;
        double temp=0;
        double ultimoReal=0;


        for (int i = 0; i < tModel.getRowCount(); i++) {
            for (int j = 1; j < tModel.getColumnCount()-1; j++) {
                demanPromedio1[i] += Double.parseDouble(tModel.getValueAt(i, j).toString());
            }
            demanPromedio1[i]= demanPromedio1[i]/ (tModel.getColumnCount()-2);

            totaldemanPromedio1 += demanPromedio1[i];    //tipos incompatibles
        }
        totaldemanPromedio1 = totaldemanPromedio1/tModel.getRowCount();

        for (int i = 0; i < tModel.getRowCount(); i++) {
            indiceEsta1[i]=demanPromedio1[i]/totaldemanPromedio1;
        }

        for (int i = 0; i < tModel.getRowCount(); i++) {
            if(tModel.getValueAt(i,tModel.getColumnCount()-1 ) != null){

                temp = Double.parseDouble(tModel.getValueAt(i,tModel.getColumnCount()-1).toString());
                ultimoReal= temp/indiceEsta1[i]*alfa+ (1-alfa)*demanPromedio1[i];
                demanPromedio2[i]= ultimoReal;
            }else{

                demanPromedio2[i]= ultimoReal* indiceEsta1[i];
                tModel.setValueAt((int)demanPromedio2[i] , i, tModel.getColumnCount()-1);

            }
        }
 
    }
    @Deprecated
    public void calcularDemandaConTendencia(TableModel tModel, double alfa, double beta){
        double indiceTend1[] = new double[tModel.getRowCount()];
        double indiceTend2[] = new double[tModel.getRowCount()];
        double demanPromedio1[] = new double[tModel.getRowCount()];
        double demanPromedio2[] = new double[tModel.getRowCount()];
        double temp;

        //inicializar tendencia en cero y la demanda promedio en con la demanda real actual
        for (int i = 0; i < tModel.getRowCount(); i++) {
            indiceTend1[i]=0;
            demanPromedio1[i]=Double.parseDouble(tModel.getValueAt(i,1).toString());
        }

        for (int j = 1; j < tModel.getColumnCount()-1; j++) {
            for (int i = 0; i < tModel.getRowCount(); i++) {

                if(tModel.getValueAt(i,j ) != null){
                    demanPromedio2[i]= (alfa*Double.parseDouble(tModel.getValueAt(i,j).toString())+(1-alfa)*(demanPromedio1[i] + indiceTend2[i]));
                    indiceTend2[i]= beta *(demanPromedio2[i]- demanPromedio1[i])+(1-beta)*indiceTend1[i];

                }else{

                }
            }
            for (int s = 0; s < tModel.getRowCount(); s++) {
                temp= demanPromedio2[s]+indiceTend2[s];
                tModel.setValueAt((int)temp, s, j+1);
                
                indiceTend1[s]=indiceTend2[s];
                demanPromedio1[s]= demanPromedio2[s];
            }
            
        }
    }
        // TableModel tModel
        public double calcularDemandaConTendenciaNew(List<DemandaXPeriodo> ventas, double alfa, double beta){

        double estimacionAnt;
        double indiceAnt;
        double temp;
        List <Double> indice = new ArrayList<Double>();
        List <Double> estimacion = new ArrayList<Double>();

//        indice.add(0.0);

        for (int i = 0; i < ventas.size(); i++) {
            if(i==0){
                indiceAnt=0;
                estimacionAnt=ventas.get(0).getVentas();
            }else{
                indiceAnt= indice.get(i-1);
                estimacionAnt= estimacion.get(i-1);
            }
            temp = alfa*ventas.get(i).getVentas() + (1-alfa)*(estimacionAnt+indiceAnt);
            estimacion.set(i,temp );
            temp= beta *(ventas.get(i).getVentas()-estimacionAnt)+(1-beta)*indiceAnt;
            indice.set(i, temp);
        }

        temp= estimacion.get(estimacion.size()-1) + indice.get(indice.size()-1);
        return temp;
    }
//    @Deprecated
//    public int CalcularDemandaAcumulada(ProductoComponente producto){
//        int total=0;
//
//        buscarDetalles(producto);
//        for (DetalleOrdenProduccion detalleOrdenProduccion : detallesOrdenes) {
//            total+= detalleOrdenProduccion.getCantidad();
//        }
//
//        return total;
//    }

    public List<DemandaXPeriodo> CalcularDemandaXPeriodo(ProductoComponente producto){
        List <DetalleOrdenProduccion> detallesOrdenes;
        int total=0;
        List<DemandaXPeriodo> demandasXPeriodo = new ArrayList<DemandaXPeriodo>();
        Date fechaIni;

        detallesOrdenes = buscarDetalles(producto);

        if(detallesOrdenes.size()>0){
            fechaIni= detallesOrdenes.get(0).getVenta().getFecha();

            for (DetalleOrdenProduccion detallete : detallesOrdenes) {
                if(diaValidoDelMes(detallete.getVenta().getFecha())){
                    if(sonDelMismoMes(fechaIni, detallete.getVenta().getFecha())){
                        total+=detallete.getCantidad();
                    }else{
                        demandasXPeriodo.add(new DemandaXPeriodo(fechaIni,total));
                        total=detallete.getCantidad();
                        fechaIni= detallete.getVenta().getFecha();
                    }

                }
            }
            total+=detallesOrdenes.get(detallesOrdenes.size()-1).getCantidad();
            demandasXPeriodo.add(new DemandaXPeriodo(fechaIni,total));
         }

        return cerrarPeriodo(demandasXPeriodo, detallesOrdenes);
    }

    private Date primerDia(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(cal.get(cal.YEAR),cal.get(cal.MONTH), 1);
        return cal.getTime();
    }

    private Date ultimoDia(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(cal.get(cal.YEAR),cal.get(cal.MONTH), 28);
        return cal.getTime();
    }

    private boolean diaValidoDelMes(Date fecha){
        boolean resul=false;
        if(fecha.compareTo(primerDia(fecha))>=0 && fecha.compareTo(ultimoDia(fecha))<=0 ){
            resul=true;
        }
        return resul;
    }

    private boolean sonDelMismoMes(Date fechaA, Date fechaB){
        boolean resul=false;
        if(fechaA.compareTo(primerDia(fechaB))>=0 && fechaA.compareTo(ultimoDia(fechaB))<=0 ){
            resul=true;
        }
        return resul;
    }


    private List <DetalleOrdenProduccion> buscarDetalles(ProductoComponente prod){
        List <DetalleOrdenProduccion> detallesOrdenes;
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from DetalleOrdenProduccion a where a.producto= :nombre and a.borrado=false" );
        consulta.setParameter("nombre",prod );
        detallesOrdenes = FachadaPersistencia.getInstancia().buscar(DetalleOrdenProduccion.class, consulta);

        if(detallesOrdenes.size()>0){
            System.out.println("\n Cant detalles de produccion encontrados:"+detallesOrdenes.size()+"\n");
        }

        return ordenarDetallesXFecha(detallesOrdenes);
    }


    private List <DetalleOrdenProduccion> ordenarDetallesXFecha(List <DetalleOrdenProduccion> detallesOrdenes){
        List <DetalleOrdenProduccion> detallesTemp = new ArrayList<DetalleOrdenProduccion>();
        Date fecha1;

        DetalleOrdenProduccion detalleTemp=null;

        int cantElem= detallesOrdenes.size();

        for (int i = 0; i < cantElem; i++) {
            fecha1=detallesOrdenes.get(0).getVenta().getFecha();
            for (DetalleOrdenProduccion detallete : detallesOrdenes) {
                if(detallete.getVenta().getFecha().compareTo(fecha1)<=0){
                    fecha1=detallete.getVenta().getFecha();
                    detalleTemp=detallete;
                }
            }
            detallesTemp.add(detalleTemp);
            detallesOrdenes.remove(detalleTemp);
            
        }
        detallesOrdenes=detallesTemp;

        //borrar estas lineas
        for (DetalleOrdenProduccion detallene : detallesOrdenes) {
            System.out.println("\n ----------------------------------------");
            System.out.println("\n Fecha ordenada: "+detallene.getVenta().getFecha().toString()+ "  Cantidad: "+ detallene.getCantidad());
        }

        return detallesOrdenes;
    }

    private List <DemandaXPeriodo> cerrarPeriodo(List <DemandaXPeriodo> ventas, List<DetalleOrdenProduccion> detalles){
        Date hoy = new Date();

        if(diaValidoDelMes(hoy)){
            if(sonDelMismoMes(hoy, detalles.get(detalles.size()-1).getVenta().getFecha())){
                ventas.remove(ventas.size()-1);
            }
        }

        return ventas;
    }

    public int calcularAcumulado( List<DemandaXPeriodo> ventas){
        int resul=0;
        for (DemandaXPeriodo demandaXPeriodo : ventas) {
            resul += demandaXPeriodo.getVentas();
        }
        return resul;
    }

     public void mostrarXPantalla(List<DemandaXPeriodo> demandas){
        if(demandas != null){
            for (DemandaXPeriodo demandaXPeriodo : demandas) {
            System.out.println("\n Periodo: "+demandaXPeriodo.getMes()+"    Total: "+demandaXPeriodo.getVentas());
            }
        }else{
            System.out.println("\n No se registraron ventas del producto seleccionado\n");
        }
    }
}
