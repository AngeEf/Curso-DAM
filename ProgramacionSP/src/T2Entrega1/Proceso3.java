package T2Entrega1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Proceso3 {
    public static void main(String[] args) {
        System.out.println("[Proceso 3] Inicio");

        // Создаём бинарный семафор с 1 разрешением (одновременно в блок кода может войти только 1 поток)
        Semaphore semaforo = new Semaphore(1);
        // Объект для чтения ввода пользователя с клавиатуры
        Scanner scanner = new Scanner(System.in);
        int n1 = 0, n2 = 0, n3 = 0;

        try {
            // Захватываем семафор (начало критической секции по условию задания)
            semaforo.acquire();

            // Последовательно запрашиваем у пользователя три целых числа
            System.out.println("[Proceso 3] Ingrese el primer número entero:");
            n1 = scanner.nextInt();

            System.out.println("[Proceso 3] Ingrese el segundo número entero:");
            n2 = scanner.nextInt();

            System.out.println("[Proceso 3] Ingrese el tercer número entero:");
            n3 = scanner.nextInt();

            // Выводим все три введённых числа
            System.out.println("[Proceso 3] Los números ingresados son: " + n1 + ", " + n2 + ", " + n3);

        } catch (InterruptedException e) {
            // Ошибка, если поток был прерван во время ожидания семафора
            System.err.println("[Proceso 3] Error en la adquisición del semáforo: " + e.getMessage());
        } finally {
            // Блок finally выполнится в любом случае (даже при ошибке):
            // освобождаем семафор и закрываем Scanner, чтобы не было утечки ресурсов
            semaforo.release();
            scanner.close();
        }

        System.out.println("[Proceso 3] Fin");
    }
}
