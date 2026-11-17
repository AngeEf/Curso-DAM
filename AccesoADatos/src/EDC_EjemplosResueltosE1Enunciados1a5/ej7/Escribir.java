package EDC_EjemplosResueltosE1Enunciados1a5.ej7;


import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
 
/*7. Empleando BufferedWriter y BufferedReader, escribir a Palabras.txt
10 palabras aleatorias distintas, una en cada línea. Otro archivo java las lee e 
indica cada una de ellas, sin repetirlas, pero especificando cuantas veces 
apareció cada una.
El archivo que lee conoce la lista de palabras inicial.*/

public class Escribir  
{ 	public static BufferedWriter escribir = null; 
    public static String codigoEnviar = ""; 
    
    public static String lista [] = {"Anfisbenas", "Endriagos", "Lamias", "Espectros"};
   
    public static void setFlujo()  
    { 	try 
    	{ 	escribir = new BufferedWriter(new FileWriter("Palabras.txt")); 
    	} 
    	catch(IOException e) 
    	{ 	e.printStackTrace();
    	} 
    } 
  
    public static void setCodigoEnviar()
    {	int max = 3;
    	for (byte n=0; n<10; n++)
    	{	int al = (int) (Math.random()*(max+1));
    		codigoEnviar += lista[al] + "\n";
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