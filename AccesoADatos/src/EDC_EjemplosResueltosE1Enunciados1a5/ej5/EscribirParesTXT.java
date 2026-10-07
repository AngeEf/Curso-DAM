package EDC_EjemplosResueltosE1Enunciados1a5.ej5;

	import java.io.FileWriter; 
	import java.io.IOException; 
	import java.io.Writer;

public class EscribirParesTXT
	{ public static Writer escribir = null; 
	  public static String codigoEnviar = ""; 
	 
	 public static void setFlujo()  
	 { try 
	  { escribir = new FileWriter("Escrito.txt"); 
	  } 
	  catch(IOException e) 
	  { e.printStackTrace(); 
	  } 
	 } 
	 
	 public static void setCodigoEnviar()
	 {	for (byte nf=0; nf<5; nf++)
	 	{	byte min=0, max=9;
	 		byte a = (byte)(min+(Math.random()*(max-min+1)));
	 		byte b = (byte)(min+(Math.random()*(max-min+1)));
	 		codigoEnviar += a + " " + b + "\n";
	 	}
	 }
	 
	 public static void enviar() 
	 { try 
	  { escribir.write(codigoEnviar);    
	   escribir.flush(); 
	  } 
	  catch(IOException e) 
	  { e.printStackTrace(); 
	  } 
	 } 
	 
	 public static void cerrarFlujo() 
	 { try 
	  { escribir.close(); 
	  } 
	  catch(IOException e) 
	  { e.printStackTrace(); 
	  } 
	 }

	 static void main(String[] args)
	 { 	 setFlujo();
		 setCodigoEnviar();
		 enviar(); 
		 cerrarFlujo(); 
	 }
}
