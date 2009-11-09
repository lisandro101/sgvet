package sgvet.igu;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import sgvet.entidades.PoliticaRevisionContinua;
import sgvet.entidades.PoliticaRevisionPeriodica;
import sgvet.igu.buscar.PanelBuscarProveedor;
import sgvet.utils.Util;
import sgvet.entidades.Proveedor;
import sgvet.gestores.GestorProveedor;
import sgvet.igu.buscar.PanelBuscarProductoGral.Tipo;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.IValidable;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelProveedor extends javax.swing.JPanel implements IValidable {

    private static final long serialVersionUID = 1L;
    private Proveedor proveedor;
    private List<Component> componentesObligatorios;
    int cantidadCambios;

    /** Creates new form PanelProveedor */
    public PanelProveedor() {
        initComponents();
        inicializarBotones();
        componentesObligatorios = Arrays.asList((Component) tfNombre);
    }

    private void inicializarBotones() {
        btAgregar.setEnabled(true);
        btEliminar.setEnabled(false);
        btModificar.setEnabled(false);
        btParametros.setVisible(false);
        
    }

    private void pantallaCargadaBotones() {
        btAgregar.setEnabled(false);
        btModificar.setEnabled(true);
        btEliminar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfContacto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        tfMail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dpInicioActividades = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbPolitica = new javax.swing.JComboBox();
        btParametros = new javax.swing.JButton();
        pBotones = new javax.swing.JPanel();
        btBuscar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();

        jLabel1.setText("Nombre");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Contacto");

        jLabel3.setText("Telefono");

        jLabel4.setText("e-mail");

        jLabel5.setText("Direccion");

        dpInicioActividades.setFormats("dd/MM/yy");
        dpInicioActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpInicioActividadesActionPerformed(evt);
            }
        });

        jLabel6.setText("Inicio Actividades ");

        jLabel7.setText("Politica de Stock:");

        cbPolitica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Politica (s,Q)", "Politica (S,R)" }));
        cbPolitica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPoliticaItemStateChanged(evt);
            }
        });

        btParametros.setText("Definir");
        btParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParametrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pCamposLayout = new javax.swing.GroupLayout(pCampos);
        pCampos.setLayout(pCamposLayout);
        pCamposLayout.setHorizontalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(tfContacto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(tfMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(dpInicioActividades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCamposLayout.createSequentialGroup()
                        .addComponent(cbPolitica, 0, 253, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btParametros)))
                .addContainerGap())
        );
        pCamposLayout.setVerticalGroup(
            pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamposLayout.createSequentialGroup()
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(tfContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpInicioActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPolitica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btParametros))
                .addContainerGap(103, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfNombreActionPerformed

private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

    PanelBuscarProveedor buscarProv = new PanelBuscarProveedor(this, Tipo.PANEL_PROVEEDOR);
    buscarProv.setModal(true);
    buscarProv.setVisible(true);

}//GEN-LAST:event_btBuscarActionPerformed

private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
    if (ValidacionBuscar.getInstancia().existenCamposVacios(this)) {
        JOptionPane.showMessageDialog(this, "Existen campos sin completar");
    } else {
        proveedor = crearProveedor();
        if (ValidacionBuscar.getInstancia().estaDuplicado(proveedor)) {
            JOptionPane.showMessageDialog(this, "El proveedor ya se encuentra registrado");
        } else {
            FachadaPersistencia.getInstancia().grabar(proveedor, true);
            Util.getInstancia().limpiarCampos(pCampos);
            proveedor = null;
        }
    }
}//GEN-LAST:event_btAgregarActionPerformed

private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed

    if (!GestorProveedor.getInstancia().sePuedeEliminar(proveedor)) {
        JOptionPane.showMessageDialog(this, "No se puede eliminar el proveedor, se encuentra asignado");
    } else {
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro desea eliminar al Proveedor?", "Aceptar",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            FachadaPersistencia.getInstancia().borrar(proveedor, true);
            Util.getInstancia().limpiarCampos(this);
            proveedor = null;
            inicializarBotones();
        }
    }

}//GEN-LAST:event_btEliminarActionPerformed

private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed

    int opcion = JOptionPane.showConfirmDialog(this,
            "¿Seguro desea guardar los cambios?", "Aceptar",
            JOptionPane.YES_NO_OPTION);

    if (opcion == JOptionPane.YES_OPTION) {
        actualizarProveedor();
        FachadaPersistencia.getInstancia().actualizar(proveedor, true);
        Util.getInstancia().limpiarCampos(pCampos);
        proveedor = null;
        inicializarBotones();
    }


}//GEN-LAST:event_btModificarActionPerformed

private void dpInicioActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpInicioActividadesActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_dpInicioActividadesActionPerformed

private void btParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParametrosActionPerformed
    
    if(cbPolitica.getSelectedIndex() == 1) {
        PanelRevisionContinua revisionContinua = new PanelRevisionContinua();
        revisionContinua.setModal(true);
        revisionContinua.setVisible(true);
    }
    else if (cbPolitica.getSelectedIndex() == 2){
        PanelRevisionPeriodica revisionPeriodica = new PanelRevisionPeriodica();
        revisionPeriodica.setModal(true);
        revisionPeriodica.setVisible(true);
    }

}//GEN-LAST:event_btParametrosActionPerformed

private void cbPoliticaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPoliticaItemStateChanged

    if(cbPolitica.getSelectedIndex() == 0) {
        btParametros.setVisible(false);
    }
    else {
        btParametros.setVisible(true);
    }
    
}//GEN-LAST:event_cbPoliticaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btParametros;
    private javax.swing.JComboBox cbPolitica;
    private org.jdesktop.swingx.JXDatePicker dpInicioActividades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pCampos;
    private javax.swing.JTextField tfContacto;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfMail;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables

    private Proveedor crearProveedor() {
        proveedor = new Proveedor();

        proveedor.setNombre(tfNombre.getText());
        proveedor.setNombreContacto(tfContacto.getText());
        proveedor.setTelefono(tfTelefono.getText());
        proveedor.setMail(tfMail.getText());
        proveedor.setDireccion(tfDireccion.getText());
        proveedor.setFechaInicioActividad(dpInicioActividades.getDate());

        if (cbPolitica.getSelectedItem().toString().equals("Politica (s,Q)")) {
            proveedor.setPolitica(new PoliticaRevisionContinua());
        } else if (cbPolitica.getSelectedItem().toString().equals("Politica (S,R)")) {
            proveedor.setPolitica(new PoliticaRevisionPeriodica());
        }

        return proveedor;
    }

    private void cargarPantallaProveedor(Proveedor prov) {
        tfNombre.setText(prov.getNombre());
        tfContacto.setText(prov.getNombreContacto());
        tfTelefono.setText(prov.getTelefono());
        tfMail.setText(prov.getMail());
        tfDireccion.setText(prov.getDireccion());
        dpInicioActividades.setDate(prov.getFechaInicioActividad());

        pantallaCargadaBotones();

    }

    public void setProveedor(Proveedor prov) {
        proveedor = prov;
        cargarPantallaProveedor(prov);

    }

    private void actualizarProveedor() {

        proveedor.setNombre(tfNombre.getText());
        proveedor.setNombreContacto(tfContacto.getText());
        proveedor.setTelefono(tfTelefono.getText());
        proveedor.setMail(tfMail.getText());
        proveedor.setDireccion(tfDireccion.getText());
        proveedor.setFechaInicioActividad(dpInicioActividades.getDate());

    }

    @Override
    public List<Component> getComponentesObligatorios() {
        return componentesObligatorios;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
}
