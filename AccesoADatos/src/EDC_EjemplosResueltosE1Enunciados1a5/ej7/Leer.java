package EDC_EjemplosResueltosE1Enunciados1a5.ej7;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.Reader; 
 
/*Empleando BufferedReader, otro archivo java lee los 
números y los muestra de menor a mayor. */

public class Leer 
{ 	public static Reader leer = null; 
	public static String codigoRecibido = ""; 
	
	public static String recibida [] = {"","","","","","","","","",""};
	public static String mostrar [] = new String[4];
	public static byte cuantos [] = new byte[4];
	/*Cuando a una posición de esta matriz le damos -2 => indica que esa posición
	de recibida ya se ha pasado a ordenada*/
	
	public static String lista [] = {"Anfisbenas", "Endriagos", "Lamias", "Espectros"};

	public static void setFlujo()  
	{ 	try 
		{ 	leer = new BufferedReader(new FileReader("Palabras.txt")); 
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
		{   while (leer.read()!=-1) 
			{ 	cont++; 
			} 

			cerrarFlujo(); 
			setFlujo(); 

			byte num=0;
			
			for (nChar=0;nChar<cont;nChar++) 
			{ 	car = (char)(leer.read()); 
				
				if ((car!='\n'))
				{	codigoRecibido += car;
					recibida[num] += car;
				}
				else
				{	codigoRecibido += " ";
					num++;
				}
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
	
	public static void setMostrar()
	{	String pal;
		for (byte m=0; m<10; m++)
		{	pal = recibida[m];
			for (byte n=0; n<4; n++)
			{	if (pal.equals(lista[n])==true)
					cuantos[n]++;
			}
		}
	}
	
	public static void mostrar() 
	{ 	setMostrar();
		System.out.println("Codigo descargado completo:\n "+codigoRecibido+"\n");
		
		for (byte n=0; n<4; n++)
			System.out.print(lista[n]+" "+cuantos[n]+" veces, ");	
	} 
 
	static void main(String[] args)
	{ 	setFlujo(); 
		recibir();
		mostrar(); 
		cerrarFlujo(); 
		
	} 
 } 
