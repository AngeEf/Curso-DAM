package escribeUsuario;

import java.util.Scanner;

public class EscribeUsuario 
{	static Scanner sc = new Scanner(System.in);

	static void main(String[] args)
	{	String s;
		System.out.print("Introduzca cadena de caracteres: ");
		s = sc.nextLine();
		System.out.println("Ha introducido: "+s);
		
		byte b;
		System.out.print("Introduzca entero: ");
		b = Byte.valueOf(sc.nextLine());
		System.out.println("Ha introducido: "+b);
		//Igual en short, long, double, float, boolean
		
		int i;
		System.out.print("Introduzca entero: ");
		i = Integer.valueOf(sc.nextLine());
		System.out.println("Ha introducido: "+i);
		
		char c;
		System.out.print("Introduzca un caracter: ");
		c = sc.next().charAt(0);
		sc.nextLine();
		System.out.println("Ha introducido: "+c);
		
		sc.close();
	}
}
