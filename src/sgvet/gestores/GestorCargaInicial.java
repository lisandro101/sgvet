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
        prov = new Proveedor();   //Recordar siempre hacer el new para que genere un nuevo UID!
        prov.setNombre("Eukanuba");
        prov.setBorrado(false);
        prov.setCodigo("44-444-44-44");
        prov.setDireccion("San Martin 456 - Godoy Cruz");
        prov.setFechaInicioActividad(new Date());
        prov.setMail("euka@gmail.com");
        prov.setNombreContacto("Claudio Perez");
        prov.setTelefono("4222222");
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
        prod.setCodigo("44-444-44-44");
        prod.setCondicionesEmbalaje("");
        prod.setCostoAlmacenamiento(10);
        prod.setCostoPedido(10);
        prod.setCostoUnitario(10);
        prod.setDemandaAnual(1000);
        prod.setDescripcion("");
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
