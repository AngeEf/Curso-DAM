package proyectoInterfaces;

import java.io.FileOutputStream;
import java.io.IOException;
// import java.util.UUID;

public class Escribir {

    public static FileOutputStream escribir = null;

    // Используем \t для перехода в ячейку справа и \n для перехода на строку ниже
    public static String codigoEnviar = "Monumento\tContinente\nChichen Itza\tAmerica\nColiseo\tEuropa\nKeops\tAfrica\n";

    public static void setFlujo() {
        try {
            // Генерируем уникальный идентификатор
            //String uniqueID = UUID.randomUUID().toString();

            // Формируем путь: папка recursos/ + базовое имя + UUID + расширение
            // String nombreArchivo = "recursos/archivo_" + uniqueID + ".xls";

            // Открываем поток данных к файлу. Если файла нет, он будет создан
             escribir = new FileOutputStream("archivo.xls");
            // escribir = new FileOutputStream(nombreArchivo);

            // Выводим имя в консоль, чтобы точно знать, что создали
            // System.out.println("Flujo abierto para:" + nombreArchivo);
        } catch(IOException e) {
            // Заменили printStackTrace на более аккуратный вывод сообщения об ошибке
            System.out.println(e.getMessage());
        }
    }

    public static void enviar() {
        short nChar;
        char car;

        try {
            // Проходим по всем символам строки для записи
            for (nChar = 0; nChar < codigoEnviar.length(); nChar++) {
                car = codigoEnviar.charAt(nChar);
                escribir.write((byte)car); // Отправляем символы по одному
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cerrarFlujo() {
        try {
            if (escribir != null) {
                escribir.close();
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void main(String[] args) {
        setFlujo();
        enviar();
        cerrarFlujo();
        System.out.println("Archivo archivo.xls creado exitosamente.");
    }
}