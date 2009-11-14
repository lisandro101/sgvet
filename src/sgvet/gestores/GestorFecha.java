/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sgvet.entidades.auxiliares.DemandaXPeriodo;

/**
 *
 * @author Seba
 */
public class GestorFecha {

    private Date fechaHoy;
    private static GestorFecha instancia;

    public synchronized static GestorFecha getInstancia() {
        if (instancia == null) {
            instancia = new GestorFecha();
        }
        return instancia;
    }

    public Date getFechaHoy() {
        if (fechaHoy == null) {
            fechaHoy = new Date();
        }
        return fechaHoy;
    }

    /**
     * @param fecha
     */
    public void setFechaHoy(Date fecha) {
        fechaHoy = fecha;

    }

    /**
     * Devuelve el año de un Date.
     * @param fecha
     * @return año
     */
    public int getAnio(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.YEAR);
    }

    /**
     * Devuelve el mes de un Date.
     * @param fecha
     * @return mes
     */
    public int getMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * Devuelve un Date creado a partir del dia, mes y anio pasados como
     * parametros.
     * @param dia
     * @param mes
     * @param anio
     * @return
     */
    public Date getFecha(int dia, int mes, int anio) {
        Calendar cal = Calendar.getInstance();
        cal.set(anio, mes, dia);
        return cal.getTime();
    }

    /**
     * Devuelve un Date creado a partir del dia y mes pasados como parametros
     * y supone que el anio es el actual.
     * @param dia
     * @param mes
     * @return
     */
    public Date getFecha(int dia, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int anio = cal.get(Calendar.YEAR);
        cal.set(anio, mes, dia);
        return cal.getTime();
    }

    /**
     * Devuelve un Date creado a partir del dia pasado como parametro y supone
     * el mes y el anio son los actuales.
     * @param dia
     * @return
     */
    public Date getFecha(int dia) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int mes = cal.get(Calendar.MONTH);
        int anio = cal.get(Calendar.YEAR);
        cal.set(anio, mes, dia);
        return cal.getTime();
    }

    @Deprecated
    public Date primerDia(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
        return cal.getTime();
    }

    @Deprecated
    public Date ultimoDia(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 28);
        return cal.getTime();
    }

    public boolean diaValidoDelMes(Date fecha) {
        boolean resul = false;
        if (fecha.compareTo(primerDia(fecha)) >= 0 && fecha.compareTo(ultimoDia(fecha)) <= 0) {
            resul = true;
        }
        return resul;
    }

    public boolean sonDelMismoMes(Date fechaA, Date fechaB) {
        boolean resul = false;
        if (fechaA.compareTo(primerDia(fechaB)) >= 0 && fechaA.compareTo(ultimoDia(fechaB)) <= 0) {
            resul = true;
        }
        return resul;
    }

    public List<DemandaXPeriodo> getPeriodosDelAnio(Date anio) {
        List<DemandaXPeriodo> periodos = new ArrayList<DemandaXPeriodo>(13);
        DemandaXPeriodo ventaMensual;

        for (int i = 1; i <= 13; i++) { // arma la List de los 13 periodos en que dividimos el año
            ventaMensual = new DemandaXPeriodo();
            ventaMensual.setAnio(anio);
            ventaMensual.setNroPeriodo(i);
            ventaMensual.setFechaInicio(calcularLimiteInferiorDelPeriodo(i, anio));
            ventaMensual.setFechaFin(calcularLimiteSuperiorDelPeriodo(i, anio));
//            ventaMensual.setCerrado(false);
            periodos.add(ventaMensual);
        }

        return periodos;
    }

    public Date calcularLimiteInferiorDelPeriodo(int nroPeriodo, Date anio) {
        Date fecha;
        fecha = primerDiaDelAnio(anio);

        switch (nroPeriodo) {
            case 1:
                break;
            case 2:
                fecha = sumarDiasALaFecha(fecha, 28);
                break;
            case 3:
                fecha = sumarDiasALaFecha(fecha, 56);
                break;
            case 4:
                fecha = sumarDiasALaFecha(fecha, 84);
                break;
            case 5:
                fecha = sumarDiasALaFecha(fecha, 112);
                break;
            case 6:
                fecha = sumarDiasALaFecha(fecha, 140);
                break;
            case 7:
                fecha = sumarDiasALaFecha(fecha, 168);
                break;
            case 8:
                fecha = sumarDiasALaFecha(fecha, 196);
                break;
            case 9:
                fecha = sumarDiasALaFecha(fecha, 224);
                break;
            case 10:
                fecha = sumarDiasALaFecha(fecha, 252);
                break;
            case 11:
                fecha = sumarDiasALaFecha(fecha, 280);
                break;
            case 12:
                fecha = sumarDiasALaFecha(fecha, 308);
                break;
            case 13:
                fecha = sumarDiasALaFecha(fecha, 336);
                break;
            default:
                System.out.println("\n\n\n El valor de periodo no esta entre 1 y 13 \n\n\n");
        }

        return fecha;
    }

    public Date calcularLimiteSuperiorDelPeriodo(int nroPeriodo, Date anio) {
        Date fecha;
        fecha = ultimoDiaDelPrimerMesDelAnio(anio);

        switch (nroPeriodo) {
            case 1:
                break;
            case 2:
                fecha = sumarDiasALaFecha(fecha, 28);
                break;
            case 3:
                fecha = sumarDiasALaFecha(fecha, 56);
                break;
            case 4:
                fecha = sumarDiasALaFecha(fecha, 84);
                break;
            case 5:
                fecha = sumarDiasALaFecha(fecha, 112);
                break;
            case 6:
                fecha = sumarDiasALaFecha(fecha, 140);
                break;
            case 7:
                fecha = sumarDiasALaFecha(fecha, 168);
                break;
            case 8:
                fecha = sumarDiasALaFecha(fecha, 196);
                break;
            case 9:
                fecha = sumarDiasALaFecha(fecha, 224);
                break;
            case 10:
                fecha = sumarDiasALaFecha(fecha, 252);
                break;
            case 11:
                fecha = sumarDiasALaFecha(fecha, 280);
                break;
            case 12:
                fecha = sumarDiasALaFecha(fecha, 308);
                break;
            case 13:
                fecha = sumarDiasALaFecha(fecha, 336);
                break;
            default:
                System.out.println("\n\n\n El valor de periodo no esta entre 1 y 13 \n\n\n");
        }

        return fecha;
    }

    public Date sumarDiasALaFecha(Date fecha, int cantDias) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DAY_OF_YEAR, cantDias);
        
        return cal.getTime();

    }

    public Date primerDiaDelAnio(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1);
        return cal.getTime();
    }

    public Date ultimoDiaDelPrimerMesDelAnio(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 28);
        return cal.getTime();
    }

    /**
     * Devuelve true si la fecha pertenece al periodo enviados por parametro
     * @param fecha
     * @param periodo nro del periodo
     * @return
     */
    public boolean isFechaDelPeriodo(Date fecha, DemandaXPeriodo periodo) {
        if (fecha.compareTo(periodo.getFechaInicio()) >= 0 && fecha.compareTo(periodo.getFechaFin()) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve true si la fecha pertenece al año enviado como parametro
     * @param fecha
     * @param anio
     * @return
     */
    public boolean isFechaDelAnio(Date fecha, Date anio) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(anio);
        cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1);
        Date primerDiaAnio = cal.getTime();
        cal.set(cal.get(Calendar.YEAR) + 1, Calendar.JANUARY, 1);
        Date primerDiaAnioSiguiente = cal.getTime();

        if (fecha.compareTo(primerDiaAnio) >= 0 && fecha.compareTo(primerDiaAnioSiguiente) < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve el entero correspondiente al nro de periodo al que pertenece la fecha (nro entre 1 y 13)
     * @param fecha
     * @return
     */
    public int aQuePeriodoCorrespondeLaFecha(Date fecha) {
        int resul = 1;
        List<DemandaXPeriodo> anio = getPeriodosDelAnio(fecha);

        for (DemandaXPeriodo demanda : anio) {
            if (isFechaDelPeriodo(fecha, demanda)) {
                resul = demanda.getNroPeriodo();
            }
        }
        return resul;
    }

    /**
     * Le da a la fecha enviada por parametro el formato dd/MM/yyyy (Ej 23/06/2009)
     * @param fecha
     * @return
     */
    public String formatearFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }
}
