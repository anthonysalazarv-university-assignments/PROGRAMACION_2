package Arreglo_Tienda.modelo.interfaz;

import Arreglo_Tienda.modelo.AppStore;
import Arreglo_Tienda.modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    public static void main(String[] args){
       int opc;
       tienda.cargarDatos();
        do{
        
        menu();
        opc = Integer.parseInt(sc.nextLine());
        switch (opc){
            case 1:

ingresarJuego();
mostarInforamcion();
            break;
            case 2:

            break;
            case 3:

            break;
            case 4:

            break;
            case 5:

            break;
            case 6:

            break;
            case 7:
                System.out.println("\n¡Gracias Hasta pronto!");
            break;
            default:
                System.out.println("\n no me aucuerdo");
            break;



        }

        }while(opc!=7);

    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }
    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
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
        if(tienda.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "Juego agregado correctamente");
        }else {
            JOptionPane.showMessageDialog(null, "Juego no agregado correctamente");
        }
    }
    public static void mostarInforamcion(){
        if(tienda.getIndice()>=0){
            for(int i=0; i <=tienda.getIndice(); i++){
                System.out.println(tienda.getJuegos()[i]);
            }
        } else{
            System.out.println("no hay juegos que mostrar");
        }
    }
}
