package Examen_P1;

public class CanalTelemetria {

    private static final double SIN_MEDICION = -1.0;
    private static final double VALOR_MINIMO = 0.0;
    private static final double VALOR_MAXIMO = 100.0;

    private static int contadorCanales = 0;

    private final int identificador;
    private String nombre;
    private double ultimoValor;

    public CanalTelemetria(int identificador, String nombre) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser positivo.");
        }
        if (!nombreValido(nombre)) {
            throw new IllegalArgumentException("El nombre no puede ser nulo, vacío ni solo espacios.");
        }
        this.identificador = identificador;
        this.nombre = nombre;
        this.ultimoValor = SIN_MEDICION;
        contadorCanales++;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombreValido(nombre)) {
            throw new IllegalArgumentException("El nombre no puede ser nulo, vacío ni solo espacios.");
        }
        this.nombre = nombre;
    }

    public static int getContadorCanales() {
        return contadorCanales;
    }

    public boolean registrarMedicion(double valor) {
        if (!medicionValida(valor)) {
            return false;
        }
        this.ultimoValor = valor;
        return true;
    }

    public String obtenerEstadoMedicion() {
        if (ultimoValor == SIN_MEDICION) {
            return "Sin mediciones";
        }
        return "Última medición: " + ultimoValor;
    }

    private static boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    private static boolean medicionValida(double valor) {
        return Double.isFinite(valor) && valor >= VALOR_MINIMO && valor <= VALOR_MAXIMO;
    }
}
