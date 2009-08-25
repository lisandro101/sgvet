package sgvet.reportes;

/**
 *
 * @author franco
 */
public enum TipoReporte {
    EMPLEADOS ("Empleados"),
    PRODUCTOS_TERMINADOS("Productos terminados");

    private String nombre;

    private TipoReporte(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}