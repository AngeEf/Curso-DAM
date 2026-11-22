package T2Entrega1;

import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        System.out.println("=== Lanzador Principal iniciado ===");
        try {
            // Получаем путь к папке, где установлена Java (например, C:\Program Files\Java\jdk...)
            String jH = System.getProperty("java.home");
            // Формируем полный путь к исполняемому файлу java (File.separator ставит / или \ в зависимости от ОС)
            String jBin = jH + File.separator + "bin" + File.separator + "java";
            // Получаем путь к скомпилированным .class файлам текущего проекта
            String carpetaClass = System.getProperty("java.class.path");

            // Настраиваем запуск Процесса 1: аналог команды "java -cp <путь> angelinaEfremova1.Proceso1"
            ProcessBuilder pb1 = new ProcessBuilder(jBin, "-cp", carpetaClass, "angelinaEfremova1.Proceso1");
            // Подключаем консоль дочернего процесса к текущей консоли (чтобы видеть вывод)
            pb1.inheritIO();
            // Запускаем Процесс 1 и ждём его полного завершения, прежде чем идти дальше
            Process p1 = pb1.start();
            p1.waitFor();

            // Настраиваем и запускаем Процесс 2 аналогичным образом
            ProcessBuilder pb2 = new ProcessBuilder(jBin, "-cp", carpetaClass, "angelinaEfremova1.Proceso2");
            pb2.inheritIO();
            // Запускаем Процесс 2 и ждём, пока он (вместе с Процессом 3 внутри) не завершится
            Process p2 = pb2.start();
            p2.waitFor();

        } catch (IOException | InterruptedException e) {
            // Обрабатываем ошибки запуска процесса (IOException) или прерывания ожидания (InterruptedException)
            e.printStackTrace();
        }

        System.out.println("=== Lanzador Principal finalizado ===");
    }
}
