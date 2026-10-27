package Tema1Entrega1.angelina3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerEfremova {
    public static BufferedReader leer = null;

    public static void setFlujo() {
        try {
            leer = new BufferedReader(new FileReader("archivos/diagonal.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recogerYMostrar() {
        try {
            String linea;
            System.out.println("Contenido del archivo diagonal.xls");
            while ((linea = leer.readLine()) != null) {
                System.out.println(linea);
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
