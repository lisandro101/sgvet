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
import sgvet.gestores.GestorDemanda;
import sgvet.igu.buscar.PanelBuscarProductoGral;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.igu.model.ProveedorTableModel;
import sgvet.igu.model.UnidadMedidaTableModel;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.IValidable;
import sgvet.utils.ValidarCodigo;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelProductoComponente extends javax.swing.JPanel implements IValidable {

    private static final long serialVersionUID = 1L;
    
    private ProductoComponente productoComponente;
    private List<Component> componentesObligatorios;
    
    private ProveedorTableModel tm;
    private ComboBoxModel tmUnidadMedida;
    /** Creates new form PanelProductoComponente */
    public PanelProductoComponente() {
        tmUnidadMedida=  new UnidadMedidaTableModel();
        initComponents();
        inicializar();
        inicializarBotones();
    }

    private void inicializar() {
        tm = new ProveedorTableModel(0);
        tProveedor.setModel(tm);
        componentesObligatorios = Arrays.asList((Component)tfCodigo);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipoProd = new javax.swing.ButtonGroup();
        pBotones = new javax.swing.JPanel();
        btResumenVentas = new javax.swing.JButton();
        btDemanda = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btTest = new javax.swing.JButton();
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

        btResumenVentas.setText("Resumen Ventas");
        btResumenVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResumenVentasActionPerformed(evt);
            }
        });
        pBotones.add(btResumenVentas);

        btDemanda.setText("Demanda");
        btDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDemandaActionPerformed(evt);
            }
        });
        pBotones.add(btDemanda);

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

        btTest.setText("Test");
        btTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTestActionPerformed(evt);
            }
        });
        pBotones.add(btTest);

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
                    .addComponent(tfDemandaAnual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(tfCostoAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(tfCostoUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(tfTamanioLoteEstandar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(tfStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(tfStockReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
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
                .addContainerGap(22, Short.MAX_VALUE))
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
                    .addComponent(tfPrecioVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, 186, Short.MAX_VALUE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, 186, Short.MAX_VALUE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(cbUnidadMedida, javax.swing.GroupLayout.Alignment.TRAILING, 0, 186, Short.MAX_VALUE)
                    .addComponent(cbTipoPrediccion, javax.swing.GroupLayout.Alignment.TRAILING, 0, 186, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pCamposLayout = new javax.swing.GroupLayout(pCampos);
        pCampos.setLayout(pCamposLayout);
        pCamposLayout.setHorizontalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProductoTerminado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(pProductoTerminado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        pCamposLayout.setVerticalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pProductoTerminado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE))
                .addContainerGap())
        );
        pTablaProveedoresLayout.setVerticalGroup(
            pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaProveedoresLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pCampos, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pTablaProveedores, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        
    if(opcion == JOptionPane.YES_OPTION) {
        actualizarProductoComponente();
        FachadaPersistencia.getInstancia().actualizar(productoComponente, true);
        Util.getInstancia().limpiarCampos(this);
        productoComponente=null;            
        inicializarBotones();
    }
}//GEN-LAST:event_btModificarActionPerformed

private void btAsignarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAsignarProveedorActionPerformed
    PanelBuscarProveedor panelProv =new PanelBuscarProveedor(tm);
    panelProv.setModal(true);
    panelProv.setVisible(true);
    
}//GEN-LAST:event_btAsignarProveedorActionPerformed

private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
    tfStock.setText("0");
    if(!Util.getInstancia().validar(this)){
        JOptionPane.showMessageDialog(this, "Existen campos sin completar");
    }else{
        productoComponente= crearProductoComponente();
        if(ValidacionBuscar.getInstancia().estaDuplicado(productoComponente)){
            JOptionPane.showMessageDialog(this, "El producto componente ya se encuentra registrado");
        }else{
            FachadaPersistencia.getInstancia().actualizar(productoComponente, true);
            Util.getInstancia().limpiarCampos(this);
            
            productoComponente=null;
        }
    }
    
}//GEN-LAST:event_btAgregarActionPerformed

private void btEliminarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarProvActionPerformed
        int filaSeleccionada = tProveedor.convertRowIndexToModel(tProveedor.getSelectedRow());
    if(filaSeleccionada == -1){
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Proveedor");
    }else{
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

    if(opcion == JOptionPane.YES_OPTION) {
        productoComponente.setBorrado(true);
        FachadaPersistencia.getInstancia().actualizar(productoComponente, true);
        Util.getInstancia().limpiarCampos(this);
        productoComponente=null;
        inicializarBotones();
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

   if(productoComponente == null){
       JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
   }else{
       if (tipoDemanda.equalsIgnoreCase("SE Simple")) {

//           PanelDemandaExpoSimple panel = new PanelDemandaExpoSimple(productoComponente);
           PanelDemandaSimple panel = new PanelDemandaSimple(productoComponente);
           panel.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
           panel.setVisible(true);

       }
       else if(tipoDemanda.equalsIgnoreCase("SE Estacionalidad")){ //Aca deberia haber otro codigo y mas ifs por cada tipo de prediccion o un switch
           
           //PanelDemandaExpoConEsta panel = new PanelDemandaExpoConEsta(productoComponente);
           PanelDemandaConEstacionalidad panel = new PanelDemandaConEstacionalidad(productoComponente);
           panel.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
           panel.setVisible(true);
       }
       else if(tipoDemanda.equalsIgnoreCase("SE Tendencia")){ //Aca deberia haber otro codigo y mas ifs por cada tipo de prediccion o un switch
           PanelDemandaConTendencia panel = new PanelDemandaConTendencia(productoComponente);
           panel.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
           panel.setVisible(true);
       }

   }
   
}//GEN-LAST:event_btDemandaActionPerformed

private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_cbCategoriaActionPerformed

private void btTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestActionPerformed
    GestorDemanda.getInstancia().calcularPrediccionDemandaXPeriodo(productoComponente);
}//GEN-LAST:event_btTestActionPerformed

private void btResumenVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResumenVentasActionPerformed

    if (productoComponente == null) {

        JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
    } else {
        PanelResumenVentas panel = new PanelResumenVentas(productoComponente);
        panel.setVisible(true);
    }


}//GEN-LAST:event_btResumenVentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoProd;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btAsignarProveedor;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btDemanda;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEliminarProv;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btResumenVentas;
    private javax.swing.JButton btTest;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbTipoPrediccion;
    private javax.swing.JComboBox cbUnidadMedida;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
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
        productoComponente = new ProductoComponente();
        
        productoComponente.setCodigo(tfCodigo.getText());
        productoComponente.setNombre(tfNombre.getText());
        productoComponente.setCategoria(GestorConfiguracion.getInstancia().getClaseDemanda(cbCategoria.getSelectedItem().toString()));
        productoComponente.setEstado(cbEstado.getSelectedItem().toString());
//        productoComponente.setNumeroPlano(tfNroPlano.getText());
//        productoComponente.setPrecioBase(Double.parseDouble(tfPrecioBase.getText()));
//        productoComponente.setPesoUnidad(Double.parseDouble(tfPesoUnidad.getText()));
        productoComponente.setUnidadMedida((String) cbUnidadMedida.getSelectedItem());
        productoComponente.setCostoAlmacenamiento(Double.parseDouble(tfCostoAlmacenamiento.getText()));
//        productoComponente.setCostoPedido(Double.parseDouble(tfCostoPedido.getText()));
        productoComponente.setCostoUnitario(Double.parseDouble(tfCostoUnitario.getText()));
        productoComponente.setTamanioLoteEstandar(Double.parseDouble(tfTamanioLoteEstandar.getText()));
//        productoComponente.setCondicionesEmbalaje(tfCondEmbalaje.getText());
        productoComponente.setStock(Double.parseDouble(tfStock.getText()));
        productoComponente.setDescripcion(tfDescripcion.getText());
        productoComponente.setStockReserva(Double.parseDouble(tfStockReserva.getText()));
        productoComponente.setDemandaAnual(Double.parseDouble(tfDemandaAnual.getText()));
        productoComponente.setTipoPrediccion((String) cbTipoPrediccion.getSelectedItem());
        productoComponente.setPrecioVenta(Double.parseDouble(tfPrecioVenta.getText()));
        
        productoComponente.setProveedores(tm.getFilas());
        
        return productoComponente;
    }
    
    public void setComponente(ProductoComponente prod){
        productoComponente = prod;
        cargarPantallaProductoComponente(prod);
        
    }
    
    
    
    private void actualizarProductoComponente(){
        
        productoComponente.setCodigo(tfCodigo.getText());
        productoComponente.setNombre(tfNombre.getText());
        productoComponente.setCategoria(GestorConfiguracion.getInstancia().getClaseDemanda(cbCategoria.getSelectedItem().toString()));
        productoComponente.setEstado(cbEstado.getSelectedItem().toString());
//        productoComponente.setNumeroPlano(tfNroPlano.getText());
//        productoComponente.setPrecioBase(Double.parseDouble(tfPrecioBase.getText()));
//        productoComponente.setPesoUnidad(Double.parseDouble(tfPesoUnidad.getText()));
        productoComponente.setUnidadMedida((String) cbUnidadMedida.getSelectedItem());
        productoComponente.setCostoAlmacenamiento(Double.parseDouble(tfCostoAlmacenamiento.getText()));
//        productoComponente.setCostoPedido(Double.parseDouble(tfCostoPedido.getText()));
        productoComponente.setCostoUnitario(Double.parseDouble(tfCostoUnitario.getText()));
        productoComponente.setTamanioLoteEstandar(Double.parseDouble(tfTamanioLoteEstandar.getText()));
//        productoComponente.setCondicionesEmbalaje(tfCondEmbalaje.getText());
        productoComponente.setStock(Double.parseDouble(tfStock.getText()));
        productoComponente.setDescripcion(tfDescripcion.getText());
        productoComponente.setStockReserva(Double.parseDouble(tfStockReserva.getText()));
        productoComponente.setDemandaAnual(Double.parseDouble(tfDemandaAnual.getText()));
        productoComponente.setTipoPrediccion((String) cbTipoPrediccion.getSelectedItem());
        productoComponente.setPrecioVenta(Double.parseDouble(tfPrecioVenta.getText()));
        
        productoComponente.setProveedores(tm.getFilas());
        
    }
    
    
    private void cargarPantallaProductoComponente(ProductoComponente prod){
        Util.getInstancia().limpiarCampos(this);
        tfCodigo.setText(prod.getCodigo());
        tfNombre.setText(prod.getNombre());
        cbCategoria.setSelectedItem(prod.getCategoria().toString());
        cbEstado.setSelectedItem(prod.getEstado());
//        tfNroPlano.setText(prod.getNumeroPlano());
//        tfPrecioBase.setText(String.valueOf(prod.getPrecioBase()));
//        tfPesoUnidad.setText(String.valueOf(prod.getPesoUnidad()));
        cbUnidadMedida.setSelectedItem(prod.getUnidadMedida());
        tfCostoAlmacenamiento.setText(String.valueOf(prod.getCostoAlmacenamiento()));
//        tfCostoPedido.setText(String.valueOf(prod.getCostoPedido()));
        tfCostoUnitario.setText(String.valueOf(prod.getCostoUnitario()));
        tfTamanioLoteEstandar.setText(String.valueOf(prod.getTamanioLoteEstandar()));
//        tfCondEmbalaje.setText(prod.getCondicionesEmbalaje());
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
    private void inicializarBotones(){
        btAgregar.setEnabled(true);
        btEliminar.setEnabled(false);
        btModificar.setEnabled(false);
    }
    
    private void pantallaCargadaBotones(){
        btAgregar.setEnabled(false);
        btModificar.setEnabled(true);
        btEliminar.setEnabled(true);
    }
    
    @Override
    public List<Component> getComponentesObligatorios() {
        return componentesObligatorios;
    }

    public ProductoComponente getProductoComponente() {
        return productoComponente;
    }
    
}
