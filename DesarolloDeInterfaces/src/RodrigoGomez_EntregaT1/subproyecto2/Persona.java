package RodrigoGomez_EntregaT1.subproyecto2;

import java.util.Scanner;

public class Persona 
{	private String nombre;
	private float altura;
	
	public static Scanner sc = new Scanner (System.in);
	
	public Persona(String n)	/*Constructor: le va a dar valor a
	todos o casi todos los atributos*/
	{	setNombre(n);
		setAltura();		
	}
	
	public Persona()
	{	setNombre();
		setAltura(true);
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
	
	public String getNombre()
	{	return (nombre);		
	}
	
	public float getAltura()
	{	return altura;
	}
	
	public void show()
	{	System.out.println("Nombre: "+getNombre()+", Altura: "+getAltura());	
	}
	
	public void cerrar()
	{	sc.close();		
	}

	static void main(String[] args)
	{	//Clase objeto = nuevo Constructor(argumentos);
		//objeto.show();
		Persona p1 = new Persona("Darrel");
		p1.show();
		Persona p2 = new Persona("Fátima");
		p2.show();
		Persona p3 = new Persona();
		p3.show();
		Persona p4 = new Persona();
		p4.show();
		p3.cerrar();
	}
}
