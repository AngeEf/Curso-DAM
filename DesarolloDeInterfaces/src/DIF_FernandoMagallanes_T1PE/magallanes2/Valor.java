package DIF_FernandoMagallanes_T1PE.magallanes2;

import java.util.Scanner;

public class Valor 
{	public static Scanner sc = new Scanner(System.in);
	public static int i = 0;
	
	public static void setI()
	{	System.out.print("Introduzca valor entero: ");
		i = Integer.valueOf(sc.nextLine());
	}
	
	public static int getI()
	{	return i;
	}
	
	public static void show()
	{	System.out.println("Ha introducido: " + getI());
	}
	
	public static void cerrar()
	{	sc.close();
	}

	public static void main(String[] args) 
	{	setI();
		show();
		cerrar();	
	}
}
