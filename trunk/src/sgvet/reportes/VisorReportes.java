package sgvet.reportes;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 * Visualizador para reportes de JasperReports
 *
 * @author R-Link
 * @version 0.1
 */
public class VisorReportes extends JRViewer {

    static final long serialVersionUID = -1L;

    /**
     * Crea una instancia de reportes vacia. Incluida para soporte JavaBeans
     */
    public VisorReportes() {
        super(null);
    }

    /**
     * Crea un nuevo formulario VisorReportes
     *
     * @param jp reporte a cargar al iniciar el visualizador
     */
    public VisorReportes(JasperPrint jp) {
        super(jp);
        initComponents();
    }

    /**
     * Carga el reporte en el visualizador
     *
     * @param jp reporte a cargar en el visualizador
     */
    public void cargarReporte(JasperPrint jp) {
        super.loadReport(jp);
        super.forceRefresh();
    }

    /**
     * Inicializacion del formulario.
     * WARNING: no moficar. Espacio regenerado por el Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}