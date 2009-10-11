package sgvet.igu;

import java.awt.Component;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import sgvet.entidades.Componente;
import sgvet.entidades.DetalleOrdenCompra;
import sgvet.entidades.OrdenCompra;
import sgvet.entidades.Proveedor;
import sgvet.gestores.GestorOrdenCompra;
import sgvet.gestores.GestorVenta;
import sgvet.gestores.GestorProveedor;
import sgvet.igu.buscar.PanelBuscarOrdenCompra;
import sgvet.igu.buscar.PanelBuscarProductoGral;
import sgvet.igu.buscar.PanelBuscarProductoGral.Tipo;
import sgvet.igu.buscar.PanelBuscarProveedor;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.igu.model.OrdenCompraTableModel;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.IValidable;
import sgvet.utils.Util;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelOrdenCompra extends javax.swing.JPanel implements IValidable {

    private static final long serialVersionUID = 1L;
    private List<Component> componentesObligatorios;
    private OrdenCompraTableModel tm;
    private Proveedor proveedor;
    private DetalleOrdenCompra detalleOrdenCompra;
    private OrdenCompra ordenCompra;
    private Componente componente;

    /** Creates new form PanelOrdenCompra */
    public PanelOrdenCompra() {
        initComponents();
        componentesObligatorios = Arrays.asList((Component) jdFecha);
        inicializar();
    }

    private void inicializar() {

        tm = new OrdenCompraTableModel(0);
        jtArticulo.setModel(tm);

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
        tfNumero = new javax.swing.JTextField();
        lbProveedor = new javax.swing.JLabel();
        tfProveedor = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArticulo = new org.jdesktop.swingx.JXTable();
        jPanel5 = new javax.swing.JPanel();
        tfArticulo = new javax.swing.JTextField();
        lbArticulo = new javax.swing.JLabel();
        lbCantidad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btAgregarArticulo = new javax.swing.JButton();
        btEliminarArticulo = new javax.swing.JButton();
        btBuscarArticulo = new javax.swing.JButton();
        tfCantidad = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btBuscarOrdenCompra = new javax.swing.JButton();
        btProcesarOrdenCompra = new javax.swing.JButton();
        btModificarOrdenCompra = new javax.swing.JButton();
        btAnularOrdenCompra = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();

        jdFecha.setDate(new Date());
        jdFecha.setFormats("dd/MM/yy");

        lbFecha.setText("Fecha");

        tfNumero.setEditable(false);
        tfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroActionPerformed(evt);
            }
        });

        lbProveedor.setText("Proveedor");

        tfProveedor.setEnabled(false);
        tfProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProveedorActionPerformed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nro Orden");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFecha)
                            .addComponent(lbProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(tfNumero))
                            .addComponent(tfProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar)
                        .addGap(256, 256, 256))
                    .addComponent(jLabel1)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbProveedor)
                    .addComponent(tfProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(61, 61, 61))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtArticulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Articulo", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jtArticulo);

        tfArticulo.setEditable(false);
        tfArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfArticuloActionPerformed(evt);
            }
        });

        lbArticulo.setText("Articulo");

        lbCantidad.setText("Cantidad");

        btAgregarArticulo.setText("Agregar");
        btAgregarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarArticuloActionPerformed(evt);
            }
        });
        jPanel3.add(btAgregarArticulo);

        btEliminarArticulo.setText("Eliminar");
        btEliminarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarArticuloActionPerformed(evt);
            }
        });
        jPanel3.add(btEliminarArticulo);

        btBuscarArticulo.setText("Buscar");
        btBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarArticuloActionPerformed(evt);
            }
        });

        tfCantidad.setText("0");
        tfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbArticulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarArticulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbArticulo)
                    .addComponent(btBuscarArticulo)
                    .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidad)
                    .addComponent(tfArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btBuscarOrdenCompra.setText("Buscar");
        btBuscarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarOrdenCompraActionPerformed(evt);
            }
        });
        jPanel4.add(btBuscarOrdenCompra);

        btProcesarOrdenCompra.setText("Procesar");
        btProcesarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcesarOrdenCompraActionPerformed(evt);
            }
        });
        jPanel4.add(btProcesarOrdenCompra);

        btModificarOrdenCompra.setText("Modificar");
        btModificarOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarOrdenCompraActionPerformed(evt);
            }
        });
        jPanel4.add(btModificarOrdenCompra);

        btAnularOrdenCompra.setText("Anular");
        btAnularOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnularOrdenCompraActionPerformed(evt);
            }
        });
        jPanel4.add(btAnularOrdenCompra);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

private void tfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfNumeroActionPerformed

private void btEliminarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarArticuloActionPerformed
    int filaSeleccionada = jtArticulo.convertRowIndexToModel(jtArticulo.getSelectedRow());
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Componente");
    } else {
        tm.eliminarFila(filaSeleccionada);

    }
}//GEN-LAST:event_btEliminarArticuloActionPerformed

private void btModificarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarOrdenCompraActionPerformed
    int opcion = JOptionPane.showConfirmDialog(this,
            "¿Seguro desea guardar los cambios?", "Aceptar",
            JOptionPane.YES_NO_OPTION);

    if (opcion == JOptionPane.YES_OPTION) {
        actualizarOrdenCompra();
        FachadaPersistencia.getInstancia().actualizar(ordenCompra, true);
//        Util.getInstancia().limpiarCampos(this);
//        ordenCompra=null;            
        //inicializarBotones();
    }
}//GEN-LAST:event_btModificarOrdenCompraActionPerformed

private void btAnularOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnularOrdenCompraActionPerformed
    int opcion = JOptionPane.showConfirmDialog(this,
            "¿Seguro desea anular la Orden de Compra?", "Aceptar",
            JOptionPane.YES_NO_OPTION);

    if (opcion == JOptionPane.YES_OPTION) {
        ordenCompra.setBorrado(true);
        FachadaPersistencia.getInstancia().actualizar(ordenCompra, true);
        Util.getInstancia().limpiarCampos(this);
        ordenCompra = null;
        //inicializarBotones();
    }
}//GEN-LAST:event_btAnularOrdenCompraActionPerformed

private void tfArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfArticuloActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfArticuloActionPerformed

private void btBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarArticuloActionPerformed

    PanelBuscarProductoGral buscarComponente = new PanelBuscarProductoGral(this, proveedor);
    buscarComponente.setModal(true);
    buscarComponente.setVisible(true);
}//GEN-LAST:event_btBuscarArticuloActionPerformed

private void tfProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProveedorActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfProveedorActionPerformed

private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
    Util.getInstancia().limpiarCampos(this);
    PanelBuscarProveedor buscarProv = new PanelBuscarProveedor(this, Tipo.PANEL_ORDEN_COMPRA);
    buscarProv.setModal(true);
    buscarProv.setVisible(true);
}//GEN-LAST:event_btBuscarActionPerformed

private void btAgregarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarArticuloActionPerformed

    double cantidad = Double.parseDouble(tfCantidad.getText());
    if (componente == null || cantidad == 0) {
        JOptionPane.showMessageDialog(this, "Existen campos vacios");
    } else {
        if (proveedor == null) {
            JOptionPane.showMessageDialog(this, "Debe asignar proveedor");
        } else {
            if (!GestorProveedor.getInstancia().proveeComponente(componente, proveedor)) {
                JOptionPane.showMessageDialog(this, "El proveedor no provee el componente seleccionado");

            } else {
                detalleOrdenCompra = new DetalleOrdenCompra();
                detalleOrdenCompra.setComponente(componente);
                detalleOrdenCompra.setCantidad(cantidad);


                if (ValidacionBuscar.getInstancia().componenteEstaCargadoOrdenEnTabla(tm, detalleOrdenCompra)) {
                    JOptionPane.showMessageDialog(this, "El Componente ya se encuentra asignado");
                } else {
                    tm.agregarFila(detalleOrdenCompra);
                    //tfArticulo.setText("");
                    tfCantidad.setText("0");

                }
            }
        }

    }
}//GEN-LAST:event_btAgregarArticuloActionPerformed

private void tfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCantidadActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfCantidadActionPerformed

private void btProcesarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcesarOrdenCompraActionPerformed

    crearOrdenCompra();

    if (ValidacionBuscar.getInstancia().estaDuplicado(ordenCompra)) {
        JOptionPane.showMessageDialog(this, "Orden ya registrada");
    } else {
        if (proveedor == null) {
            JOptionPane.showMessageDialog(this, "No se ha asignado Proveedor");
        } else if (jtArticulo.getModel().getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "No se han asignado Articulos");
        } else {
            btProcesarOrdenCompra.setEnabled(false);
            tfNumero.setText(GestorOrdenCompra.getInstancia().obtenerNroOrden());
            ordenCompra.setNroOrdenCompra(Integer.parseInt(tfNumero.getText()));
            GestorOrdenCompra.getInstancia().terminarOrden(ordenCompra);
            FachadaPersistencia.getInstancia().actualizar(ordenCompra, true);
        }
    }

}//GEN-LAST:event_btProcesarOrdenCompraActionPerformed

private void btBuscarOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarOrdenCompraActionPerformed
    PanelBuscarOrdenCompra panelBusqueda = new PanelBuscarOrdenCompra(this);
    panelBusqueda.setModal(true);
    panelBusqueda.setVisible(true);
}//GEN-LAST:event_btBuscarOrdenCompraActionPerformed

private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
    Util.getInstancia().limpiarCampos(this);
    ordenCompra = null;
    btProcesarOrdenCompra.setEnabled(true);
}//GEN-LAST:event_btLimpiarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarArticulo;
    private javax.swing.JButton btAnularOrdenCompra;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btBuscarArticulo;
    private javax.swing.JButton btBuscarOrdenCompra;
    private javax.swing.JButton btEliminarArticulo;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btModificarOrdenCompra;
    private javax.swing.JButton btProcesarOrdenCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jdFecha;
    private org.jdesktop.swingx.JXTable jtArticulo;
    private javax.swing.JLabel lbArticulo;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbProveedor;
    private javax.swing.JTextField tfArticulo;
    private javax.swing.JTextField tfCantidad;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfProveedor;
    // End of variables declaration//GEN-END:variables

    public void setDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        this.detalleOrdenCompra = detalleOrdenCompra;

    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        cargarPantallaOrdenCompra(ordenCompra);
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
        tfProveedor.setText(proveedor.getNombre());
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
        tfArticulo.setText(componente.getNombre());
        tfCantidad.setText("0");
    }

    private OrdenCompra crearOrdenCompra() {
        ordenCompra = new OrdenCompra();

        //ordenCompra.setNroOrdenCompra(tfNumero.getText());
        ordenCompra.setProveedor(proveedor);
        ordenCompra.setDetallesOrdenCompra(tm.getFilas());
        ordenCompra.setFecha(jdFecha.getDate());

        for (DetalleOrdenCompra detalle : ordenCompra.getDetallesOrdenCompra()) {
            detalle.setOrdenCompra(ordenCompra);
        }

        return ordenCompra;
    }

    public void setTableModelComponentes(OrdenCompraTableModel tableModel) {
        tm.agregarFilas(tableModel.getFilas());
    }

    private void cargarPantallaOrdenCompra(OrdenCompra orden) {
        Util.getInstancia().limpiarCampos(this);
        ordenCompra = orden;
        proveedor = orden.getProveedor();

        tfNumero.setText(Integer.toString(orden.getNroOrdenCompra()));
        tfProveedor.setText(orden.getProveedor().getNombre());
        tm.agregarFilas(orden.getDetallesOrdenCompra());
        jdFecha.setDate(orden.getFecha());
    }

    private void actualizarOrdenCompra() {
        ordenCompra.setNroOrdenCompra(Integer.parseInt(tfNumero.getText()));
        ordenCompra.setProveedor(proveedor);
        ordenCompra.setDetallesOrdenCompra(tm.getFilas());
        ordenCompra.setFecha(jdFecha.getDate());
    }

    @Override
    public List<Component> getComponentesObligatorios() {
        return componentesObligatorios;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }
}
