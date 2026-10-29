package AngelinaEfremova_T1PE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerEfremova {
    public static BufferedReader leer = null;

    public static void setFlujo() {
        try {
            leer = new BufferedReader(new FileReader("AccesoADatos/resources/Nombre.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void recogerYMostrar() {
        try {
            String linea;
            while ((linea = leer.readLine()) != null) {
                // Значения из столбца B начинаются с символа табуляции \\t
                if (linea.startsWith("\t")) {
                    System.out.println(linea.trim());
                }
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
