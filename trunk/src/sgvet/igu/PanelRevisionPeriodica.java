package sgvet.igu;

import java.awt.Component;
import java.util.List;
import sgvet.entidades.ProductoComponente;
import sgvet.utils.*;

/**
 *
 * @author  Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelRevisionPeriodica extends javax.swing.JDialog implements IValidable {

    private static final long serialVersionUID = 1L;
//    private DemandaSESTableModel tmDemanda;
//    private DefaultTableModel tModel;
    private ProductoComponente producto;
//    private List<Demanda> demandas;
//
//    private int cantAnios;
//    private Date anioInicial;
    private double tendencia;
    private double alfa;
    private double beta;

    /** Creates new form PanelCargoEmpleado */
    public PanelRevisionPeriodica(ProductoComponente productoNuevo) {

        producto = productoNuevo;

        initComponents();
        inicializar();

        inicializarBotones();

    }

    public PanelRevisionPeriodica() {
        initComponents();
        inicializar();

        inicializarBotones();

    }

    private void inicializar() {
//        tModel = new DefaultTableModel();
//        tDemanda.setModel(tModel);
        cargarPantalla();
        btLimpiar.setEnabled(false);
    }

    private void inicializarBotones() {
        //btCalcular.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errores = new javax.swing.ButtonGroup();
        pBotones = new javax.swing.JPanel();
        btCalcular = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        pProducto = new javax.swing.JPanel();
        jpProveedor = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jpPolitica = new javax.swing.JPanel();
        jpRevisionPeriodica = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfPeriodoRevision = new javax.swing.JTextField();
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

        btCalcular.setText("Guardar");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });
        pBotones.add(btCalcular);

        btGuardar.setText("Cerrar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        pBotones.add(btGuardar);

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        pBotones.add(btLimpiar);

        jpProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

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

        jpRevisionPeriodica.setBorder(javax.swing.BorderFactory.createTitledBorder("Revision Periodica"));

        jLabel2.setText("Periodo de Revision:");

        tfPeriodoRevision.setEditable(false);

        javax.swing.GroupLayout jpRevisionPeriodicaLayout = new javax.swing.GroupLayout(jpRevisionPeriodica);
        jpRevisionPeriodica.setLayout(jpRevisionPeriodicaLayout);
        jpRevisionPeriodicaLayout.setHorizontalGroup(
            jpRevisionPeriodicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRevisionPeriodicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPeriodoRevision, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpRevisionPeriodicaLayout.setVerticalGroup(
            jpRevisionPeriodicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRevisionPeriodicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRevisionPeriodicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPeriodoRevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        lbAlfa.setText("Costo de Emision:");

        tfCostoEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCostoEmisionActionPerformed(evt);
            }
        });

        lbBeta.setText("Desviacion Demanda:");

        tfDesviacionDemanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDesviacionDemandaActionPerformed(evt);
            }
        });

        lbDemandaAcumulada.setText("Nivel de Servicio:");

        lbPrediccion.setText("Tasa Almacenamiento:");

        jLabel4.setText("Tiempo de Entrega:");

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
                .addGap(111, 111, 111)
                .addComponent(jpRevisionPeriodica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPoliticaLayout.setVerticalGroup(
            jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPoliticaLayout.createSequentialGroup()
                .addGroup(jpPoliticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpRevisionPeriodica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(tfTiempoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
    dispose();
}//GEN-LAST:event_btGuardarActionPerformed

private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
}//GEN-LAST:event_btCalcularActionPerformed

private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
    sgvet.utils.Util.getInstancia().limpiarCampos(this);
    //producto=null;
    btGuardar.setEnabled(false);
}//GEN-LAST:event_btLimpiarActionPerformed

private void tfCostoEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCostoEmisionActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfCostoEmisionActionPerformed

private void tfDesviacionDemandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDesviacionDemandaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfDesviacionDemandaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.ButtonGroup errores;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpPolitica;
    private javax.swing.JPanel jpProveedor;
    private javax.swing.JPanel jpRevisionPeriodica;
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
    private javax.swing.JTextField tfPeriodoRevision;
    private javax.swing.JTextField tfTasaAlmacenamiento;
    private javax.swing.JTextField tfTiempoEntrega;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Component> getComponentesObligatorios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ProductoComponente getProductoTerminado() {
        return producto;
    }

    public void setProductoTerminado(ProductoComponente producton) {
        producto = producton;
        cargarPantalla();
    }

    private void cargarPantalla() {
//        sgvet.utils.Util.getInstancia().limpiarCampos(this);

        tfCodigo.setText(producto.getCodigo());
        tfNombre.setText(producto.getNombre());

    }

    private double redondear(double valor) {
        return (Math.floor(valor * 100) / 100);
    }
}
