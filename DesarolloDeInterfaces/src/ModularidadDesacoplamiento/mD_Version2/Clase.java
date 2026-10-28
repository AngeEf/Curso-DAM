package ModularidadDesacoplamiento.mD_Version2;

import java.util.Scanner;

public class Clase 
{	static float min=5.0F, max=8.0F;
	static float minAl,maxAl;
	static Scanner sc = new Scanner(System.in);
	static float al;
	
	public static float getMin()
	{	return min;
	}
	
	public static float getMax()
	{	return max;
	}

	public static float getMinAl()
	{	return minAl;
	}
	
	public static float getMaxAl()
	{	return maxAl;
	}
	
	public static void setMaxAl()
	{	System.out.print("Introduzca número con decimales: ");
		maxAl = Float.valueOf(sc.nextLine());
	}
	
	public static void setMinAlC()
	{	Funciones.setMinAl();
		minAl = Funciones.getM();
	}
	
	public static void setAl()
	{	al = (float) (getMinAl()+(Math.random()*(getMaxAl()-getMinAl())));
	}
	
	public static float getAl()
	{	return al;		
	}
	
	public static void show()
	{	System.out.println("Mínimo y máximo: " + getMin()+" " +getMax() + " Mínimo Aleatorio: " +
            getMinAl() + " Aleatorio: " + getAl());
	}
	
	public static void cerrar()
	{	sc.close();		
	}

	static void main(String[] args)
	{	setMinAlC();
		setMaxAl();
		setAl();
		show();
		cerrar();
	}
}
