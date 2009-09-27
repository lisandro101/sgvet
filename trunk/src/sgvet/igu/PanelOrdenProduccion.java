package sgvet.igu;

import java.awt.Component;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import sgvet.entidades.DetalleOrdenProduccion;
import sgvet.entidades.Venta;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorVenta;
import sgvet.igu.buscar.PanelBuscarOrdenProduccion;
import sgvet.igu.buscar.PanelBuscarProductoGral;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.igu.model.OrdenProduccionTableModel;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.IValidable;
import sgvet.utils.Util;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelOrdenProduccion extends javax.swing.JPanel implements IValidable {

    private static final long serialVersionUID = 1L;
    
    private List<Component> componentesObligatorios;
    
    private Venta venta;
    private OrdenProduccionTableModel tm;
    private ProductoComponente producto;
    private DetalleOrdenProduccion detalleOrdenProduccion;
    
    
    /** Creates new form OrdenCompra */
    public PanelOrdenProduccion() {
        initComponents();
        componentesObligatorios = Arrays.asList((Component)jdFecha);
        inicializar();
    }

    private void inicializar() { 
        tm = new OrdenProduccionTableModel(0);
        jtProducto.setModel(tm);
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jdFecha = new org.jdesktop.swingx.JXDatePicker();
        lbFecha = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbCliente = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducto = new org.jdesktop.swingx.JXTable();
        jPanel5 = new javax.swing.JPanel();
        lbProducto = new javax.swing.JLabel();
        tfProducto = new javax.swing.JTextField();
        lbCantidad = new javax.swing.JLabel();
        spCantidad = new javax.swing.JSpinner();
        btBuscarProducto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btAgregarProducto = new javax.swing.JButton();
        btEliminarProducto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btBuscarOrdenProduccion = new javax.swing.JButton();
        btProcesarOrdenProduccion = new javax.swing.JButton();
        btModificarOrdenProduccion = new javax.swing.JButton();
        btAnularOrdenProduccion = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();

        jdFecha.setDate(new Date());
        jdFecha.setFormats("dd/MM/yy");

        lbFecha.setText("Fecha");

        lbNumero.setText("Numero");

        tfNumero.setEditable(false);
        tfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroActionPerformed(evt);
            }
        });

        lbCliente.setText("Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumero)
                            .addComponent(lbCliente)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbFecha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumero))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbFecha)
                    .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProducto);

        lbProducto.setText("Producto");

        tfProducto.setEditable(false);
        tfProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProductoActionPerformed(evt);
            }
        });

        lbCantidad.setText("Cantidad");

        spCantidad.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        btBuscarProducto.setText("Buscar");
        btBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProducto)
                .addGap(3, 3, 3)
                .addComponent(tfProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProducto)
                    .addComponent(tfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarProducto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCantidad)
                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btAgregarProducto.setText("Agregar");
        btAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProductoActionPerformed(evt);
            }
        });
        jPanel3.add(btAgregarProducto);

        btEliminarProducto.setText("Eliminar");
        btEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarProductoActionPerformed(evt);
            }
        });
        jPanel3.add(btEliminarProducto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btBuscarOrdenProduccion.setText("Buscar");
        btBuscarOrdenProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarOrdenProduccionActionPerformed(evt);
            }
        });
        jPanel4.add(btBuscarOrdenProduccion);

        btProcesarOrdenProduccion.setText("Vender");
        btProcesarOrdenProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcesarOrdenProduccionActionPerformed(evt);
            }
        });
        jPanel4.add(btProcesarOrdenProduccion);

        btModificarOrdenProduccion.setText("Modificar");
        btModificarOrdenProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarOrdenProduccionActionPerformed(evt);
            }
        });
        jPanel4.add(btModificarOrdenProduccion);

        btAnularOrdenProduccion.setText("Anular");
        btAnularOrdenProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnularOrdenProduccionActionPerformed(evt);
            }
        });
        jPanel4.add(btAnularOrdenProduccion);

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        jPanel4.add(btLimpiar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos() {
        Util.getInstancia().limpiarCampos(this);
        venta = null;
        btProcesarOrdenProduccion.setEnabled(true);
    }

private void tfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfNumeroActionPerformed

private void btEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarProductoActionPerformed
    int filaSeleccionada = jtProducto.convertRowIndexToModel(jtProducto.getSelectedRow());
    if(filaSeleccionada == -1){
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Producto");
    }else{
        tm.eliminarFila(filaSeleccionada);
        
    }
}//GEN-LAST:event_btEliminarProductoActionPerformed

private void btModificarOrdenProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarOrdenProduccionActionPerformed
    int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro desea guardar los cambios?", "Aceptar",
                JOptionPane.YES_NO_OPTION);
        
    if(opcion == JOptionPane.YES_OPTION) {
        actualizarOrdenProduccion();
        FachadaPersistencia.getInstancia().actualizar(venta, true);
//        Util.getInstancia().limpiarCampos(this);
//        venta=null;            
        //inicializarBotones();
    }
}//GEN-LAST:event_btModificarOrdenProduccionActionPerformed

private void btAnularOrdenProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnularOrdenProduccionActionPerformed
    int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro desea anular la Orden de Compra?", "Aceptar",
                JOptionPane.YES_NO_OPTION);
        
    if(opcion == JOptionPane.YES_OPTION) {
        //venta.setBorrado(true);
        if(GestorVenta.getInstancia().anularOrden(venta)){
            FachadaPersistencia.getInstancia().actualizar(venta, true);
        }else{
            JOptionPane.showMessageDialog(this, "No es posible anular la orden."+"\nEsta en estado: "+venta.getEstado().toString());
        }
        
//        Util.getInstancia().limpiarCampos(this);
//        venta=null;
        //inicializarBotones();
    }   
}//GEN-LAST:event_btAnularOrdenProduccionActionPerformed

private void tfProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProductoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfProductoActionPerformed

private void btBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProductoActionPerformed
    PanelBuscarProductoGral panelBuscar = new PanelBuscarProductoGral(this);
    panelBuscar.setModal(true);
    panelBuscar.setVisible(true);

}//GEN-LAST:event_btBuscarProductoActionPerformed

private void btAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProductoActionPerformed
    int cantidad = (Integer)spCantidad.getValue();
        if(producto == null ||cantidad ==0){
            JOptionPane.showMessageDialog(this, "Existen campos vacios");
        }else{ 
            
                detalleOrdenProduccion = new DetalleOrdenProduccion();
                detalleOrdenProduccion.setProducto(producto);
                detalleOrdenProduccion.setCantidad(cantidad);
                
                if(ValidacionBuscar.getInstancia().componenteEstaCargadoOrdenProdEnTabla(tm, detalleOrdenProduccion)){
                    JOptionPane.showMessageDialog(this, "El Producto ya se encuentra asignado");
                }else{
                    tm.agregarFila(detalleOrdenProduccion);
                    //tfArticulo.setText("");
                    spCantidad.setValue((Integer.valueOf("0")));

                }
            
        }
}//GEN-LAST:event_btAgregarProductoActionPerformed

private void btProcesarOrdenProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcesarOrdenProduccionActionPerformed
    crearOrdenProduccion();
    if (ValidacionBuscar.getInstancia().estaDuplicado(venta)) {
        JOptionPane.showMessageDialog(this, "Orden ya registrada");
    } else {
//        if(ValidacionBuscar.getInstancia().existenCamposVacios(this)){
//            JOptionPane.showMessageDialog(this, "Existen campos vacios");
//        }else{
        if(tfCliente.getText().trim().equals("") || !(tm.getRowCount() >= 1)){
            JOptionPane.showMessageDialog(this, "Existen campos vacios");
        } else {
            GestorVenta.getInstancia().procesarOrden(venta);
            tfNumero.setText(GestorVenta.getInstancia().obtenerNroOrden());
            //venta.setEstado(venta.getEstado());
            venta.setNroOrdenProduccion(Integer.parseInt(tfNumero.getText()));
            FachadaPersistencia.getInstancia().actualizar(venta, true);
                limpiarCampos();
        }

    }
}//GEN-LAST:event_btProcesarOrdenProduccionActionPerformed

private void btBuscarOrdenProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarOrdenProduccionActionPerformed
    PanelBuscarOrdenProduccion panelBuscar = new PanelBuscarOrdenProduccion(this);
    panelBuscar.setModal(true);
    panelBuscar.setVisible(true);
            
}//GEN-LAST:event_btBuscarOrdenProduccionActionPerformed

private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
    limpiarCampos();
}//GEN-LAST:event_btLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarProducto;
    private javax.swing.JButton btAnularOrdenProduccion;
    private javax.swing.JButton btBuscarOrdenProduccion;
    private javax.swing.JButton btBuscarProducto;
    private javax.swing.JButton btEliminarProducto;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btModificarOrdenProduccion;
    private javax.swing.JButton btProcesarOrdenProduccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jdFecha;
    private org.jdesktop.swingx.JXTable jtProducto;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbProducto;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfProducto;
    // End of variables declaration//GEN-END:variables

    
    
    
     private Venta crearOrdenProduccion(){
        venta = new Venta();
        
        //venta.setNroOrdenProduccion(Integer.parseInt(tfNumero.getText()));
        venta.setNombreCliente(tfCliente.getText());
        venta.setDetallesOrdenProduccion(tm.getFilas());
        venta.setFecha(jdFecha.getDate());
        
         for (DetalleOrdenProduccion detalle : venta.getDetallesOrdenProduccion()) {
             detalle.setVenta(venta);
         }
        
        return venta;
    }

    private void cargarPantallaOrdenProduccion(Venta orden){
        Util.getInstancia().limpiarCampos(this);
        venta = orden;
        
        tfNumero.setText(Integer.toString(orden.getNroOrdenProduccion()));
        tfCliente.setText(orden.getNombreCliente());
        tm.agregarFilas(orden.getDetallesOrdenProduccion());
        jdFecha.setDate(orden.getFecha());
        btProcesarOrdenProduccion.setEnabled(false);
    }
    
    private void actualizarOrdenProduccion(){
        venta.setNroOrdenProduccion(Integer.parseInt(tfNumero.getText()));
        venta.setNombreCliente(tfCliente.getText());
        venta.setDetallesOrdenProduccion(tm.getFilas());
        venta.setFecha(jdFecha.getDate());
    }
    
    public void setProducto(ProductoComponente prod){
        producto= prod;
        tfProducto.setText(prod.getNombre());
        
    }
    
    public void setOrdenProduccion(Venta orden){
        cargarPantallaOrdenProduccion(orden);
        
    }
    
    @Override
    public List<Component> getComponentesObligatorios() {
        return componentesObligatorios;
    }

    public Venta getOrdenProduccion() {
        return venta;
    }
    
    
}