package sgvet.igu;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXList;
import org.jdesktop.swingx.JXTable;
import sgvet.igu.model.IModeloReiniciable;

/**
 *
 * @author  stafoxter
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private static final long serialVersionUID = 0;
    private int tabVieja = 0;
    private int tabNueva;
    private PanelProveedor panelProveedor;
    private PanelProductoComponente panelProductoComponente;
    private PanelOrdenCompra panelOrdenCompra;
    private PanelOrdenProduccion panelOrdenProduccion;

    /** Creates new form PantallaPrincipal */
    public PantallaPrincipal() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        panelProveedor = new PanelProveedor();
        panelProductoComponente = new PanelProductoComponente();
        panelOrdenCompra = new PanelOrdenCompra();
        panelOrdenProduccion = new PanelOrdenProduccion();

        jTabbedPane1.add("     Proveedor     ", panelProveedor);
        jTabbedPane1.add("      Producto     ", panelProductoComponente);
        jTabbedPane1.add("       Venta       ", panelOrdenProduccion);
        jTabbedPane1.add("    Orden Compra   ", panelOrdenCompra);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        menu = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        demanda = new javax.swing.JMenu();
        curvaABC = new javax.swing.JMenuItem();
        jmiSenialRastreo = new javax.swing.JMenuItem();
        configuracion = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenu();
        verReportes = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Veterinaria");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        archivo.setText("Archivo");

        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        archivo.add(salir);

        menu.add(archivo);

        demanda.setText("Demanda");
        demanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandaActionPerformed(evt);
            }
        });

        curvaABC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        curvaABC.setText("Calcular Curva ABC");
        curvaABC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curvaABCActionPerformed(evt);
            }
        });
        demanda.add(curvaABC);

        jmiSenialRastreo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiSenialRastreo.setText("Señal de Rastreo");
        jmiSenialRastreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSenialRastreoActionPerformed(evt);
            }
        });
        demanda.add(jmiSenialRastreo);

        menu.add(demanda);

        configuracion.setText("Configuración");
        configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionActionPerformed(evt);
            }
        });

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Parámetros");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        configuracion.add(jMenuItem3);

        menu.add(configuracion);

        reportes.setText("Reportes");

        verReportes.setText("Ver");
        verReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verReportesActionPerformed(evt);
            }
        });
        reportes.add(verReportes);

        menu.add(reportes);

        ayuda.setText("Ayuda");
        menu.add(ayuda);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    salir();
}//GEN-LAST:event_formWindowClosing

private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
    tabNueva = jTabbedPane1.getSelectedIndex();

    if (tabVieja != tabNueva) {

        switch (tabVieja) {
            case 1:
                if (panelProductoComponente.getProductoComponente() == null) {
                    limpiarCampos(panelProductoComponente);
                } else {
                    guardarInfoPanel(panelProductoComponente);
                    limpiarCampos(panelProductoComponente);
                }
                break;
            case 4:
                if (panelOrdenCompra.getOrdenCompra() == null) {
                    limpiarCampos(panelOrdenCompra);
                } else {
                    guardarInfoPanel(panelOrdenCompra);
                    limpiarCampos(panelOrdenCompra);
                }
                break;
            case 5:
                if (panelOrdenProduccion.getOrdenProduccion() == null) {
                    limpiarCampos(panelOrdenProduccion);
                } else {
                    guardarInfoPanel(panelOrdenProduccion);
                    limpiarCampos(panelOrdenProduccion);
                }
                break;
            case 7:
                if (panelProveedor.getProveedor() == null) {
                    limpiarCampos(panelProveedor);
                } else {
                    guardarInfoPanel(panelProveedor);
                    limpiarCampos(panelProveedor);
                }
                break;
            default:
                break;
        }

        tabVieja = tabNueva;
    }
}//GEN-LAST:event_jTabbedPane1MouseClicked

private void verReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verReportesActionPerformed
    DialogoReportes dialogoReportes = new DialogoReportes(this, true);

    dialogoReportes.setLocationRelativeTo(null);
    dialogoReportes.setVisible(true);
}//GEN-LAST:event_verReportesActionPerformed

private void demandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandaActionPerformed
}//GEN-LAST:event_demandaActionPerformed

private void curvaABCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curvaABCActionPerformed
    PanelCurvaABC panelABC = new PanelCurvaABC(this, rootPaneCheckingEnabled);
    panelABC.setLocationRelativeTo(this);
    panelABC.setVisible(true);

}//GEN-LAST:event_curvaABCActionPerformed

private void configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionActionPerformed
}//GEN-LAST:event_configuracionActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    PanelConfiguracion panelConf = new PanelConfiguracion(this, true);
    panelConf.setLocationRelativeTo(this);
    panelConf.setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
    salir();
}//GEN-LAST:event_salirActionPerformed

private void jmiSenialRastreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSenialRastreoActionPerformed
    PanelSenialRastreo panelSR = new PanelSenialRastreo(this, true);
    panelSR.setLocationRelativeTo(this);
    panelSR.setVisible(true);
}//GEN-LAST:event_jmiSenialRastreoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenu configuracion;
    private javax.swing.JMenuItem curvaABC;
    private javax.swing.JMenu demanda;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem jmiSenialRastreo;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu reportes;
    private javax.swing.JMenuItem salir;
    private javax.swing.JMenuItem verReportes;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea salir?", "Salir",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Limpia los campos de un panel
     * 
     * @param contenedor Panel que se desea limpiar
     */
    private void limpiarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(0);
            } else if (componente instanceof JXDatePicker) {
                ((JXDatePicker) componente).setDate(null);
            } else if (componente instanceof JXTable) {
                ((IModeloReiniciable) ((JXTable) componente).getModel()).reiniciar();
            } else if (componente instanceof JXList) {
                ((IModeloReiniciable) ((JXList) componente).getModel()).reiniciar();
            } else if (componente instanceof Container) {
                limpiarCampos((Container) componente);
            }
        }
    }

    private void avisoPanelCargado(Container contenedor) {
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea guardar cambios?", "No",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            for (Component componente : contenedor.getComponents()) {
                if (componente instanceof JButton) {
                    if (((JButton) componente).getText().equals("Modificar")) {
                        ((JButton) componente).doClick();
                    }
                }
            }
            limpiarCampos(contenedor);
        } else {
            limpiarCampos(contenedor);
        }
    }

    private void guardarInfoPanel(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JButton) {
                if (((JButton) componente).getText().equals("Modificar")) {
                    ((JButton) componente).doClick();
                }
            }
        }
    }
}
