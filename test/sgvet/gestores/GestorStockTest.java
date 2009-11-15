/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sgvet.entidades.ProductoComponente;

/**
 *
 * @author Seba
 */
public class GestorStockTest {

    public GestorStockTest() {
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
     * Test of getStockPendiente method, of class GestorStock.
     */
    @Test
    public void testGetStockPendiente() {
        System.out.println("getStockPendiente");
        ProductoComponente prod = null;
        GestorStock instance = new GestorStockImpl();
        double expResult = 0.0;
        double result = instance.getStockPendiente(prod);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFactorDeSeguridad method, of class GestorStock.
     */
    @Test
    public void testGetFactorDeSeguridad() {
        System.out.println("getFactorDeSeguridad");
        double nivelServicio = 0.0;
        GestorStock instance = new GestorStockImpl();
        double expResult = 0.0;
        double result = instance.getFactorDeSeguridad(nivelServicio);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrediccionDemanda method, of class GestorStock.
     */
    @Test
    public void testGetPrediccionDemanda() {
        System.out.println("getPrediccionDemanda");
        ProductoComponente prod = null;
        double tiempoEntrega = 0.0;
        GestorStock instance = new GestorStockImpl();
        double expResult = 0.0;
        double result = instance.getPrediccionDemanda(prod, tiempoEntrega);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQOptimo method, of class GestorStock.
     */
    @Test
    public void testGetQOptimo() {
        System.out.println("getQOptimo");
        ProductoComponente producto = null;
        GestorStock instance = new GestorStockImpl();
        double expResult = 0.0;
        double result = instance.getQOptimo(producto);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCostoAnualAlmacenamiento method, of class GestorStock.
     */
    @Test
    public void testGetCostoAnualAlmacenamiento() {
        System.out.println("getCostoAnualAlmacenamiento");
        ProductoComponente producto = null;
        GestorStock instance = new GestorStockImpl();
        double expResult = 0.0;
        double result = instance.getCostoAnualAlmacenamiento(producto);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GestorStockImpl extends GestorStock {
    }

}