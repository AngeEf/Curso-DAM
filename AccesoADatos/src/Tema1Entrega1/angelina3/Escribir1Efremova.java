package Tema1Entrega1.angelina3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Escribir1Efremova {
    public static BufferedWriter escribir = null;

    public static void setFlujo() {
        try {
            escribir = new BufferedWriter(new FileWriter("archivos/diagonal.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviar() {
        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(100) + 1;
        try {
            escribir.write(num1 + "\n");
            escribir.write("\t" + num2 + "\n");
            escribir.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        System.out.println("Paso 1: Los dos primeros numeros se han escrito correctamente en diagonal.xls.");
    }
}
