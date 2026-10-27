package Tema1Entrega1.efremova2;

import java.util.Random;

public class Efremova implements Angelina {
    private byte al;

    @Override
    public byte generarAleatorio(byte min, byte max) {
        Random random = new Random();
        return (byte) (random.nextInt(max - min + 1) + min);
    }

    @Override
    public void calcularValores() {
        // Rango 1:
        byte min = 10;
        byte max = 20;
        byte minAl = generarAleatorio(min, max);
        // Rango 2:
        min = 30;
        max = 40;
        byte maxAl = generarAleatorio(min, max);
        // // Total: [minAl, maxAl]
        this.al = generarAleatorio(minAl, maxAl);
    }

    @Override
    public void show() {
        System.out.println("Aleatorio: " + this.al);
    }

    static void main(String[] args) {
        Efremova ejercicio2 = new Efremova();
        ejercicio2.calcularValores();
        ejercicio2.show();
    }
}
