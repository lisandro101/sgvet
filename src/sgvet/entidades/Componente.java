package sgvet.entidades;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import sgvet.persistencia.IPersistente;

/**
 * Contiene los datos de un componente genérico (puede ser una materia prima
 * o un producto)
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 * @version 1.0
 */
@Entity
@Table(name="componentes")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.CHAR)
@DiscriminatorValue("X")
public class Componente implements Serializable, IPersistente {
    private static final long serialVersionUID = 1L;
    private static final List<String> CAMPOS_UNICOS = Arrays.asList(
            "nombre", "codigo");
    
    private String id;
    private String codigo;
    private String nombre;
    private String unidadMedida;
    private List<Proveedor> proveedores;
    private boolean borrado;
    private char tipo;
    private double stock;
    private double stockReserva;
    private double costoAlmacenamiento;
    private double costoPedido;
    private double costoUnitario;
    private double tamanioLoteEstandar;
    private double precioBase;
    private double pesoUnidad;
    private String descripcion;
    private double demandaAnual;

    /**
     * Constructor
     */
    public Componente() {
        setId(UUID.randomUUID().toString());
    }

    public Componente(String cod, String nom, String uni, List<Proveedor> prov, double dem) {
        setId(UUID.randomUUID().toString());
        borrado = false;
        codigo = cod;
        nombre = nom;
        unidadMedida = uni;
        proveedores = prov;
        demandaAnual = dem;
    }
    
    /**
     * Devuelve el identificador único de la clase
     * 
     * @return El identificador único de la clase
     */
    @Id
    @Column(name="id", length=36)
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único de la clase
     * 
     * @param id Nuevo valor del identificador único de la clase
     */
    public void setId(String id) {
        this.id = id;
    }

    @Column(name="codigo", length=20)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Column(name="nombre", length=100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @ManyToMany(targetEntity=Proveedor.class, cascade=CascadeType.ALL)
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    @Column(name="borrado")
    public boolean isBorrado() {
        return borrado;
    }

    @Override
    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @Column(name="tipo")
    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    @Override
    @Transient
    public List<String> getCamposUnicos() {
        return CAMPOS_UNICOS;
    }

    @Column(name="unidad_medida", length=20)
    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Componente other = (Componente) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Column(name="stock")
    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
    
    @Column(name="stock_reserva")
    public double getStockReserva() {
        return stockReserva;
    }

    public void setStockReserva(double stockReserva) {
        this.stockReserva = stockReserva;
    }

    /**
     * @return the costoAlmacenamiento
     */
    @Column(name = "costo_almacenamiento")
    public double getCostoAlmacenamiento() {
        return costoAlmacenamiento;
    }

    /**
     * @param costoAlmacenamiento the costoAlmacenamiento to set
     */
    public void setCostoAlmacenamiento(double costoAlmacenamiento) {
        this.costoAlmacenamiento = costoAlmacenamiento;
    }

    /**
     * @return the costoEmision
     */
    @Column(name="costo_pedido")
    public double getCostoPedido() {
        return costoPedido;
    }

    /**
     * @param costoEmision the costoEmision to set
     */
    public void setCostoPedido(double costoPedido) {
        this.costoPedido = costoPedido;
    }

    /**
     * @return the costoUnitarioOmision
     */
    @Column(name="costo_unitario")
    public double getCostoUnitario() {
        return costoUnitario;
    }

    /**
     * @param costoUnitarioOmision the costoUnitarioOmision to set
     */
    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    /**
     * @return the tamanioLoteEstandar
     */
    @Column(name="tamanio_lote_estandar")
    public double getTamanioLoteEstandar() {
        return tamanioLoteEstandar;
    }

    /**
     * @param tamanioLoteEstandar the tamanioLoteEstandar to set
     */
    public void setTamanioLoteEstandar(double tamanioLoteEstandar) {
        this.tamanioLoteEstandar = tamanioLoteEstandar;
    }

    /**
     * @return the precioBase
     */
    @Column(name="precio_base")
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * @param precioBase the precioBase to set
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * @return the pesoUnidad
     */
    @Column(name="peso_unidad")
    public double getPesoUnidad() {
        return pesoUnidad;
    }

    /**
     * @param pesoUnidad the pesoUnidad to set
     */
    public void setPesoUnidad(double pesoUnidad) {
        this.pesoUnidad = pesoUnidad;
    }

    /**
     * @return the descripcion
     */
    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the demandaAnual
     */
    @Column(name="demanda_anual")
    public double getDemandaAnual() {
        return demandaAnual;
    }

    /**
     * @param demandaAnual the demandaAnual to set
     */
    public void setDemandaAnual(double demandaAnual) {
        this.demandaAnual = demandaAnual;
    }
    
    
}