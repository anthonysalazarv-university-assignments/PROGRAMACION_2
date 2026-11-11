package Arreglo_Tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego[] juegos;
    private int indice;

    public AppStore() {
        juegos = new Juego[MAX];
        indice = -1;
    }

    // --- Getters ---

    public Juego[] getJuegos() {
        return juegos;
    }

    public int getIndice() {
        return indice;
    }

    // --- Métodos de gestión ---

    public boolean agregarJuego(Juego j) {
        if (j != null && indice < MAX - 1) {
            juegos[++indice] = j;
            return true;
        }
        return false;
    }

    public Juego buscarJuego(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            for (int i = 0; i <= indice; i++) {
                if (juegos[i].getNombre().equalsIgnoreCase(nombre)) {
                    return juegos[i];
                }
            }
        }
        return null;
    }

    // --- Métodos de negocio ---

    public boolean comprar(String nombre, int cantidad) {
        if (nombre != null && !nombre.trim().isEmpty() && cantidad > 0) {
            Juego j = buscarJuego(nombre);
            if (j != null) {
                return j.comprar(cantidad);
            }
        }
        return false;
    }

    public double vender(String nombre, int cantidad) {
        Juego j = buscarJuego(nombre);
        if (j != null) {
            if (j.vender(cantidad)) {
                return j.getPrecio() * cantidad;
            }
        }
        return 0;
    }

    // --- Datos iniciales ---

    public void cargarDatos() {
        agregarJuego(new Juego("Minecraft", "Aventura", 1024, 29.99, 50));
        agregarJuego(new Juego("FIFA 25", "Deportes", 4096, 59.99, 30));
        agregarJuego(new Juego("Call of Duty", "Shooter", 8192, 69.99, 20));
        agregarJuego(new Juego("Among Us", "Estrategia", 512, 4.99, 100));
    }

    // --- Estadísticas ---

    public String masVendido() {
        String nombre = "";
        int mayor = 0;
        if (indice >= 0) {
            nombre = juegos[0].getNombre();
            mayor = juegos[0].getLicenciasVendidas();
            for (int i = 1; i <= indice; i++) {
                if (juegos[i].getLicenciasVendidas() > mayor) {
                    nombre = juegos[i].getNombre();
                    mayor = juegos[i].getLicenciasVendidas();
                }
            }
        }
        return nombre;
    }
}
