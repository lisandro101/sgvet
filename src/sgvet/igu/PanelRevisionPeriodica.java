package sgvet.igu;

import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import sgvet.entidades.Politica;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorValidacion;
import sgvet.igu.buscar.ValidacionBuscar;
import sgvet.utils.*;

/**
 *
 * @author  Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelRevisionPeriodica extends javax.swing.JDialog implements IValidable {

    private static final long serialVersionUID = 1L;
    Politica politica;
    ProductoComponente producto;

    /** Creates new form PanelCargoEmpleado
     * @param prod
     */
    public PanelRevisionPeriodica(ProductoComponente prod) {

        initComponents();
        producto = prod;

        if (prod.getPolitica() != null) {
            if (prod.getPolitica().getTipoPolitica().equals(Politica.TipoPolitica.PERIODICA)) {
                politica = prod.getPolitica();
            } else {
                politica = null;
            }
        } else {
            politica = null;
        }

        inicializar();


    }

    private void inicializar() {
        cargarPantalla();
        tfNombre.setText(producto.getNombre());
        tfCodigo.setText(producto.getCodigo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errores = new javax.swing.ButtonGroup();
        pBotones = new javax.swing.JPanel();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pProducto = new javax.swing.JPanel();
        jpProveedor = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jpPolitica = new javax.swing.JPanel();
        lbAlfa = new javax.swing.JLabel();
        tfCostoEmision = new javax.swing.JTextField();
        lbBeta = new javax.swing.JLabel();
        tfDesviacionDemanda = new javax.swing.JTextField();
        lbDemandaAcumulada = new javax.swing.JLabel();
        tfNivelServicio = new javax.swing.JTextField();
        lbPrediccion = new javax.swing.JLabel();
        tfTasaAlmacenamiento = new javax.swing.JTextField();
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

        jpProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        lbCodigo.setText("Código:");

        lbNombre.setText("Nombre:");

        tfCodigo.setEnabled(false);

        tfNombre.setEnabled(false);

        javax.swing.GroupLayout jpProveedorLayout = new javax.swing.GroupLayout(jpProveedor);
        jpProveedor.setLayout(jpProveedorLayout);
        jpProveedorLayout.setHorizontalGroup(
            jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo)
                    .addComponent(lbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpProveedorLayout.setVerticalGroup(
            jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedorLayout.createSequentialGroup()
                .addGroup(jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(jpProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pProductoLayout.setVerticalGroup(
            pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpPolitica.setBorder(javax.swing.BorderFactory.createTitledBorder("Politica"));

        lbAlfa.setText("Costo de Emision:");

        tfCostoEmision.setText("2");
        tfCostoEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCostoEmisionActionPerformed(evt);
            }
        });

        lbBeta.setText("Desviacion Demanda:");

        tfDesviacionDemanda.setText("80");
        tfDesviacionDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDesviacionDemandaActionPerformed(evt);
            }
        });

        lbDemandaAcumulada.setText("Nivel de Servicio:");

        tfNivelServicio.setText("99");

        lbPrediccion.setText("Tasa Almacenamiento:");

        tfTasaAlmacenamiento.setText("0.2");

        jLabel4.setText("Tiempo de Entrega:");

        tfTiempoEntrega.setText("3");

        javax.swing.GroupLayout jpPoliticaLayout = new javax.swing.GroupLayout(jpPolitica);
        jpPolitica.setLayout(jpPoliticaLayout);
        jpPoliticaLayout.setHorizontalGroup(
            jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPoliticaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPrediccion)
                    .addComponent(lbDemandaAcumulada)
                    .addComponent(lbAlfa)
                    .addComponent(lbBeta)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTiempoEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(tfNivelServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(tfTasaAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(tfCostoEmision, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(tfDesviacionDemanda, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addGap(349, 349, 349))
        );
        jpPoliticaLayout.setVerticalGroup(
            jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(tfTiempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
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
                    .addComponent(pBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)))
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

private void tfCostoEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCostoEmisionActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfCostoEmisionActionPerformed

private void tfDesviacionDemandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDesviacionDemandaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfDesviacionDemandaActionPerformed

private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
    if (verificarCampos()) {
        if (politica == null) {
            crearPolitica();
        } else {
            actualizarPolitica();
        }

        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Campos Erroneos o Incompletos");
    }
}//GEN-LAST:event_btAceptarActionPerformed

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    dispose();
}//GEN-LAST:event_btCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.ButtonGroup errores;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpPolitica;
    private javax.swing.JPanel jpProveedor;
    private javax.swing.JLabel lbAlfa;
    private javax.swing.JLabel lbBeta;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDemandaAcumulada;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrediccion;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pProducto;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCostoEmision;
    private javax.swing.JTextField tfDesviacionDemanda;
    private javax.swing.JTextField tfNivelServicio;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTasaAlmacenamiento;
    private javax.swing.JTextField tfTiempoEntrega;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Component> getComponentesObligatorios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void crearPolitica() {
        //if(verificarCampos()){
        politica = new Politica();
        politica.setTipoPolitica(Politica.TipoPolitica.PERIODICA);
        politica.setCostoEmision(Double.valueOf(tfCostoEmision.getText()));
        politica.setDesviacionEstandarDemanda(Double.valueOf(tfDesviacionDemanda.getText()));
        politica.setNivelServicio(Double.parseDouble(tfNivelServicio.getText()));
        politica.setTasaAnualAlmacenamiento(Double.parseDouble(tfTasaAlmacenamiento.getText()));
        politica.setTiempoEntrega(Integer.parseInt(tfTiempoEntrega.getText()));
        producto.setPolitica(politica);
        politica.setTipoPolitica(Politica.TipoPolitica.PERIODICA);
        //}
    }

    private void actualizarPolitica() {
        if (verificarCampos()) {
            politica.setCostoEmision(Double.valueOf(tfCostoEmision.getText()));
            politica.setDesviacionEstandarDemanda(Double.valueOf(tfDesviacionDemanda.getText()));
            politica.setNivelServicio(Double.parseDouble(tfNivelServicio.getText()));
            politica.setTasaAnualAlmacenamiento(Double.parseDouble(tfTasaAlmacenamiento.getText()));
            politica.setTiempoEntrega(Integer.parseInt(tfTiempoEntrega.getText()));
            producto.setPolitica(politica);
        }
    }

    private boolean verificarCampos() {
        int resul = 0;
        if (!ValidacionBuscar.getInstancia().existenCamposVacios(jpPolitica)) {
            if (!GestorValidacion.getInstancia().isCamposNumericosValidos(jpPolitica)) {
                ++resul;
            }
        } else {
            ++resul;
        }
        if (resul > 0) {
            return false;
        } else {
            return true;
        }
    }

    private void cargarPantalla() {
        if (politica != null) {
            tfCostoEmision.setText(politica.getCostoEmision() + "");
            tfDesviacionDemanda.setText(politica.getDesviacionEstandarDemanda() + "");
            tfNivelServicio.setText(politica.getNivelServicio() + "");
            tfTasaAlmacenamiento.setText(politica.getTasaAnualAlmacenamiento() + "");
            tfTiempoEntrega.setText(politica.getTiempoEntrega() + "");

        }
    }
}
