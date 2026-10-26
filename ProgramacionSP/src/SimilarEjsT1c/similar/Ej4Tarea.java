package SimilarEjsT1c.similar;

public class Ej4Tarea implements Runnable 
{//Esta clase lanza una tarea para cada hilo
	public static String nombre;
	
    public Ej4Tarea(String n) {
      System.out.println("\nSe inicia "+n);
      	nombre = n;
    }

    @Override
    public void run() {
        
    	int min = 60000, max = 120000;
    	//Al realizar pruebas, conviene cambiarlos temporalmente por valores menores
    	
		int espera = (int)(min+(Math.random()*(max-min+1)));
  
        try 
        {	Thread.sleep(espera);
        } 
        catch (Exception e) 
		{	e.printStackTrace();
		} 

        System.out.println("\n"+nombre + " ha finalizado");
    }
}
