/*
 * PanelCurvaABC.java
 *
 * Created on Sep 28, 2009, 11:47:21 AM
 */
package sgvet.igu;

import java.awt.Frame;
import java.util.List;
import javax.swing.JDialog;
import sgvet.entidades.auxiliares.ItemABC;
import sgvet.gestores.GestorABC;
import sgvet.igu.model.CurvaABCTableModel;
import sgvet.utils.Util;

/**
 *
 * @author lnieto
 */
public class PanelCurvaABC extends JDialog {

    private CurvaABCTableModel tmCurvaABC;
    private List<ItemABC> curvaABC;
    String clase = "Todas";

    /** Creates new form PanelCurvaABC
     * @param parent
     */
    public PanelCurvaABC(Frame parent) {

        super(parent, true);

        initComponents();
        inicializar();
        esconderBotones();
        calcularABC();

    }

    /** Creates new form PanelCurvaABC
     * @param parent
     * @param modal
     */
    public PanelCurvaABC(Frame parent, boolean modal) {

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
        pBotones = new javax.swing.JPanel();
        btCalcular = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btCerrar = new javax.swing.JButton();
        pProducto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbDemandaAnualTotal = new javax.swing.JLabel();
        tfDemandaAnualTotal = new javax.swing.JTextField();
        lbDemandaValorizadaTotal = new javax.swing.JLabel();
        tfDemandaValorizadaTotal = new javax.swing.JTextField();
        lbCantidadProductos = new javax.swing.JLabel();
        tfCantidadProductos = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbCantidadProdA = new javax.swing.JLabel();
        tfCantidadProdA = new javax.swing.JTextField();
        lbCantidadProdB = new javax.swing.JLabel();
        tfCantidadProdB = new javax.swing.JTextField();
        lbCantidadProdC = new javax.swing.JLabel();
        tfCantidadProdC = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lbDemanda80 = new javax.swing.JLabel();
        tfDemanda80 = new javax.swing.JTextField();
        lbDemanda90 = new javax.swing.JLabel();
        tfDemanda90 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtABC = new org.jdesktop.swingx.JXTable();
        jpCategoria = new javax.swing.JPanel();
        rbTodas1 = new javax.swing.JRadioButton();
        rbClaseA1 = new javax.swing.JRadioButton();
        rbClaseB1 = new javax.swing.JRadioButton();
        rbClaseC1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });
        pBotones.add(btCalcular);

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        pBotones.add(btBuscar);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbDemandaAnualTotal.setText("Demanda Anual Total");

        tfDemandaAnualTotal.setEditable(false);

        lbDemandaValorizadaTotal.setText("Demanda Valorizada Total");

        tfDemandaValorizadaTotal.setEditable(false);

        lbCantidadProductos.setText("Cantidad Productos");

        tfCantidadProductos.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDemandaAnualTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDemandaAnualTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbDemandaValorizadaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDemandaValorizadaTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbCantidadProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCantidadProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDemandaAnualTotal)
                    .addComponent(tfDemandaAnualTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDemandaValorizadaTotal)
                    .addComponent(tfDemandaValorizadaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidadProductos)
                    .addComponent(tfCantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbCantidadProdA.setText("Cantidad Productos A");

        tfCantidadProdA.setEditable(false);

        lbCantidadProdB.setText("Cantidad Productos B");

        tfCantidadProdB.setEditable(false);

        lbCantidadProdC.setText("Cantidad Productos C");

        tfCantidadProdC.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCantidadProdA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCantidadProdA, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbCantidadProdB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCantidadProdB, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbCantidadProdC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCantidadProdC, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCantidadProdA)
                    .addComponent(tfCantidadProdA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidadProdB)
                    .addComponent(tfCantidadProdB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidadProdC)
                    .addComponent(tfCantidadProdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbDemanda80.setText("Dermanda 80%");

        tfDemanda80.setEditable(false);

        lbDemanda90.setText("Dermanda 90%");

        tfDemanda90.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(lbDemanda80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDemanda80, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDemanda90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDemanda90, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(115, 115, 115))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDemanda90)
                    .addComponent(tfDemanda90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDemanda80)
                    .addComponent(tfDemanda80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pProductoLayout = new javax.swing.GroupLayout(pProducto);
        pProducto.setLayout(pProductoLayout);
        pProductoLayout.setHorizontalGroup(
            pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pProductoLayout.setVerticalGroup(
            pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jtABC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Demanda Valorizada", "Demanda Acumulada", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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

        jpCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));

        rbTodas1.setSelected(true);
        rbTodas1.setText("Todas");
        rbTodas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodas1ActionPerformed(evt);
            }
        });
        jpCategoria.add(rbTodas1);

        rbClaseA1.setText("Curva A");
        rbClaseA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClaseA1ActionPerformed(evt);
            }
        });
        jpCategoria.add(rbClaseA1);

        rbClaseB1.setText("Curva B");
        rbClaseB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClaseB1ActionPerformed(evt);
            }
        });
        jpCategoria.add(rbClaseB1);

        rbClaseC1.setText("Curva C");
        rbClaseC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClaseC1ActionPerformed(evt);
            }
        });
        jpCategoria.add(rbClaseC1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed

        Util.getInstancia().limpiarCampos(this);

        inicializar();

        calcularABC();

        btLimpiar.setEnabled(true);

}//GEN-LAST:event_btCalcularActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

        Util.getInstancia().limpiarCampos(this);

        inicializar();

        if (clase != null) {
            curvaABC = GestorABC.getInstancia().buscarCurvaABC(clase);
            tmCurvaABC.limpiarTableModel();
            tmCurvaABC.agregarFilas(curvaABC);
        }

        btLimpiar.setEnabled(true);

    }//GEN-LAST:event_btBuscarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed

        sgvet.utils.Util.getInstancia().limpiarCampos(this);
        btLimpiar.setEnabled(false);

}//GEN-LAST:event_btLimpiarActionPerformed

    private void rbTodas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodas1ActionPerformed

        clase = "Todas";

        rbClaseA1.setSelected(false);
        rbClaseB1.setSelected(false);
        rbClaseC1.setSelected(false);
        rbTodas1.setSelected(true);

}//GEN-LAST:event_rbTodas1ActionPerformed

    private void rbClaseA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClaseA1ActionPerformed

        clase = "Clase A";

        rbClaseA1.setSelected(true);
        rbClaseB1.setSelected(false);
        rbClaseC1.setSelected(false);
        rbTodas1.setSelected(false);

}//GEN-LAST:event_rbClaseA1ActionPerformed

    private void rbClaseB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClaseB1ActionPerformed

        clase = "Clase B";

        rbClaseA1.setSelected(false);
        rbClaseB1.setSelected(true);
        rbClaseC1.setSelected(false);
        rbTodas1.setSelected(false);

}//GEN-LAST:event_rbClaseB1ActionPerformed

    private void rbClaseC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClaseC1ActionPerformed

        clase = "Clase C";

        rbClaseA1.setSelected(false);
        rbClaseB1.setSelected(false);
        rbClaseC1.setSelected(true);
        rbTodas1.setSelected(false);

}//GEN-LAST:event_rbClaseC1ActionPerformed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        
        dispose();

    }//GEN-LAST:event_btCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                PanelCurvaABC dialog = new PanelCurvaABC(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpCategoria;
    private org.jdesktop.swingx.JXTable jtABC;
    private javax.swing.JLabel lbCantidadProdA;
    private javax.swing.JLabel lbCantidadProdB;
    private javax.swing.JLabel lbCantidadProdC;
    private javax.swing.JLabel lbCantidadProductos;
    private javax.swing.JLabel lbDemanda80;
    private javax.swing.JLabel lbDemanda90;
    private javax.swing.JLabel lbDemandaAnualTotal;
    private javax.swing.JLabel lbDemandaValorizadaTotal;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pProducto;
    private javax.swing.JRadioButton rbClaseA1;
    private javax.swing.JRadioButton rbClaseB1;
    private javax.swing.JRadioButton rbClaseC1;
    private javax.swing.JRadioButton rbTodas1;
    private javax.swing.JTextField tfCantidadProdA;
    private javax.swing.JTextField tfCantidadProdB;
    private javax.swing.JTextField tfCantidadProdC;
    private javax.swing.JTextField tfCantidadProductos;
    private javax.swing.JTextField tfDemanda80;
    private javax.swing.JTextField tfDemanda90;
    private javax.swing.JTextField tfDemandaAnualTotal;
    private javax.swing.JTextField tfDemandaValorizadaTotal;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {

        GestorABC gestor = GestorABC.getInstancia();
        tmCurvaABC = new CurvaABCTableModel(0);
        jtABC.setModel(tmCurvaABC);

        curvaABC = gestor.buscarCurvaABC("Todas");
        tmCurvaABC.limpiarTableModel();
        tmCurvaABC.agregarFilas(curvaABC);

        tfCantidadProductos.setText("" + gestor.getCantidadProductos());
        tfCantidadProdA.setText("" + gestor.getCantidadProductosA());
        tfCantidadProdB.setText("" + gestor.getCantidadProductosB());
        tfCantidadProdC.setText("" + gestor.getCantidadProductosC());
        tfDemanda80.setText("" + gestor.getDemanda80());
        tfDemanda90.setText("" + gestor.getDemanda90());
        tfDemandaAnualTotal.setText("" + gestor.getDemandaAnualTotal());
        tfDemandaValorizadaTotal.setText("" + gestor.getDemandaValorizadaTotal());

    }

    private void esconderBotones() {

        btBuscar.setVisible(false);
        btCalcular.setVisible(false);
        btLimpiar.setVisible(false);
        jpCategoria.setVisible(false);

    }

    private void calcularABC() {

        curvaABC = GestorABC.getInstancia().calcularCurvaABC();
        tmCurvaABC.limpiarTableModel();
        tmCurvaABC.agregarFilas(curvaABC);

    }
}
