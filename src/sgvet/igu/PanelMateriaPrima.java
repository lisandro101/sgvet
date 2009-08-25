package sgvet.igu;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.ComboBoxModel;
import sgvet.igu.buscar.PanelBuscarProveedor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sgvet.utils.Util;
import sgvet.entidades.MateriaPrima;
import sgvet.entidades.MateriaPrima.Estado;
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
public class PanelMateriaPrima extends javax.swing.JPanel implements IValidable {
    private static final long serialVersionUID = 1L;
    
    private ProveedorTableModel tm;
    private MateriaPrima materiaPrima;
    private List<Component> componentesObligatorios;
    private ComboBoxModel tmUnidadMedida;
    
    /** Creates new form PanelMateriaPrima */
    public PanelMateriaPrima() {
        tmUnidadMedida=  new UnidadMedidaTableModel();
        initComponents();
        inicializar();
        inicializarBotones();
        
    }

    private void inicializar() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel(Estado.values());
        cbEstado.setModel(dcm);   

        tm = new ProveedorTableModel(0);
        tProveedor.setModel(tm);
        componentesObligatorios = Arrays.asList((Component)tfCodigo);
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCampos = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbCostoAlmacenamiento = new javax.swing.JLabel();
        lbCostoUnitario = new javax.swing.JLabel();
        lbPesoPorUnid = new javax.swing.JLabel();
        lbPrecioBase = new javax.swing.JLabel();
        lbTamanioLoteEstandar = new javax.swing.JLabel();
        lbUnidadMedida = new javax.swing.JLabel();
        tfTamanioLoteEstandar = new javax.swing.JTextField();
        tfPrecioBase = new javax.swing.JTextField();
        tfCostoAlmacenamiento = new javax.swing.JTextField();
        tfCostoUnitario = new javax.swing.JTextField();
        tfPesoPorUnidad = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        lbDescripcion = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        lbEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        cbUnidadMedida = new javax.swing.JComboBox();
        tfStock = new javax.swing.JTextField();
        lbStock = new javax.swing.JLabel();
        lbStockReserva = new javax.swing.JLabel();
        tfStockReserva = new javax.swing.JTextField();
        lbCostoPedido = new javax.swing.JLabel();
        tfCostoPedido = new javax.swing.JTextField();
        lbDemandaAnual = new javax.swing.JLabel();
        tfDemandaAnual = new javax.swing.JTextField();
        pBotones = new javax.swing.JPanel();
        btBuscar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        pTablaProveedores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProveedor = new org.jdesktop.swingx.JXTable();
        jPanel1 = new javax.swing.JPanel();
        btAsignarProveedor = new javax.swing.JButton();
        btEliminarProveedor = new javax.swing.JButton();

        lbCodigo.setText("Código:");

        lbNombre.setText("Nombre:");

        lbCostoAlmacenamiento.setText("Costo Almacenamiento:");

        lbCostoUnitario.setText("Costo Unitario:");

        lbPesoPorUnid.setText("Peso por Unidad:");

        lbPrecioBase.setText("Precio Base:");

        lbTamanioLoteEstandar.setText("Tamaño Lote Estandar:");

        lbUnidadMedida.setText("Unidad medida:");

        tfCostoAlmacenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCostoAlmacenamientoActionPerformed(evt);
            }
        });

        tfCodigo.setInputVerifier(new ValidarCodigo(1));

        lbDescripcion.setText("Descripción:");

        lbEstado.setText("Estado:");

        cbUnidadMedida.setModel(tmUnidadMedida);
        cbUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadMedidaActionPerformed(evt);
            }
        });

        tfStock.setEditable(false);
        tfStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStockActionPerformed(evt);
            }
        });

        lbStock.setText("Stock");

        lbStockReserva.setText("Stock reserva");

        lbCostoPedido.setText("Costo Pedido:");

        lbDemandaAnual.setText("Demanda Anual:");

        javax.swing.GroupLayout pCamposLayout = new javax.swing.GroupLayout(pCampos);
        pCampos.setLayout(pCamposLayout);
        pCamposLayout.setHorizontalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCamposLayout.createSequentialGroup()
                        .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pCamposLayout.createSequentialGroup()
                                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCostoAlmacenamiento)
                                    .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbPesoPorUnid)
                                        .addComponent(lbUnidadMedida)
                                        .addComponent(lbNombre)
                                        .addComponent(lbCodigo)
                                        .addComponent(lbTamanioLoteEstandar)
                                        .addComponent(lbPrecioBase)
                                        .addComponent(lbStock)
                                        .addComponent(lbDescripcion)
                                        .addComponent(lbEstado)
                                        .addComponent(lbCostoUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                                .addGap(23, 23, 23))
                            .addGroup(pCamposLayout.createSequentialGroup()
                                .addComponent(lbStockReserva)
                                .addGap(70, 70, 70)))
                        .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfStockReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfPrecioBase, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfTamanioLoteEstandar, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfPesoPorUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfCostoUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfCostoAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(cbUnidadMedida, javax.swing.GroupLayout.Alignment.TRAILING, 0, 208, Short.MAX_VALUE)
                            .addComponent(tfStock, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(cbEstado, 0, 208, Short.MAX_VALUE)))
                    .addGroup(pCamposLayout.createSequentialGroup()
                        .addComponent(lbCostoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addGap(23, 23, 23)
                        .addComponent(tfCostoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                    .addGroup(pCamposLayout.createSequentialGroup()
                        .addComponent(lbDemandaAnual, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addGap(23, 23, 23)
                        .addComponent(tfDemandaAnual, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pCamposLayout.setVerticalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCostoAlmacenamiento)
                    .addComponent(tfCostoAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCostoUnitario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbPesoPorUnid)
                    .addComponent(tfPesoPorUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbTamanioLoteEstandar)
                    .addComponent(tfTamanioLoteEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbPrecioBase)
                    .addComponent(tfPrecioBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbUnidadMedida)
                    .addComponent(cbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbStock)
                    .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescripcion)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbStockReserva)
                    .addComponent(tfStockReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfCostoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCostoPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfDemandaAnual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDemandaAnual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        pTablaProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedores"));

        jScrollPane1.setViewportView(tProveedor);

        btAsignarProveedor.setText("Asignar Proveedor");
        btAsignarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAsignarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btAsignarProveedor);

        btEliminarProveedor.setText("Eliminar");
        btEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminarProveedor);

        javax.swing.GroupLayout pTablaProveedoresLayout = new javax.swing.GroupLayout(pTablaProveedores);
        pTablaProveedores.setLayout(pTablaProveedoresLayout);
        pTablaProveedoresLayout.setHorizontalGroup(
            pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                .addContainerGap())
        );
        pTablaProveedoresLayout.setVerticalGroup(
            pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pTablaProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pTablaProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void tfCostoAlmacenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCostoAlmacenamientoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfCostoAlmacenamientoActionPerformed

private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed

    int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro desea guardar los cambios?", "Aceptar",
                JOptionPane.YES_NO_OPTION);
        
    if(opcion == JOptionPane.YES_OPTION) {
        actualizarMateriaPrima();
        FachadaPersistencia.getInstancia().actualizar(materiaPrima, true);
        Util.getInstancia().limpiarCampos(this);
        materiaPrima=null;            
        inicializarBotones();
    }
}//GEN-LAST:event_btModificarActionPerformed

private void btAsignarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAsignarProveedorActionPerformed
    PanelBuscarProveedor buscarProv = new PanelBuscarProveedor(tm);   
    buscarProv.setModal(true);
    buscarProv.setVisible(true);
            
}//GEN-LAST:event_btAsignarProveedorActionPerformed

private void btEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarProveedorActionPerformed
        
    int filaSeleccionada = tProveedor.convertRowIndexToModel(tProveedor.getSelectedRow());
    if(filaSeleccionada == -1){
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Proveedor");
    }else{
        tm.eliminarFila(filaSeleccionada);
    }
}//GEN-LAST:event_btEliminarProveedorActionPerformed

private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
    
        tfStock.setText("0");
        if(ValidacionBuscar.getInstancia().existenCamposVacios(this)){
            JOptionPane.showMessageDialog(this, "Existen campos sin completar");
        }else{
            materiaPrima= crearMateriaPrima();
            if(ValidacionBuscar.getInstancia().estaDuplicado(materiaPrima)){
                JOptionPane.showMessageDialog(this, "La materia prima ya se encuentra registrada");
            }else{
                FachadaPersistencia.getInstancia().actualizar(materiaPrima, true);
                Util.getInstancia().limpiarCampos(this);

                materiaPrima = null;
            }
        }
    
}//GEN-LAST:event_btAgregarActionPerformed

private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
    if(materiaPrima != null && ValidacionEliminar.getInstancia().materiaPrimaEstaRelacionada(materiaPrima)){
        JOptionPane.showMessageDialog(this, "No puede eliminar la Materia Prima " +
                "se utiliza en alguna estructura");
    } else {
        int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Seguro desea eliminar la Materia Prima?", "Aceptar",
                    JOptionPane.YES_NO_OPTION);

        if(opcion == JOptionPane.YES_OPTION) {
            FachadaPersistencia.getInstancia().borrar(materiaPrima, true);
            Util.getInstancia().limpiarCampos(this);
            materiaPrima = null;
            inicializarBotones();
        }
    }
}//GEN-LAST:event_btEliminarActionPerformed

private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
     PanelBuscarProductoGral buscarProv = new PanelBuscarProductoGral(this);   
     buscarProv.setModal(true);
     buscarProv.setVisible(true);
}//GEN-LAST:event_btBuscarActionPerformed

private void cbUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadMedidaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbUnidadMedidaActionPerformed

private void tfStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStockActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btAsignarProveedor;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEliminarProveedor;
    private javax.swing.JButton btModificar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbUnidadMedida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCostoAlmacenamiento;
    private javax.swing.JLabel lbCostoPedido;
    private javax.swing.JLabel lbCostoUnitario;
    private javax.swing.JLabel lbDemandaAnual;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPesoPorUnid;
    private javax.swing.JLabel lbPrecioBase;
    private javax.swing.JLabel lbStock;
    private javax.swing.JLabel lbStockReserva;
    private javax.swing.JLabel lbTamanioLoteEstandar;
    private javax.swing.JLabel lbUnidadMedida;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pCampos;
    private javax.swing.JPanel pTablaProveedores;
    private org.jdesktop.swingx.JXTable tProveedor;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCostoAlmacenamiento;
    private javax.swing.JTextField tfCostoPedido;
    private javax.swing.JTextField tfCostoUnitario;
    private javax.swing.JTextField tfDemandaAnual;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPesoPorUnidad;
    private javax.swing.JTextField tfPrecioBase;
    private javax.swing.JTextField tfStock;
    private javax.swing.JTextField tfStockReserva;
    private javax.swing.JTextField tfTamanioLoteEstandar;
    // End of variables declaration//GEN-END:variables

    private MateriaPrima crearMateriaPrima(){
        materiaPrima = new MateriaPrima();

        materiaPrima.setCodigo(tfCodigo.getText());
        materiaPrima.setCostoAlmacenamiento(Double.parseDouble(tfCostoAlmacenamiento.getText()));        
        materiaPrima.setCostoUnitario(Double.parseDouble(tfCostoUnitario.getText()));
        materiaPrima.setDescripcion(tfDescripcion.getText());
        materiaPrima.setNombre(tfNombre.getText());
        materiaPrima.setPesoUnidad(Double.parseDouble(tfPesoPorUnidad.getText()));
        materiaPrima.setPrecioBase(Double.parseDouble(tfPrecioBase.getText()));
        materiaPrima.setTamanioLoteEstandar(Double.parseDouble(tfTamanioLoteEstandar.getText()));
        materiaPrima.setUnidadMedida((String) cbUnidadMedida.getSelectedItem());
        materiaPrima.setProveedores(tm.getFilas());  
        materiaPrima.setEstado((Estado)cbEstado.getSelectedItem());
        materiaPrima.setStock(Double.valueOf(tfStock.getText()));
        materiaPrima.setStockReserva(Double.valueOf(tfStockReserva.getText()));
        materiaPrima.setCostoPedido(Double.parseDouble(tfCostoPedido.getText()));
        materiaPrima.setDemandaAnual(Double.parseDouble(tfDemandaAnual.getText()));
        
        return materiaPrima;
    }
    
    private void cargarPantallaMateriaPrima(MateriaPrima mat){
        Util.getInstancia().limpiarCampos(this);
        tfCodigo.setText(mat.getCodigo());
        tfCostoAlmacenamiento.setText(String.valueOf(mat.getCostoAlmacenamiento()));
        tfCostoUnitario.setText(String.valueOf(mat.getCostoUnitario()));
        tfDescripcion.setText(mat.getDescripcion());
        tfNombre.setText(mat.getNombre());
        tfPesoPorUnidad.setText(String.valueOf(mat.getPesoUnidad()));
        tfPrecioBase.setText(String.valueOf(mat.getPrecioBase()));
        tfTamanioLoteEstandar.setText(String.valueOf(mat.getTamanioLoteEstandar()));
        cbUnidadMedida.setSelectedItem(mat.getUnidadMedida());
        tfStock.setText(String.valueOf(mat.getStock()));
        tfStockReserva.setText(String.valueOf(mat.getStockReserva()));
        tfCostoPedido.setText(String.valueOf(mat.getCostoPedido()));
        tfDemandaAnual.setText(String.valueOf(mat.getDemandaAnual()));
        
        tm.agregarFilas(mat.getProveedores());
        
        cbEstado.setSelectedItem(mat.getEstado());
        btModificar.setEnabled(true);
        materiaPrima=mat;
        pantallaCargadaBotones();
    }
    
    public void setComponente(MateriaPrima mat){
        materiaPrima=mat;
        cargarPantallaMateriaPrima(mat);
        
    }
     
    private void actualizarMateriaPrima(){
        
        materiaPrima.setCodigo(tfCodigo.getText());
        materiaPrima.setCostoAlmacenamiento(Double.parseDouble(tfCostoAlmacenamiento.getText()));        
        materiaPrima.setCostoUnitario(Double.parseDouble(tfCostoUnitario.getText()));
        materiaPrima.setDescripcion(tfDescripcion.getText());
        materiaPrima.setNombre(tfNombre.getText());
        materiaPrima.setPesoUnidad(Double.parseDouble(tfPesoPorUnidad.getText()));
        materiaPrima.setPrecioBase(Double.parseDouble(tfPrecioBase.getText()));
        materiaPrima.setTamanioLoteEstandar(Double.parseDouble(tfTamanioLoteEstandar.getText()));
        materiaPrima.setUnidadMedida((String) cbUnidadMedida.getSelectedItem());
        materiaPrima.setProveedores(tm.getFilas());  
        materiaPrima.setEstado((Estado)cbEstado.getSelectedItem());
        materiaPrima.setStock(Double.valueOf(tfStock.getText()));
        materiaPrima.setStockReserva(Double.valueOf(tfStockReserva.getText()));
        materiaPrima.setCostoPedido(Double.parseDouble(tfCostoPedido.getText()));
        materiaPrima.setDemandaAnual(Double.parseDouble(tfDemandaAnual.getText()));
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

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }
       
    @Override
    public List<Component> getComponentesObligatorios() {
        return componentesObligatorios;
    }   
}
