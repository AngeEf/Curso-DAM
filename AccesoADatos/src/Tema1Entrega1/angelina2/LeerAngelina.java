package Tema1Entrega1.angelina2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerAngelina {
    public static BufferedReader leer = null;

    public static void setFlujo() {
        try {
            leer = new BufferedReader(new FileReader("archivos/numeros.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recogerYMostrar() {
        String linea;
        int numeroFila = 1;

        try {
            System.out.println("Contenido de 3 lineas seleccionadas (lineas 2, 5 y 8)");
            while ((linea = leer.readLine()) != null) {
                // Seleccione la 2, 5 y 7 linea para la salida.
                if (numeroFila == 2 || numeroFila == 5 || numeroFila == 7) {
                    System.out.println("Linea " + numeroFila + ": " + linea);
                }
                numeroFila++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cerrarFlujo() {
        try {
            if (leer != null) {
                leer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void main(String[] args) {
        setFlujo();
        recogerYMostrar();
        cerrarFlujo();
    }
}
