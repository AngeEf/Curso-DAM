package T2Entrega1;

// Отправка и приём данных между процессами (OutputStream и InputStream)
// Класс Numeros запускает процесс Receptor и отправляет ему 5 чисел типа short.
// Receptor принимает их, выводит в свой поток вывода, а Numeros перехватывает этот вывод и печатает у себя на экране.
// Receptor.java (дочерний процесс)

import java.io.*;

public class Numeros {
    public static void main(String[] args) {
        String jBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String cp = System.getProperty("java.class.path");

        // ВАЖНО: НЕ вызываем pb.inheritIO(), потому что нам нужно перехватить ввод и вывод!
        ProcessBuilder pb = new ProcessBuilder(jBin, "-cp", cp, "paquete.Receptor");

        try {
            Process p = pb.start();

            // 1. ОТПРАВКА ДАННЫХ в дочерний процесс (пишем в его входной поток)
            OutputStream os = p.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true); // true = авто-сброс буфера (autoFlush)

            short[] datos = {10, 25, 300, -5, 1000};
            for (short n : datos) {
                pw.println(n); // Отправляем каждое число с новой строки
            }
            pw.flush();
            pw.close(); // ОБЯЗАТЕЛЬНО закрыть, чтобы Receptor понял, что данные закончились!

            // 2. ПРИЁМ ДАННЫХ от дочернего процесса (читаем то, что он вывел в System.out)
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("[Desde Numeros] " + linea);
            }
            br.close();

            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}