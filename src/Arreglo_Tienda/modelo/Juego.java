package Arreglo_Tienda.modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int tamanio;
    private double precio;
    private int licenciasDisponibles;
    private int licenciasVendidas;

    public Juego(String nombre, String categoria, int tamanio, double precio, int licenciasDisponibles) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tamanio = tamanio;
        this.precio = precio;
        this.licenciasDisponibles = licenciasDisponibles;
        licenciasVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }


    public String getCategoria() {
        return categoria;
    }

    public int getTamanio() {
        return tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.isEmpty()) {
            this.categoria = categoria;
        }
    }

    public void setTamanio(int tamanio) {
        if (tamanio > 0) {
            this.tamanio = tamanio;
        }
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }
    }
    public boolean comprar(int cantidad) {
        if (cantidad > 0 && cantidad <= licenciasDisponibles) {
            licenciasDisponibles -= cantidad;
            licenciasVendidas += cantidad;
            return true;
        }
        return false;
    }

    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= licenciasVendidas) {
            licenciasVendidas -= cantidad;
            licenciasDisponibles += cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " | " + categoria + " | " + tamanio + " MB | $" + precio + " | Disponibles: " + licenciasDisponibles + " | Vendidas: " + licenciasVendidas;
    }
}
