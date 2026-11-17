package EDC_EjemplosResueltosE1Enunciados1a5.ej6;


import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
 
/*Empleando BufferedWriter y BufferedReader, escribir a Numeros.txt 10
numeros enteros aleatorios distintos, uno en cada línea. Otro archivo java lee 
los números y los muestra de menor a mayor.*/

public class Escribir  
{ 	public static BufferedWriter escribir = null; 
    public static String codigoEnviar = ""; 
   
    public static void setFlujo()  
    { 	try 
    	{ 	escribir = new BufferedWriter(new FileWriter("Numeros.txt")); 
    	} 
    	catch(IOException e) 
    	{ 	e.printStackTrace();
    	} 
    } 
  
    public static void setCodigoEnviar()
    {	int max = 99999;
    	for (byte n=0; n<10; n++)
    	{	int al = (int) (Math.random()*(max+1));
    		codigoEnviar += al + "\n";
    	}	
    }
    
    public static void enviar() 
    { 	try 
    	{ 	setCodigoEnviar();
    		escribir.write(codigoEnviar); 
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
   		enviar(); 
   		cerrarFlujo(); 
    } 
 } 