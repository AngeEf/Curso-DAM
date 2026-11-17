package IntroducirString;

import java.util.Scanner;

public class EquipoB 
{	private String nombre;
	private static String lista[] = {"Daugawa Riga", "Dorna Godella", "ASK Riga", "Zalgiris Kaunas"};
									//0              1                2           3

	public void setNombre(String n)//Por argumento
	{	nombre = n;		
	}
	
	public void setNombre(byte max)//Aleatorio
	{	byte al = (byte) (Math.random()*(max+1));
		nombre = lista[al];
	}
	
	public void setNombre()//Predefinido
	{	nombre = "Partizán Belgrado";
	}
	
	public void setNombre(boolean bo)//Introduce usuario
	{	Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca nombre: ");
		nombre = sc.nextLine();
		sc.close();
	}
	
	public String getNombre()
	{	return nombre;
	}
	
	public void show()
	{	System.out.println("Nombre: "+getNombre());		
	}

	public EquipoB(String a)
	{	setNombre(a);		
	}
	
	public EquipoB(byte a)
	{	setNombre(a);		
	}
	
	public EquipoB()
	{	setNombre();		
	}
	
	public EquipoB(boolean a)
	{	setNombre(a);		
	}
	
	public static void main(String[] args) 
	{	EquipoB b1 = new EquipoB("Pallacanestro Varese");
		b1.show();
		EquipoB b2 = new EquipoB((byte)3);
		b2.show();
		EquipoB b3 = new EquipoB();
		b3.show();
		EquipoB b4 = new EquipoB(true);
		b4.show();
	}
}
