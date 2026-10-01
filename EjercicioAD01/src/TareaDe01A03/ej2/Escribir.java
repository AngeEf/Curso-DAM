package TareaDe01A03.ej2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Escribir {

	/*2.Empleando FileOutputSteam, escribir a apellidos.txt 
cinco apellidos a tu elección. El primero, el tuyo. 
Escribir.java escribe.  */
	
	public static FileOutputStream fos = null;
	public static String enviar ="Gómez\nHernández\nZayas\nOlmo\nBrock";
		
	public static void setFos()
	{	try 
		{	fos = new FileOutputStream("apellidos.txt");
		} 
		catch (FileNotFoundException e) 
		{	e.printStackTrace();
		}
	}
	
	public static void enviar()
	{	short nChar; // short nChar=0; - Variable 'nChar' initializer '0' is redundant
	  	char car;  // same
	  	try 
	  	{ 	for (nChar=0;nChar<enviar.length();nChar++) 
	  		{ 	car = enviar.charAt(nChar); 
	  			fos.write((byte)car); 
	  		} 
	  	} 
	  catch(IOException e) 
	  { e.printStackTrace(); 
	  }
	}

	public static void cerrarFlujoSalida()
	{	try 
		{	fos.close();
		} catch (IOException e) 
		{	e.printStackTrace();
		}
	}
	
	static void main(String[] args)
	{	//Escribir
		setFos();
		enviar();
		cerrarFlujoSalida();	
	}
}
