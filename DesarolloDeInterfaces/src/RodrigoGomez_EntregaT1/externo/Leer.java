package RodrigoGomez_EntregaT1.externo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Leer 
{	public static FileInputStream fis = null;	/*Flujo de entrada desde el archivo al 
	código*/
	public static String recibir = ""; /*Atributo en que apuntaremos el resultado de
	la lectura*/
	
	public static void setFis() //Crea flujo de lectura del archivo externo
	{	try //Intenta crear el flujo de datos desde archivo externo (ar.xls) a Leer.java
		{	fis = new FileInputStream("ar.xls");
		} 
		catch (FileNotFoundException e) /*Si el flujo lo has creado bien, no le hagas
		caso al catch*/
		{	System.out.println("Leer.java no logra acceder al archivo externo");
			e.printStackTrace();
		}
	}
	
	public static void cerrar() //Cerrar el flujo
	{	try 
		{	fis.close();
		} catch (IOException e) 
		{	e.printStackTrace();
		}
	}
	
	public static void setRecibir()
	{	short cont=0;
		try 
		{	while (fis.read()!=-1)/*Mientras al leer los caracteres no leamos -1,
		que es la señal de fin de contenido el archivo*/
			{	cont++;//Contamos un caracter más
			}
		}	//Ya sabemos que hay 31 caracteres: cont=31
		catch (IOException e) 
		{	e.printStackTrace();
		}
		//fis está después de la segunda 'a' de Vanessa
		cerrar();//Cerramos fis
		setFis();//Abrir un nuevo fis
		//fis está antes de la 'N' del primer Nombre
		
		for (short s=0; s<cont; s++)	/*Recorre todos los caracteres desde el nº0
		(1ª 'N') hasta el nº31 (última 'a')*/
		{	byte b =0;
			try 
			{ b = (byte)(fis.read());/*Cada caracter lo pasamos en formato byte a variable
			b*/
				//Después de ejecutarse el flujo.read, sin que se lo digamos, pasa
			//al siguiente caracter
			} catch (IOException e) 
			{	e.printStackTrace();
			}
			char ch = (char)b;//El caracter lo pasamos a formato char
			recibir += ch; //En formato char lo pasamos a la cadena de caracteres.
			// recibir = recibir + ch
		}
	}
	
	public static String getRecibir()
	{	return recibir;		
	}
	
	public static void show()
	{	System.out.println("Código leído:\n"+getRecibir());
	}

	static void main(String[] args)
	{	setFis();
		setRecibir();
		show();
		cerrar();
	}
}
