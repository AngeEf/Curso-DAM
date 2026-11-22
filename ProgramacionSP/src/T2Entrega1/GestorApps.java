package T2Entrega1;

import java.io.IOException;
import java.util.Scanner;

// Управление внешними приложениями (isAlive и destroy)
// 1. Запустить Блокнот (notepad.exe) или Paint (mspaint.exe).
// 2. Закрыть запущенное приложение. Если приложение не запущено (или пользователь уже закрыл его сам), вывести сообщение об этом.
// 3. Выйти из программы.

        public class GestorApps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Для стандартных программ Windows достаточно имени.
        // Для остальных (например, Eclipse) нужен полный путь с двойными слешами: "C:\\ruta\\eclipse.exe"
        ProcessBuilder pbPaint = new ProcessBuilder("mspaint.exe");
        Process pPaint = null; // Ссылка на запущенный процесс

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n1. Abrir Paint | 2. Cerrar Paint | 3. Salir");
            opcion = sc.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        // Проверяем, не запущен ли уже процесс
                        if (pPaint != null && pPaint.isAlive()) {
                            System.out.println("Paint ya está en ejecución.");
                        } else {
                            pPaint = pbPaint.start();
                            System.out.println("Paint iniciado.");
                        }
                        break;

                    case 2:
                        // Проверяем, существует ли объект и жив ли ещё процесс
                        if (pPaint != null && pPaint.isAlive()) {
                            pPaint.destroy(); // Принудительно закрываем процесс
                            System.out.println("Paint cerrado.");
                        } else {
                            System.out.println("Error: Paint no se encuentra en ejecución.");
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException e) {
                System.err.println("Error al ejecutar la aplicación: " + e.getMessage());
            }
        }
        sc.close();
    }
}
