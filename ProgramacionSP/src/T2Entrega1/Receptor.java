package T2Entrega1;

// Receptor.java (дочерний процесс) main -> Numeros

import java.util.Scanner;

public class Receptor {
    public static void main(String[] args) {
        // Читаем данные, которые прислал родитель через OutputStream
        Scanner sc = new Scanner(System.in);

        System.out.println("Valores recibidos en Receptor:");
        // Пока во входном потоке есть числа типа short — читаем их
        while (sc.hasNextShort()) {
            short num = sc.nextShort();
            System.out.println("Número: " + num);
        }
        sc.close();
    }
}
