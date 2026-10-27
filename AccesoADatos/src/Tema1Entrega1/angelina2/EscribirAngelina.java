package Tema1Entrega1.angelina2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class EscribirAngelina {
    public static Writer escribir = null;

    public static void setFlujo() {
        try {
            escribir = new FileWriter("archivos/numeros.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduciendo datos para la tabla numeros.xls:");
        System.out.print("Introduzca el primer numero (float): ");
        float num1 = scanner.nextFloat();
        System.out.print("Introduzca el primer numero (float): ");
        float num2 = scanner.nextFloat();
        System.out.print("Introduzca el primer numero (float): ");
        float num3 = scanner.nextFloat();
        try {
            for (int fila = 1; fila <= 10; fila++) {
                String linea = fila + "\t" + num1 + "\t" + num2 + "\t" + num3 + "\n";
                escribir.write(linea);
            }
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
        System.out.println("El archivo numeros.xls se ha creado correctamente y se ha rellenado con 10 filas.");
    }
}
