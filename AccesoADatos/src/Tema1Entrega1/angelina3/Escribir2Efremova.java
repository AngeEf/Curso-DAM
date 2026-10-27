package Tema1Entrega1.angelina3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir2Efremova {
    public static BufferedWriter escribir = null;

    public static void setFlujo() {
        try {
            escribir = new BufferedWriter(new FileWriter("archivos/diagonal.xls", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviar() {
        String[] listaPalabras = {"Manzana", "Platano", "Naranja", "Uva",};
        try {
            for (int i = 0; i < listaPalabras.length; i++) {
                int cantidadTabs = i + 2;
                String linea = "\t".repeat(cantidadTabs) + listaPalabras[i] + "\n";
                escribir.write(linea);
            }
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
        System.out.println("Paso 2: Se agregaron cuatro palabras correctamente a diagonal.xls.");
    }
}
