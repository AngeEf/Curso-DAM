package T2Entrega1;

// Многократный запуск процесса и сохранение результатов в массивы
// Класс Personas запускает процесс Persona 4 раза.
// Каждый запуск Persona спрашивает у пользователя имя, фамилию и год рождения (short), после чего (под защитой семафора) отправляет эти 3 значения обратно в Personas
// Personas сохраняет их в три массива (String[], String[], short[]) и в конце выводит список всех 4 человек.
// здесь Persona должен одновременно читать ввод с клавиатуры пользователя (System.in) И отдавать свой вывод родителю (не в консоль, а в InputStream родителя).
// Для этого вместо inheritIO() используется pb.redirectInput(ProcessBuilder.Redirect.INHERIT)
// Persona.java (дочерний процесс) -> Personas

import java.io.*;

public class Personas {
    public static void main(String[] args) {
        String jBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        String cp = System.getProperty("java.class.path");

        // Массивы для хранения данных о 4 людях
        String[] nombres = new String[4];
        String[] apellidos = new String[4];
        short[] anios = new short[4];

        for (int i = 0; i < 4; i++) {
            System.out.println("\n--- Introduciendo datos de la Persona " + (i + 1) + " ---");
            ProcessBuilder pb = new ProcessBuilder(jBin, "-cp", cp, "paquete.Persona");

            // Подключаем клавиатуру к дочернему процессу, но НЕ перенаправляем его вывод (stdout)
            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            // Подключаем System.err к консоли, чтобы подсказки ("Escribe tu nombre:") видел пользователь,
            // а чистые данные шли только в System.out для родителя!
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);

            try {
                Process p = pb.start();

                // Читаем ровно 3 строки с чистыми данными, которые прислал Persona
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                nombres[i] = br.readLine();
                apellidos[i] = br.readLine();
                anios[i] = Short.parseShort(br.readLine()); // Преобразуем строку в short

                br.close();
                p.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Выводим собранные данные из массивов
        System.out.println("\n=== LISTADO DE PERSONAS ===");
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + nombres[i] + " " + apellidos[i] + " (Año: " + anios[i] + ")");
        }
    }
}
