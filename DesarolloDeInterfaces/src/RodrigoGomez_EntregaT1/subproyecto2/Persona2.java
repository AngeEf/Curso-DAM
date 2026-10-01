package RodrigoGomez_EntregaT1.subproyecto2;

import java.util.Scanner;

public class Persona2 
{	private String nombre;
	private float altura;
	private static float alturaTotal=0;
	
	public static Scanner sc = new Scanner (System.in);
	
	public Persona2(String n)	/*Constructor: le va a dar valor a
	todos o casi todos los atributos*/
	{	setNombre(n);
		setAltura();	
		setAlturaTotal();
	}
	
	public Persona2()
	{	setNombre();
		setAltura(true);
		setAlturaTotal();
	}	
		
	public void setNombre(String n)//Valor por argumento
	{	nombre = n;		
	}
	
	public void setNombre()//Valor introducido por usuario
	{	System.out.print("Introduzca nombre: ");
		nombre = sc.nextLine();
	}
		
	public void setAltura()//Valor aleatorio
	{	float min = 1.60F, max = 1.90F;
		altura = (float)(min+(Math.random()*(max-min)));
	}
	
	public void setAltura(boolean bo)
	{	altura = 1.75F;		
	}	
	
	public void setAlturaTotal()
	{	alturaTotal += getAltura();
	}
	
	public String getNombre()
	{	return (nombre);		
	}
	
	public float getAltura()
	{	return altura;
	}
	
	public float getAlturaTotal()
	{	return alturaTotal;		
	}
	
	public void show()
	{	System.out.println("Nombre: "+getNombre()+", Altura: "+getAltura()
			+", Altura total: "+getAlturaTotal());	
	}
	
	public void cerrar()
	{	sc.close();		
	}

	static void main(String[] args)
	{	//Clase objeto = nuevo Constructor(argumentos);
		//objeto.show();
		Persona2 p1 = new Persona2("Darrel");
		p1.show();
		Persona2 p2 = new Persona2("Fátima");
		p2.show();
		Persona2 p3 = new Persona2();
		p3.show();
		Persona2 p4 = new Persona2();
		p4.show();
		p3.cerrar();
	}
}
