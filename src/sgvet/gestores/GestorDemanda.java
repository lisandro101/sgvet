/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import sgvet.entidades.Demanda;
import sgvet.entidades.auxiliares.DemandaXPeriodo;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.ProductoComponente;
import sgvet.persistencia.FachadaPersistencia;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stafoxter
 */
public class GestorDemanda {

    private Date fechaCierre;
    private double[] indices;
    private int ventasDelMesAbierto;
    private double tendencia;
    private static GestorDemanda instancia;

    public synchronized static GestorDemanda getInstancia() {
        if (instancia == null) {
            instancia = new GestorDemanda();
        }
        return instancia;
    }


    public boolean validarConstanteAlfa(double constante) {
        if (constante >= 0 && constante <= 1) {
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

//    public double[] calcularErrores(List<Demanda> demandasHist, Demanda demandaPred, double demandaReal, PanelDemanda.Error error) {
//        double[] errores = new double[3];
//        int n = 0;
////        double resultado=0;
//
//        if (error == PanelDemanda.Error.ERROR_MEDIO) {
//            errores[0] = Math.abs(demandaReal - demandaPred.getPM());
//            errores[1] = Math.abs(demandaReal - demandaPred.getPMP());
//            errores[2] = Math.abs(demandaReal - demandaPred.getPMSE());
//        } else if (error == PanelDemanda.Error.ERROR_MEDIO_ABSOLUTO) {
//            for (Demanda dema : demandasHist) {
//                errores[0] += Math.abs(dema.getDemandaReal() - dema.getPM());
//                errores[1] += Math.abs(dema.getDemandaReal() - dema.getPMP());
//                errores[2] += Math.abs(dema.getDemandaReal() - dema.getPMSE());
//                ++n;
//            }
//            errores[0] = errores[0] / n;
//            errores[1] = errores[1] / n;
//            errores[2] = errores[2] / n;
//
//        } else if (error == PanelDemanda.Error.ERROR_CUADRADO_MEDIO) {
//            for (Demanda dema : demandasHist) {
//                errores[0] += Math.pow((dema.getDemandaReal() - dema.getPM()), 2);
//                errores[1] += Math.pow((dema.getDemandaReal() - dema.getPMP()), 2);
//                errores[2] += Math.pow((dema.getDemandaReal() - dema.getPMSE()), 2);
//                ++n;
//            }
//            errores[0] = errores[0] / n;
//            errores[1] = errores[1] / n;
//            errores[2] = errores[2] / n;
//        } else {
//            for (Demanda dema : demandasHist) {
//                errores[0] += (Math.abs(dema.getDemandaReal() - dema.getPM())) / dema.getDemandaReal();
//                errores[1] += (Math.abs(dema.getDemandaReal() - dema.getPMP())) / dema.getDemandaReal();
//                errores[2] += (Math.abs(dema.getDemandaReal() - dema.getPMSE())) / dema.getDemandaReal();
//                ++n;
//            }
//            errores[0] = (errores[0] / n) * 100;
//            errores[1] = (errores[1] / n) * 100;
//            errores[2] = (errores[2] / n) * 100;
//        }
//        return errores;
//    }
//
//    // Calcula el suavizamiento exponencial simple para un arreglo de demandas a predecir
//    @Deprecated
//    public List<Demanda> calcularES(double alfa, List<Demanda> demandas) {
//        int temp = 0;
//        int demandaReal = 0;
//        int demandaPre = 0;
//        //demandas.get(0).setPrediccionSES(demandaEspActual);
//        demandas.get(0).setPrediccionSES(demandas.get(0).getDemandaReal());
//
//        for (int i = 1; i < demandas.size(); i++) {
//            if (demandas.get(i).getDemandaReal() != 0) {
//                demandaReal = demandas.get(i).getDemandaReal();
//
//            } else if (demandas.get(i).getDemandaReal() == 0) {
//                ++temp;
//            }
//            if (temp <= 1) {
//                demandaPre = (int) demandas.get(i - 1).getPrediccionSES();
//            }
//
//            demandas.get(i).setPrediccionSES((int) (alfa * demandaReal + (1 - alfa) * demandaPre));
//        }
//
//        return demandas;
//    }
    public int calcularESNew(double alfa, List<DemandaXPeriodo> ventas) {
        int temp = 0;
        int demandaReal = 0;
        int demandaPre = 0;

        abrirPeriodoActualSiNoEstaFinalizado(ventas);
        int cantPeriDeVentas = calcularCantidadPeriodosCerrados(ventas);

        if (cantPeriDeVentas > 0) {
            ventas.get(0).setPrediccionVenta(ventas.get(0).getVentas());

            for (int i = 1; i < cantPeriDeVentas; i++) {
                if (ventas.get(i).getVentas() != 0) {
                    demandaReal = ventas.get(i).getVentas();
                } else if (ventas.get(i).getVentas() == 0) {
                    ++temp;
                }
                if (temp <= 1) {
                    demandaPre = ventas.get(i - 1).getPrediccionVenta();
                }
                ventas.get(i).setPrediccionVenta((int) (alfa * demandaReal + (1 - alfa) * demandaPre));
            }
//            temp = ventas.get(ventas.size() - 1).getPrediccionVenta();
            temp = ventas.get(cantPeriDeVentas - 1).getPrediccionVenta();
        }

        return temp;
    }

    public List<Integer> calcularDemandaConEstacionalidadNew(double alfa, double gamma, List<DemandaXPeriodo> ventas) {
        List<Integer> predicciones = new ArrayList<Integer>();
        int cantPeriodos = 13;
        double indiceEstacionalidad[] = new double[cantPeriodos];
        double demanPromedioXPeriodo[] = new double[cantPeriodos];

        GestorFecha gf = GestorFecha.getInstancia();
        int primerPeriodoDeVenta = gf.aQuePeriodoCorrespondeLaFecha(ventas.get(0).getFechaInicio());
        double demandaPromedioAnial= 0.0;
        int indiceNroPeriodo=0;
        int cantAniosCerrados=0;

        abrirPeriodoActualSiNoEstaFinalizado(ventas);


        //inicializar indices estacionalidad
        for (int i = 0; i < cantPeriodos; i++) {
            indiceEstacionalidad[i]=1;
            System.out.println("indice "+i+" vale: "+indiceEstacionalidad[i]);
        }
        

        //calcular el promedio de ventas por periodo
        int temp=0;
        for (int i = 0; i < ventas.size(); i++) {
            if(ventas.get(i).isCerrado() && ventas.get(i).getAnio().compareTo(gf.primerDiaDelAnio(gf.getFechaHoy()))<0){
                indiceNroPeriodo= gf.aQuePeriodoCorrespondeLaFecha(ventas.get(i).getFechaInicio())-1;
                demanPromedioXPeriodo[indiceNroPeriodo] += ventas.get(i).getVentas();
                if(temp==12){
                    temp=0;
                    ++cantAniosCerrados;
                }
                ++temp;
            }
        }
        for (int i = 0; i < cantPeriodos; i++) {
            demanPromedioXPeriodo[i] = demanPromedioXPeriodo[i]/cantAniosCerrados;

        }


        //calcular demanda promedio anual
        for (int i = 0; i < cantPeriodos; i++) {
            demandaPromedioAnial += demanPromedioXPeriodo[i];
        }
        demandaPromedioAnial= demandaPromedioAnial/cantPeriodos;


        //calcular indices de estacionalidad
        for (int i = 0; i < cantPeriodos; i++) {
            if(demanPromedioXPeriodo[i] != 0){
                indiceEstacionalidad[i]= demanPromedioXPeriodo[i]/demandaPromedioAnial;
            }


        }


        //calcular actualizaciones
        double indiceTemp;
        double demandaTemp;
        for (int i = 0; i < ventas.size(); i++) {
            if(ventas.get(i).isCerrado() &&
                    ventas.get(i).getAnio().compareTo(gf.primerDiaDelAnio(gf.getFechaHoy()))>=0){

                indiceNroPeriodo= gf.aQuePeriodoCorrespondeLaFecha(ventas.get(i).getFechaInicio())-1;

                demandaTemp =  (alfa*
                        (ventas.get(i).getVentas()/indiceEstacionalidad[indiceNroPeriodo]))+
                        ((1-alfa)*demanPromedioXPeriodo[indiceNroPeriodo]);
                        
                if(demandaTemp != 0){
                    demanPromedioXPeriodo[indiceNroPeriodo]= demandaTemp;
                }

                indiceTemp= (gamma*
                        (ventas.get(i).getVentas()/demanPromedioXPeriodo[indiceNroPeriodo]))+
                        ((1-gamma)*indiceEstacionalidad[indiceNroPeriodo]);

                if(indiceTemp != 0){
                    indiceEstacionalidad[indiceNroPeriodo]=indiceTemp;
                }


            }
        }

        //calcular predicciones
        int cantPredicciones=0;
        int resultado;

        if(indiceNroPeriodo<12){
            cantPredicciones = (cantPeriodos-1)-indiceNroPeriodo;
        }
        if(indiceNroPeriodo==12){
            cantPredicciones = cantPeriodos;
        }
        if(indiceNroPeriodo>12){
            System.out.println("\n\n\n Error en el indice de periodos en el " +
                    "calculo de prediccion de demanda con estacionalidad\n\n");
        }
        
        for (int i = 0; i < cantPredicciones; i++) {
            ++indiceNroPeriodo;
            resultado= (int) Math.floor(demanPromedioXPeriodo[indiceNroPeriodo]*indiceEstacionalidad[indiceNroPeriodo]);
            predicciones.add(resultado);
            
        }
        indices= indiceEstacionalidad;

        return predicciones;

    }

    @Deprecated
    public List<Integer> calcularDemandaConEstacionalidad(double alfa, double gamma, List<DemandaXPeriodo> vendido) {

        DefaultTableModel tModel = convertirListATableModel(vendido);
        List<Integer> predicciones = new ArrayList<Integer>();
        //mostrarTableModel(tModel);

        double indiceEsta1[] = new double[tModel.getRowCount()];
        double demanPromedio1[] = new double[tModel.getRowCount()];
        double indiceEsta2[] = new double[tModel.getRowCount()];
        double demanPromedio2[] = new double[tModel.getRowCount()];
        int totaldemanPromedio1 = 0;
        double temp = 0;
        double ultimoReal = 0;


        for (int i = 0; i < tModel.getRowCount(); i++) {
            for (int j = 1; j < tModel.getColumnCount() - 1; j++) {

                if(vendido.get(i+j-1).isCerrado()){
                    demanPromedio1[i] += Double.parseDouble(tModel.getValueAt(i, j).toString());
                    
                }


            }
            demanPromedio1[i] = demanPromedio1[i] / (tModel.getColumnCount() - 2);

            totaldemanPromedio1 += demanPromedio1[i];    //tipos incompatibles
        }
        totaldemanPromedio1 = totaldemanPromedio1 / tModel.getRowCount();

        for (int i = 0; i < tModel.getRowCount(); i++) {
            indiceEsta1[i] = demanPromedio1[i] / totaldemanPromedio1;
        }

        Integer cero = new Integer(0);

//        for (int i = 0; i < tModel.getRowCount(); i++) {
//            if (tModel.getValueAt(i, tModel.getColumnCount() - 1) != null && !tModel.getValueAt(i, tModel.getColumnCount() - 1).equals(cero)) {
//
//                temp = Double.parseDouble(tModel.getValueAt(i, tModel.getColumnCount() - 1).toString());
//                ultimoReal = temp / indiceEsta1[i] * alfa + (1 - alfa) * demanPromedio1[i];
//                demanPromedio2[i] = ultimoReal;
//            } else {
//
//                demanPromedio2[i] = ultimoReal * indiceEsta1[i];
//                tModel.setValueAt((int) demanPromedio2[i], i, tModel.getColumnCount() - 1);
//
//
//                predicciones.add((int) demanPromedio2[i]);
//            }
//        }
        int valor = 0;
        boolean entrar = true;
        int periodoActual;

        periodoActual = GestorFecha.getInstancia().aQuePeriodoCorrespondeLaFecha(GestorFecha.getInstancia().getFechaHoy());

        int cerrados = calcularCantidadPeriodosCerrados(vendido);

//        for (int j = 1; j < tModel.getColumnCount(); j++) {
//
//            //if (entrar) {
//                for (int i = 0; i < tModel.getRowCount(); i++) {
//
//                    //if (!String.valueOf(tModel.getValueAt(i, j)).equals("-1")) {
//                        if (valor < cerrados) {
//
//                            //if (tModel.getValueAt(i, j) != null && !tModel.getValueAt(i, j).equals(cero)){
//                            temp = Double.parseDouble(tModel.getValueAt(i, j).toString());
//                            ultimoReal = temp / indiceEsta1[i] * alfa + (1 - alfa) * demanPromedio1[i];
//                            demanPromedio2[i] = ultimoReal;
//                            ++valor;
//                            //}
//
//                        }
//                        if(j == (tModel.getColumnCount()-1) && i >= periodoActual) {
//
//                            //demanPromedio2[i] = ultimoReal * indiceEsta1[i];
//                            demanPromedio2[i] = demanPromedio2[i] * indiceEsta1[i];
//                            tModel.setValueAt((int) demanPromedio2[i], i, j);
//
//
//                            predicciones.add((int) demanPromedio2[i]);
//              //              entrar = false;
//                        }
////                    } else if (String.valueOf(tModel.getValueAt(i, j)).equals("-1") && valor > 0) {
////                            demanPromedio2[i] = ultimoReal * indiceEsta1[i];
////                            tModel.setValueAt((int) demanPromedio2[i], i, j);
////
////
////                            predicciones.add((int) demanPromedio2[i]);
////                            entrar = false;
////                    }
//                }
//            //}
//        }

        for (int i = 0; i < tModel.getRowCount(); i++) {
            if (tModel.getValueAt(i, tModel.getColumnCount() - 1) != null && !tModel.getValueAt(i, tModel.getColumnCount() - 1).equals(cero)) {

                temp = Double.parseDouble(tModel.getValueAt(i, tModel.getColumnCount() - 1).toString());
                ultimoReal = temp / indiceEsta1[i] * alfa + (1 - alfa) * demanPromedio1[i];
                demanPromedio2[i] = ultimoReal;
            }
            if(i >= periodoActual){

                demanPromedio2[i] = ultimoReal * indiceEsta1[i];
                tModel.setValueAt((int) demanPromedio2[i], i, tModel.getColumnCount() - 1);


                predicciones.add((int) demanPromedio2[i]);
            }
        }



        indices = indiceEsta1;

        //solo van las predicciones del periodo abierto en adelante
//        int periodoActual;
        int sacar;
//        periodoActual = GestorFecha.getInstancia().aQuePeriodoCorrespondeLaFecha(GestorFecha.getInstancia().getFechaHoy());

        System.out.println("cant periodos cerrados: "+ cerrados);
        System.out.println("cantidad de predicciones: "+ predicciones.size());

//        if(predicciones.size() > (13-periodoActual+1)){
//            sacar = predicciones.size() - (13-periodoActual+1);
//            for (int i = 0; i < sacar; i++) {
//                predicciones.remove(0);
//            }
//        }


        return predicciones;
    }


    //supone que las fechas de las ventas estan ordenadas ascendentemente
    private int calcularCantAniosDeVentas(List<DemandaXPeriodo> ventas) {
        int resul = 0;
        int periodo = 0;
        Date primerAnio; //= primerDiaDelAnio(ventas.get(0).getAnio());
        Date ultimoAnio;

        abrirPeriodoActualSiNoEstaFinalizado(ventas);
        int cantPeriDeVentas = calcularCantidadPeriodosCerrados(ventas);


        if (cantPeriDeVentas > 0) {
            primerAnio = GestorFecha.getInstancia().primerDiaDelAnio(ventas.get(0).getAnio());
            ultimoAnio = GestorFecha.getInstancia().primerDiaDelAnio(ventas.get(cantPeriDeVentas - 1).getAnio());

            while (primerAnio.compareTo(ultimoAnio) < 0) {

                if(periodo < cantPeriDeVentas){
                    primerAnio = GestorFecha.getInstancia().primerDiaDelAnio(ventas.get(periodo).getAnio());
                    periodo += 13;
                    ++resul;
                }else{
                    primerAnio = ultimoAnio;
                }

            }

        }
        return resul;

    }


    public double calcularDemandaConTendenciaNew(List<DemandaXPeriodo> ventas, double alfa, double beta) {

        double estimacionAnt;
        double indiceAnt;
        double temp;
        List<Double> indice = new ArrayList<Double>();
        List<Double> estimacion = new ArrayList<Double>();

        abrirPeriodoActualSiNoEstaFinalizado(ventas);
        int cantPeriDeVentas = calcularCantidadPeriodosCerrados(ventas);


        for (int i = 0; i < cantPeriDeVentas; i++) {
            if (i == 0) {
                indiceAnt = 0;
                estimacionAnt = ventas.get(0).getVentas();
            } else {
                indiceAnt = indice.get(i - 1);
                estimacionAnt = estimacion.get(i - 1);
            }
            temp = alfa * ventas.get(i).getVentas() + (1 - alfa) * (estimacionAnt + indiceAnt);

            //estimacion.set(i, temp);
            estimacion.add(temp);

            temp = beta * (ventas.get(i).getVentas() - estimacionAnt) + (1 - beta) * indiceAnt;

            //indice.set(i, temp);
            indice.add(temp);
        }

        temp = estimacion.get(estimacion.size()-1) + indice.get(indice.size()-1);
        tendencia= indice.get(indice.size()-1);
        return temp;
    }

    public List<DemandaXPeriodo> calcularDemandaXPeriodo(ProductoComponente producto) {
        List<DetalleOrdenProduccion> detallesOrdenes;
        int total = 0;
        List<DemandaXPeriodo> demandasXPeriodo = new ArrayList<DemandaXPeriodo>();//getPeriodosDelAnio(getFechaHoy());

        int cantVendida;
        Date fechaIni;
        Date fechaFin;
        int periodoIni;
        DemandaXPeriodo ventaDelPeriodo;


        int primerIndice = 0;
        int indiceNroPeriodoActual = 0;

        // los detalles de las oredenes se encuentran ordenados por fecha ascendente
        detallesOrdenes = buscarDetalles(producto);
        


        if (detallesOrdenes.size() > 0) {

            periodoIni = GestorFecha.getInstancia().aQuePeriodoCorrespondeLaFecha(detallesOrdenes.get(0).getVenta().getFecha());
            fechaIni = GestorFecha.getInstancia().calcularLimiteInferiorDelPeriodo(periodoIni, detallesOrdenes.get(0).getVenta().getFecha());
            fechaFin = GestorFecha.getInstancia().calcularLimiteSuperiorDelPeriodo(periodoIni, detallesOrdenes.get(0).getVenta().getFecha());
            cantVendida = 0;//detallesOrdenes.get(0).getCantidad();

            ventaDelPeriodo = new DemandaXPeriodo(periodoIni, fechaIni, fechaIni, fechaFin, cantVendida, false);

            for (DetalleOrdenProduccion detallete : detallesOrdenes) {

                if (GestorFecha.getInstancia().isFechaDelAnio(fechaFin, detallete.getVenta().getFecha())) { // si son del mismo año
                    if (GestorFecha.getInstancia().isFechaDelPeriodo(detallete.getVenta().getFecha(), ventaDelPeriodo)) { // si son del mismo periodo
                        sumarVentaAlPeriodo(detallete.getCantidad(), ventaDelPeriodo);
                    } else {
                        ventaDelPeriodo.setCerrado(true);
                        demandasXPeriodo.add(ventaDelPeriodo);

                        periodoIni = GestorFecha.getInstancia().aQuePeriodoCorrespondeLaFecha(detallete.getVenta().getFecha());
                        fechaIni = GestorFecha.getInstancia().calcularLimiteInferiorDelPeriodo(periodoIni, detallete.getVenta().getFecha());
                        fechaFin = GestorFecha.getInstancia().calcularLimiteSuperiorDelPeriodo(periodoIni, detallete.getVenta().getFecha());
                        cantVendida = detallete.getCantidad();

                        ventaDelPeriodo = new DemandaXPeriodo(periodoIni, fechaIni, fechaIni, fechaFin, cantVendida, false);

                    }
                } else {
                    ventaDelPeriodo.setCerrado(true);
                    demandasXPeriodo.add(ventaDelPeriodo);

                    periodoIni = GestorFecha.getInstancia().aQuePeriodoCorrespondeLaFecha(detallete.getVenta().getFecha());
                    fechaIni = GestorFecha.getInstancia().calcularLimiteInferiorDelPeriodo(periodoIni, detallete.getVenta().getFecha());
                    fechaFin = GestorFecha.getInstancia().calcularLimiteSuperiorDelPeriodo(periodoIni, detallete.getVenta().getFecha());
                    cantVendida = detallete.getCantidad();

                    ventaDelPeriodo = new DemandaXPeriodo(periodoIni, fechaIni, fechaIni, fechaFin, cantVendida, false);
                }

            }
            ventaDelPeriodo.setCerrado(true);

            demandasXPeriodo.add(ventaDelPeriodo);

            abrirPeriodoActualSiNoEstaFinalizado(demandasXPeriodo);

        }

        validarPeriodoNulos(demandasXPeriodo);

        return demandasXPeriodo;
    }

    private void sumarVentaAlPeriodo(int venta, DemandaXPeriodo periodo) {
        int temp = venta;
        temp += periodo.getVentas();
        periodo.setVentas(temp);

    }

    private List<DetalleOrdenProduccion> buscarDetalles(ProductoComponente prod) {
        List<DetalleOrdenProduccion> detallesOrdenes;
        Query consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from DetalleOrdenProduccion a where a.producto= :nombre and a.borrado=false");
        consulta.setParameter("nombre", prod);
        detallesOrdenes = FachadaPersistencia.getInstancia().buscar(DetalleOrdenProduccion.class, consulta);

        if (detallesOrdenes.size() > 0) {
            System.out.println("\n Cant detalles de produccion encontrados:" + detallesOrdenes.size() + "\n");
        }

        return ordenarDetallesXFecha(detallesOrdenes);
    }

    /**
     * Devuelve el List de DetalleOrdenProduccion ordenados por fecha ascendente
     * @param detallesOrdenes List de DetalleOrdenProduccion desordenado
     * @return
     */
    private List<DetalleOrdenProduccion> ordenarDetallesXFecha(List<DetalleOrdenProduccion> detallesOrdenes) {
        List<DetalleOrdenProduccion> detallesTemp = new ArrayList<DetalleOrdenProduccion>();
        Date fecha1;

        DetalleOrdenProduccion detalleTemp = null;

        int cantElem = detallesOrdenes.size();

        for (int i = 0; i < cantElem; i++) {
            fecha1 = detallesOrdenes.get(0).getVenta().getFecha();
            for (DetalleOrdenProduccion detallete : detallesOrdenes) {
                if (detallete.getVenta().getFecha().compareTo(fecha1) <= 0) {
                    fecha1 = detallete.getVenta().getFecha();
                    detalleTemp = detallete;
                }
            }
            detallesTemp.add(detalleTemp);
            detallesOrdenes.remove(detalleTemp);

        }
        detallesOrdenes = detallesTemp;


        return detallesOrdenes;
    }

    private List<DemandaXPeriodo> abrirPeriodoActualSiNoEstaFinalizado(List<DemandaXPeriodo> ventas) {
//        int indice = ventas.size() - 1;
//        DemandaXPeriodo demandete = ventas.get(indice);
        Date hoy= GestorFecha.getInstancia().getFechaHoy();
        int nroPeri = GestorFecha.getInstancia().aQuePeriodoCorrespondeLaFecha(hoy);

        for (DemandaXPeriodo demandaXPeriodo : ventas) {
            if (GestorFecha.getInstancia().isFechaDelPeriodo(GestorFecha.getInstancia().getFechaHoy(), demandaXPeriodo)) {
//                ventas.get(indice).setCerrado(false);
//                ventasDelMesAbierto = ventas.get(indice).getVentas();
//                fechaCierre = ventas.get(indice).getFechaFin();
                demandaXPeriodo.setCerrado(false);
                ventasDelMesAbierto = demandaXPeriodo.getVentas();
    //            fechaCierre = demandaXPeriodo.getFechaFin();

            }else if(demandaXPeriodo.getFechaInicio().compareTo(GestorFecha.getInstancia().getFechaHoy())>0){
                demandaXPeriodo.setCerrado(false);

   //            fechaCierre = GestorFecha.getInstancia().calcularLimiteSuperiorDelPeriodo(nroPeri, hoy);

            }
        }

        fechaCierre = GestorFecha.getInstancia().calcularLimiteSuperiorDelPeriodo(nroPeri, hoy);

        return ventas;
    }

    public int calcularAcumulado(List<DemandaXPeriodo> ventas) {
        int resul = 0;
        for (DemandaXPeriodo demandaXPeriodo : ventas) {
            if (demandaXPeriodo.isCerrado()) {
                resul += demandaXPeriodo.getVentas();
            }
        }
        return resul;
    }

    private  void mostrarTodasLasVentasPorPeriodo(List<DemandaXPeriodo> demandas) {
        String estado;
        if (demandas != null) {
            for (DemandaXPeriodo demandaXPeriodo : demandas) {
                if (demandaXPeriodo.isCerrado()) {
                    estado = "Cerrado";
                } else {
                    estado = "Abierto";
                }

                System.out.println("\n--------------------------------------------------------------");
                System.out.println("\n NRO PERIODO: " + demandaXPeriodo.getNroPeriodo());
                System.out.println("\n Fecha Inicio: " + demandaXPeriodo.getFechaInicio());
                System.out.println("\n Fecha Fin: " + demandaXPeriodo.getFechaFin());
                System.out.println("\n Total venta del Periodo: " + demandaXPeriodo.getVentas());
                System.out.println("\n Prediccion del Periodo: " + demandaXPeriodo.getPrediccionVenta());
                System.out.println("\n Estado : " + estado);

            }
        } else {
            System.out.println("\n No se registraron ventas del producto seleccionado\n");
        }
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("\n Ventas del periodo abierto: " + ventasDelMesAbierto);
        System.out.println("\n--------------------------------------------------------------");

    }

    public  void mostrarTodasLasVentasPorPeriodoCerrados(ProductoComponente producto) {

        List<DemandaXPeriodo> demandas = calcularDemandaXPeriodo(producto);
        GestorFecha gf = GestorFecha.getInstancia();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("PRODUCTO: "+producto.getNombre());
        System.out.println("-----------------------------------------------------------------");
        if (demandas != null) {
            for (DemandaXPeriodo demandaXPeriodo : demandas) {
                if (demandaXPeriodo.isCerrado()) {
                    System.out.println("\n--------------------------------------------------------------");
                    System.out.println("\n NRO PERIODO: " + demandaXPeriodo.getNroPeriodo());
                    System.out.println("\n Fecha Inicio: " + gf.formatearFecha(demandaXPeriodo.getFechaInicio())+ "   Fecha Fin: "+gf.formatearFecha(demandaXPeriodo.getFechaFin()));
                    System.out.println("\n Total venta del Periodo: " + demandaXPeriodo.getVentas());
                }
            }
        }else{
            System.out.println("EL PRODUCTO NO REGISTRA VENTAS");
        }

    }

    private int truncar(double valor) {
        int resul;
        resul = Math.round((float) valor);
        return resul;
    }

    private boolean estaCerradoElPeriodo(DemandaXPeriodo venta) {
        if (venta.isCerrado()) {
            return true;
        } else {
            return false;
        }
    }

    private DemandaXPeriodo cerrarPeriodo(DemandaXPeriodo venta) {
        venta.setCerrado(true);
        return venta;
    }

    private void validarPeriodoNulos(List<DemandaXPeriodo> demandas) {
        int resul = 0;

        for (DemandaXPeriodo demandaXPeriodo : demandas) {
            if (demandaXPeriodo.getVentas() == 0 && demandaXPeriodo.isCerrado()) {
                ++resul;
            }

        }

        if (resul > 0) {
            JOptionPane.showMessageDialog(null, "Existen periodos cerrados en los que no se han registrado ventas");
        }

    }

    private DefaultTableModel convertirListATableModel(List<DemandaXPeriodo> ventas) {
        DefaultTableModel tabla = new DefaultTableModel();
        int indice = 0;
        tabla.setRowCount(13);
        tabla.setColumnCount(calcularCantAniosDeVentas(ventas) + 1); // es mas 1 xq le sume la columna donde figura los nombres de los periodos

        abrirPeriodoActualSiNoEstaFinalizado(ventas);
        int cantPeriDeVentas = calcularCantidadPeriodosCerrados(ventas);
        //int nroPrimerPeriodoVentas = ventas.get(0).getNroPeriodo()-1;

        System.out.println("cant periodos cerrados:" +cantPeriDeVentas);
        for (int j = 1; j < tabla.getColumnCount(); j++) {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (indice < cantPeriDeVentas){ //&&  i==nroPrimerPeriodoVentas) {
                    tabla.setValueAt(ventas.get(indice).getVentas(), i, j);
                    ++indice;
//                    if(nroPrimerPeriodoVentas <=12){
//                        ++nroPrimerPeriodoVentas;
//                    }else{
//                        nroPrimerPeriodoVentas=0;
//                    }
                    //nroPrimerPeriodoVentas=i+1;
                } else {
                    tabla.setValueAt(0, i, j);
                }
           
            }
        }

        return tabla;
    }

    private void mostrarTableModel(DefaultTableModel tabla) {
        System.out.println("\n -------------------------------------------------");
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {

                System.out.print("   " + tabla.getValueAt(i, j));
            }
            System.out.println("\n");
        }
        System.out.println("\n -------------------------------------------------");
    }

    public int getVentasPeriodoAbierto() {
        return ventasDelMesAbierto;
    }

    public double[] getIndicesEstacionalidad() {
        return indices;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public List<DemandaXPeriodo> calcularPrediccionDemandaXPeriodo(ProductoComponente producto) {

        List<DemandaXPeriodo> demandas = calcularDemandaXPeriodo(producto);
        List<DemandaXPeriodo> temporal = new ArrayList<DemandaXPeriodo>();
        int valor;

        //variables q tiene q venir como parametros
        double alfa = 0.4;
        double gamma = 0.2;
        double beta = 0.2;


        if (producto == null || producto.getTipoPrediccion().equalsIgnoreCase(" ")) {
            System.out.println("\n\n\n Debe seleccionar un producto y/o el producto seleccionado debe tener un tipo de prediccion asociado \n\n\n");
        } else {
            if (demandas.size() > 0) {

                demandas.get(0).setPrediccionVenta(demandas.get(0).getVentas());
                temporal.add(demandas.get(0));

                if (producto.getTipoPrediccion().equalsIgnoreCase("SE Simple")) {

                    for (int i = 1; i < demandas.size(); i++) {

                        temporal.add(demandas.get(i));
                        demandas.get(i).setPrediccionVenta(calcularESNew(alfa, temporal));
                    }


                } else if (producto.getTipoPrediccion().equalsIgnoreCase("SE Estacionalidad")) { //Aca deberia haber otro codigo y mas ifs por cada tipo de prediccion o un switch
                    List<Integer> resultado;
                    for (int i = 1; i < demandas.size(); i++) {

                        temporal.add(demandas.get(i));
                        resultado = calcularDemandaConEstacionalidad(alfa, gamma, temporal);

                        if(resultado.size()>0){
                            demandas.get(i).setPrediccionVenta(resultado.get(0));
                        }else{
                            demandas.get(i).setPrediccionVenta(0);
                        }


                    }

                } else if (producto.getTipoPrediccion().equalsIgnoreCase("SE Tendencia")) { //Aca deberia haber otro codigo y mas ifs por cada tipo de prediccion o un switch

                    for (int i = 1; i < demandas.size(); i++) {

                        temporal.add(demandas.get(i));
                        demandas.get(i).setPrediccionVenta(truncar(calcularDemandaConTendenciaNew(temporal, alfa, beta)));
                    }
                }

            } else {
                System.out.println("\n\n\n No se han registrado ventas del producto seleccionado \n\n\n");
            }


            //mostrarXPantalla(demandas);

        }

        return demandas;
    }

     private void mostrarDetallesVentas(List<DetalleOrdenProduccion> detalles) {

         System.out.println("\n\n ---------------------------------------------------");
         System.out.println("VENTAS PRODUCTO: "+ detalles.get(0).getProducto().getNombre()+"\n");
         for (DetalleOrdenProduccion detalle : detalles) {
             System.out.println("Fecha: "+GestorFecha.getInstancia().formatearFecha(detalle.getVenta().getFecha())+"      Cantidad: "+ detalle.getVenta().getDetallesOrdenProduccion().get(0).getCantidad());
         }
         System.out.println("\n\n ---------------------------------------------------");
     }

     private int calcularCantidadPeriodosCerrados(List<DemandaXPeriodo> periodos) {
         int resul=0;
         for (DemandaXPeriodo demandaXPeriodo : periodos) {
             if(demandaXPeriodo.isCerrado()){
                 ++resul;
             }
         }
         return resul;
     }

    /**
     * @return the tendencia
     */
    public double getTendencia() {
        return tendencia;
    }

 
}
