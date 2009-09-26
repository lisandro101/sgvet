/*
 * PanelBuscarProductoGral.java
 *
 * Created on 30 de octubre de 2008, 18:32
 */

package sgvet.igu.buscar;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import sgvet.entidades.Componente;
import sgvet.entidades.EstructuraDeProducto;
import sgvet.entidades.MateriaPrima;
import sgvet.entidades.ParteDeEstructura;
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.ProductoTerminado;
import sgvet.entidades.Proveedor;
import sgvet.entidades.RutaFabricacion;
import sgvet.igu.PanelDemanda;
import sgvet.igu.PanelPuntoEquilibrio;
import sgvet.igu.PanelDetalleRuta;
import sgvet.igu.PanelEstructuraDeProducto;
import sgvet.igu.PanelMateriaPrima;
import sgvet.igu.PanelOrdenCompra;
import sgvet.igu.PanelOrdenProduccion;
import sgvet.igu.PanelProductoComponente;
import sgvet.igu.PanelProductoTerminado;
import sgvet.igu.PanelRutaFabricacion;
import sgvet.igu.interfaces.iBuscaProductoGeneral;
import sgvet.igu.model.ComponenteDetalleRutaTableModel;
import sgvet.igu.model.ProductoGralTableModel;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author  stafoxter
 */
public class PanelBuscarProductoGral extends javax.swing.JDialog {
    
    private static final long serialVersionUID = 1L;

    private PanelDemanda panelDemanda;
    private PanelPuntoEquilibrio panelPuntoEquilibrio;
    private ProductoGralTableModel tmBuscar;
    private ProductoGralTableModel tmOrigen;
    private ComponenteDetalleRutaTableModel tmDetalleRuta;
    //private ComponenteEstructuraTableModel tmDetalleEstructura;
    private List<Componente> componentes;    
    private PanelMateriaPrima panelMateriaPrima;
    private PanelProductoComponente panelProductoComponente;
    private PanelProductoTerminado panelProductoTerminado;
    private PanelDetalleRuta panelDetalleRuta;
    private PanelEstructuraDeProducto panelEstructuraDeProducto;
    private PanelOrdenCompra panelOrdenCompra;
    private PanelOrdenProduccion panelOrdenProduccion;
    private iBuscaProductoGeneral iProducto;
    private PanelRutaFabricacion panelRutaFabricacion;
    private Proveedor proveedor;
    List<EstructuraDeProducto> estructuras;
    List<ParteDeEstructura> partes;
    
    public enum Tipo {
        TABLE_MODEL ("TableModel"),
        PANEL_MATERIA_PRIMA ("Panel Materia Prima"),
        PANEL_PROD_COMPONENTE ("Panel Prod Componente"),
        PANEL_PROD_TERMINADO ("Panel Prod Terminado"),
        PANEL_DETALLE_RUTA ("Panel Detalle Ruta"),
        PANEL_ESTRUCTURA ("Panel Estructura"),
        PANEL_DETALLE_ESTRUCTURA ("Panel Detalle Estructura"),
        PANEL_PROVEEDOR ("Panel Proveedor"),
        PANEL_ORDEN_COMPRA ("Panel Orden Compra"),
        PANEL_ORDEN_PRODUCCION ("Panel Orden Produccion"),
        PANEL_IBUSCA ("Panel IBusca"),
        PANEL_RUTA_FABRICACION ("Panel Ruta Fabricacion"),
        PANEL_PUNTO_EQUILIBRIO ("Panel Punto Equilibrio"),
        PANEL_DEMANDA ("Panel Demanda");
        
        private String nombre;
        
        private Tipo(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
    
    private Tipo tipo;
    /** Creates new form PanelBuscarProductoGral */
    
    //Si es para rellenar un Un TableModel
    public PanelBuscarProductoGral(TableModel tm1) {
        initComponents();
        tipo= Tipo.TABLE_MODEL;
        tmOrigen = (ProductoGralTableModel) tm1;
        inicializar(); 
    }
    
    //Constructor ara cualquier pantalla que implemente la interface iBuscaProductoGeneral
    public PanelBuscarProductoGral(iBuscaProductoGeneral iProd) {
        initComponents();
        tipo= Tipo.PANEL_IBUSCA;
        iProducto = iProd;
        inicializar();
    }
    
    //Si es para la pantalla Materia prima
    public PanelBuscarProductoGral(PanelMateriaPrima ini) {
        initComponents();
        tipo= Tipo.PANEL_MATERIA_PRIMA;
        panelMateriaPrima= ini;
        inicializar();
    }
    
    //Si es para la pantalla Producto Componente
    public PanelBuscarProductoGral(PanelProductoComponente ini) {
        initComponents();
        tipo= Tipo.PANEL_PROD_COMPONENTE;
        panelProductoComponente= ini;
        inicializar();
    }
    
    //Si es para la pantalla Producto Terminado
    public PanelBuscarProductoGral(PanelProductoTerminado ini) {
        initComponents();
        tipo= Tipo.PANEL_PROD_TERMINADO;
        panelProductoTerminado= ini;
        inicializar();
    }

    public PanelBuscarProductoGral(PanelDetalleRuta ini) {
        initComponents();
        tipo= Tipo.PANEL_DETALLE_RUTA;
        panelDetalleRuta= ini;
        tmDetalleRuta= ini.getTableModelComponente();
        inicializar();
    }
    
    public PanelBuscarProductoGral(PanelEstructuraDeProducto ini, Tipo tipo1) {
        initComponents();
        tipo= tipo1;
        panelEstructuraDeProducto= ini;
        inicializar();
    }
    
    public PanelBuscarProductoGral(PanelOrdenCompra tm1, Proveedor prov) {
        initComponents();
        tipo = Tipo.PANEL_ORDEN_COMPRA;
        panelOrdenCompra = tm1;
        proveedor = prov;
        inicializar();
    }
    
    public PanelBuscarProductoGral(PanelOrdenProduccion tm1) {
        initComponents();
        tipo= Tipo.PANEL_ORDEN_PRODUCCION;
        panelOrdenProduccion= tm1;
        inicializar();
    }
    
    public PanelBuscarProductoGral(PanelRutaFabricacion tm1) {
        initComponents();
        tipo= Tipo.PANEL_RUTA_FABRICACION;
        panelRutaFabricacion= tm1;
        inicializar();
    }
    
    public PanelBuscarProductoGral(PanelPuntoEquilibrio panel){
        initComponents();
        tipo= Tipo.PANEL_PUNTO_EQUILIBRIO;
        panelPuntoEquilibrio =panel;
        inicializar();
    }

    public PanelBuscarProductoGral(PanelDemanda panel){
        initComponents();
        tipo= Tipo.PANEL_DEMANDA;
        panelDemanda =panel;
        inicializar();
    }
    
    private void inicializar() {
        tmBuscar = new ProductoGralTableModel(0);
        tResultadoComponentes.setModel(tmBuscar);
        tResultadoComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tResultadoComponentes = new org.jdesktop.swingx.JXTable();
        pBoton = new javax.swing.JPanel();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbCodigo.setText("Código:");

        lbNombre.setText("Nombre:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pProductoTerminadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(lbNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btBuscarProdTerminado)
                .addContainerGap())
        );
        pProductoTerminadoLayout.setVerticalGroup(
            pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pProductoTerminadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(btBuscarProdTerminado)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pProductoTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(lbNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tResultadoComponentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tResultadoComponentes.setEditable(false);
        jScrollPane1.setViewportView(tResultadoComponentes);

        javax.swing.GroupLayout pTablaComponentesLayout = new javax.swing.GroupLayout(pTablaComponentes);
        pTablaComponentes.setLayout(pTablaComponentesLayout);
        pTablaComponentesLayout.setHorizontalGroup(
            pTablaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaComponentesLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(90, 90, 90))
        );
        pTablaComponentesLayout.setVerticalGroup(
            pTablaComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTablaComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });
        pBoton.add(btAceptar);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        pBoton.add(btCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pBoton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(pTablaComponentes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pProductoTerminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProductoTerminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pTablaComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
    int indice = tResultadoComponentes.convertRowIndexToModel(tResultadoComponentes.getSelectedRow());
    Componente resultado;

    
    if(indice ==-1 ){
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Componente");
    }else{
        resultado=tmBuscar.getFila(indice);
        if(tipo== Tipo.TABLE_MODEL){
            if(tmOrigen.getRowCount()<1){
                tmOrigen.agregarFila(resultado);   
                dispose(); 
                
            }else{
                if(ValidacionBuscar.getInstancia().componenteEstaCargadoEnTabla(tmOrigen, resultado)){
                    JOptionPane.showMessageDialog(this, "El Componente ya se encuentra asignado");
                }else{
                    tmOrigen.agregarFila(resultado);    
                    dispose(); 
                }
            }
        }else if(tipo== Tipo.PANEL_IBUSCA){
            iProducto.setComponente(resultado);
            dispose();
        
        }else if(tipo== Tipo.PANEL_DETALLE_ESTRUCTURA){
            panelEstructuraDeProducto.setComponente(resultado);
            dispose();
        
        }else if(tipo== Tipo.PANEL_MATERIA_PRIMA){
            panelMateriaPrima.setComponente((MateriaPrima)resultado);
            dispose(); 
            
        }else if(tipo== Tipo.PANEL_PROD_COMPONENTE){
            panelProductoComponente.setComponente((ProductoComponente)resultado);
            dispose(); 
        }else if(tipo== Tipo.PANEL_DETALLE_RUTA){

            if(tmDetalleRuta.getRowCount()<1){
                asignarCantidad(resultado);
                panelDetalleRuta.setComponente(resultado);       
                dispose(); 
            }else{
                if(ValidacionBuscar.getInstancia().parteNodoRutaEstaCargadaEnTabla(tmDetalleRuta, resultado)){
                    JOptionPane.showMessageDialog(this, "El Componente ya se encuentra asignado");
                }else{
                    asignarCantidad(resultado);
                    panelDetalleRuta.setComponente(resultado);   
                    dispose(); 
                }
            }
             
        }else if(tipo== Tipo.PANEL_PROD_TERMINADO){
            panelProductoTerminado.setComponente((ProductoTerminado)resultado);
            dispose(); 
        }else if(tipo== Tipo.PANEL_PUNTO_EQUILIBRIO){
            panelPuntoEquilibrio.setProductoTerminado((ProductoTerminado)resultado);
            dispose();
        }else if(tipo== Tipo.PANEL_DEMANDA){
            panelDemanda.setProductoTerminado((ProductoComponente)resultado);
            dispose();
        }else if(tipo== Tipo.PANEL_ESTRUCTURA){
            Query consulta = FachadaPersistencia.getInstancia().crearConsulta("" +
                    "SELECT a FROM EstructuraDeProducto a " +
                    "WHERE a.productoTerminado= :producto" );
            consulta.setParameter("producto", (ProductoTerminado)resultado);
            EstructuraDeProducto estructura;
            try{
                estructura= FachadaPersistencia.getInstancia().buscar(EstructuraDeProducto.class, consulta).get(0);
                panelEstructuraDeProducto.setEstructura(estructura);
            }catch(IndexOutOfBoundsException e){
                
                estructura = new EstructuraDeProducto();
                estructura.setProductoTerminado((ProductoTerminado)resultado);
                panelEstructuraDeProducto.setEstructura(estructura);
                        //panelEstructuraDeProducto.setProductoTerminado((ProductoTerminado)resultado);
            }

            dispose();       
        }else if(tipo==Tipo.PANEL_ORDEN_COMPRA){
            panelOrdenCompra.setComponente(resultado);
            dispose();
        }else if(tipo==Tipo.PANEL_ORDEN_PRODUCCION){
            panelOrdenProduccion.setProductoTerminado((ProductoComponente)resultado);
            dispose();
        }else if(tipo== Tipo.PANEL_RUTA_FABRICACION){
            panelRutaFabricacion.setComponente(resultado);
            dispose();
        }
    }
}//GEN-LAST:event_btAceptarActionPerformed

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
dispose();
}//GEN-LAST:event_btCancelarActionPerformed

private void btBuscarProdTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarProdTerminadoActionPerformed
    Query consulta;
    tmBuscar.limpiarTableModel();
    
    if( tipo== Tipo.PANEL_DETALLE_ESTRUCTURA){
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from Componente a where ( (a.nombre) LIKE :nombre or (a.codigo) LIKE :codigo ) and a.borrado=false and a.tipo IN (:tipo1, :tipo2)");
        consulta.setParameter("nombre", "%"+tfNombre.getText()+"%");
        consulta.setParameter("codigo", "%"+tfCodigo.getText()+"%");
        consulta.setParameter("tipo1", 'C');
        consulta.setParameter("tipo2", 'M');
        componentes = FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);
        
    }else if(tipo == Tipo.PANEL_ORDEN_COMPRA){        
        consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM Componente a " +
                "WHERE ( (a.nombre) LIKE :nombre OR (a.codigo) LIKE :codigo ) " +
                "AND a.borrado = false AND a.tipo IN (:tipo1, :tipo2)");
        consulta.setParameter("nombre", "%"+tfNombre.getText()+"%");
        consulta.setParameter("codigo", "%"+tfCodigo.getText()+"%");
        consulta.setParameter("tipo1", 'C');
        consulta.setParameter("tipo2", 'M');
           
        componentes = FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);
        

    }else if(tipo== Tipo.PANEL_DETALLE_RUTA){
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from EstructuraDeProducto a where a.productoTerminado = :producto and a.borrado=false");
        consulta.setParameter("producto", panelDetalleRuta.getProductoTerminado());    
        estructuras= FachadaPersistencia.getInstancia().buscar(EstructuraDeProducto.class, consulta);
        componentes= new ArrayList<Componente>();
        
        if(estructuras.size()==1){
            partes= estructuras.get(0).getPartes();
            
            for (ParteDeEstructura parteDeEstructura1 : partes) {
                componentes.add(parteDeEstructura1.getComponente());
            }
        
        }
       
    }else if(tipo== Tipo.PANEL_RUTA_FABRICACION){
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from EstructuraDeProducto a where a.borrado=false");
        estructuras= FachadaPersistencia.getInstancia().buscar(EstructuraDeProducto.class, consulta);

        componentes= new ArrayList<Componente>();
        List<Componente> comTemp = new ArrayList<Componente>();
        
        if(estructuras.size()>=1){
            for (EstructuraDeProducto estructura : estructuras) {
                comTemp.add(estructura.getProductoTerminado());
            }
        } 
        
        List<RutaFabricacion> rutas;

        for (Componente compo : comTemp) {
            consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from RutaFabricacion a where a.productoTerminado = :producto and a.borrado=false");
            consulta.setParameter("producto", compo);
            rutas= FachadaPersistencia.getInstancia().buscar(RutaFabricacion.class, consulta);
            
            if(rutas.size()==0){
                componentes.add(compo);
            }
            
        }
    
    }else if(tipo==Tipo.PANEL_ORDEN_PRODUCCION){
        
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from RutaFabricacion a where a.borrado=false");
        
        List<RutaFabricacion> rutas = FachadaPersistencia.getInstancia().buscar(RutaFabricacion.class, consulta);
        componentes= new ArrayList<Componente>();
        
        for (RutaFabricacion rutaFabricacion : rutas) {
            componentes.add(rutaFabricacion.getProductoTerminado());
        }
        
    }else{
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from Componente a where ( (a.nombre) LIKE :nombre or (a.codigo) LIKE :codigo ) and a.borrado=false and a.tipo= :tipo" );
        consulta.setParameter("nombre", "%"+tfNombre.getText()+"%");
        consulta.setParameter("codigo", "%"+tfCodigo.getText()+"%");
        
        if(tipo== Tipo.TABLE_MODEL){
          // TODO: aca depende de q necesitamos para el TableModel  
        }else if(tipo== Tipo.PANEL_MATERIA_PRIMA){
            consulta.setParameter("tipo", 'M');
        }else if(tipo== Tipo.PANEL_PROD_COMPONENTE || tipo== Tipo.PANEL_DEMANDA){
            consulta.setParameter("tipo", 'C');
        }else{
            consulta.setParameter("tipo", 'T');
        }
        
        componentes= FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);
    }
    
//    indice=componentes.size();
//    for (int i = 0; i < indice; i++) {
//        tmBuscar.agregarFila(componentes.get(i));
//    }
    if(componentes != null){
        for (Componente componente : componentes) {
            tmBuscar.agregarFila(componente);
        }
    }
}//GEN-LAST:event_btBuscarProdTerminadoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btBuscarProdTerminado;
    private javax.swing.JButton btCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JPanel pBoton;
    private javax.swing.JPanel pProductoTerminado;
    private javax.swing.JPanel pTablaComponentes;
    private org.jdesktop.swingx.JXTable tResultadoComponentes;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables

    private void asignarCantidad(Componente componente){
        for (ParteDeEstructura parteDeEstructura1 : partes) {
            if(parteDeEstructura1.getComponente().getNombre().equals(componente.getNombre())){
                panelDetalleRuta.setCantComponente(parteDeEstructura1.getCantidad());
            }
        }       
    }
}
