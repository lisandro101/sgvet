/*
 * PanelBuscarProveedor.java
 *
 * Created on 26 de octubre de 2008, 17:15
 */
package sgvet.igu.buscar;

import sgvet.igu.*;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import sgvet.entidades.Proveedor;
import sgvet.igu.buscar.PanelBuscarProductoGral.Tipo;
import sgvet.igu.model.ProveedorTableModel;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author  stafoxter
 */
public class PanelBuscarProveedor extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private ProveedorTableModel tmBuscar;
    private ProveedorTableModel tmOrigen;
    private List<Proveedor> proveedores;
    //private PanelProveedor panelOrigen;
    private PanelProveedor panelProveedor;
    private PanelOrdenCompra panelOrdenCompra;
    //private int tipoBusqueda;
    private Tipo tipo;

    /** Creates new form PanelBuscarProveedor
     * @param tm1
     */
    public PanelBuscarProveedor(ProveedorTableModel tm1) {
        initComponents();
        //tipoBusqueda=1;
        tipo = Tipo.TABLE_MODEL;
        tmOrigen = tm1;
        inicializar();

    }

    //public PanelBuscarProveedor(PanelProveedor prov) {
    public PanelBuscarProveedor(JPanel panel, Tipo tipo1) {
        initComponents();
        tipo = tipo1;
        if (tipo == Tipo.PANEL_PROVEEDOR) {
            panelProveedor = (PanelProveedor) panel;
        } else if (tipo == Tipo.PANEL_ORDEN_COMPRA) {
            panelOrdenCompra = (PanelOrdenCompra) panel;
        }

        inicializar();
    }

    private void inicializar() {
        tmBuscar = new ProveedorTableModel(0);
        tProveedores.setModel(tmBuscar);
        tProveedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pTablaProveedores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProveedores = new org.jdesktop.swingx.JXTable();
        pBoton = new javax.swing.JPanel();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pBuscar = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Proveedor");

        tProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Teléfono", "Contacto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tProveedores.setEditable(false);
        jScrollPane1.setViewportView(tProveedores);

        javax.swing.GroupLayout pTablaProveedoresLayout = new javax.swing.GroupLayout(pTablaProveedores);
        pTablaProveedores.setLayout(pTablaProveedoresLayout);
        pTablaProveedoresLayout.setHorizontalGroup(
            pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );
        pTablaProveedoresLayout.setVerticalGroup(
            pTablaProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });
        pBoton.add(btAceptar);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        pBoton.add(btCancelar);

        lbNombre.setText("Nombre:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBuscarLayout = new javax.swing.GroupLayout(pBuscar);
        pBuscar.setLayout(pBuscarLayout);
        pBuscarLayout.setHorizontalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btBuscar)
                .addContainerGap())
        );
        pBuscarLayout.setVerticalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(btBuscar)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pTablaProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pTablaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    dispose();
}//GEN-LAST:event_btCancelarActionPerformed

private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
    tmBuscar.limpiarTableModel();

    Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
            "Select a from Proveedor a where (a.nombre) LIKE :nombre and a.borrado=false");
    consulta.setParameter("nombre", "%" + tfNombre.getText() + "%");

    proveedores = FachadaPersistencia.getInstancia().buscar(Proveedor.class,
            consulta);


    for (int i = 0; i < proveedores.size(); i++) {
        tmBuscar.agregarFila(proveedores.get(i));
    }

}//GEN-LAST:event_btBuscarActionPerformed

private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
    int indice = tProveedores.convertRowIndexToModel(
            tProveedores.getSelectedRow());
    Proveedor resultado;

    if (indice == -1) {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Proveedor");
    } else {
        resultado = tmBuscar.getFila(indice);
        if (tipo == Tipo.TABLE_MODEL) {
            if (tmOrigen.getRowCount() < 1) {
                tmOrigen.agregarFila(resultado);
                dispose();
            } else {
                if (ValidacionBuscar.getInstancia().proveedorEstaCargadoEnTabla(
                        tmOrigen, resultado)) {
                    JOptionPane.showMessageDialog(this,
                            "El proveedor ya se encuentra asignado");
                } else {
                    tmOrigen.agregarFila(resultado);
                    dispose();
                }
            }
        } else if (tipo == Tipo.PANEL_PROVEEDOR) {
            panelProveedor.setProveedor(resultado);
            dispose();
        } else if (tipo == Tipo.PANEL_ORDEN_COMPRA) {
            panelOrdenCompra.setProveedor(resultado);
            dispose();
        }
    }
}//GEN-LAST:event_btAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JPanel pBoton;
    private javax.swing.JPanel pBuscar;
    private javax.swing.JPanel pTablaProveedores;
    private org.jdesktop.swingx.JXTable tProveedores;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
