/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgvet.gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import sgvet.entidades.ClaseDemanda;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Proveedor;
import sgvet.entidades.Venta;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.persistencia.IPersistente;

/**
 *
 * @author Lisandro
 */
public class GestorCargaInicial {

    private static GestorCargaInicial instance;
    //private HashMap<String, ProductoComponente> productos;

    public synchronized static GestorCargaInicial getInstancia() {
        if (instance == null) {
            instance = new GestorCargaInicial();
        }
        return instance;
    }

    public void cargarTodo() {

        System.out.println("Realizando Carga Inicial....");

        cargarVentas(cargarProductos(cargarProveedores()));
        cargarClasesDemanda();
        GestorABC.getInstancia().calcularCurvaABC();

        System.out.println("Finalizada Carga Inicial.");

    }

    public HashMap<String, Proveedor> cargarProveedores() {

        Proveedor prov;

        List<IPersistente> persistentes = new ArrayList<IPersistente>();
        HashMap<String, Proveedor> proveedores = new HashMap<String, Proveedor>();

        /* -----  Repetir este codigo para crear proveedores a persistir  ---- */

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

    public HashMap<String, ProductoComponente> cargarProductos(HashMap<String, Proveedor> proveedores) {

        ProductoComponente prod;
        List<Proveedor> prov;
        List<IPersistente> persistentes = new ArrayList<IPersistente>();

        HashMap<String, ProductoComponente> productos = new HashMap<String, ProductoComponente>();

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
        productos.put(prod.getNombre(), prod);


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
        productos.put(prod.getNombre(), prod);


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
        productos.put(prod.getNombre(), prod);


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
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Top Nutrition 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg Top Nutrition");
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
        prov.add(proveedores.get("Top Nutrition")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Top Nutrition 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg Top Nutrition");
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
        prov.add(proveedores.get("Top Nutrition")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Top Nutrition 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg Top Nutrition");
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
        prov.add(proveedores.get("Top Nutrition")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Top Nutrition Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm Top Nutrition");
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
        prov.add(proveedores.get("Top Nutrition")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Vital Can 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg Vital Can");
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
        prov.add(proveedores.get("Vital Can")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Vital Can 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg Vital Can");
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
        prov.add(proveedores.get("Vital Can")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Vital Can 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg Vital Can");
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
        prov.add(proveedores.get("Vital Can")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Vital Can Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm Vital Can");
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
        prov.add(proveedores.get("Vital Can")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Eukanuba 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg Eukanuba");
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
        prov.add(proveedores.get("Eukanuba")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Eukanuba 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg Eukanuba");
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
        prov.add(proveedores.get("Eukanuba")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Eukanuba 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg Eukanuba");
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
        prov.add(proveedores.get("Eukanuba")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Eukanuba Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm Eukanuba");
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
        prov.add(proveedores.get("Eukanuba")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Royal 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg Royal");
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
        prov.add(proveedores.get("Royal")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Royal 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg Royal");
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
        prov.add(proveedores.get("Royal")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Royal 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg Royal");
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
        prov.add(proveedores.get("Royal")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Royal Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm Royal");
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
        prov.add(proveedores.get("Royal")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("EXACT 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg EXACT");
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
        prov.add(proveedores.get("EXACT")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("EXACT 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg EXACT");
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
        prov.add(proveedores.get("EXACT")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("EXACT 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg EXACT");
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
        prov.add(proveedores.get("EXACT")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("EXACT Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm EXACT");
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
        prov.add(proveedores.get("EXACT")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("KONGO 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg KONGO");
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
        prov.add(proveedores.get("Kongo")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("KONGO 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg KONGO");
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
        prov.add(proveedores.get("Kongo")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("KONGO 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg KONGO");
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
        prov.add(proveedores.get("Kongo")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("KONGO Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm KONGO");
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
        prov.add(proveedores.get("Kongo")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("PURINA 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg PURINA1");
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
        prov.add(proveedores.get("Purina")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("PURINA 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg PURINA");
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
        prov.add(proveedores.get("Purina")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("PURINA 30Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("Una Bolsa de 30 kg PURINA");
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
        prov.add(proveedores.get("Purina")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("PURINA Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm PURINA");
        prod.setEstado("Activo");
        prod.setNumeroPlano("");
        prod.setPesoUnidad(10);
        prod.setPoliticaCompra("");
        prod.setPrecioBase(10);
        prod.setPrecioVenta(100);
        prod.setStock(10);
        prod.setStockReserva(5);
        prod.setTamanioLoteEstandar(5);
        prod.setTipoPrediccion("SE Tendencia");
        prod.setUnidadMedida("unid");

        prov = new ArrayList<Proveedor>();
        prov.add(proveedores.get("Purina")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Dog Selection 2Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-1-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("Una Bolsa de 2 kg PURINA1");
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
        prov.add(proveedores.get("Dog Selection")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("PURINA 15Kg");
        prod.setBorrado(false);
        prod.setCodigo("2-2-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(40);
        prod.setDemandaAnual(400);
        prod.setDescripcion("Una Bolsa de 15 kg PURINA");
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
        prov.add(proveedores.get("Dog Selection")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("Protect Garrapaticida aerosol");
        prod.setBorrado(false);
        prod.setCodigo("2-3-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(80);
        prod.setDemandaAnual(200);
        prod.setDescripcion("garrapaticida para perros");
        prod.setEstado("Activo");
        prod.setNumeroPlano("");
        prod.setPesoUnidad(10);
        prod.setPoliticaCompra("");
        prod.setPrecioBase(10);
        prod.setPrecioVenta(100);
        prod.setStock(10);
        prod.setStockReserva(5);
        prod.setTamanioLoteEstandar(5);
        prod.setTipoPrediccion("SE Estacionalidad");
        prod.setUnidadMedida("unid");

        prov = new ArrayList<Proveedor>();
        prov.add(proveedores.get("Dog Selection")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);


        prod = new ProductoComponente();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prod.setNombre("PURINA Vitamina 200gm");
        prod.setBorrado(false);
        prod.setCodigo("2-4-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(15);
        prod.setDemandaAnual(500);
        prod.setDescripcion("Complejo Vitaminico Polvo 200gm PURINA");
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
        prov.add(proveedores.get("Dog Selection")); //Se pueden ir agregando todos los proveedores que hagan falta segun el nombre con el que se cargaron
        prod.setProveedores(prov);

        persistentes.add(prod);
        productos.put(prod.getNombre(), prod);
        /* ------------------------------------------------------------------- */

        /* Llama al método que persiste la lista de proveedores */
        persistir(persistentes);
        return productos;
    }
    /*
     *## Lizandro tengo problema con el formato de fecha y las ralciones de EstadoOrdenCompra.##
     * y de paso anda revisando el codigo.
     * Gracias.
    public void CargarOrdenCompra(HashMap<String,OrdenCompra> OrdenCompra) {

    OrdenCompra OrdComp;
    List<OrdenCompra> OrdComp;
    List<IPersistente> persistentes = new ArrayList();

    //* -----  Repetir este codigo para crear OrdenCompra a persistir  ----

    OrdComp = new OrdenCompra();   //Recordar siempre hacer el new para que genere un nuevo UID!
    OrdComp.setId("1");
    Proveedor Prov = new Proveedor();
    OrdComp.setProveedor(Prov);
    //OrdComp.setFecha(25/09/2009);
    //OrdComp.setFechaEstimadaEntrega("30/09/2009");
    //OrdenCampra.setDetallesOrdenCompra.getId();
    OrdComp.setNroOrdenCompra(1);
    //EstadoOrdenCompra EstadoOrden=new EstadoOrdenCompra();
    OrdComp.setEstado(OrdenCompra.EstadoOrdenCompra.ANULADO);
    persistir(persistentes);
    }
     */

    /**
     * Persiste en la base de datos las clases de demanda
     */
    public void cargarClasesDemanda() {

        ClaseDemanda cd;
        List<IPersistente> persistentes = new ArrayList<IPersistente>();

        cd = new ClaseDemanda();
        cd.setClase("Clase A");
        cd.setNumeroClase(1);
        cd.setL(2);
        persistentes.add(cd);

        cd = new ClaseDemanda();
        cd.setClase("Clase B");
        cd.setNumeroClase(2);
        cd.setL(4.5);
        persistentes.add(cd);

        cd = new ClaseDemanda();
        cd.setClase("Clase C");
        cd.setNumeroClase(3);
        cd.setL(5);
        persistentes.add(cd);

        persistir(persistentes);
    }

    public void cargarVentas(HashMap<String, ProductoComponente> productos) {


//nombre de productos: "PURINA Vitamina 200gm" "Protect Garrapaticida aerosol"  "Vital Can Vitamina 200gm"
        List<IPersistente> persistentes = new ArrayList<IPersistente>();
        //HashMap<String, Venta> ventas = new HashMap<String, Venta>();

        Venta venta;
        List<DetalleOrdenProduccion> detalle;
        DetalleOrdenProduccion linea;


        //-------------------------------------------------------------------
        //-------Producto para el calculo de la prediccion exponencial simple
        //-------------------------------------------------------------------
        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2000);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 1, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(28);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);


        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2001);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 2, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(26);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);


        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2002);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 3, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(24);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);
        

        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2003);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 4, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(29);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);


        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2004);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 5, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(28);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);
        

        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2005);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 6, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(25);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);
        

        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2006);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 7, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(27);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);


        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2007);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 8, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(30);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);


        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2008);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 9, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(31);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        persistentes.add(venta);


        venta = new Venta();
        venta.setNombreCliente("Pablo Romero");
        venta.setNroOrdenProduccion(2009);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 10, 2009));
        venta.setBorrado(false);

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Vital Can Vitamina 200gm"));
        linea.setCantidad(27);
        linea.setBorrado(false);
        linea.setVenta(venta);

        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);


        //-------------------------------------------------------------------
        //-------Producto para el calculo de la prediccion con tendencia
        //-------------------------------------------------------------------
        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(995);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 1, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(26);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(996);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 2, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(25);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(997);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 3, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(25);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(998);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 4, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(28);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(999);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 5, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(27);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(1000);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 6, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(28);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(1001);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 7, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(27);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(1002);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 8, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(15);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------
        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(1003);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 8, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(15);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------
        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(1005);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 9, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(31);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------
        venta = new Venta();
        venta.setNombreCliente("Juan Perez");
        venta.setNroOrdenProduccion(1005);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 10, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("PURINA Vitamina 200gm"));
        linea.setCantidad(28);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------



        //-------------------------------------------------------------------
        //-------Producto para el calculo de la prediccion con estacionalidad
        //-------------------------------------------------------------------

//----------------------------------- AÑO 2006 -----------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3000);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 1, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(145);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3001);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 2, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(121);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3002);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 3, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(121);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3003);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 4, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(88);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3004);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 5, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(73);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3005);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 6, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(52);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3006);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 7, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(50);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);


        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3007);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 8, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(75);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3008);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 9, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(95);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3009);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 10, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(103);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3010);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 11, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(142);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3011);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 12, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(143);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3012);
        venta.setFecha(GestorFecha.getInstancia().getFecha(25, 12, 2006));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(154);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);


//----------------------------------- AÑO 2007 -----------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3013);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 1, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(138);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3014);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 2, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(126);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3015);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 3, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(105);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3016);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 4, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(86);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3017);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 5, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(76);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3018);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 6, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(49);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3019);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 7, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(52);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);


        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3020);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 8, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(69);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3021);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 9, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(94);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3022);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 10, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(117);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3023);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 11, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(133);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3024);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 12, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(137);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3025);
        venta.setFecha(GestorFecha.getInstancia().getFecha(25, 12, 2007));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(139);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);


//----------------------------------- AÑO 2008 -----------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3026);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 1, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(164);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3027);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 2, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(139);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3028);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 3, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(117);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3029);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 4, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(82);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3039);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 5, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(64);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3031);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 6, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(53);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3032);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 7, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(53);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);


        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3033);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 8, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(65);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3034);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 9, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(95);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3035);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 10, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(99);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3036);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 11, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(139);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3037);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 12, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(141);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3038);
        venta.setFecha(GestorFecha.getInstancia().getFecha(25, 12, 2008));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(147);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

//----------------------------------- AÑO 2009 -----------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3039);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 1, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(155);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);
        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3040);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 2, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(145);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3041);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 3, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(128);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3042);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 4, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(99);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3043);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 5, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(87);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3044);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 6, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(75);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3045);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 7, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(53);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);


        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3046);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 8, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(55);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3047);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 9, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(56);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------

        venta = new Venta();
        venta.setNombreCliente("Raul Castro");
        venta.setNroOrdenProduccion(3048);
        venta.setFecha(GestorFecha.getInstancia().getFecha(1, 10, 2009));

        linea = new DetalleOrdenProduccion();
        linea.setProducto(productos.get("Protect Garrapaticida aerosol"));
        linea.setCantidad(63);
        linea.setBorrado(false);
        linea.setVenta(venta);


        detalle = new ArrayList<DetalleOrdenProduccion>();
        detalle.add(linea);
        venta.setDetallesOrdenProduccion(detalle);

        venta.setBorrado(false);

        persistentes.add(venta);

        //---------------------------------------------------
        
        persistir(persistentes);
    }

    /**
     * Guarda en la base de datos una lista de objetos persistentes (cualquier
     * objeto que implemente la interfaz IPersistente).
     * @param objetos
     */
    public void persistir(List<IPersistente> objetos) {
        FachadaPersistencia.getInstancia().comenzarTransaccion();

        for (IPersistente objeto : objetos) {
            FachadaPersistencia.getInstancia().grabar(objeto, false);
        }

        FachadaPersistencia.getInstancia().finalizarTransaccion();
    }
}
