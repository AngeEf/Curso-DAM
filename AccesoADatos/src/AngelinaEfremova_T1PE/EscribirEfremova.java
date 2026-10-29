package AngelinaEfremova_T1PE;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class EscribirEfremova {
    public static Writer escribir = null;

    public static void setFlujo() {
        try {
            escribir = new FileWriter("AccesoADatos/resources/Nombre.xls");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static int generarAleatorio() {
        Random random = new Random();
        int n;
        do {
            n = random.nextInt(189) + 11;
        } while (n % 2 == 0 || n == 55);

        return n;
    }

    public static void enviar() {
        int n = generarAleatorio();
        int max = n + 200;
        boolean enColumnaA = true;

        try {
            for (int i = n; i <= max; i += 2) {
                if (enColumnaA) {
                    escribir.write(i + "\n");
                } else {
                    escribir.write("\t" + i + "\n");
                }
                enColumnaA = !enColumnaA; // Columnas alternas A y B
            }
            escribir.flush();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void cerrarFlujo() {
        try {
            if (escribir != null) {
            escribir.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void main(String[] args) {
        setFlujo();
        enviar();
        cerrarFlujo();
        System.out.println("El archivo Nombre.xls ha escrito");
    }

}
