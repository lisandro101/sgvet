package sgvet.reportes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author franco
 */
public class GestorReportes {
    private Connection conn;

    public GestorReportes() {
        inicializar();
    }

    private void inicializar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/radiadores","radiadores",
                    "radiadores");
            conn.setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JasperPrint generar(TipoReporte tipoReporte) {
        JasperPrint resultado = null;
        JasperReport jr = null;

        switch(tipoReporte) {
            case EMPLEADOS:
                jr = obtenerReporte("/radiadores/reportes/empleados.jrxml");
                break;
            case PRODUCTOS_TERMINADOS:
                jr = obtenerReporte("/radiadores/reportes/productos_terminados.jrxml");
                break;
        }

        try {
            if (jr != null) {
                resultado = JasperFillManager.fillReport(jr, new HashMap(),
                        conn);
            }
        } catch (JRException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    private JasperReport obtenerReporte(String reporte) {
        JasperReport resultado = null;

        try {
            InputStream in = GestorReportes.class.getResourceAsStream(reporte);
            resultado = JasperCompileManager.compileReport(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
}