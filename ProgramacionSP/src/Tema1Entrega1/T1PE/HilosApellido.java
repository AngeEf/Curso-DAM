package Tema1Entrega1.T1PE;

import java.util.Scanner;

// Класс-монитор (Cerradura) для синхронизации потоков, как в учебных материалах
class Cerradura {
    public boolean hiloCTerminado = false; // Изначально поток C не завершен
}

public class HilosApellido {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cerradura cerr = new Cerradura(); // Общий ресурс для синхронизации

        // Создание Потока A (Hilo A)
        Thread hiloA = new Thread(() -> {
            System.out.println("Hilo A iniciado y en espera...");
            synchronized (cerr) {
                while (!cerr.hiloCTerminado) { // Ждем, пока Hilo C не завершится
                    try {
                        cerr.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            // 3 дополнительных секунды после завершения Hilo C
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Hilo A ha terminado.");
        });

        // Создание Потока B (Hilo B)
        Thread hiloB = new Thread(() -> {
            System.out.println("Hilo B iniciado y en espera...");
            synchronized (cerr) {
                while (!cerr.hiloCTerminado) { // Ждем, пока Hilo C не завершится
                    try {
                        cerr.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            // 3 дополнительных секунды после завершения Hilo C
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Hilo B ha terminado.");
        });

        // Создание Потока C (Hilo C)
        Thread hiloC = new Thread(() -> {
            System.out.println("Hilo C ejecutándose...");
            try {
                Thread.sleep(2000); // Симуляция работы Потока C
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Hilo C ha terminado. Notificando a Hilo A y Hilo B...");

            // Уведомление потоков A и B
            synchronized (cerr) {
                cerr.hiloCTerminado = true;
                cerr.notifyAll(); // Отправляем сигнал всем ожидающим потокам
            }
        });

        // Первый цикл: управление потоками A и B[cite: 5]
        while (true) {
            // Если оба потока запущены и выполняются, переходим ко второму циклу
            if (hiloA.isAlive() && hiloB.isAlive()) {
                System.out.println("\nAmbos hilos (A y B) se están ejecutando.");
                break;
            }

            System.out.println("\nElija una opción:");
            System.out.println("a. Lanzar ejecución de Hilo A.");
            System.out.println("b. Lanzar ejecución de Hilo B.");
            System.out.println("c. Preguntar si Hilo A se está ejecutando.");
            System.out.println("d. Preguntar si Hilo B se está ejecutando.");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine().toLowerCase();

            switch (opcion) {
                case "a":
                    if (hiloA.getState() == Thread.State.NEW) {
                        hiloA.start();
                    } else {
                        System.out.println("Hilo A ya ha sido lanzado.");
                    }
                    break;
                case "b":
                    if (hiloB.getState() == Thread.State.NEW) {
                        hiloB.start();
                    } else {
                        System.out.println("Hilo B ya ha sido lanzado.");
                    }
                    break;
                case "c":
                    System.out.println("¿Hilo A se está ejecutando? " + (hiloA.isAlive() ? "Sí" : "No"));
                    break;
                case "d":
                    System.out.println("¿Hilo B se está ejecutando? " + (hiloB.isAlive() ? "Sí" : "No"));
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        // Второй цикл: управление потоком C, когда A и B уже работают[cite: 1, 5]
        while (true) {
            System.out.println("\nElija una opción:");
            System.out.println("a. Lanzar ejecución de Hilo C.");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine().toLowerCase();

            if (opcion.equals("a")) {
                if (hiloC.getState() == Thread.State.NEW) {
                    hiloC.start();
                    break; // Запускаем C и выходим из цикла, чтобы программа могла штатно завершиться
                } else {
                    System.out.println("Hilo C ya ha sido lanzado.");
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
