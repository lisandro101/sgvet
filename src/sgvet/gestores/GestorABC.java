package sgvet.gestores;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Configuracion;
import sgvet.entidades.auxiliares.ItemABC;
import sgvet.entidades.ProductoComponente;
import sgvet.igu.PanelConfiguracion;
import sgvet.igu.PanelCurvaABC;
import sgvet.persistencia.FachadaPersistencia;

public class GestorABC implements IObservadorFecha {

    private static GestorABC instance;
    private static GestorConfiguracion gc;
    private double demandaAnualTotal;
    private double demandaValorizadaTotal;
    private int cantidadProductos;
    private int cantidadProductosA;
    private int cantidadProductosB;
    private int cantidadProductosC;
    private double demanda80;
    private double demanda90;

    public synchronized static GestorABC getInstancia() {
        if (instance == null) {
            instance = new GestorABC();
            gc = GestorConfiguracion.getInstancia();
        }
        return instance;
    }

    /**
     * @return the demandaAnualTotal
     */
    public double getDemandaAnualTotal() {
        return demandaAnualTotal;
    }

    /**
     * @return the demandaValorizadaTotal
     */
    public double getDemandaValorizadaTotal() {
        return demandaValorizadaTotal;
    }

    /**
     * @return the cantidadProductos
     */
    public int getCantidadProductos() {
        return cantidadProductos;
    }

    /**
     * @return the cantidadProductosA
     */
    public int getCantidadProductosA() {
        return cantidadProductosA;
    }

    /**
     * @return the cantidadProductosB
     */
    public int getCantidadProductosB() {
        return cantidadProductosB;
    }

    /**
     * @return the cantidadProductosC
     */
    public int getCantidadProductosC() {
        return cantidadProductosC;
    }

    /**
     * @return the demanda80
     */
    public double getDemanda80() {
        return demanda80;
    }

    /**
     * @return the demanda90
     */
    public double getDemanda90() {
        return demanda90;
    }

    private GestorABC() {
    }

    public List<ItemABC> calcularCurvaABC() {

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a " +
                "FROM ProductoComponente a " +
                "WHERE a.borrado = false");
        List<ProductoComponente> productos =
                FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, consulta);

        List<ItemABC> itemsABC = new ArrayList<ItemABC>();

        for (ProductoComponente producto : productos) {
            itemsABC.add(new ItemABC(producto, producto.getDemandaAnual() * producto.getPrecioVenta()));
        }

        List<ItemABC> curvaABC = new ArrayList<ItemABC>();
        int cantElem = itemsABC.size();
        ItemABC itemMayor = null;

        for (int i = 0; i < cantElem; i++) {

            itemMayor = itemsABC.get(0);
            for (ItemABC item : itemsABC) {
                if (itemMayor.getDemandaValorizada() <= item.getDemandaValorizada()) {
                    itemMayor = item;
                }

            }
            curvaABC.add(itemMayor);
            itemsABC.remove(itemMayor);

        }

        double demandaAcumulada = 0;

        for (ItemABC itemABC : curvaABC) {
            demandaAcumulada += itemABC.getDemandaValorizada();
            itemABC.setDemandaAcumulada(demandaAcumulada);
        }

        double demandaClaseA = 0.8 * demandaAcumulada;
        double demandaClaseB = 0.9 * demandaAcumulada;
        List<ProductoComponente> productosActualizados = new ArrayList<ProductoComponente>();

        for (ItemABC itemABC : curvaABC) {
            if (itemABC.getDemandaAcumulada() <= demandaClaseA) {
                itemABC.getProducto().setCategoria(GestorConfiguracion.getInstancia().getClaseDemanda(1));
                productosActualizados.add(itemABC.getProducto());
            } else if (itemABC.getDemandaAcumulada() <= demandaClaseB) {
                itemABC.getProducto().setCategoria(GestorConfiguracion.getInstancia().getClaseDemanda(2));
                productosActualizados.add(itemABC.getProducto());
            } else {
                itemABC.getProducto().setCategoria(GestorConfiguracion.getInstancia().getClaseDemanda(3));
                productosActualizados.add(itemABC.getProducto());
            }
        }

        persistir(productosActualizados);

        return curvaABC;
    }

    public List<ItemABC> buscarCurvaABC(String categoria) {

        List<ProductoComponente> productos;

        demandaAnualTotal = 0;
        demandaValorizadaTotal = 0;
        cantidadProductos = 0;
        cantidadProductosA = 0;
        cantidadProductosB = 0;
        cantidadProductosC = 0;
        demanda80 = 0;
        demanda90 = 0;

        if (categoria.equals("Todas")) {
            Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                    "SELECT a " +
                    "FROM ProductoComponente a " +
                    "WHERE a.borrado = false");
            productos = FachadaPersistencia.getInstancia().buscar(
                    ProductoComponente.class, consulta);
        } else {
            Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                    "SELECT a " +
                    "FROM ProductoComponente a " +
                    "WHERE a.borrado = false " +
                    "AND a.categoria = :categoria");
            consulta.setParameter("categoria", gc.getClaseDemanda(categoria));
            productos = FachadaPersistencia.getInstancia().buscar(
                    ProductoComponente.class, consulta);
        }


        List<ItemABC> itemsABC = new ArrayList<ItemABC>();

        for (ProductoComponente producto : productos) {
            itemsABC.add(new ItemABC(producto, producto.getDemandaAnual() * producto.getPrecioVenta()));
            cantidadProductos++;
        }

        List<ItemABC> curvaABC = new ArrayList<ItemABC>();
        int cantElem = itemsABC.size();
        ItemABC itemMayor = null;

        for (int i = 0; i < cantElem; i++) {

            itemMayor = itemsABC.get(0);
            for (ItemABC item : itemsABC) {
                if (itemMayor.getDemandaValorizada() <= item.getDemandaValorizada()) {
                    itemMayor = item;
                }

            }

            curvaABC.add(itemMayor);
            itemsABC.remove(itemMayor);
            demandaAnualTotal += itemMayor.getProducto().getDemandaAnual();
            demandaValorizadaTotal += itemMayor.getDemandaValorizada();
        }

        double demandaAcumulada = 0;

        for (ItemABC itemABC : curvaABC) {

            demandaAcumulada += itemABC.getDemandaValorizada();
            itemABC.setDemandaAcumulada(demandaAcumulada);

            if (itemABC.getProducto().getCategoria().toString() != null) {

                if (itemABC.getProducto().getCategoria().toString().equals("Clase A")) {
                    cantidadProductosA++;
                } else if (itemABC.getProducto().getCategoria().toString().equals("Clase B")) {
                    cantidadProductosB++;
                } else {
                    cantidadProductosC++;
                }

            }
        }

        demanda80 = 0.8 * demandaAcumulada;
        demanda90 = 0.9 * demandaAcumulada;

        return curvaABC;
    }

    public void persistir(List<ProductoComponente> prods) {

        FachadaPersistencia.getInstancia().comenzarTransaccion();

        for (ProductoComponente prod : prods) {
            FachadaPersistencia.getInstancia().actualizar(prod, false);
        }

        FachadaPersistencia.getInstancia().finalizarTransaccion();
    }

    @Override
    public void actualizar(Frame panel) {

        Date fecha;
        List<Configuracion> conf = null;
        GestorFecha gf = GestorFecha.getInstancia();
        Calendar cal = Calendar.getInstance();

        conf = FachadaPersistencia.getInstancia().buscar(Configuracion.class, "SELECT a FROM Configuracion a");

        if (conf.size() > 0) {

            fecha = conf.get(0).getUltimaABC();
            cal.setTime(fecha);
            cal.add(Calendar.YEAR, 1);
            fecha = cal.getTime();

            if (gf.getFechaHoy().compareTo(fecha) >= 0) {
                conf.get(0).setUltimaABC(gf.getFechaHoy());
                FachadaPersistencia.getInstancia().actualizar(conf.get(0), true);

                PanelCurvaABC panelABC = new PanelCurvaABC(panel);
                panelABC.setTitle("Ajuste Automatico de Clasificacion ABC");
                panelABC.setVisible(true);
            }
        }
    }
}
