package Arreglo_Tienda.modelo.interfaz;

import Arreglo_Tienda.modelo.AppStore;
import Arreglo_Tienda.modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    public static void main(String[] args) {
        int opc;

        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    ingresarJuego();
                    break;
                case 2:
                    mostrarJuegos();
                    break;
                case 3:
                    buscarJuego();
                    break;
                case 4:
                    comprar();
                    break;
                case 5:
                    vender();
                    break;
                case 6:
                    juegoMasVendido();
                    break;
                case 7:
                    System.out.println("\n¡Gracias, hasta pronto!");
                    break;
                default:
                    System.out.println("\nOpción no válida, intente de nuevo.");
                    break;
            }
        } while (opc != 7);
    }

    // --- Menú ---

    public static void menu() {
        System.out.println("********** AppStore Udla **********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    // --- Operaciones ---

    public static void ingresarJuego() {
        System.out.println("******* Ingreso de datos *******");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());

        if (tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            JOptionPane.showMessageDialog(null, "Juego agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Juego no agregado correctamente");
        }
    }

    public static void mostrarInformacion() {
        if (tienda.getIndice() >= 0) {
            for (int i = 0; i <= tienda.getIndice(); i++) {
                System.out.println(tienda.getJuegos()[i]);
            }
        } else {
            System.out.println("No hay juegos que mostrar");
        }
    }

    public static void mostrarJuegos() {
        System.out.println("******* Lista de juegos *******");
        if (tienda.getIndice() >= 0) {
            for (int i = 0; i <= tienda.getIndice(); i++) {
                System.out.println("  " + (i + 1) + ". " + tienda.getJuegos()[i]);
            }
        } else {
            System.out.println("No hay juegos que mostrar");
        }
    }

    public static void buscarJuego() {
        System.out.println("******* Buscar juego *******");
        System.out.print("Ingrese el nombre del juego: ");
        String nombre = sc.nextLine();
        Juego j = tienda.buscarJuego(nombre);

        if (j != null) {
            System.out.println("  " + j);
        } else {
            System.out.println("Juego no encontrado");
        }
    }

    public static void comprar() {
        System.out.println("******* Comprar juego *******");
        System.out.print("Ingrese el nombre del juego: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        if (tienda.comprar(nombre, cantidad)) {
            JOptionPane.showMessageDialog(null, "Compra realizada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Compra no realizada");
        }
    }

    public static void vender() {
        System.out.println("******* Vender juego *******");
        System.out.print("Ingrese el nombre del juego: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        double total = tienda.vender(nombre, cantidad);
        if (total > 0) {
            System.out.println("Venta realizada. Total: $" + total);
        } else {
            System.out.println("Venta no realizada");
        }
    }

    public static void juegoMasVendido() {
        System.out.println("******* Juego más vendido *******");
        String nombre = tienda.masVendido();

        if (!nombre.isEmpty()) {
            System.out.println("El juego más vendido es: " + nombre);
        } else {
            System.out.println("No hay juegos vendidos");
        }
    }
}
