/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sgvet.entidades.Politica;
import static org.junit.Assert.*;
import sgvet.entidades.ProductoComponente;

/**
 *
 * @author Seba
 */
public class GestorRevisionPeriodicaTest {

    Politica poli;
    public GestorRevisionPeriodicaTest() {
        poli = new Politica();
        poli.setCostoEmision(10);
        poli.setDesviacionEstandarDemanda(2);
        poli.setNivelServicio(95);
        poli.setTasaAnualAlmacenamiento(3);
        poli.setTiempoEntrega(5);
        poli.setTipoPolitica(Politica.TipoPolitica.PERIODICA);
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
     * Test of getInstancia method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        GestorRevisionPeriodica expResult = null;
        GestorRevisionPeriodica result = GestorRevisionPeriodica.getInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarGestorRevisionPeriodica method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testCargarGestorRevisionPeriodica() {
        System.out.println("cargarGestorRevisionPeriodica");
        ProductoComponente prod = null;
        GestorRevisionPeriodica instance = null;
        instance.cargarGestorRevisionPeriodica(prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntoPedido method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testGetPuntoPedido() {
        System.out.println("getPuntoPedido");
        GestorRevisionPeriodica instance = null;
        double expResult = 0.0;
        double result = instance.getPuntoPedido();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStockDisponible method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testGetStockDisponible() {
        System.out.println("getStockDisponible");
        GestorRevisionPeriodica instance = null;
        double expResult = 0.0;
        double result = instance.getStockDisponible();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeriodoDeRevision method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testGetPeriodoDeRevision() {
        System.out.println("getPeriodoDeRevision");
        GestorRevisionPeriodica instance = null;
        int expResult = 0;
        int result = instance.getPeriodoDeRevision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadAPedir method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testGetCantidadAPedir() {
        System.out.println("getCantidadAPedir");
        GestorRevisionPeriodica instance = null;
        double expResult = 0.0;
        double result = instance.getCantidadAPedir();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        GestorRevisionPeriodica instance = null;
//        instance.actualizar();
        // TODO revisar linea superior comentada.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPedidosRevisionPeriodica method, of class GestorRevisionPeriodica.
     */
    @Test
    public void testGetPedidosRevisionPeriodica() {
        System.out.println("getPedidosRevisionPeriodica");
        GestorRevisionPeriodica instance = null;
        List expResult = null;
        List result = instance.getPedidosRevisionPeriodica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}