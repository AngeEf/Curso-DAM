package EDC_EjemplosResueltosE1Enunciados1a5.ej6;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.Reader; 
 
/*Empleando BufferedReader, otro archivo java lee los 
números y los muestra de menor a mayor. */

public class Leer 
{ 	public static Reader leer = null; 
	public static String codigoRecibido = ""; 
	
	public static int recibida [] = new int[10];
	public static int ordenada [] = new int[10];
	public static int referencia [] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	/*Cuando a una posición de esta matriz le damos -2 => indica que esa posición
	de recibida ya se ha pasado a ordenada*/

	public static void setFlujo()  
	{ 	try 
		{ 	leer = new BufferedReader(new FileReader("Numeros.txt")); 
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

			byte num=0;
			
			for (nChar=0;nChar<cont;nChar++) 
			{ 	car = (char)(leer.read()); 
				
				if (car!='\n')
				{	codigoRecibido += car;
					int i = Character.getNumericValue(car); 
					//Pasamos el caracter a formato int
					
					recibida[num] = (recibida[num]*10)+i;
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
	
	public static void setOrdenado()
	{	int menor = 100000, pos=20;
	
		for (byte m=0; m<10; m++)
		{	for (byte n=0; n<10; n++)
			{	if ((menor > recibida[n]) && (referencia [n] == -1))
				{	menor = recibida[n];
					pos = n;
				}
			}
			
			ordenada[m] = menor;
			referencia [pos] = -2;
			menor = 100000;
		}
	}
	
	public static void mostrar() 
	{ 	System.out.println("Codigo descargado completo:\n "+codigoRecibido+"\n");
		System.out.print("Matriz recibida:\n ");
		for (byte n=0; n<10; n++)
			System.out.print(recibida[n]+" ");
		System.out.println();
		System.out.println();
		setOrdenado();
		System.out.print("Matriz ordenada:\n ");
		for (byte n=0; n<10; n++)
			System.out.print(ordenada[n]+" ");	
	} 
 
	static void main(String[] args)
	{ 	setFlujo(); 
		recibir(); 
		cerrarFlujo(); 
		mostrar(); 
	} 
 } 
