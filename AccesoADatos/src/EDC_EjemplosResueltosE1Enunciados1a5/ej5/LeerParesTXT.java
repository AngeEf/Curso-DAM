package EDC_EjemplosResueltosE1Enunciados1a5.ej5;

import java.io.FileReader; 
import java.io.IOException; 
import java.io.Reader; 
public class LeerParesTXT  
{ 
public static Reader leer = null; 
public static String codigoRecibido = "";
public static void setFlujo()  
{ try 
 { leer = new FileReader("Escrito.txt"); 
 } 
 catch(IOException e) 
 { e.printStackTrace(); 
 } 
} 

public static void recibir() 
{ short nChar;
 char car;
 short cont=0; 
 try 
 {  
  while (leer.read()!=-1) 
  { cont++; 
  } 

  cerrarFlujo(); 
  setFlujo(); 

  byte nf=0;
  boolean leerC = true;
  
  for (nChar=0;nChar<cont;nChar++) 
  { car = (char)(leer.read());
  	if (leerC)
  		codigoRecibido += car + "\n";

      leerC = car == '\n';
  	} 
  } 
 catch(IOException e) 
 { e.printStackTrace(); 
 }  
} 

public static void cerrarFlujo() 
{ try 
 { leer.close(); 
 } 
 catch(IOException e) 
 { e.printStackTrace(); 
 } 
 } 
  
 public static void mostrar() 
 { System.out.println("Código descargado:\n"+codigoRecibido); 
 } 
 
 static void main(String[] args)
 { setFlujo(); 
  recibir(); 
  cerrarFlujo(); 
  mostrar(); 
 } 
}
