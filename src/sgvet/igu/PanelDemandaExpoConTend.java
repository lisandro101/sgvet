package sgvet.igu;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import sgvet.entidades.Demanda;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorDemanda;
import sgvet.igu.model.DemandaSESTableModel;
import sgvet.utils.*;

/**
 *
 * @author  Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelDemandaExpoConTend extends javax.swing.JDialog implements IValidable {
    private static final long serialVersionUID = 1L;

    private DemandaSESTableModel tmDemanda;
    private ProductoComponente producto;
    private List<Demanda> demandas;

    private int cantPeriodos;
    private Date fechaInicial;
    private double alfa;


    /** Creates new form PanelCargoEmpleado */
    public PanelDemandaExpoConTend() {
        initComponents();
        inicializar();
        inicializarBotones();

    }

    private void inicializar() {
        tmDemanda = new DemandaSESTableModel(0);
        tDemandaSES.setModel(tmDemanda);
        
    }

    private void inicializarBotones(){
        btCalcular.setEnabled(false);

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
        scPanel = new javax.swing.JScrollPane();
        tDemandaSES = new org.jdesktop.swingx.JXTable();
        lbAlfa5 = new javax.swing.JLabel();
        tfAlfa = new javax.swing.JTextField();
        lbPeriodoInicial5 = new javax.swing.JLabel();
        tfCantPeriodos = new javax.swing.JTextField();
        lbCantidadPeriodos = new javax.swing.JLabel();
        dpPeriodoIni = new org.jdesktop.swingx.JXDatePicker();
        btCargar = new javax.swing.JButton();

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
                    .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
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

        tDemandaSES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Periodo", "Predicción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scPanel.setViewportView(tDemandaSES);

        lbAlfa5.setText("ALfa:");

        tfAlfa.setText("0.3");
        tfAlfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlfaActionPerformed(evt);
            }
        });

        lbPeriodoInicial5.setText("Periodo Inicial:");

        lbCantidadPeriodos.setText("Cant Periodos:");

        dpPeriodoIni.setFormats("MMMM yyyy");
        dpPeriodoIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpPeriodoIniActionPerformed(evt);
            }
        });

        btCargar.setText("Cargar");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCantidadPeriodos)
                                    .addComponent(lbAlfa5)
                                    .addComponent(lbPeriodoInicial5))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAlfa, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(tfCantPeriodos, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(dpPeriodoIni, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(btCargar)))
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(scPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpPeriodoIni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPeriodoInicial5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCantPeriodos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidadPeriodos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAlfa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlfa5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
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
//    demandas = tmDemanda.getFilas();
    alfa = Double.parseDouble(tfAlfa.getText());
    demandas = GestorDemanda.getInstancia().calcularES(alfa, demandas);
    tmDemanda.limpiarTableModel();
    tmDemanda.agregarFilas(demandas);

}//GEN-LAST:event_btCalcularActionPerformed

private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
 sgvet.utils.Util.getInstancia().limpiarCampos(this);
 producto=null;
 btCalcular.setEnabled(false);
}//GEN-LAST:event_btLimpiarActionPerformed

private void dpPeriodoIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpPeriodoIniActionPerformed
    // buscar si el producto ya tiene una demanda para el periodo q se cargo en pantalla
    // si tiene demanda ponerla en el texfield
}//GEN-LAST:event_dpPeriodoIniActionPerformed

private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
    if(validarDatosPantalla()){
        demandas= new ArrayList<Demanda>();
        Demanda demandaPredecida;

        Calendar cal = Calendar.getInstance();

        fechaInicial = convertirFecha(fechaInicial);
        cal.setTime(fechaInicial);

        for (int i = 0; i < cantPeriodos; i++) {
            demandaPredecida= new Demanda();

            if(i>0){
                cal.add(Calendar.DAY_OF_MONTH, 31);
            }
            
            demandaPredecida.setPeriodo(cal.getTime());

            demandas.add(demandaPredecida);

        }

        tmDemanda.agregarFilas(demandas);
        btCalcular.setEnabled(true);
    }

}//GEN-LAST:event_btCargarActionPerformed

private void tfAlfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlfaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfAlfaActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btLimpiar;
    private org.jdesktop.swingx.JXDatePicker dpPeriodoIni;
    private javax.swing.ButtonGroup errores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlfa5;
    private javax.swing.JLabel lbCantidadPeriodos;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPeriodoInicial5;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pProducto;
    private javax.swing.JPanel pProductoTerminado;
    private javax.swing.JScrollPane scPanel;
    private org.jdesktop.swingx.JXTable tDemandaSES;
    private javax.swing.JTextField tfAlfa;
    private javax.swing.JTextField tfCantPeriodos;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<Component> getComponentesObligatorios() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ProductoComponente getProductoTerminado() {
        return producto;
    }

    public void setProductoTerminado(ProductoComponente producto) {
        this.producto = producto;
        cargarPantalla();
    }
    
    private void cargarPantalla(){
        sgvet.utils.Util.getInstancia().limpiarCampos(this);
        tfCodigo.setText(producto.getCodigo());
        tfNombre.setText(producto.getNombre());
        
    }


    private Date convertirFecha(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    private double redondear(double valor){
        return (Math.floor(valor*100)/100);
    }

    private boolean validarDatosPantalla(){
        boolean resul= true;

        if(tfCantPeriodos.getText().equals("") || dpPeriodoIni.getDate()==null
                || tfAlfa.getText().equals("")){
            resul=false;
            JOptionPane.showMessageDialog(this, "Existen campos vacios");
        }else{
            cantPeriodos= Integer.parseInt(tfCantPeriodos.getText());
            fechaInicial = dpPeriodoIni.getDate();
            alfa = Double.parseDouble(tfAlfa.getText());
        }
        return resul;
    }
}
