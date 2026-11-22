package T2Entrega1;

// Persona.java (дочерний процесс) -> Personas

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Persona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Semaphore semaforo = new Semaphore(1);

        // Подсказки выводим в System.err, чтобы они показались пользователю,
        // но НЕ попали в BufferedReader родителя (он читает только System.out)
        System.err.print("Nombre: ");
        String nombre = sc.nextLine();

        System.err.print("Primer apellido: ");
        String apellido = sc.nextLine();

        System.err.print("Año de nacimiento: ");
        short anio = sc.nextShort();

        // Отправляем все 3 значения или ни одного под защитой семафора
        try {
            semaforo.acquire();
            System.out.println(nombre);
            System.out.println(apellido);
            System.out.println(anio);
            System.out.flush(); // Принудительно отправляем данные родителю
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        } finally {
            semaforo.release();
            sc.close();
        }
    }
}
