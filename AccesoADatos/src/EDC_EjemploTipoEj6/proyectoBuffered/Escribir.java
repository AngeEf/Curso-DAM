package EDC_EjemploTipoEj6.proyectoBuffered;


import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
 
/*Empleando BufferedWriter, escribir a valores.xls 5 
numeros enteros aleatorios distintos, uno en cada columna. */

public class Escribir  
{ 	public static BufferedWriter escribir = null;
	public static String enviar = "";
       
    public static void setFlujo()  
    { 	try 
    	{ 	escribir = new BufferedWriter(new FileWriter("valores.xls")); 
    	} 
    	catch(IOException e) 
    	{ 	e.printStackTrace();
    	} 
    } 
  
    public static void setEnviar()
    {	for (byte c=0;c<5;c++)
    	{	short max = 999;
    		short al = (short)(Math.random()*(max+1));
    		enviar += al + "\t";
    	}
    }
    
    public static void enviar() 
    { 	try 
    	{	escribir.write(enviar); 
    		escribir.flush(); 
    	} 
    	catch(IOException e) 
    	{ e.printStackTrace(); 
    	} 
    } 
  
    public static void cerrarFlujo() 
    { 	try 
   		{ 	escribir.close(); 
   		} 
   		catch(IOException e) 
   		{ 	e.printStackTrace(); 
   		} 
    } 
  
    static void main(String[] args)
    { 	setFlujo(); 
    	setEnviar();
   		enviar(); 
   		cerrarFlujo(); 
    } 
 } 