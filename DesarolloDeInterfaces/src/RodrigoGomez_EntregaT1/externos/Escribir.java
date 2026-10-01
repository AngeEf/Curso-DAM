package RodrigoGomez_EntregaT1.externos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escribir 
{	private static FileOutputStream escritura = null;
	private static final String enviar =  "Criatura\tCriatura\tCriatura\n"+
					         		"Tardígrado\tAnfisbena\tEndriago";
		
	public static void setEscritura()
	{	try 
		{	escritura = new FileOutputStream("externo.xls");
		} 
		catch (FileNotFoundException e) 
		{	e.printStackTrace();
		}
		//Crear un flujo de datos desde Escribir.java a externo.xls
	}
	
	public static void enviar()
	{	for (short s=0;s<enviar.length();s++)
		//Recorremos todos los caracteres de enviar desde 0 hasta longitud - 1 (56 - 1)
			try 
			{	escritura.write((byte)enviar.charAt(s));
			} catch (IOException e) 
			{	e.printStackTrace();
			}/*Escribimos cada caracter en el flujo => lo enviamos
	a externo.xls*/
			/*enviar.charAt(s): devuelve el caracter del String enviar en la posición s*/
	}
		
	public static void cerrar()
	{	try 
		{	escritura.close();
		} 
		catch (IOException e) 
		{	e.printStackTrace();
		}
	}

	static void main(String[] args)
	{	setEscritura();
		enviar();
		cerrar();
	}
}
