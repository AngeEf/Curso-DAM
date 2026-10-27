package Tema1Entrega1.angelinaEfremova2;

import java.util.Scanner;

public class Ejercicio2 {

    static void main(String[] args) {
        // Objeto de bloqueo para la comunicacion entre Hilo-1 e Hilo-3
        final Cerradura cerraduraHilo1a3 = new Cerradura();

        // Objeto de bloqueo para la comunicacion entre Hilo-2 e Hilos-4, 5 y 6
        final Cerradura cerraduraHilo2a456 = new Cerradura();

        // Hilo-3
        Thread hilo3 = new Thread(() -> {
            synchronized (cerraduraHilo1a3) {
                System.out.println("[Hilo-3] Esperando la notificacion de Hilo-1...");
                while (!cerraduraHilo1a3.adelante) {
                    try {
                        cerraduraHilo1a3.wait(); // Espera bloqueada hasta recibir notify()
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("[Hilo-3] Notificacion recibida de Hilo-1");
            }
        },"Hilo-3");

        // Hilo-1
        Thread hilo1 = new Thread(() -> {
            try {
                // Tiempo de espera aleatorio entre 500 y 1500 ms
                long tiempoEspera = (long) (500 + Math.random() * 1000);
                System.out.println("[Hilo-1] Iniciado. Esperando un tiempo aleatorio de " + tiempoEspera + " ms");
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (cerraduraHilo1a3) {
                System.out.println("[Hilo-1] Tiempo completado. Enviando notify() a Hilo-3");
                cerraduraHilo1a3.adelante = true;
                cerraduraHilo1a3.notify(); // Notifica a Hilo-3
            }
        }, "Hilo-1");

        // Hilo-4 | Hilo-5 | Hilo-6
        Runnable tareaEsperaGrupo = () -> {
            String nombreHilo = Thread.currentThread().getName();
            synchronized (cerraduraHilo2a456) {
                System.out.println("[" + nombreHilo + "] Esperando la notificacion comun de Hilo-2");
                while (!cerraduraHilo2a456.adelante) {
                    try {
                        cerraduraHilo2a456.wait(); // Espera bloqueada hasta recibir notifyAll()
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("[" + nombreHilo + "] Notificacion común recibida de Hilo-2");
            }
        };

        Thread hilo4 = new Thread(tareaEsperaGrupo, "Hilo-4");
        Thread hilo5 = new Thread(tareaEsperaGrupo, "Hilo-5");
        Thread hilo6 = new Thread(tareaEsperaGrupo, "Hilo-6");

        // Hilo-2
        Thread hilo2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            String respuesta = "";

            while (!respuesta.equalsIgnoreCase("y")) {
                System.out.print("[Hilo-2] Desea terminar el bucle? (y/n): ");
                respuesta = scanner.nextLine().trim();
            }

            synchronized (cerraduraHilo2a456) {
                System.out.println("[Hilo-2] Enviando notifyAll() a los Hilos 4, 5 y 6");
                cerraduraHilo2a456.adelante = true;
                cerraduraHilo2a456.notifyAll();
            }
        }, "Hilo-2");

        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hilo1.start();
        hilo2.start();
    }
}

class Cerradura {
    public boolean adelante = false;
}