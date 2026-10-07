package EDC_EjemploTipoEj6.proyectoBuffered;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.Reader; 
 
/*6. Otro archivo java lee los 
números y los muestra de mayor a menor.*/

public class LeerV2 
{ 	public static Reader leer = null; 
	public static String numero = ""; 
	public static short[] recibirA = {-1,-1,-1,-1,-1};
	public static short[] recibirOrdenado = {-1,-1,-1,-1,-1};

	public static void setFlujo()  
	{ 	try 
		{ 	leer = new BufferedReader(new FileReader("valores.xls")); 
		} 
		catch(IOException e) 
		{ 	e.printStackTrace();
		} 
	} 
	
	public static void setRecibir()
	{	short nChar;
		char car;
		short cont=0; 
		try 
		{  
			while (leer.read()!=-1) 
			{ 	cont++; 
			} 
			cerrarFlujo(); 
			setFlujo(); 

			byte c=0;
			for (nChar=0;nChar<cont;nChar++) 
				//Recorrer el archivo destino completo
			{ 	car = (char)(leer.read());
				//Cada caracter del archivo destino lo apuntamos en car
			
				if (car != '\t')//Si no es tabulador, vamos apuntando
					//cifras
				{	numero += car;
				}
				else if (car == '\t')//Si no, pasamos números y vamos
					//a la siguiente posición del array
				{	short s = Short.parseShort(numero);
					recibirA[c] = Short.parseShort(numero);
					c++;
					numero="";
					
				}		
			}
		} 
		catch(IOException e) 
		{ 	e.printStackTrace(); 
		}  
	}

	/*mostrar de mayor a menor
	 * public static short recibirA [] =      {181,683,195,93,767};
	 *recibirA entre 0 y 999, ambos inclusive
	public static short recibirOrdenado [] = {-1,-1,-1,-1,-1};*/
	
	public static void ordenar()
	{	short mayor = -5, colMayor=-1;
	//mayor toma nota en cada recorrido de recibirA cuál es el mayor valor
	//colMayor toma nota en cada recorrido de recibirA en qué columna
	// estaba el mayor.
	
	//Vamos a ordenar de mayor a menor, por tanto, se inicia la variable
	// con un valor menor que el mínimo
		for (byte b=0;b<5;b++)//Recorre recibirOrdenado
		{	for (byte c=0;c<5;c++)//Recorre recibirA
			{	if (mayor < recibirA[c])
				{	mayor = recibirA[c];
					colMayor=c;
				}
			}
			recibirOrdenado[b]=mayor;
			recibirA[colMayor]=-1;
			mayor=-5;
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
	{ 	System.out.print("Codigo descargado recibir:\t");
		for (byte c=0;c<5;c++)
			System.out.print(recibirA[c]+"\t");
		System.out.println();
		System.out.print("Codigo descargado ordenado:\t");
		for (byte c=0;c<5;c++)
			System.out.print(recibirOrdenado[c]+"\t");
	} 
 
	static void main(String[] args)
	{ 	setFlujo(); 
		setRecibir(); 
		ordenar();		
		mostrar();
		cerrarFlujo();
	} 
 } 
