package EDC_EjemplosResueltosE1Enunciados1a5.ej4;

	import java.io.FileWriter; 
	import java.io.IOException; 
	import java.io.Writer;
import java.util.Scanner; 
	 
	public class EscribirParesXLS  
	{ public static Writer escribir = null; 
	  public static String codigoEnviar = ""; 
	 
	 public static void setFlujo()  
	 { try 
	  { escribir = new FileWriter("Escrito.xls"); 
	  } 
	  catch(IOException e) 
	  { e.printStackTrace(); 
	  } 
	 } 
	 
	 public static void setCodigoEnviar()
	 {	String resp;
	 	Scanner sc = new Scanner (System.in);
		do
	 	{	byte min=10, max=99;
	 		byte a = (byte)(min+(Math.random()*(max-min+1)));
	 		byte b = (byte)(min+(Math.random()*(max-min+1)));
			
	 		codigoEnviar += a + "\t" + b + "\n";
	 		
			System.out.print("Indique si desea introducir "
	 			+ "otra línea (S/N): ");
	 		resp = sc.nextLine();
	 	}while(!resp.equals("N"));
		sc.close();
		 
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
