package proyectoInterfaces;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== CREANDO EQUIPOS DE FUTBOL ===");

        // Crear dos objetos de la subclase Futbol
        // El numero de Champions se genera automaticamente de forma aleatoria
        Futbol equipoFutbol1 = new Futbol("Real Madrid");
        Futbol equipoFutbol2 = new Futbol("FC Barcelona");

        System.out.println("\n=== CREANDO EQUIPOS DE BALONCESTO ===");

        // Crear dos objetos de la subclase Baloncesto
        Baloncesto equipoBaloncesto1 = new Baloncesto("Olympiacos");
        Baloncesto equipoBaloncesto2 = new Baloncesto("Panathinaikos");

        // Pedir al usuario el numero de Euroligas para el primer equipo
        System.out.print("Introduzca el numero de Euroligas para " + equipoBaloncesto1.getNombre() + ": ");
        int euroligas1 = Integer.parseInt(sc.nextLine()); // Leemos el valor introducido por el usuario
        equipoBaloncesto1.setNumEuroligas(euroligas1); // Asignamos el valor al equipo

        // Pedir al usuario el numero de Euroligas para el segundo equipo
        System.out.print("Introduzca el numero de Euroligas para " + equipoBaloncesto2.getNombre() + ": ");
        int euroligas2 = Integer.parseInt(sc.nextLine());
        equipoBaloncesto2.setNumEuroligas(euroligas2);

        sc.close();

        System.out.println("\n=== MOSTRANDO TODOS LOS VALORES ===");

        // Mostrar todos sus valores llamando al metodo showS() obligado
        equipoFutbol1.showS();
        equipoFutbol2.showS();
        equipoBaloncesto1.showS();
        equipoBaloncesto2.showS();
    }
}