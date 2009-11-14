/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelCurvaABC.java
 *
 * Created on Sep 28, 2009, 11:47:21 AM
 */
package sgvet.igu;

import java.awt.Frame;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import sgvet.entidades.ProductoComponente;
import sgvet.igu.model.SenialRastreoTableModel;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.Util;

/**
 *
 * @author lnieto
 */
public class PanelSenialRastreo extends javax.swing.JDialog {

    private SenialRastreoTableModel tmSenialRastreo;
    private List<ProductoComponente> productos;
    int cantidad = 0;

    /** Creates new form PanelCurvaABC
     * @param parent
     */
    public PanelSenialRastreo(Frame parent) {
        super(parent, true);
        initComponents();
        inicializar();
    }

    /** Creates new form PanelCurvaABC
     * @param parent
     * @param modal
     */
    public PanelSenialRastreo(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializar();
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtABC = new org.jdesktop.swingx.JXTable();
        lbCantidadAvisos = new javax.swing.JLabel();
        tfCantidadAvisos = new javax.swing.JTextField();
        pBotones = new javax.swing.JPanel();
        btCalcular = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtABC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Categoria", "L", "Senal Rastreo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtABC);

        lbCantidadAvisos.setText("Cantidad de avisos:");

        tfCantidadAvisos.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(lbCantidadAvisos)
                        .addGap(18, 18, 18)
                        .addComponent(tfCantidadAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCantidadAvisos)
                    .addComponent(tfCantidadAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });
        pBotones.add(btCalcular);

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        pBotones.add(btLimpiar);

        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });
        pBotones.add(btCerrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addGap(31, 31, 31))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(587, Short.MAX_VALUE)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed

        Util.getInstancia().limpiarCampos(this);

        inicializar();

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a " +
                "FROM ProductoComponente a " +
                "WHERE a.borrado = false");

        productos = FachadaPersistencia.getInstancia().buscar(
                ProductoComponente.class, consulta);

        tmSenialRastreo.limpiarTableModel();

        if (tmSenialRastreo.agregarFilas(productos)) {
            JOptionPane.showMessageDialog(this, "No existen ventas para algunos productos.", "WARNING", JOptionPane.ERROR_MESSAGE);
        }

        btLimpiar.setEnabled(true);

}//GEN-LAST:event_btCalcularActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed

        sgvet.utils.Util.getInstancia().limpiarCampos(this);
        btLimpiar.setEnabled(false);
}//GEN-LAST:event_btLimpiarActionPerformed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                PanelSenialRastreo dialog = new PanelSenialRastreo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable jtABC;
    private javax.swing.JLabel lbCantidadAvisos;
    private javax.swing.JPanel pBotones;
    private javax.swing.JTextField tfCantidadAvisos;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {

        tfCantidadAvisos.setVisible(false);
        lbCantidadAvisos.setVisible(false);

        tmSenialRastreo = new SenialRastreoTableModel(0);
        jtABC.setModel(tmSenialRastreo);

        Query consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a " +
                "FROM ProductoComponente a " +
                "WHERE a.borrado = false");

        productos = FachadaPersistencia.getInstancia().buscar(
                ProductoComponente.class, consulta);

        tmSenialRastreo.limpiarTableModel();

        if (tmSenialRastreo.agregarFilas(productos)) {
            JOptionPane.showMessageDialog(this, "No existen ventas para algunos productos.", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void setCantidadAvisos(int cant) {

        tfCantidadAvisos.setVisible(true);
        lbCantidadAvisos.setVisible(true);
        btCalcular.setVisible(false);
        btLimpiar.setVisible(false);
        cantidad = cant;
        tfCantidadAvisos.setText(cantidad + "");
    }
}
