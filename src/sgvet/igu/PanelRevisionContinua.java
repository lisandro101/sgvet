package sgvet.igu;

import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import sgvet.entidades.PoliticaRevisionContinua;
import sgvet.entidades.Proveedor;
import sgvet.gestores.GestorValidacion;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.persistencia.FachadaPersistencia;
import sgvet.utils.*;

/**
 *
 * @author  Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelRevisionContinua extends javax.swing.JDialog implements IValidable {

    private static final long serialVersionUID = 1L;
    PoliticaRevisionContinua politica;
    Proveedor proveedor;

    public PanelRevisionContinua(Proveedor prov) {

        initComponents();
        proveedor = prov;
        
        if(prov.getPolitica() instanceof PoliticaRevisionContinua ){
            politica= (PoliticaRevisionContinua)prov.getPolitica();
        }else{
            politica= null;
        }

        inicializar();
    }

    private void inicializar() {

        cargarPantalla();
        tfNombre.setText(proveedor.getNombre());
        tfCodigo.setText(proveedor.getCodigo());

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errores = new javax.swing.ButtonGroup();
        pBotones = new javax.swing.JPanel();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pProducto = new javax.swing.JPanel();
        pProveedor = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jpPolitica = new javax.swing.JPanel();
        lbAlfa = new javax.swing.JLabel();
        tfCostoEmision = new javax.swing.JTextField();
        tfDesviacionDemanda = new javax.swing.JTextField();
        lbBeta = new javax.swing.JLabel();
        lbPrediccion = new javax.swing.JLabel();
        tfTasaAlmacenamiento = new javax.swing.JTextField();
        tfNivelServicio = new javax.swing.JTextField();
        lbDemandaAcumulada = new javax.swing.JLabel();
        jpRevisionContinua = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfPrediccionDemanda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfTiempoEntrega = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Demanda");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });
        pBotones.add(btAceptar);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        pBotones.add(btCancelar);

        pProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

        lbCodigo.setText("Código:");

        lbNombre.setText("Nombre:");

        tfCodigo.setEnabled(false);

        tfNombre.setEnabled(false);

        javax.swing.GroupLayout pProveedorLayout = new javax.swing.GroupLayout(pProveedor);
        pProveedor.setLayout(pProveedorLayout);
        pProveedorLayout.setHorizontalGroup(
            pProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(lbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
                .addContainerGap())
        );
        pProveedorLayout.setVerticalGroup(
            pProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProveedorLayout.createSequentialGroup()
                .addGroup(pProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pProductoLayout = new javax.swing.GroupLayout(pProducto);
        pProducto.setLayout(pProductoLayout);
        pProductoLayout.setHorizontalGroup(
            pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pProductoLayout.setVerticalGroup(
            pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpPolitica.setBorder(javax.swing.BorderFactory.createTitledBorder("Politica"));

        lbAlfa.setText("Costo de Emision:");

        tfCostoEmision.setText("2");
        tfCostoEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCostoEmisionActionPerformed(evt);
            }
        });

        tfDesviacionDemanda.setText("80");
        tfDesviacionDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDesviacionDemandaActionPerformed(evt);
            }
        });

        lbBeta.setText("Desviacion Demanda:");

        lbPrediccion.setText("Tasa Almacenamiento:");

        tfTasaAlmacenamiento.setText("0.2");

        tfNivelServicio.setText("99");

        lbDemandaAcumulada.setText("Nivel de Servicio:");

        jpRevisionContinua.setBorder(javax.swing.BorderFactory.createTitledBorder("Revision Continua"));

        jLabel1.setText("Prediccion de la Demanda:");

        tfPrediccionDemanda.setText("0");
        tfPrediccionDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrediccionDemandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRevisionContinuaLayout = new javax.swing.GroupLayout(jpRevisionContinua);
        jpRevisionContinua.setLayout(jpRevisionContinuaLayout);
        jpRevisionContinuaLayout.setHorizontalGroup(
            jpRevisionContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRevisionContinuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPrediccionDemanda, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpRevisionContinuaLayout.setVerticalGroup(
            jpRevisionContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRevisionContinuaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRevisionContinuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfPrediccionDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jLabel4.setText("Tiempo de Entrega:");

        tfTiempoEntrega.setText("3");

        javax.swing.GroupLayout jpPoliticaLayout = new javax.swing.GroupLayout(jpPolitica);
        jpPolitica.setLayout(jpPoliticaLayout);
        jpPoliticaLayout.setHorizontalGroup(
            jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPoliticaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPrediccion)
                    .addComponent(lbDemandaAcumulada)
                    .addComponent(lbAlfa)
                    .addComponent(lbBeta)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTiempoEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(tfNivelServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(tfTasaAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(tfCostoEmision, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(tfDesviacionDemanda, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addComponent(jpRevisionContinua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPoliticaLayout.setVerticalGroup(
            jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPoliticaLayout.createSequentialGroup()
                .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPoliticaLayout.createSequentialGroup()
                        .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbAlfa)
                            .addComponent(tfCostoEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbBeta)
                            .addComponent(tfDesviacionDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDemandaAcumulada)
                            .addComponent(tfNivelServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPrediccion)
                            .addComponent(tfTasaAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfTiempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpRevisionContinua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jpPolitica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(pBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPolitica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
    if (verificarCampos()) {
        if (politica == null) {
            crearPolitica();
        } else {
            actualizarPolitica();
        }

        dispose();
    }else{
        JOptionPane.showMessageDialog(this, "Campos Erroneos o Incompletos");
    }
}//GEN-LAST:event_btAceptarActionPerformed

private void tfCostoEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCostoEmisionActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfCostoEmisionActionPerformed

private void tfDesviacionDemandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDesviacionDemandaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfDesviacionDemandaActionPerformed

private void tfPrediccionDemandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrediccionDemandaActionPerformed
    if(tfPrediccionDemanda.getText().trim().equals("0")){
        tfTiempoEntrega.setEditable(true);
    }else{
        tfTiempoEntrega.setEditable(false);
    }
}//GEN-LAST:event_tfPrediccionDemandaActionPerformed

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    dispose();
}//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.ButtonGroup errores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpPolitica;
    private javax.swing.JPanel jpRevisionContinua;
    private javax.swing.JLabel lbAlfa;
    private javax.swing.JLabel lbBeta;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDemandaAcumulada;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrediccion;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pProducto;
    private javax.swing.JPanel pProveedor;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCostoEmision;
    private javax.swing.JTextField tfDesviacionDemanda;
    private javax.swing.JTextField tfNivelServicio;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPrediccionDemanda;
    private javax.swing.JTextField tfTasaAlmacenamiento;
    private javax.swing.JTextField tfTiempoEntrega;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Component> getComponentesObligatorios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private double redondear(double valor) {
        return (Math.floor(valor * 100) / 100);
    }

    private void crearPolitica(){
        //if(verificarCampos()){
            politica = new PoliticaRevisionContinua();
            politica.setCostoEmision(Double.valueOf(tfCostoEmision.getText()));
            politica.setDesviacionEstandarDemanda(Double.valueOf(tfDesviacionDemanda.getText()));
            politica.setNivelServicio(Double.parseDouble(tfNivelServicio.getText()));
            politica.setPrediccionDemanda(Double.parseDouble(tfPrediccionDemanda.getText()));            
            politica.setTasaAnualAlmacenamiento(Double.parseDouble(tfTasaAlmacenamiento.getText()));
            politica.setTiempoEntrega(Integer.parseInt(tfTiempoEntrega.getText()));
            politica.setProveedor(proveedor);
            proveedor.setPolitica(politica);
        //}
    }

    private void actualizarPolitica(){
        if(verificarCampos()){
            politica.setCostoEmision(Double.valueOf(tfCostoEmision.getText()));
            politica.setDesviacionEstandarDemanda(Double.valueOf(tfDesviacionDemanda.getText()));
            politica.setNivelServicio(Double.parseDouble(tfNivelServicio.getText()));
            politica.setPrediccionDemanda(Double.parseDouble(tfPrediccionDemanda.getText()));
            politica.setTasaAnualAlmacenamiento(Double.parseDouble(tfTasaAlmacenamiento.getText()));
            politica.setTiempoEntrega(Integer.parseInt(tfTiempoEntrega.getText()));
            politica.setProveedor(proveedor);
            proveedor.setPolitica(politica);
        }
    }

    
    private boolean verificarCampos(){
        int resul = 0;
        if(!ValidacionBuscar.getInstancia().existenCamposVacios(this)){
            if(!GestorValidacion.getInstancia().isCamposNumericosValidos(jpPolitica)){
                ++resul;
            }            
        }else{
            ++resul;
        }
        if(resul>0){
            return false;
        }else{
            return true;
        }
    }

    private void cargarPantalla(){
        if(politica != null){
            tfCostoEmision.setText(politica.getCostoEmision()+"");
            tfDesviacionDemanda.setText(politica.getDesviacionEstandarDemanda()+"");
            tfNivelServicio.setText(politica.getNivelServicio()+"");
            tfPrediccionDemanda.setText(politica.getPrediccionDemanda()+"");
            tfTasaAlmacenamiento.setText(politica.getTasaAnualAlmacenamiento()+"");
            tfTiempoEntrega.setText(politica.getTiempoEntrega()+"");
            
        }
    }
}

