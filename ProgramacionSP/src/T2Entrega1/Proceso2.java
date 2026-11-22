package T2Entrega1;

import java.io.File;
import java.io.IOException;

public class Proceso2 {
    public static void main(String[] args) {
        System.out.println("[Proceso 2] Inicio");

        try {
            // Формируем пути к Java и классам проекта для запуска дочернего процесса
            String jH = System.getProperty("java.home");
            String jBin = jH + File.separator + "bin" + File.separator + "java";
            String carpetaClass = System.getProperty("java.class.path");

            // Готовим запуск Процесса 3
            ProcessBuilder pb3 = new ProcessBuilder(jBin, "-cp", carpetaClass, "angelinaEfremova1.Proceso3");
            // Обязательно наследуем ввод/вывод, чтобы пользователь мог вводить числа с клавиатуры в Процессе 3
            pb3.inheritIO();

            System.out.println("[Proceso 2] Esperando a que termine el Proceso 3...");
            // Запускаем Процесс 3
            Process p3 = pb3.start();

            // Блокируем выполнение Процесса 2 до тех пор, пока Процесс 3 не завершится.
            // waitFor() возвращает код завершения (0 — всё прошло успешно).
            int exitCode = p3.waitFor();

            if (exitCode == 0) {
                System.out.println("[Proceso 2] Proceso 3 ha finalizado con éxito.");
            } else {
                System.out.println("[Proceso 2] Proceso 3 finalizó con errores.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("[Proceso 2] Excepción: " + e.getMessage());
        }

        System.out.println("[Proceso 2] Fin");
    }
}
