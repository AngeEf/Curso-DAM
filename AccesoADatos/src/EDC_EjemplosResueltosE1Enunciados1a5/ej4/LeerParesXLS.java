package EDC_EjemplosResueltosE1Enunciados1a5.ej4;

import java.io.FileReader; 
import java.io.IOException; 
import java.io.Reader; 
public class LeerParesXLS  
{ 
public static Reader leer = null; 
public static String codigoRecibido = "";
public static void setFlujo()  
{ try 
 { leer = new FileReader("Escrito.xls"); 
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
  
  for (nChar=0;nChar<cont;nChar++) 
  { car = (char)(leer.read());
  	if (car == '\n')
  		nf++;
  	if ((nf % 2) == 0)
  		codigoRecibido += car; 
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
