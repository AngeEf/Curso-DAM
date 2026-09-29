package proyectoInterfaces;

import java.io.FileInputStream;
import java.io.IOException;

public class Leer {

    public static FileInputStream leer = null;
    public static String recibir = "";

    public static void setFlujo() {
        try {
            leer = new FileInputStream("archivo.xls");
        } catch(IOException e) {
            // Улучшенное логирование ошибки
            System.out.println(e.getMessage());
        }
    }

    public static void recoger() {
        short nChar;
        char car;
        short cont = 0; // cont оставляем 0, так как мы его инкрементируем (cont++)

        try {
            // 1. Считаем количество символов в файле
            while (leer.read() != -1) {
                cont++;
            }

            cerrarFlujo(); // Закрываем поток
            setFlujo();    // и открываем снова, чтобы читать с самого начала

            // Используем StringBuilder для эффективной сборки текста в цикле
            StringBuilder sb = new StringBuilder();

            // 2. Читаем символы и добавляем их в буфер
            for (nChar = 0; nChar < cont; nChar++) {
                car = (char)(leer.read());
                sb.append(car); // Вместо (recibir += car;) используем метод append()
            }

            // Превращаем собранный буфер в обычную строку и сохраняем в recibir
            recibir = sb.toString();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cerrarFlujo() {
        try {
            if (leer != null) {
                leer.close();
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void main(String[] args) {
        setFlujo();
        recoger();
        cerrarFlujo();

        System.out.println("=== CONTENIDO DE ARCHIVO.XLS ===");
        System.out.println(recibir);
    }
}