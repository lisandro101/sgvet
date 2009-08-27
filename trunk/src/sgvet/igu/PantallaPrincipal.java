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
    private PanelMateriaPrima panelMateriaPrima;
    private PanelProductoTerminado panelProductoTerminado;
    private PanelEmpleado panelEmpleado;   
    private PanelOrdenProduccion panelOrdenProduccion;
    private PanelMaquina panelMaquina; 
    private PanelEstructuraDeProducto panelEstructuraDeProducto;
    private PanelRutaFabricacion panelRutaFabricacion;
    private PanelCentroTrabajo panelCentroTrabajo;

    /** Creates new form PantallaPrincipal */
    public PantallaPrincipal() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        panelProveedor = new PanelProveedor();
        panelProductoComponente = new PanelProductoComponente();
        panelOrdenCompra = new PanelOrdenCompra();
//        panelMateriaPrima = new PanelMateriaPrima();
//        panelProductoTerminado = new PanelProductoTerminado();
//        panelEmpleado = new PanelEmpleado();        
//        panelOrdenProduccion = new PanelOrdenProduccion();
//        panelMaquina = new PanelMaquina();
//        panelEstructuraDeProducto = new PanelEstructuraDeProducto();
//        panelRutaFabricacion = new PanelRutaFabricacion();
//        panelCentroTrabajo = new PanelCentroTrabajo();

        jTabbedPane1.add("     Proveedor     ", panelProveedor);
        jTabbedPane1.add("      Producto     ", panelProductoComponente);
        jTabbedPane1.add("   Orden Compra    ", panelOrdenCompra);
//        jTabbedPane1.add("   Materia Prima   ", panelMateriaPrima);
//        jTabbedPane1.add("Producto Componente", panelProductoComponente);
//        jTabbedPane1.add("Producto Terminado ", panelProductoTerminado);
//        jTabbedPane1.add("     Personal      ", panelEmpleado);
//        jTabbedPane1.add(" Orden Producción  ", panelOrdenProduccion);
//        jTabbedPane1.add("    Maquinaria     ", panelMaquina);
//        jTabbedPane1.add("    Estructura     ", panelEstructuraDeProducto);
//        jTabbedPane1.add("       Ruta        ", panelRutaFabricacion);
//        jTabbedPane1.add("  Centro Trabajo   ", panelCentroTrabajo);
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
        costos = new javax.swing.JMenu();
        costoFijo = new javax.swing.JMenuItem();
        costoVariable = new javax.swing.JMenuItem();
        puntoEquilibrio = new javax.swing.JMenuItem();
        inventario = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        indices = new javax.swing.JMenu();
        calcularIndices = new javax.swing.JMenuItem();
        demanda = new javax.swing.JMenu();
        prediccionDemanda = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenu();
        verReportes = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Fabrica Radiadores");
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
        menu.add(archivo);

        costos.setText("Costos");

        costoFijo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        costoFijo.setText("Costo Fijo");
        costoFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoFijoActionPerformed(evt);
            }
        });
        costos.add(costoFijo);

        costoVariable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        costoVariable.setText("Costo Variable");
        costoVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoVariableActionPerformed(evt);
            }
        });
        costos.add(costoVariable);

        puntoEquilibrio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        puntoEquilibrio.setText("Punto Equilibrio");
        puntoEquilibrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntoEquilibrioActionPerformed(evt);
            }
        });
        costos.add(puntoEquilibrio);

        menu.add(costos);

        inventario.setText("Inventario");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Calcular");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        inventario.add(jMenuItem1);

        menu.add(inventario);

        indices.setText("Indices");

        calcularIndices.setText("Calcular");
        calcularIndices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularIndicesActionPerformed(evt);
            }
        });
        indices.add(calcularIndices);

        menu.add(indices);

        demanda.setText("Demanda");

        prediccionDemanda.setText("Predicción de la demanda");
        prediccionDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prediccionDemandaActionPerformed(evt);
            }
        });
        demanda.add(prediccionDemanda);

        menu.add(demanda);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
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
            case 0:
                if (panelMateriaPrima.getMateriaPrima() == null) {
                    limpiarCampos(panelMateriaPrima);
                } else {
//                    avisoPanelCargado(panelMateriaPrima);
                    guardarInfoPanel(panelMateriaPrima);
                    limpiarCampos(panelMateriaPrima);
                }
                break;
            case 1:
                if (panelProductoComponente.getProductoComponente() == null) {
                    limpiarCampos(panelProductoComponente);
                } else {
                    guardarInfoPanel(panelProductoComponente);
                    limpiarCampos(panelProductoComponente);
                }
                break;
            case 2:
                if (panelProductoTerminado.getProductoTerminado() == null) {
                    limpiarCampos(panelProductoTerminado);
                } else {
                    guardarInfoPanel(panelProductoTerminado);
                    limpiarCampos(panelProductoTerminado);
                }
                break;
            case 3:
                if (panelEmpleado.getEmpleado() == null) {
                    limpiarCampos(panelEmpleado);
                } else {
                    guardarInfoPanel(panelEmpleado);
                    limpiarCampos(panelEmpleado);
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
            case 6:
                if (panelMaquina.getMaquina() == null) {
                    limpiarCampos(panelMaquina);
                } else {
                    guardarInfoPanel(panelMaquina);
                    limpiarCampos(panelMaquina);
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
            case 8:
                if (panelEstructuraDeProducto.getEstructuraDeProducto() == null) {
                    limpiarCampos(panelEstructuraDeProducto);
                } else {
                    guardarInfoPanel(panelEstructuraDeProducto);
                    limpiarCampos(panelEstructuraDeProducto);
                }
                break;
            case 9:
                if (panelRutaFabricacion.getRutaFabricacion() == null) {
                    limpiarCampos(panelRutaFabricacion);
                } else {
                    guardarInfoPanel(panelRutaFabricacion);
                    limpiarCampos(panelRutaFabricacion);
                }
                break;
            case 10:
                if (panelCentroTrabajo.getCentroDeTrabajo() == null) {
                    limpiarCampos(panelCentroTrabajo);
                } else {
                    guardarInfoPanel(panelCentroTrabajo);
                    limpiarCampos(panelCentroTrabajo);
                }
                break;
            default:
                break;
        }

        tabVieja = tabNueva;
    }
}//GEN-LAST:event_jTabbedPane1MouseClicked

private void costoFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoFijoActionPerformed
    PanelCostoFijo panelCostoFijo = new PanelCostoFijo();
    panelCostoFijo.setModal(true);
    panelCostoFijo.setVisible(true);
}//GEN-LAST:event_costoFijoActionPerformed

private void costoVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoVariableActionPerformed
    PanelCostoVariable panelCostoVariable = new PanelCostoVariable();
    panelCostoVariable.setModal(true);
    panelCostoVariable.setVisible(true);
}//GEN-LAST:event_costoVariableActionPerformed

private void puntoEquilibrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntoEquilibrioActionPerformed
    PanelPuntoEquilibrio panelCostoVariable = new PanelPuntoEquilibrio();
    panelCostoVariable.setModal(true);
    panelCostoVariable.setVisible(true);
}//GEN-LAST:event_puntoEquilibrioActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    PanelInventario panelInventario = new PanelInventario();
    panelInventario.setModal(true);
    panelInventario.setVisible(true);
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void calcularIndicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularIndicesActionPerformed
    PanelIndices panelIndices = new PanelIndices();

    panelIndices.setLocationRelativeTo(this);
    panelIndices.setVisible(true);
}//GEN-LAST:event_calcularIndicesActionPerformed

private void prediccionDemandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prediccionDemandaActionPerformed
    PanelDemanda panelDemanda = new PanelDemanda();
    panelDemanda.setModal(true);
    panelDemanda.setLocationRelativeTo(null);
    panelDemanda.setVisible(true);
}//GEN-LAST:event_prediccionDemandaActionPerformed

private void verReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verReportesActionPerformed
    DialogoReportes dialogoReportes = new DialogoReportes(this, true);

    dialogoReportes.setLocationRelativeTo(null);
    dialogoReportes.setVisible(true);
}//GEN-LAST:event_verReportesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenuItem calcularIndices;
    private javax.swing.JMenuItem costoFijo;
    private javax.swing.JMenuItem costoVariable;
    private javax.swing.JMenu costos;
    private javax.swing.JMenu demanda;
    private javax.swing.JMenu indices;
    private javax.swing.JMenu inventario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem prediccionDemanda;
    private javax.swing.JMenuItem puntoEquilibrio;
    private javax.swing.JMenu reportes;
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
