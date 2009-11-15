/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sgvet.entidades.Politica;
import static org.junit.Assert.*;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Venta;

/**
 *
 * @author Seba
 */
public class GestorRevisionContinuaTest {

    Politica poli;
    ProductoComponente prod;
    
    public GestorRevisionContinuaTest() {
        poli = new Politica();
        poli.setCostoEmision(10);
        poli.setDesviacionEstandarDemanda(2);
        poli.setNivelServicio(95);
        poli.setTasaAnualAlmacenamiento(3);
        poli.setTiempoEntrega(5);
        poli.setTipoPolitica(Politica.TipoPolitica.CONTINUA);

        prod = new ProductoComponente();
        prod.setBorrado(false);
        prod.setCategoria(null);
        prod.setCostoAlmacenamiento(2);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(200);
        prod.setFechaUltimaRevision(new Date());
        prod.setPolitica(poli);
        prod.setPrecioVenta(17);
        prod.setStock(30);
        prod.setStockReserva(15);


    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstancia method, of class GestorRevisionContinua.
     */
    @Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        GestorRevisionContinua expResult = null;
        GestorRevisionContinua result = GestorRevisionContinua.getInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarGestorRevisionContinua method, of class GestorRevisionContinua.
     */
    @Test
    public void testCargarGestorRevisionContinua() {
        System.out.println("cargarGestorRevisionContinua");
        ProductoComponente prod = null;
        GestorRevisionContinua instance = null;
        instance.cargarGestorRevisionContinua(prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntoDePedido method, of class GestorRevisionContinua.
     */
    @Test
    public void testGetPuntoDePedido() {
        System.out.println("getPuntoDePedido");
        GestorRevisionContinua instance = null;
        double expResult = 0.0;
        double result = instance.getPuntoDePedido();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPedidosRevisionContinua method, of class GestorRevisionContinua.
     */
    @Test
    public void testGetPedidosRevisionContinua() {
        System.out.println("getPedidosRevisionContinua");
        Venta venta = null;
        GestorRevisionContinua instance = null;
        List expResult = null;
        List result = instance.getPedidosRevisionContinua(venta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStockDisponible method, of class GestorRevisionContinua.
     */
    @Test
    public void testGetStockDisponible() {
        System.out.println("getStockDisponible");
        GestorRevisionContinua instance = null;
        double expResult = 0.0;
        double result = prod.getStock()+12;
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}