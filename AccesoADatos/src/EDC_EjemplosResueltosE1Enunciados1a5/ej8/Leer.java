package EDC_EjemplosResueltosE1Enunciados1a5.ej8;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path; 

public class Leer 
{ 	public static BufferedReader leer = null; 
	public static String codigoRecibido = ""; 
	
	public static void setFlujo()  
	{ 	try 
		{ 	Path ruta = Path.of("Numeros.doc");
			leer =  Files.newBufferedReader(ruta);
		} 
		catch(IOException e) 
		{ 	e.printStackTrace();
		} 
	} 

	public static void recibir() 
	{ 	
		try
		{	String linea;
			while ((linea = leer.readLine()) != null)
			{	if (linea.isBlank()) continue;
				codigoRecibido += linea + "\n";
			}
		}
		catch(IOException e)
		{	e.printStackTrace();
		}
	} 
	
	public static void cerrarFlujo() 
	{ 	try 
		{ 	leer.close(); 
		} 
		catch(IOException e) 
		{ 	e.printStackTrace(); 
		} 
	} 
	
	public static void mostrar() 
	{ 	System.out.println("Codigo descargado completo:\n"+codigoRecibido+"\n");	
	} 
 
	static void main(String[] args)
	{ 	setFlujo(); 
		recibir(); 
		cerrarFlujo(); 
		mostrar(); 
	} 
 } 
