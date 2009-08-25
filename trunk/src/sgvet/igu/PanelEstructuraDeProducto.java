package sgvet.igu;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import sgvet.entidades.Componente;
import sgvet.entidades.EstructuraDeProducto;
import sgvet.entidades.ParteDeEstructura;
import sgvet.entidades.ProductoTerminado;
import sgvet.igu.buscar.PanelBuscarProductoGral;
import sgvet.igu.buscar.PanelBuscarProductoGral.Tipo;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.igu.model.ComponenteEstructuraTableModel;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.IValidable;
import sgvet.utils.Util;

/**
 *
 * @author Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelEstructuraDeProducto extends javax.swing.JPanel implements IValidable{
    
    private static final long serialVersionUID = 1L;

    private ComponenteEstructuraTableModel tmComponente;
    private List<ParteDeEstructura> partesDeEstructuras;
    private ParteDeEstructura parteDeEstructura;
    private ProductoTerminado productoTerminado;
    private Componente componente;
    private EstructuraDeProducto estructuraDeProducto;
    private List<Component> componentesObligatorios;
    
    /** Creates new form PanelEstructuraDeProducto */
    public PanelEstructuraDeProducto() {
        initComponents();
        inicializar();
    }

    
    private void inicializar(){
        partesDeEstructuras = new ArrayList<ParteDeEstructura>();
        tmComponente = new ComponenteEstructuraTableModel(0);

        jtComponente.setModel(tmComponente);
        jtComponente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        componentesObligatorios = Arrays.asList((Component)tfCodigo);
        inicializarBotones();
    }

    private void inicializarBotones(){
        btBuscarComponente.setEnabled(false);
        btEliminar.setEnabled(false);
        btGuardar.setEnabled(false);
        btAgregarComponente.setEnabled(false);
        btEliminarComponente.setEnabled(false);
    }
    
    private void pantallaCargadaBotones(){
        btBuscarComponente.setEnabled(true);
        btGuardar.setEnabled(true);
        btEliminar.setEnabled(true);
        btAgregarComponente.setEnabled(true);
        btEliminarComponente.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pProductoTerminado = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        btBuscarProdTerminado = new javax.swing.JButton();
        pTablaComponentes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtComponente = new org.jdesktop.swingx.JXTable();
        jPanel5 = new javax.swing.JPanel();
        btAgregarComponente = new javax.swing.JButton();
        btEliminarComponente = new javax.swing.JButton();
        lbComponente = new javax.swing.JLabel();
        tfComponente = new javax.swing.JTextField();
        btBuscarComponente = new javax.swing.JButton();
        lbCantidad = new javax.swing.JLabel();
        tfCantidad = new javax.swing.JTextField();
        pBotones = new javax.swing.JPanel();
        btGuardar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();

        pProductoTerminado.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto Terminado"));

        lbCodigo.setText("Código:");

        lbNombre.setText("Nombre:");

        tfCodigo.setEnabled(false);

        tfNombre.setEnabled(false);

        btBuscarProdTerminado.setText("Buscar");
        btBuscarProdTerminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarProdTerminadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pProductoTerminadoLayout = new javax.swing.GroupLayout(pProductoTerminado);
        pProductoTerminado.setLayout(pProductoTerminadoLayout);
        pProductoTerminadoLayout.setHorizontalGroup(
            pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(lbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(pProductoTerminadoLayout.createSequentialGroup()
                        .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarProdTerminado)))
                .addContainerGap())
        );
        pProductoTerminadoLayout.setVerticalGroup(
            pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminadoLayout.createSequentialGroup()
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCodigo)
                    .addComponent(btBuscarProdTerminado)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pTablaComponentes.setBorder(javax.swing.BorderFactory.createTitledBorder("Componentes"));

        jtComponente.setModel(new javax.swing.table.DefaultTableModel(
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
                "Componente", "Unidad Medida", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtComponente);

        btAgregarComponente.setText("Agregar");
        btAgregarComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarComponenteActionPerformed(evt);
            }
        });
        jPanel5.add(btAgregarComponente);

        btEliminarComponente.setText("Eliminar");
        btEliminarComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarComponenteActionPerformed(evt);
            }
        });
        jPanel5.add(btEliminarComponente);

        lbComponente.setText("Nombre");

        tfComponente.setEditable(false);

        btBuscarComponente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgvet/images/lupa (3).jpg"))); // NOI18N
        btBuscarComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarComponenteActionPerformed(evt);
            }
        });

        lbCantidad.setText("Cantidad");

        javax.swing.GroupLayout pTablaComponentesLayout = new javax.swing.GroupLayout(pTablaComponentes);
        pTablaComponentes.setLayout(pTablaComponentesLayout);
        pTablaComponentesLayout.setHorizontalGroup(
            pTablaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaComponentesLayout.createSequentialGroup()
                .addGroup(pTablaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTablaComponentesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbComponente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfComponente, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscarComponente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaComponentesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaComponentesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pTablaComponentesLayout.setVerticalGroup(
            pTablaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTablaComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pTablaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbComponente)
                    .addComponent(tfComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarComponente)
                    .addComponent(lbCantidad)
                    .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        pBotones.add(btGuardar);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pProductoTerminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pTablaComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProductoTerminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pTablaComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
    int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro desea guardar los cambios?", "Aceptar",
                JOptionPane.YES_NO_OPTION);
        
    if(opcion == JOptionPane.YES_OPTION) {
        actualizarEstructuraProducto();
        FachadaPersistencia.getInstancia().actualizar(estructuraDeProducto, true);
        Util.getInstancia().limpiarCampos(this);
        estructuraDeProducto=null;            
        inicializarBotones();
    }
}//GEN-LAST:event_btGuardarActionPerformed

private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
    if (ValidacionEliminar.getInstancia().estructuraEstaRelacionada(estructuraDeProducto)) {
            JOptionPane.showMessageDialog(this, "No puede eliminar la Estructura, posee una ruta asociada. ");
        }
    else {
        int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Seguro desea eliminar la Estructura?", "Aceptar",
                    JOptionPane.YES_NO_OPTION);

        if(opcion == JOptionPane.YES_OPTION) {
            estructuraDeProducto.setBorrado(true);
            FachadaPersistencia.getInstancia().actualizar(estructuraDeProducto, true);
            Util.getInstancia().limpiarCampos(this);
            estructuraDeProducto=null;
            inicializarBotones();
        }
    }
}//GEN-LAST:event_btEliminarActionPerformed

private void btBuscarProdTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdTerminadoActionPerformed
     PanelBuscarProductoGral buscarProv = new PanelBuscarProductoGral(this, Tipo.PANEL_ESTRUCTURA);   
     buscarProv.setModal(true);
     buscarProv.setVisible(true);
}//GEN-LAST:event_btBuscarProdTerminadoActionPerformed

private void btAgregarComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarComponenteActionPerformed
        if(componente == null || tfCantidad.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Existen campos vacios");
        }else{
            parteDeEstructura = new ParteDeEstructura();
            parteDeEstructura.setCantidad(Double.parseDouble(tfCantidad.getText()));
            parteDeEstructura.setComponente(componente);
            
            if(ValidacionBuscar.getInstancia().parteNodoEstructuraEstaCargadaEnTabla(tmComponente, componente)){
                    JOptionPane.showMessageDialog(this, "El Componente ya se encuentra asignado");
            }else{
                
                tmComponente.agregarFila(parteDeEstructura);
                
            }
        }
}//GEN-LAST:event_btAgregarComponenteActionPerformed

private void btEliminarComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarComponenteActionPerformed
int filaSeleccionada = jtComponente.convertRowIndexToModel(jtComponente.getSelectedRow());
    if(filaSeleccionada == -1){
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Componente");
    }else{
        FachadaPersistencia.getInstancia().borrarFisico(tmComponente.getFila(filaSeleccionada), true);
        tmComponente.eliminarFila(filaSeleccionada);
        
    }
}//GEN-LAST:event_btEliminarComponenteActionPerformed

private void btBuscarComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarComponenteActionPerformed
        PanelBuscarProductoGral buscarComponente = new PanelBuscarProductoGral(this, Tipo.PANEL_DETALLE_ESTRUCTURA);
        buscarComponente.setModal(true); 
        buscarComponente.setVisible(true);
}//GEN-LAST:event_btBuscarComponenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarComponente;
    private javax.swing.JButton btBuscarComponente;
    private javax.swing.JButton btBuscarProdTerminado;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEliminarComponente;
    private javax.swing.JButton btGuardar;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable jtComponente;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbComponente;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pProductoTerminado;
    private javax.swing.JPanel pTablaComponentes;
    private javax.swing.JTextField tfCantidad;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfComponente;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables

    public void setProductoTerminado(ProductoTerminado prod){
        Util.getInstancia().limpiarCampos(this);
        productoTerminado=prod;
        tfCodigo.setText(productoTerminado.getCodigo());
        tfNombre.setText(productoTerminado.getNombre()); 
        pantallaCargadaBotones();
        
    }
    public void setEstructura(EstructuraDeProducto estructura){
        Util.getInstancia().limpiarCampos(this);
        estructuraDeProducto= estructura;
        productoTerminado = estructura.getProductoTerminado();
        partesDeEstructuras= estructura.getPartes();
        
        tfCodigo.setText(productoTerminado.getCodigo());
        tfNombre.setText(productoTerminado.getNombre()); 
        tmComponente.agregarFilas(partesDeEstructuras);
        pantallaCargadaBotones();
        
    }
    
    
    public void setComponente(Componente con){
        componente=con;
        tfComponente.setText(componente.getNombre());
        tfCantidad.setText("");
        pantallaCargadaBotones();
    }
    
    public ComponenteEstructuraTableModel getTableModelComponente(){
        return tmComponente;
    }

    private EstructuraDeProducto crearEstructuraProducto(){
        estructuraDeProducto = new EstructuraDeProducto();
        
        partesDeEstructuras= tmComponente.getFilas();
        
        for (ParteDeEstructura parteDeEstructura1 : partesDeEstructuras) {
                parteDeEstructura1.setEstructura(estructuraDeProducto);
        }
        estructuraDeProducto.setPartes(partesDeEstructuras);
        estructuraDeProducto.setProductoTerminado(productoTerminado);
        return estructuraDeProducto;
    }
    private void actualizarEstructuraProducto(){
        partesDeEstructuras= tmComponente.getFilas();
        
        for (ParteDeEstructura parteDeEstructura1 : partesDeEstructuras) {
                parteDeEstructura1.setEstructura(estructuraDeProducto);
        }
        estructuraDeProducto.setPartes(partesDeEstructuras);
        estructuraDeProducto.setProductoTerminado(productoTerminado);
    }

    @Override
    public List<Component> getComponentesObligatorios() {
        return componentesObligatorios;
    }

    public EstructuraDeProducto getEstructuraDeProducto() {
        return estructuraDeProducto;
    }
    
    
}
