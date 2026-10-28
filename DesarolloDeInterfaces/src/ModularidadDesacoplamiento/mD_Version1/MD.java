package ModularidadDesacoplamiento.mD_Version1;

import java.util.Scanner;

public class MD 
{
/*Tipo 2.Empleando Clase.java, Funciones.java y diversas funciones, mejorar la modularidad y el 
 * desacoplamiento del siguiente código, considerando atributos no auxiliares a 
todas las variables del main:
*/
	static void main(String[] args) {
		float min = 5, max = 8;
		float minAl = (float) (min+(Math.random()*(max-min)));
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca número con decimales: ");
		float maxAl = Float.valueOf(sc.nextLine());
		float al = (byte) (minAl+(Math.random()*(maxAl-minAl)));
		System.out.println("Aleatorio: " + al);
		sc.close();

	}

}
