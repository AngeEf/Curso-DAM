package Tema1Entrega1.angelina1;

import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirEfremova {
    public static FileOutputStream escribir = null;

    public static void setFlujo() {
        try {
            escribir = new FileOutputStream("archivos/palabras.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviar() {
        String[] listaPalabras = {"Manzana", "Platano", "Naranja", "Uva", "Fresa", "Mango", "Pina", "Sandia", "Melon", "Kiwi"};
        try {
            for (int i = 0; i < 10; i++) {
                int indiceAleatorio = (int) (Math.random() * listaPalabras.length);
                String palabra = listaPalabras[indiceAleatorio] + "\\n";
                escribir.write(palabra.getBytes());
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
        System.out.println("El archivo palabras.txt se ha creado correctamente y se ha rellenado con 10 palabras.");
    }
}
