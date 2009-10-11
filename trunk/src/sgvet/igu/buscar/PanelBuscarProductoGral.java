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
import sgvet.entidades.ProductoComponente;
import sgvet.entidades.Proveedor;

import sgvet.igu.PanelOrdenCompra;
import sgvet.igu.PanelOrdenProduccion;
import sgvet.igu.PanelProductoComponente;
import sgvet.igu.PanelStock;
import sgvet.igu.interfaces.iBuscaProductoGeneral;
import sgvet.igu.model.ProductoGralTableModel;
import sgvet.persistencia.FachadaPersistencia;

/**
 *
 * @author  stafoxter
 */
public class PanelBuscarProductoGral extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private ProductoGralTableModel tmBuscar;
    private ProductoGralTableModel tmOrigen;
    private List<Componente> componentes;
    private PanelProductoComponente panelProductoComponente;
    private PanelOrdenCompra panelOrdenCompra;
    private PanelOrdenProduccion panelOrdenProduccion;
    private iBuscaProductoGeneral iProducto;
    private Proveedor proveedor;
    private PanelStock panelStock;

    public enum Tipo {

        TABLE_MODEL("TableModel"),
        PANEL_PROD_COMPONENTE("Panel Prod Componente"),
        PANEL_PROVEEDOR("Panel Proveedor"),
        PANEL_ORDEN_COMPRA("Panel Orden Compra"),
        PANEL_ORDEN_PRODUCCION("Panel Orden Produccion"),
        PANEL_IBUSCA("Panel IBusca"),
        PANEL_DEMANDA("Panel Demanda"),
        PANEL_STOCK("Panel Stock");
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
        tipo = Tipo.TABLE_MODEL;
        tmOrigen = (ProductoGralTableModel) tm1;
        inicializar();
    }

    //Constructor ara cualquier pantalla que implemente la interface iBuscaProductoGeneral
    public PanelBuscarProductoGral(iBuscaProductoGeneral iProd) {
        initComponents();
        tipo = Tipo.PANEL_IBUSCA;
        iProducto = iProd;
        inicializar();
    }

    //Si es para la pantalla Producto Componente
    public PanelBuscarProductoGral(PanelProductoComponente ini) {
        initComponents();
        tipo = Tipo.PANEL_PROD_COMPONENTE;
        panelProductoComponente = ini;
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
        tipo = Tipo.PANEL_ORDEN_PRODUCCION;
        panelOrdenProduccion = tm1;
        inicializar();
    }
//
//    public PanelBuscarProductoGral(PanelDemanda panel) {
//        initComponents();
//        tipo = Tipo.PANEL_DEMANDA;
//        panelDemanda = panel;
//        inicializar();
//    }

    public PanelBuscarProductoGral(PanelStock panel) {
        //throw new UnsupportedOperationException("Not yet implemented");
        initComponents();
        tipo = Tipo.PANEL_STOCK;
        panelStock = panel;
        inicializar();
    }

    private void inicializar() {
        tmBuscar = new ProductoGralTableModel(0);
        tResultadoComponentes.setModel(tmBuscar);
        tResultadoComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
                    .addComponent(lbCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lbNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE))
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


    if (indice == -1) {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado Componente");
    } else {
        resultado = tmBuscar.getFila(indice);
        if (tipo == Tipo.TABLE_MODEL) {
            if (tmOrigen.getRowCount() < 1) {
                tmOrigen.agregarFila(resultado);
                dispose();

            } else {
                if (ValidacionBuscar.getInstancia().componenteEstaCargadoEnTabla(tmOrigen, resultado)) {
                    JOptionPane.showMessageDialog(this, "El Componente ya se encuentra asignado");
                } else {
                    tmOrigen.agregarFila(resultado);
                    dispose();
                }
            }
        } else if (tipo == Tipo.PANEL_IBUSCA) {
            iProducto.setComponente(resultado);
            dispose();

        } else if (tipo == Tipo.PANEL_PROD_COMPONENTE) {
            panelProductoComponente.setComponente((ProductoComponente) resultado);
            dispose();
//        } else if (tipo == Tipo.PANEL_DEMANDA) {
//            panelDemanda.setProductoTerminado((ProductoComponente) resultado);
//            dispose();
        } else if (tipo == Tipo.PANEL_ORDEN_COMPRA) {
            panelOrdenCompra.setComponente(resultado);
            dispose();
        } else if (tipo == Tipo.PANEL_ORDEN_PRODUCCION) {
            panelOrdenProduccion.setProducto((ProductoComponente) resultado);
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
    List<Componente> todos;
    componentes = new ArrayList<Componente>();

    if (tipo == Tipo.PANEL_ORDEN_COMPRA) {
        consulta = FachadaPersistencia.getInstancia().crearConsulta(
                "SELECT a FROM Componente a " +
                "WHERE ( (a.nombre) LIKE :nombre OR (a.codigo) LIKE :codigo ) " +
                "AND a.borrado = false AND a.tipo IN (:tipo1, :tipo2)");
        consulta.setParameter("nombre", "%" + tfNombre.getText() + "%");
        consulta.setParameter("codigo", "%" + tfCodigo.getText() + "%");
        consulta.setParameter("tipo1", 'C');
        consulta.setParameter("tipo2", 'M');

        todos = FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);

        for (Componente componente : todos) {
            if(componente.getProveedores().contains(proveedor)){
                componentes.add(componente);
            }
        }

    } else if (tipo == Tipo.PANEL_ORDEN_PRODUCCION) {

        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from Componente a where a.borrado=false");

        componentes = FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);

    } else {
        consulta = FachadaPersistencia.getInstancia().crearConsulta("Select a from Componente a where ( (a.nombre) LIKE :nombre or (a.codigo) LIKE :codigo ) and a.borrado=false and a.tipo= :tipo");
        consulta.setParameter("nombre", "%" + tfNombre.getText() + "%");
        consulta.setParameter("codigo", "%" + tfCodigo.getText() + "%");

        if (tipo == Tipo.TABLE_MODEL) {
            // TODO: aca depende de q necesitamos para el TableModel
        } else if (tipo == Tipo.PANEL_PROD_COMPONENTE || tipo == Tipo.PANEL_DEMANDA) {
            consulta.setParameter("tipo", 'C');
        } else {
            consulta.setParameter("tipo", 'T');
        }

        componentes = FachadaPersistencia.getInstancia().buscar(Componente.class, consulta);
    }

//    indice=componentes.size();
//    for (int i = 0; i < indice; i++) {
//        tmBuscar.agregarFila(componentes.get(i));
//    }
    if (componentes != null) {
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
}
