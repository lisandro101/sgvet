package sgvet.gestores;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import sgvet.entidades.Politica;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.auxiliares.DTOPedidos;
import sgvet.igu.PanelConfiguracion;
import sgvet.igu.PanelPedidosPeriodica;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author Luciano, Lisandro
 */
public class GestorRevisionPeriodica extends GestorStock implements IObservadorFecha {

    private static GestorRevisionPeriodica instancia;
    ProductoComponente producto;
    Politica politica;

    public synchronized static GestorRevisionPeriodica getInstancia() {
        if (instancia == null) {
            instancia = new GestorRevisionPeriodica();
        }
        return instancia;
    }

    private GestorRevisionPeriodica() {
    }

    /**
     * Carga el gestor con la informacion de la interfaz.
     *
     * @param prod
     */
    public void cargarGestorRevisionPeriodica(ProductoComponente prod) {

        politica = prod.getPolitica();
        producto = prod;

    }

    private double getStockDeSeguridad() {

        double stockSeguridad = 0;

        stockSeguridad = getDesviacionEstandarDemanda() * getFactorDeSeguridad(politica.getNivelServicio());

        return stockSeguridad;

    }

    private double getDesviacionEstandarDemanda() {

        double desviacion;
        double periodoRevision;

        periodoRevision = getPeriodoDeRevision();

        desviacion = politica.getTiempoEntrega() * periodoRevision / politica.getDesviacionEstandarDemanda();

        return desviacion;

    }

    /**
     * Devuelve el stock disponible. Si el perido de revision es mayor que cero lo utiliza pero si es menor lo calcula.
     * 
     * @return
     */
    public double getPuntoPedido() {

        double puntoPedido;
        double tiempoEntrega;
        double periodoRevision;

        tiempoEntrega = politica.getTiempoEntrega();
        periodoRevision = getPeriodoDeRevision();

        puntoPedido = getPrediccionDemanda(producto, tiempoEntrega + periodoRevision) + getStockDeSeguridad();

        return puntoPedido;

    }

    /**
     * Devuelve el stock disponible (S).
     *
     * @return
     */
    public double getStockDisponible() {

        double stockDisponible;

        stockDisponible = producto.getStock() + getStockPendiente(producto); //- stockComprometido

        return stockDisponible;

    }

    public int getPeriodoDeRevision() {

        int periodoDeRevision;

        periodoDeRevision = (int) (getQOptimo(producto) / producto.getDemandaAnual());

        return periodoDeRevision;

    }

    public double getCantidadAPedir() {
        double cantidad;

        cantidad = getPuntoPedido() - getStockDisponible();

        return cantidad;

    }

    @Override
    public void actualizar(Frame panel) {

        List<DTOPedidos> pedidos;
        pedidos = getPedidosRevisionPeriodica();
        realizarPedidos(pedidos);

    }

    /**
     *
     * @return
     */
    public List<DTOPedidos> getPedidosRevisionPeriodica() {

        List<DTOPedidos> pedidos = new ArrayList<DTOPedidos>();
        DTOPedidos pedido;
        List<ProductoComponente> productos;
        GestorFecha gf = GestorFecha.getInstancia();
        Date ultimaRevision;

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM ProductoComponente a WHERE a.borrado=false");

        productos = FachadaPersistencia.getInstancia().buscar(ProductoComponente.class, consulta);

        for (ProductoComponente prod : productos) {
            if (prod.getPolitica() != null) {
                if (prod.getPolitica().getTipoPolitica().equals(Politica.TipoPolitica.PERIODICA)) {
                    cargarGestorRevisionPeriodica(prod);

                    if (prod.getFechaUltimaRevision() == null) {
                        pedido = new DTOPedidos(producto, getCantidadAPedir());
                        pedidos.add(pedido);
                    } else {

                        ultimaRevision = gf.sumarDiasALaFecha(prod.getFechaUltimaRevision(), getPeriodoDeRevision());

                        if (gf.getFechaHoy().compareTo(ultimaRevision) >= 0) { /* Si fecha de hoy - fecha revision es >= R */
                            pedido = new DTOPedidos(producto, getCantidadAPedir());
                            pedidos.add(pedido);
                        }

                    }
                }
            }
        }

        return pedidos;

    }

    private void realizarPedidos(List<DTOPedidos> pedidos) {

        PanelPedidosPeriodica panel = new PanelPedidosPeriodica(pedidos);
        panel.setModal(true);
        panel.setVisible(true);

    }
}

