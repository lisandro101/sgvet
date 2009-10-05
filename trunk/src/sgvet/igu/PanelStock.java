package sgvet.igu;

import java.util.List;
import javax.management.Query;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import sgvet.entidades.Componente;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Proveedor;
import sgvet.gestores.GestorStock;
import sgvet.igu.buscar.PanelBuscarProductoGral;
import sgvet.igu.buscar.PanelBuscarProductoGral.Tipo;
import sgvet.igu.interfaces.iBuscaProductoGeneral;
import sgvet.igu.model.ProductoGralTableModel;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author martin
 */
public class PanelStock extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private ProductoGralTableModel tmBuscar;
    private List<Componente> componentes;
    private Object[][] data;
    private TableColumn TableColumn;

    /** Creates new form PanelStock */
    public PanelStock() {
        initComponents();
    //String[] columnNames = {"Nombre", "Demanda Anual", "Demanda Real"};

    //comboStock.addItem(ABORT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tResultadoComponentes = new org.jdesktop.swingx.JXTable();
        pBoton = new javax.swing.JPanel();
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        comboStock = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tResultadoComponentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Demanda Anual", "Demanda Real"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tResultadoComponentes.setEditable(false);
        jScrollPane1.setViewportView(tResultadoComponentes);

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        pBoton.add(btBuscar);

        btCancelar.setText("Aceptar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        pBoton.add(btCancelar);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        comboStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Stock Disponible", "Stock x Demanda Anual", "Stock x Demanda Real" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboStock, 0, 489, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(pBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
}//GEN-LAST:event_btCancelarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

        GestorStock objgs = new GestorStock();
        System.out.println("LLEGA!!!");
        if (comboStock.getSelectedItem() == "Stock Disponible") {
            String[] columnNames = {"Nombre", "Stock Disponible"};
            System.out.println("STOCK DISPONIBLE");
            List<ProductoComponente> listaProductos = objgs.calcularStockDisponible();
            //System.out.println("La cantidad de productos es " + listaProductos.size());
            for (ProductoComponente producto : listaProductos){
                System.out.println("El producto " + producto.getNombre() + " tiene" + producto.getStock() + " items en Stock");
            }
            this.inicializar(listaProductos, columnNames);

        }

        if (comboStock.getSelectedItem() == "Stock x Demanda Anual") {
            String[] columnNames = {"Nombre", "Stock x Demanda Anual"};
            List<ProductoComponente> listaProductos = objgs.calcularStockDemandaAnual();
            System.out.println("La cantidad de productos es " + listaProductos.size());
            this.inicializar(listaProductos, columnNames);

        }

        if (comboStock.getSelectedItem() == "Stock x Demanda Real") {
            String[] columnNames = {"Nombre", "Stock x Demanda Real"};
        }

        if (comboStock.getSelectedItem() == "") {
        }

        if (comboStock.getSelectedItem() == "") {
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void inicializar(List listaProductos, String[] columnNames) {
        tmBuscar = new ProductoGralTableModel(0);
        tResultadoComponentes.setModel(tmBuscar);
        tResultadoComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PanelStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox comboStock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pBoton;
    private org.jdesktop.swingx.JXTable tResultadoComponentes;
    // End of variables declaration//GEN-END:variables
}
