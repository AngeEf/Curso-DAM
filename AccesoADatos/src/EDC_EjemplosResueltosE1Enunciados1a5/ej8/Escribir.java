package EDC_EjemplosResueltosE1Enunciados1a5.ej8;


import java.io.BufferedWriter; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner; 
 
/*8. Empleando rutas, BufferedWriter y BufferedReader, escribir a
Numeros.doc 3 numeros enteros escritos por el usuario, uno en cada línea. Otro archivo java lee
los números y los muestra. Asegurar que no hay problemas con los cambios de línea.*/

public class Escribir  
{ 	public static BufferedWriter escribir = null; 
    public static String codigoEnviar = ""; 
    
    public static Scanner sc = new Scanner(System.in);
   
    public static void setFlujo()  
    { 	try 
    	{ 	Path ruta = Path.of("Numeros.doc");
    		escribir =  Files.newBufferedWriter(ruta);
    	} 
    	catch(IOException e) 
    	{ 	e.printStackTrace();
    	} 
    } 
  
    public static void setCodigoEnviar()
    {	int i;
    	for (byte n=0; n<3; n++)
    	{	System.out.print("Introduzca número entero: ");
    		i = Integer.valueOf(sc.nextLine());
    		codigoEnviar += i;
    		if (n<2)
    			codigoEnviar += "\n";
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
    
    public static void cerrarScanner() 
    { 	try 
   		{ 	sc.close(); 
   		} 
   		catch(Exception e) 
   		{ 	e.printStackTrace(); 
   		} 
    } 
    
    static void main(String[] args)
    { 	setFlujo(); 
   		enviar(); 
   		cerrarFlujo(); 
   		cerrarScanner();
    } 
 } 