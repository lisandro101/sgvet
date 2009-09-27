package sgvet.igu;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import sgvet.entidades.Demanda;
import sgvet.entidades.DemandaXPeriodo;
import sgvet.entidades.ProductoComponente;
import sgvet.gestores.GestorDemanda;
import sgvet.igu.model.DemandaSESTableModel;
import sgvet.utils.*;

/**
 *
 * @author  Franco Catena, Mario Mariani, Lisandro Nieto, Sebastián Torres
 */
public class PanelDemandaExpoSimpleNew extends javax.swing.JDialog implements IValidable {
    private static final long serialVersionUID = 1L;

    private DemandaSESTableModel tmDemanda;
    private ProductoComponente producto;
    private List<Demanda> demandas;

    private int cantPeriodos;
    private Date fechaInicial;
    private double alfa;


    /** Creates new form PanelCargoEmpleado */
    public PanelDemandaExpoSimpleNew() {
        initComponents();
        inicializar();
        inicializarBotones();

    }

    public PanelDemandaExpoSimpleNew(ProductoComponente producto) {
        initComponents();

        this.producto = producto;

        inicializar();
        inicializarBotones();

    }

    private void inicializar() {
        tmDemanda = new DemandaSESTableModel(0);
 //       tDemandaSES.setModel(tmDemanda);
        cargarPantalla();
        btLimpiar.setEnabled(false);
//        tfCodigoProducto.setText(producto.getCodigo());
//        tfNombreProducto.setText(producto.getNombre());
        
    }

    private void inicializarBotones(){
        //btCalcular.setEnabled(false);

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
        tfCodigoProducto = new javax.swing.JTextField();
        tfNombreProducto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbAlfa5 = new javax.swing.JLabel();
        tfAlfa = new javax.swing.JTextField();
        lbPeriodo = new javax.swing.JLabel();
        dpPeriodo = new org.jdesktop.swingx.JXDatePicker();
        lbDemandaAcumulada = new javax.swing.JLabel();
        tfDemandaAcumulada = new javax.swing.JTextField();
        lbPrediccion = new javax.swing.JLabel();
        tfPrediccion = new javax.swing.JTextField();

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

        tfCodigoProducto.setEnabled(false);

        tfNombreProducto.setEnabled(false);

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
                    .addComponent(tfCodigoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(tfNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );
        pProductoTerminadoLayout.setVerticalGroup(
            pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminadoLayout.createSequentialGroup()
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(tfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        lbAlfa5.setText("ALfa:");

        tfAlfa.setText("0.3");
        tfAlfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlfaActionPerformed(evt);
            }
        });

        lbPeriodo.setText("Periodo:");

        dpPeriodo.setEditable(false);
        dpPeriodo.setFormats("MMMM yyyy");
        dpPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpPeriodoActionPerformed(evt);
            }
        });

        lbDemandaAcumulada.setText("Demanda Acumulada:");

        tfDemandaAcumulada.setEditable(false);

        lbPrediccion.setText("Predicción:");

        tfPrediccion.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPeriodo)
                                    .addComponent(lbAlfa5))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAlfa, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(dpPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbDemandaAcumulada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPrediccion, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(tfDemandaAcumulada, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                        .addGap(126, 126, 126))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbPrediccion)
                        .addContainerGap(341, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpPeriodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPeriodo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlfa5)
                    .addComponent(tfAlfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDemandaAcumulada)
                    .addComponent(tfDemandaAcumulada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrediccion)
                    .addComponent(tfPrediccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
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
    //demandas = GestorDemanda.getInstancia().calcularES(alfa, demandas);
    tfDemandaAcumulada.setText(String.valueOf(GestorDemanda.getInstancia().CalcularDemandaAcumulada(producto)));
    MostrarXPantalla( GestorDemanda.getInstancia().CalcularDemandaXPeriodo(producto));

    tmDemanda.limpiarTableModel();
    tmDemanda.agregarFilas(demandas);

}//GEN-LAST:event_btCalcularActionPerformed

private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
 sgvet.utils.Util.getInstancia().limpiarCampos(this);
 //producto=null;
 btCalcular.setEnabled(false);
}//GEN-LAST:event_btLimpiarActionPerformed

private void dpPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpPeriodoActionPerformed
    // buscar si el producto ya tiene una demanda para el periodo q se cargo en pantalla
    // si tiene demanda ponerla en el texfield
}//GEN-LAST:event_dpPeriodoActionPerformed

private void tfAlfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlfaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_tfAlfaActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btLimpiar;
    private org.jdesktop.swingx.JXDatePicker dpPeriodo;
    private javax.swing.ButtonGroup errores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAlfa5;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDemandaAcumulada;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPeriodo;
    private javax.swing.JLabel lbPrediccion;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pProducto;
    private javax.swing.JPanel pProductoTerminado;
    private javax.swing.JTextField tfAlfa;
    private javax.swing.JTextField tfCodigoProducto;
    private javax.swing.JTextField tfDemandaAcumulada;
    private javax.swing.JTextField tfNombreProducto;
    private javax.swing.JTextField tfPrediccion;
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
//        sgvet.utils.Util.getInstancia().limpiarCampos(this);
        tfCodigoProducto.setText(producto.getCodigo());
        tfNombreProducto.setText(producto.getNombre());
        
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

//        if(tfCantPeriodos.getText().equals("") || dpPeriodo.getDate()==null
//                || tfAlfa.getText().equals("")){
//            resul=false;
//            JOptionPane.showMessageDialog(this, "Existen campos vacios");
//        }else{
//            cantPeriodos= Integer.parseInt(tfCantPeriodos.getText());
//            fechaInicial = dpPeriodo.getDate();
//            alfa = Double.parseDouble(tfAlfa.getText());
//        }
        return resul;
    }

    private void MostrarXPantalla(List<DemandaXPeriodo> demandas){
        if(demandas != null){
            for (DemandaXPeriodo demandaXPeriodo : demandas) {
            System.out.println("\n Periodo: "+demandaXPeriodo.getMes()+"    Total: "+demandaXPeriodo.getVentas());
            }
        }else{
            System.out.println("\n No se registraron ventas del producto seleccionado\n");
        }


    }
}
