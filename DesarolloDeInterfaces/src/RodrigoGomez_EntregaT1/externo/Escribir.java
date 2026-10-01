package RodrigoGomez_EntregaT1.externo;

import java.io.FileOutputStream;
import java.io.IOException;

public class Escribir {

	public static FileOutputStream fos = null;
	
	public static String enviar = "Nombre:\tRoberto\nNombre:\tVanessa";
	//Posiciones:                  0123...
	
	public static void setFos()
	{	try 
		{	fos = new FileOutputStream("ar.xls");
		} catch (IOException e) 
		{	e.printStackTrace();
		}
	}
	
	public static void enviar()
	{	byte b;
		for (byte c=0; c<enviar.length();c++)
		{	b = (byte)(enviar.charAt(c));
			try 
			{	fos.write(b);
			} catch (IOException e) 
			{	e.printStackTrace();
			}
		}
	}
	
	public static void cerrar()
	{	try 
		{	fos.close();
		} 
		catch (IOException e) 
		{	e.printStackTrace();
		}
	}
	
	static void main(String[] args)
	{	setFos();
		enviar();
	
	
		cerrar();
	}

}
