/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgvet.gestores;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Proveedor;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author Lisandro
 */
public class GestorCargaInicial {
    public HashMap<String,Proveedor> cargarProveedores() {

        Proveedor prov;
        List<IPersistente> persistentes = new ArrayList();
        HashMap<String,Proveedor> proveedores = new HashMap<String, Proveedor>();

        
        /* -----  Repetir este codigo para crear proveedores a persistir  ---- */
        
        /* -----  Proveedor Dog Chow  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Dog Chow");
        prov.setBorrado(false);
        prov.setCodigo("3-1-44-11");
        prov.setDireccion("Luis Braille 456 -Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("Dog_Chow@gmail.com");
        prov.setNombreContacto("David Godoy");
        prov.setTelefono("4459532");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
        /* -----  Proveedor Top Nutrition  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Top Nutrition");
        prov.setBorrado(false);
        prov.setCodigo("3-2-44-22");
        prov.setDireccion("Alberdi 345 -Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("TopNu_Mza@gmail.com");
        prov.setNombreContacto("Mariano Lopez");
        prov.setTelefono("4296758");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
        /* -----  Proveedor Vital Can  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Vital Can");
        prov.setBorrado(false);
        prov.setCodigo("3-3-44-33");
        prov.setDireccion("Vicente Zapata 212 -Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("Vital_Can@gmail.com");
        prov.setNombreContacto("Alberto Martinez");
        prov.setTelefono("4296048");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Eukanuba");
        prov.setBorrado(false);
        prov.setCodigo("3-4-44-44");
        prov.setDireccion("San Martin 456 - Godoy Cruz");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("euka@gmail.com");
        prov.setNombreContacto("Claudio Perez");
        prov.setTelefono("4222222");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
        /* -----  Proveedor Royal  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Royal");
        prov.setBorrado(false);
        prov.setCodigo("3-5-44-55");
        prov.setDireccion("Jorge a calle 618-Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("Royal@gmail.com");
        prov.setNombreContacto("Eduardo Jofre");
        prov.setTelefono("4217623");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
 /* -----  Proveedor EXACT  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("EXACT");
        prov.setBorrado(false);
        prov.setCodigo("3-6-44-66");
        prov.setDireccion("Italia 618-Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("EXACT@gmail.com");
        prov.setNombreContacto("Carlos Dente");
        prov.setTelefono("4287623");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
        /* -----  Proveedor Kongo  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Kongo");
        prov.setBorrado(false);
        prov.setCodigo("3-7-44-77");
        prov.setDireccion("Junin 618-Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("Kongo@gmail.com");
        prov.setNombreContacto("Victor Pellero");
        prov.setTelefono("4497345");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
        /* -----  Proveedor Purina  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Purina");
        prov.setBorrado(false);
        prov.setCodigo("3-8-44-88");
        prov.setDireccion("Lavalle 234 -Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("Purina@gmail.com");
        prov.setNombreContacto("Juan Valles");
        prov.setTelefono("4459302");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */
        /* -----  Proveedor Dog Selection  ---- */
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Dog Selection");
        prov.setBorrado(false);
        prov.setCodigo("3-9-44-99");
        prov.setDireccion("Mexico 234 -Mendoza");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("Dog Selection@gmail.com");
        prov.setNombreContacto("Jesus Kiko");
        prov.setTelefono("4463895");
        persistentes.add(prov);
        proveedores.put(prov.getNombre(), prov);
        /* ------------------------------------------------------------------- */

        /* Llama al método que persiste la lista de proveedores */
        persistir(persistentes);

        //Devuelve una hash de proveedores para utilizarla a la hora de crear los productos
        return proveedores;
    }

    public void cargarProductos(HashMap<String,Proveedor> proveedores) {

        ProductoComponente prod;
        List<Proveedor> prov;
        List<IPersistente> persistentes = new ArrayList();

        /* -----  Repetir este codigo para crear proveedores a persistir  ---- */
        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Dog Chow 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg Dog Chow");
        prod.setEstado("Activo");
        prod.setNumeroPlano("");
        prod.setPesoUnidad(10);
        prod.setPoliticaCompra("");
        prod.setPrecioBase(10);
        prod.setPrecioVenta(100);
        prod.setStock(10);
        prod.setStockReserva(5);
        prod.setTamanioLoteEstandar(5);
        prod.setTipoPrediccion("SE Simple");
        prod.setUnidadMedida("unid");
        
        prov = new ArrayList<Proveedor>();
        prov.add(proveedores.get("Dog Chow")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        /* ------------------------------------------------------------------- */
/* -----  Producto Alimento 15Kg  ---- */
        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Dog Chow 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg Dog Chow");
        prod.setEstado("Activo");
        prod.setNumeroPlano("");
        prod.setPesoUnidad(10);
        prod.setPoliticaCompra("");
        prod.setPrecioBase(10);
        prod.setPrecioVenta(100);
        prod.setStock(10);
        prod.setStockReserva(5);
        prod.setTamanioLoteEstandar(5);
        prod.setTipoPrediccion("SE Simple");
        prod.setUnidadMedida("unid");

        prov = new ArrayList<Proveedor>();
        prov.add(proveedores.get("Dog Chow")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        /* ------------------------------------------------------------------- */
/* -----  Producto Alimento 30Kg  ---- */
        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Dog Chow 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg Dog Chow");
        prod.setEstado("Activo");
        prod.setNumeroPlano("");
        prod.setPesoUnidad(10);
        prod.setPoliticaCompra("");
        prod.setPrecioBase(10);
        prod.setPrecioVenta(100);
        prod.setStock(10);
        prod.setStockReserva(5);
        prod.setTamanioLoteEstandar(5);
        prod.setTipoPrediccion("SE Simple");
        prod.setUnidadMedida("unid");

        prov = new ArrayList<Proveedor>();
        prov.add(proveedores.get("Dog Chow")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        /* ------------------------------------------------------------------- */

/* -----  Producto Vitamina Complejo  ---- */
        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Dog Chow Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm Dog Chow");
        prod.setEstado("Activo");
        prod.setNumeroPlano("");
        prod.setPesoUnidad(10);
        prod.setPoliticaCompra("");
        prod.setPrecioBase(10);
        prod.setPrecioVenta(100);
        prod.setStock(10);
        prod.setStockReserva(5);
        prod.setTamanioLoteEstandar(5);
        prod.setTipoPrediccion("SE Simple");
        prod.setUnidadMedida("unid");

        prov = new ArrayList<Proveedor>();
        prov.add(proveedores.get("Dog Chow")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        /* ------------------------------------------------------------------- */


        /* Llama al método que persiste la lista de proveedores */
        persistir(persistentes);
    }

    public void persistir(List<IPersistente> objetos) {
        FachadaPersistencia.getInstancia().comenzarTransaccion();

        for (IPersistente objeto : objetos) {
            FachadaPersistencia.getInstancia().grabar(objeto, false);
        }

        FachadaPersistencia.getInstancia().finalizarTransaccion();
    }
}
