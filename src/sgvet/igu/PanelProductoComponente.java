package sgvet.igu;

import java.awt.Component;
import java.awt.Dialog;
import java.util.Arrays;
import java.util.List;
import javax.swing.ComboBoxModel;
import sgvet.igu.buscar.PanelBuscarProveedor;
import javax.swing.JOptionPane;
import sgvet.utils.Util;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorConfiguracion;
import sgvet.gestores.GestorValidacion;
import sgvet.igu.buscar.PanelBuscarProductoGral;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.igu.model.ProveedorTableModel;
import sgvet.igu.model.UnidadMedidaTableModel;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.IValidable;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelProductoComponente extends javax.swing.JPanel implements IValidable {

    private static final long serialVersionUID = 1L;
    private ProductoComponente producto;
    private List<Component> componentesObligatorios;
    private ProveedorTableModel tm;
    private ComboBoxModel tmUnidadMedida;

    /** Creates new form PanelProductoComponente */
    public PanelProductoComponente() {
        tmUnidadMedida = new UnidadMedidaTableModel();
        initComponents();
        inicializar();

    }

    private void inicializar() {
        tm = new ProveedorTableModel(0);
        tProveedor.setModel(tm);
        componentesObligatorios = Arrays.asList((Component) tfCodigo);
        btModificar.setEnabled(false);
        btEliminar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipoProd = new javax.swing.ButtonGroup();
        pBotones = new javax.swing.JPanel();
        btResumenVentas = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btDemanda = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btBuscar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        pCampos = new javax.swing.JPanel();
        pProductoTerminado2 = new javax.swing.JPanel();
        tfCostoUnitario = new javax.swing.JTextField();
        lbTamanioLoteEstandar = new javax.swing.JLabel();
        lbStock = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        lbCostoUnitario = new javax.swing.JLabel();
        lbCostoAlmacenamiento = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        tfCostoAlmacenamiento = new javax.swing.JTextField();
        tfStock = new javax.swing.JTextField();
        tfTamanioLoteEstandar = new javax.swing.JTextField();
        tfStockReserva = new javax.swing.JTextField();
        lbStockReserva = new javax.swing.JLabel();
        lbDemandaAnual = new javax.swing.JLabel();
        tfDemandaAnual = new javax.swing.JTextField();
        pProductoTerminado1 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        lbUnidadMedida = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox();
        cbCategoria = new javax.swing.JComboBox();
        cbUnidadMedida = new javax.swing.JComboBox();
        lbPrecioVenta = new javax.swing.JLabel();
        tfPrecioVenta = new javax.swing.JTextField();
        lbTipoPrediccion = new javax.swing.JLabel();
        cbTipoPrediccion = new javax.swing.JComboBox();
        pTablaProveedores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProveedor = new org.jdesktop.swingx.JXTable();
        jPanel2 = new javax.swing.JPanel();
        btAsignarProveedor = new javax.swing.JButton();
        btEliminarProv = new javax.swing.JButton();
        pBotones1 = new javax.swing.JPanel();
        btParametros = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbPolitica = new javax.swing.JComboBox();

        btResumenVentas.setText("Resumen Ventas");
        btResumenVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResumenVentasActionPerformed(evt);
            }
        });
        pBotones.add(btResumenVentas);
        pBotones.add(jSeparator3);

        btDemanda.setText("Demanda");
        btDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDemandaActionPerformed(evt);
            }
        });
        pBotones.add(btDemanda);
        pBotones.add(jSeparator2);
        pBotones.add(jSeparator1);

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        pBotones.add(btBuscar);

        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });
        pBotones.add(btAgregar);

        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        pBotones.add(btModificar);

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        pBotones.add(btEliminar);

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        pBotones.add(btLimpiar);

        lbTamanioLoteEstandar.setText("Tamaño Lote Estandar:");

        lbStock.setText("Stock:");

        lbCostoUnitario.setText("Costo Unitario:");

        lbCostoAlmacenamiento.setText("Costo Almacenamiento:");

        lbDescripcion.setText("Descripción:");

        lbStockReserva.setText("Stock reserva");

        lbDemandaAnual.setText("Demanda Anual:");

        javax.swing.GroupLayout pProductoTerminado2Layout = new javax.swing.GroupLayout(pProductoTerminado2);
        pProductoTerminado2.setLayout(pProductoTerminado2Layout);
        pProductoTerminado2Layout.setHorizontalGroup(
            pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminado2Layout.createSequentialGroup()
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCostoUnitario)
                    .addComponent(lbCostoAlmacenamiento)
                    .addComponent(lbTamanioLoteEstandar)
                    .addComponent(lbStock)
                    .addComponent(lbDescripcion)
                    .addComponent(lbStockReserva)
                    .addComponent(lbDemandaAnual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDemandaAnual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(tfCostoAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(tfCostoUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(tfTamanioLoteEstandar, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(tfStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(tfStockReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
        );
        pProductoTerminado2Layout.setVerticalGroup(
            pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminado2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCostoAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCostoAlmacenamiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCostoUnitario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTamanioLoteEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTamanioLoteEstandar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfStockReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStockReserva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDemandaAnual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDemandaAnual))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lbCodigo.setText("Código:");

        lbNombre.setText("Nombre:");

        lbCategoria.setText("Categoria:");

        lbEstado.setText("Estado:");

        lbUnidadMedida.setText("Unidad Medida:");

        tfCodigo.setEditable(false);

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Activo", "Suspendido", "Inactivo" }));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Clase A", "Clase B", "Clase C" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        cbUnidadMedida.setModel(tmUnidadMedida);
        cbUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadMedidaActionPerformed(evt);
            }
        });

        lbPrecioVenta.setText("Precio Venta:");

        lbTipoPrediccion.setText("Tipo Predicción:");
        lbTipoPrediccion.setName("tipoPrediccion"); // NOI18N

        cbTipoPrediccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "SE Simple", "SE Tendencia", "SE Estacionalidad" }));
        cbTipoPrediccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoPrediccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pProductoTerminado1Layout = new javax.swing.GroupLayout(pProductoTerminado1);
        pProductoTerminado1.setLayout(pProductoTerminado1Layout);
        pProductoTerminado1Layout.setHorizontalGroup(
            pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEstado)
                    .addComponent(lbCategoria)
                    .addComponent(lbNombre)
                    .addComponent(lbCodigo)
                    .addComponent(lbUnidadMedida)
                    .addComponent(lbTipoPrediccion)
                    .addComponent(lbPrecioVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPrecioVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 192, Short.MAX_VALUE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, 192, Short.MAX_VALUE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(cbUnidadMedida, javax.swing.GroupLayout.Alignment.TRAILING, 0, 192, Short.MAX_VALUE)
                    .addComponent(cbTipoPrediccion, javax.swing.GroupLayout.Alignment.TRAILING, 0, 192, Short.MAX_VALUE))
                .addContainerGap())
        );
        pProductoTerminado1Layout.setVerticalGroup(
            pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminado1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCategoria)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUnidadMedida)
                    .addComponent(cbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipoPrediccion)
                    .addComponent(cbTipoPrediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrecioVenta)
                    .addComponent(tfPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pCamposLayout = new javax.swing.GroupLayout(pCampos);
        pCampos.setLayout(pCamposLayout);
        pCamposLayout.setHorizontalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProductoTerminado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(pProductoTerminado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pCamposLayout.setVerticalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pProductoTerminado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pProductoTerminado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pTablaProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedores"));

        jScrollPane1.setViewportView(tProveedor);

        btAsignarProveedor.setText("Asignar Proveedor");
        btAsignarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAsignarProveedorActionPerformed(evt);
            }
        });
        jPanel2.add(btAsignarProveedor);

        btEliminarProv.setText("Eliminar");
        btEliminarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarProvActionPerformed(evt);
            }
        });
        jPanel2.add(btEliminarProv);

        javax.swing.GroupLayout pTablaProveedoresLayout = new javax.swing.GroupLayout(pTablaProveedores);
        pTablaProveedores.setLayout(pTablaProveedoresLayout);
        pTablaProveedoresLayout.setHorizontalGroup(
            pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
                .addContainerGap())
        );
        pTablaProveedoresLayout.setVerticalGroup(
            pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaProveedoresLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btParametros.setText("Definir");
        btParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParametrosActionPerformed(evt);
            }
        });

        jLabel7.setText("Politica de Stock:");

        cbPolitica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Politica (s,Q)", "Politica (S,R)" }));
        cbPolitica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPoliticaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pBotones1Layout = new javax.swing.GroupLayout(pBotones1);
        pBotones1.setLayout(pBotones1Layout);
        pBotones1Layout.setHorizontalGroup(
            pBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotones1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPolitica, 0, 450, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pBotones1Layout.setVerticalGroup(
            pBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotones1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pBotones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbPolitica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btParametros)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pTablaProveedores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                    .addComponent(pCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pTablaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed

    int opcion = JOptionPane.showConfirmDialog(this,
            "¿Seguro desea guardar los cambios?", "Aceptar",
            JOptionPane.YES_NO_OPTION);

    if (opcion == JOptionPane.YES_OPTION) {
        actualizarProductoComponente();
        FachadaPersistencia.getInstancia().actualizar(producto, true);
        limpiarPantalla();

    }
}//GEN-LAST:event_btModificarActionPerformed

private void btAsignarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAsignarProveedorActionPerformed
    PanelBuscarProveedor panelProv = new PanelBuscarProveedor(tm);
    panelProv.setModal(true);
    panelProv.setVisible(true);

}//GEN-LAST:event_btAsignarProveedorActionPerformed

private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
//    tfStock.setText("0");
    tfCodigo.setText(GestorValidacion.getInstancia().generarCodigoProducto());
    if (!Util.getInstancia().validar(this)) {
        JOptionPane.showMessageDialog(this, "Existen campos sin completar");
    } else {
        producto = crearProductoComponente();
        if (ValidacionBuscar.getInstancia().estaDuplicado(producto)) {
            JOptionPane.showMessageDialog(this, "El producto componente ya se encuentra registrado");
        } else {
            FachadaPersistencia.getInstancia().actualizar(producto, true);
            limpiarPantalla();
        }
    }

}//GEN-LAST:event_btAgregarActionPerformed

private void btEliminarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarProvActionPerformed
    int filaSeleccionada = tProveedor.convertRowIndexToModel(tProveedor.getSelectedRow());
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Proveedor");
    } else {
        tm.eliminarFila(filaSeleccionada);
        tm.imprimirModel();
    }
}//GEN-LAST:event_btEliminarProvActionPerformed

private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
    PanelBuscarProductoGral buscarProv = new PanelBuscarProductoGral(this);
    buscarProv.setModal(true);
    buscarProv.setVisible(true);
}//GEN-LAST:event_btBuscarActionPerformed

private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed

    int opcion = JOptionPane.showConfirmDialog(this,
            "¿Seguro desea eliminar el Producto Componente?", "Aceptar",
            JOptionPane.YES_NO_OPTION);

    if (opcion == JOptionPane.YES_OPTION) {
        producto.setBorrado(true);
        FachadaPersistencia.getInstancia().actualizar(producto, true);
        limpiarPantalla();

    }


}//GEN-LAST:event_btEliminarActionPerformed

private void cbUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadMedidaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbUnidadMedidaActionPerformed

private void cbTipoPrediccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPrediccionActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_cbTipoPrediccionActionPerformed

private void btDemandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDemandaActionPerformed
    String tipoDemanda = cbTipoPrediccion.getModel().getSelectedItem().toString();

    if (producto == null) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
    } else {
        if (tipoDemanda.equalsIgnoreCase("SE Simple")) {

//           PanelDemandaExpoSimple panel = new PanelDemandaExpoSimple(productoComponente);
            PanelDemandaSimple panel = new PanelDemandaSimple(producto);
            panel.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
            panel.setVisible(true);

        } else if (tipoDemanda.equalsIgnoreCase("SE Estacionalidad")) { //Aca deberia haber otro codigo y mas ifs por cada tipo de prediccion o un switch

            //PanelDemandaExpoConEsta panel = new PanelDemandaExpoConEsta(productoComponente);
            PanelDemandaConEstacionalidad panel = new PanelDemandaConEstacionalidad(producto);
            panel.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
            panel.setVisible(true);
        } else if (tipoDemanda.equalsIgnoreCase("SE Tendencia")) { //Aca deberia haber otro codigo y mas ifs por cada tipo de prediccion o un switch
            PanelDemandaConTendencia panel = new PanelDemandaConTendencia(producto);
            panel.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
            panel.setVisible(true);
        }

    }

}//GEN-LAST:event_btDemandaActionPerformed

private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_cbCategoriaActionPerformed

private void btResumenVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResumenVentasActionPerformed

    if (producto == null) {

        JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
    } else {
        PanelResumenVentas panel = new PanelResumenVentas(producto);
        panel.setVisible(true);
    }


}//GEN-LAST:event_btResumenVentasActionPerformed

private void btParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParametrosActionPerformed

    if (producto == null) {
        crearProductoComponente();
    }
    if (cbPolitica.getSelectedIndex() == 1) {
        PanelRevisionContinua revisionContinua = new PanelRevisionContinua(producto);
        revisionContinua.setModal(true);
        revisionContinua.setVisible(true);
    } else if (cbPolitica.getSelectedIndex() == 2) {
        PanelRevisionPeriodica revisionPeriodica = new PanelRevisionPeriodica(producto);
        revisionPeriodica.setModal(true);
        revisionPeriodica.setVisible(true);
    }
}//GEN-LAST:event_btParametrosActionPerformed

private void cbPoliticaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPoliticaItemStateChanged

    if (cbPolitica.getSelectedIndex() == 0) {
        btParametros.setVisible(false);
    } else {
        btParametros.setVisible(true);
    }
}//GEN-LAST:event_cbPoliticaItemStateChanged

private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
    limpiarPantalla();
}//GEN-LAST:event_btLimpiarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoProd;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btAsignarProveedor;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btDemanda;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEliminarProv;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btParametros;
    private javax.swing.JButton btResumenVentas;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbPolitica;
    private javax.swing.JComboBox cbTipoPrediccion;
    private javax.swing.JComboBox cbUnidadMedida;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCostoAlmacenamiento;
    private javax.swing.JLabel lbCostoUnitario;
    private javax.swing.JLabel lbDemandaAnual;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrecioVenta;
    private javax.swing.JLabel lbStock;
    private javax.swing.JLabel lbStockReserva;
    private javax.swing.JLabel lbTamanioLoteEstandar;
    private javax.swing.JLabel lbTipoPrediccion;
    private javax.swing.JLabel lbUnidadMedida;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pBotones1;
    private javax.swing.JPanel pCampos;
    private javax.swing.JPanel pProductoTerminado1;
    private javax.swing.JPanel pProductoTerminado2;
    private javax.swing.JPanel pTablaProveedores;
    private org.jdesktop.swingx.JXTable tProveedor;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCostoAlmacenamiento;
    private javax.swing.JTextField tfCostoUnitario;
    private javax.swing.JTextField tfDemandaAnual;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPrecioVenta;
    private javax.swing.JTextField tfStock;
    private javax.swing.JTextField tfStockReserva;
    private javax.swing.JTextField tfTamanioLoteEstandar;
    // End of variables declaration//GEN-END:variables

    private ProductoComponente crearProductoComponente() {

        producto = new ProductoComponente();

        producto.setCodigo(tfCodigo.getText());
        producto.setNombre(tfNombre.getText());
        producto.setCategoria(GestorConfiguracion.getInstancia().getClaseDemanda(
                cbCategoria.getSelectedItem().toString()));
        producto.setEstado(cbEstado.getSelectedItem().toString());
        producto.setUnidadMedida((String) cbUnidadMedida.getSelectedItem());
        producto.setCostoAlmacenamiento(Double.parseDouble(tfCostoAlmacenamiento.getText()));
        producto.setCostoUnitario(Double.parseDouble(tfCostoUnitario.getText()));
        producto.setTamanioLoteEstandar(Double.parseDouble(tfTamanioLoteEstandar.getText()));
        producto.setStock(Double.parseDouble(tfStock.getText()));
        producto.setDescripcion(tfDescripcion.getText());
        producto.setStockReserva(Double.parseDouble(tfStockReserva.getText()));
        producto.setDemandaAnual(Double.parseDouble(tfDemandaAnual.getText()));
        producto.setTipoPrediccion((String) cbTipoPrediccion.getSelectedItem());
        producto.setPrecioVenta(Double.parseDouble(tfPrecioVenta.getText()));

        producto.setProveedores(tm.getFilas());

        return producto;

    }

    public void setComponente(ProductoComponente prod) {
        limpiarPantalla();
        producto = prod;
        cargarPantallaProductoComponente(prod);

    }

    private void actualizarProductoComponente() {

        producto.setCodigo(tfCodigo.getText());
        producto.setNombre(tfNombre.getText());
        producto.setCategoria(GestorConfiguracion.getInstancia().getClaseDemanda(
                cbCategoria.getSelectedItem().toString()));
        producto.setEstado(cbEstado.getSelectedItem().toString());
        producto.setUnidadMedida((String) cbUnidadMedida.getSelectedItem());
        producto.setCostoAlmacenamiento(Double.parseDouble(tfCostoAlmacenamiento.getText()));
        producto.setCostoUnitario(Double.parseDouble(tfCostoUnitario.getText()));
        producto.setTamanioLoteEstandar(Double.parseDouble(tfTamanioLoteEstandar.getText()));
        producto.setStock(Double.parseDouble(tfStock.getText()));
        producto.setDescripcion(tfDescripcion.getText());
        producto.setStockReserva(Double.parseDouble(tfStockReserva.getText()));
        producto.setDemandaAnual(Double.parseDouble(tfDemandaAnual.getText()));
        producto.setTipoPrediccion((String) cbTipoPrediccion.getSelectedItem());
        producto.setPrecioVenta(Double.parseDouble(tfPrecioVenta.getText()));

        producto.setProveedores(tm.getFilas());

    }

    private void cargarPantallaProductoComponente(ProductoComponente prod) {

        tfCodigo.setText(prod.getCodigo());
        tfNombre.setText(prod.getNombre());
        cbCategoria.setSelectedItem(prod.getCategoria().toString());
        cbEstado.setSelectedItem(prod.getEstado());
        cbUnidadMedida.setSelectedItem(prod.getUnidadMedida());
        tfCostoAlmacenamiento.setText(String.valueOf(prod.getCostoAlmacenamiento()));
        tfCostoUnitario.setText(String.valueOf(prod.getCostoUnitario()));
        tfTamanioLoteEstandar.setText(String.valueOf(prod.getTamanioLoteEstandar()));
        tfStock.setText(String.valueOf(prod.getStock()));
        tfDescripcion.setText(prod.getDescripcion());
        tfStockReserva.setText(String.valueOf(prod.getStockReserva()));
        tfDemandaAnual.setText(String.valueOf(prod.getDemandaAnual()));
        cbTipoPrediccion.setSelectedItem(prod.getTipoPrediccion());
        tfPrecioVenta.setText(String.valueOf(prod.getPrecioVenta()));

        for (int i = 0; i < prod.getProveedores().size(); i++) {
            tm.agregarFila(prod.getProveedores().get(i));
        }

        pantallaCargadaBotones();

    }

    private void inicializarBotones() {
        btAgregar.setEnabled(true);
        btEliminar.setEnabled(false);
        btModificar.setEnabled(false);
        btParametros.setVisible(false);
    }

    private void pantallaCargadaBotones() {
        btAgregar.setEnabled(false);
        btModificar.setEnabled(true);
        btEliminar.setEnabled(true);
        tfStock.setEnabled(false);
    }

    @Override
    public List<Component> getComponentesObligatorios() {
        return componentesObligatorios;
    }

    public ProductoComponente getProductoComponente() {
        return producto;
    }

    private void limpiarPantalla() {
        Util.getInstancia().limpiarCampos(this);
        tfStock.setEnabled(true);
        producto = null;
        inicializarBotones();
    }
}
