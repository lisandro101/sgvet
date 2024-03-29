package sgvet.igu;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.auxiliares.DemandaXPeriodo;
import sgvet.gestores.GestorDemanda;
import sgvet.gestores.GestorFecha;
import sgvet.utils.*;

/**
 *
 * @author  Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelDemandaConEstacionalidad extends javax.swing.JDialog implements IValidable {
    private static final long serialVersionUID = 1L;

//    private DemandaSESTableModel tmDemanda;
    private DefaultTableModel tModel;
    private ProductoComponente producto;
//    private List<Demanda> demandas;

//    private int cantAnios;
//    private Date anioInicial;
    private double alfa;
    private double gamma;


    /** Creates new form PanelCargoEmpleado */
    public PanelDemandaConEstacionalidad(ProductoComponente productoNuevo) {

        producto = productoNuevo;

        initComponents();
        inicializar();
        
        inicializarBotones();

    }

    public PanelDemandaConEstacionalidad() {
        initComponents();
        inicializar();

        inicializarBotones();

    }

    private void inicializar() {

        tModel = new DefaultTableModel();

        List<String> nombreColumnas = new ArrayList<String>();
        nombreColumnas.add("Periodo");
        nombreColumnas.add("Predicción");
        tModel.setColumnIdentifiers(nombreColumnas.toArray());


        TPrediccion.setModel(tModel);
        cargarPantalla();
        btLimpiar.setEnabled(false);
        tfFechaHoy.setText(GestorFecha.getInstancia().formatearFecha(GestorFecha.getInstancia().getFechaHoy()));
    }

    private void inicializarBotones(){
//        btCalcular.setEnabled(false);
        btIndices.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errores = new javax.swing.ButtonGroup();
        pBotones = new javax.swing.JPanel();
        btCalcular = new javax.swing.JButton();
        btCerrar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        pProducto = new javax.swing.JPanel();
        pProductoTerminado = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbAlfa = new javax.swing.JLabel();
        tfAlfa = new javax.swing.JTextField();
        tfGamma = new javax.swing.JTextField();
        lbGamma = new javax.swing.JLabel();
        lbDemandaAcumulada = new javax.swing.JLabel();
        tfDemandaAcumulada = new javax.swing.JTextField();
        lbPrediccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPrediccion = new org.jdesktop.swingx.JXTable();
        btIndices = new javax.swing.JButton();
        pPeriodoAbierto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfFechaCierre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfAcumulado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfFechaHoy = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Demanda");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });
        pBotones.add(btCalcular);

        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });
        pBotones.add(btCerrar);

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        pBotones.add(btLimpiar);

        pProductoTerminado.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        lbCodigo.setText("Código:");

        lbNombre.setText("Nombre:");

        tfCodigo.setEnabled(false);

        tfNombre.setEnabled(false);

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
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addContainerGap())
        );
        pProductoTerminadoLayout.setVerticalGroup(
            pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminadoLayout.createSequentialGroup()
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(pProductoTerminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pProductoLayout.setVerticalGroup(
            pProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pProductoTerminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Demanda"));

        lbAlfa.setText("ALfa:");

        tfAlfa.setText("0.3");
        tfAlfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlfaActionPerformed(evt);
            }
        });

        tfGamma.setText("0.6");
        tfGamma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGammaActionPerformed(evt);
            }
        });

        lbGamma.setText("Gamma:");

        lbDemandaAcumulada.setText("Demanda Acumulada:");

        tfDemandaAcumulada.setEditable(false);

        lbPrediccion.setText("Prediccion:");

        TPrediccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Periodo", "Predicción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TPrediccion.setEditable(false);
        jScrollPane1.setViewportView(TPrediccion);

        btIndices.setText("Indices");
        btIndices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIndicesActionPerformed(evt);
            }
        });

        pPeriodoAbierto.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodo Abierto"));

        jLabel1.setText("Fecha de cierre:");

        tfFechaCierre.setEditable(false);

        jLabel2.setText("Acumulado:");

        tfAcumulado.setEditable(false);

        jLabel3.setText("Fecha Actual:");

        tfFechaHoy.setEditable(false);
        tfFechaHoy.setMinimumSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout pPeriodoAbiertoLayout = new javax.swing.GroupLayout(pPeriodoAbierto);
        pPeriodoAbierto.setLayout(pPeriodoAbiertoLayout);
        pPeriodoAbiertoLayout.setHorizontalGroup(
            pPeriodoAbiertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeriodoAbiertoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPeriodoAbiertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPeriodoAbiertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFechaHoy, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(tfAcumulado, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(tfFechaCierre, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );
        pPeriodoAbiertoLayout.setVerticalGroup(
            pPeriodoAbiertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeriodoAbiertoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPeriodoAbiertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPeriodoAbiertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfAcumulado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPeriodoAbiertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbPrediccion)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btIndices)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addGap(185, 185, 185))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAlfa)
                            .addComponent(lbGamma)
                            .addComponent(lbDemandaAcumulada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAlfa, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(tfGamma, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(tfDemandaAcumulada, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addComponent(pPeriodoAbierto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pPeriodoAbierto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbAlfa)
                            .addComponent(tfAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbGamma)
                            .addComponent(tfGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDemandaAcumulada)
                            .addComponent(tfDemandaAcumulada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btIndices))
                    .addComponent(lbPrediccion))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
    dispose();
}//GEN-LAST:event_btCerrarActionPerformed

private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
    List<Integer> resultados;
//    alfa = Double.parseDouble(tfAlfa.getText());
//    gamma = Double.parseDouble(tfGamma.getText());
    List <DemandaXPeriodo> ventas;

    if (validarYCargarDatosPantalla()) {
        ventas= GestorDemanda.getInstancia().calcularDemandaXPeriodo(producto);
        resultados = GestorDemanda.getInstancia().calcularDemandaConEstacionalidadNew(alfa, gamma, ventas);
        CargarTabla(resultados);
        btIndices.setEnabled(true);
        inicializarPanelPeriodoAbierto();
        
        tfDemandaAcumulada.setText(String.valueOf(GestorDemanda.getInstancia().calcularAcumulado(ventas)));
    }

}//GEN-LAST:event_btCalcularActionPerformed

private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
 sgvet.utils.Util.getInstancia().limpiarCampos(this);
 //producto=null;
 btCalcular.setEnabled(false);
}//GEN-LAST:event_btLimpiarActionPerformed

private void tfAlfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlfaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfAlfaActionPerformed

private void tfGammaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGammaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfGammaActionPerformed

private void btIndicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIndicesActionPerformed
    PanelIndiceEstacionalidad PanelIndice = new PanelIndiceEstacionalidad(GestorDemanda.getInstancia().getIndicesEstacionalidad()); 
     PanelIndice.setModal(true);
     PanelIndice.setVisible(true);
}//GEN-LAST:event_btIndicesActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTable TPrediccion;
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btIndices;
    private javax.swing.JButton btLimpiar;
    private javax.swing.ButtonGroup errores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAlfa;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDemandaAcumulada;
    private javax.swing.JLabel lbGamma;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrediccion;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pPeriodoAbierto;
    private javax.swing.JPanel pProducto;
    private javax.swing.JPanel pProductoTerminado;
    private javax.swing.JTextField tfAcumulado;
    private javax.swing.JTextField tfAlfa;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDemandaAcumulada;
    private javax.swing.JTextField tfFechaCierre;
    private javax.swing.JTextField tfFechaHoy;
    private javax.swing.JTextField tfGamma;
    private javax.swing.JTextField tfNombre;
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
    
    private void cargarPantalla(){
//        sgvet.utils.Util.getInstancia().limpiarCampos(this);
       
        tfCodigo.setText(producto.getCodigo());
        tfNombre.setText(producto.getNombre());
        
    }



    private boolean validarYCargarDatosPantalla(){
        boolean resul= true;

        if(tfAlfa.getText().equals("") || tfGamma.getText().equals("")){
            resul=false;
            JOptionPane.showMessageDialog(this, "Existen campos vacios");
        }else{
            alfa = Double.parseDouble(tfAlfa.getText());
            gamma = Double.parseDouble(tfGamma.getText());
        }
        return resul;
    }

   

    private void CargarTabla(List<Integer> resultados){
        int fila= 0;
        int nroPeriodo = 13 - resultados.size();

        tModel.setRowCount(resultados.size());
        tModel.setColumnCount(2);
        //TPrediccion.setModel(tModel);
        for (Integer resul : resultados) {
            ++nroPeriodo;
            tModel.setValueAt(nroPeriodo, fila, 0);
            tModel.setValueAt(resul, fila, 1);

            ++fila;
        }

    }

    private void inicializarPanelPeriodoAbierto(){
        tfAcumulado.setText(String.valueOf(GestorDemanda.getInstancia().getVentasPeriodoAbierto()));

        if(GestorDemanda.getInstancia().getFechaCierre() != null){
            tfFechaCierre.setText(formatearFecha(GestorDemanda.getInstancia().getFechaCierre()));
        }

   }

   private String formatearFecha(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }


}
