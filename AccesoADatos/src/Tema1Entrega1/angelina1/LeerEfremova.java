package Tema1Entrega1.angelina1;

import java.io.FileInputStream;
import java.io.IOException;

public class LeerEfremova {

    public static FileInputStream leer = null;
    public static String contenidoRecibido = "";

    public static void setFlujo() {
        try {
            leer = new FileInputStream("archivos/palabras.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recoger() {
        int valor;
        try {
            while ((valor = leer.read()) != -1) {
                contenidoRecibido += (char) valor;
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

    public static void mostrar() {
        System.out.println("Содержимое файла palabras.txt");
        System.out.println(contenidoRecibido);
    }

    static void main(String[] args) {
        setFlujo();
        recoger();
        cerrarFlujo();
        mostrar();
    }
}
