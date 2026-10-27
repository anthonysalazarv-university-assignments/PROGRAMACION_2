package Examen_P1;

public class MainTelemetria {
    public static void main(String[] args) {
        System.out.println("Canales creados: " + CanalTelemetria.getContadorCanales());

        CanalTelemetria canal = new CanalTelemetria(1, "Temperatura");
        System.out.println("Canales creados: " + CanalTelemetria.getContadorCanales());
        System.out.println(canal.obtenerEstadoMedicion());

        System.out.println("Registrar 45.0: " + canal.registrarMedicion(45.0));
        System.out.println(canal.obtenerEstadoMedicion());

        System.out.println("Registrar 120.0: " + canal.registrarMedicion(120.0));
        System.out.println(canal.obtenerEstadoMedicion());

        System.out.println("Registrar 0.0: " + canal.registrarMedicion(0.0));
        System.out.println(canal.obtenerEstadoMedicion());

        try {
            new CanalTelemetria(-5, "Invalido");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Canales creados: " + CanalTelemetria.getContadorCanales());
    }
}