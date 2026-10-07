package EDC_EjemploTipoEj6.proyectoBuffered;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.Reader; 
 
public class LeerV1 
{ 	public static Reader leer = null; 
	public static String codigoRecibido = ""; 

	public static void setFlujo()  
	{ 	try 
		{ 	leer = new BufferedReader(new FileReader("archivo.txt")); 
		} 
		catch(IOException e) 
		{ 	e.printStackTrace();
		} 
	} 

	public static void recibir() 
	{ 	short nChar;
		char car;
		short cont=0; 
		try 
		{  
			while (leer.read()!=-1) 
			{ 	cont++; 
			} 

			cerrarFlujo(); 
			setFlujo(); 

			for (nChar=0;nChar<cont;nChar++) 
			{ 	car = (char)(leer.read()); 
				codigoRecibido += car; 
			} 
		} 
		catch(IOException e) 
		{ 	e.printStackTrace(); 
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
	{ 	System.out.println("Codigo descargado: "+codigoRecibido); 
	} 
 
	static void main(String[] args)
	{ 	setFlujo(); 
		recibir(); 
		cerrarFlujo(); 
		mostrar(); 
	} 
 } 
