package Tema1Entrega1.angelinaEfremova1;

public class Ejercicio1 {
    static void main(String[] args) {
        // Crear flujo 2 (retraso de 3s)
        Thread hilo2 = new Thread(() -> {
            try {
                Thread.sleep(3000); // retraso de 3s
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Hilo-2");
        // Crear flujo 1 (espera 1s y luego Hilo-2 se complete mediante join)
        Thread hilo1 = new Thread(() -> {
            try {
                Thread.sleep(1000); // retraso de 1s
                System.out.println("Estado " + Thread.currentThread().getName() + " antes join: " + Thread.currentThread().getState());
                // espera Hilo-2
                hilo2.join();
                System.out.println("Estado " + Thread.currentThread().getName() + " despues join: " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        },"Hilo-1");

        // Establecimos la prioridad: el flujo 1 es superior al flujo 2.
        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("--- Info sobre hilos ---");
        System.out.println(hilo1.getName() + " | Prioridad: " + hilo1.getPriority() + " | ID: " + hilo1.getId());
        System.out.println(hilo2.getName() + " | Prioridad: " + hilo2.getPriority() + " | ID: " + hilo2.getId());

        // Estados antes de la llamada start()
        System.out.println("Estado " + hilo1.getName() + " antes start(): " + hilo1.getState());
        System.out.println("Estado " + hilo2.getName() + " antes start(): " + hilo2.getState());

        hilo1.start();
        hilo2.start();

        try {
            Thread.sleep(500);
            System.out.println("Estado " + hilo2.getName() + " durante del proceso: " + hilo2.getState());
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Estados despues de la finalización
        System.out.println("Estado " + hilo1.getName() + " al final: " + hilo1.getState());
        System.out.println("Estado " + hilo2.getName() + " al final: " + hilo2.getState());
    }
}
