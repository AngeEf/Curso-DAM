package SimilarEjsT1c.similar;

import java.util.Scanner;

/*4. Crear un bucle en el que se le pregunta al usuario repetidamente si 
desea: 
a.Cerrar la ejecuci�n.\n 
b.Lanzar ejecuci�n de hilo 1.\n 
c.Lanzar ejecuci�n de hilo 2.\n 
d.Lanzar ejecuci�n de hilo 3.\n 
e.Preguntar si primer hilo se est� ejecutando.\n 
f.Preguntar si segundo hilo se est� ejecutando.\n 
g.Preguntar si tercer hilo se est� ejecutando.

Cada hilo, tras ser lanzado, espera entre 60 y 120 segundos aleatoriamente 
hasta finalizar. 
Cada hilo indica cuando ha comenzado y cuando ha 
finalizado. */


public class Ej4 
{	private static char opcion = 'z';
	public static Thread h1 = null;
	public static Thread h2 = null;
	public static Thread h3 = null;

	public static Scanner sc = new Scanner (System.in);
	
	public static void menu()
	{	do
		{	try 
			{	Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{	e.printStackTrace();
			}
			System.out.println("Opciones:");
			System.out.println(
					"\ta.Cerrar la ejecuci�n.\n"+
					"\tb.Lanzar ejecuci�n de hilo 1.\n"+ 
					"\tc.Lanzar ejecuci�n de hilo 2.\n"+
					"\td.Lanzar ejecuci�n de hilo 3.\n"+ 
					"\te.Preguntar si primer hilo se est� ejecutando.\n"+ 
					"\tf.Preguntar si segundo hilo se est� ejecutando.\n"+ 
					"\tg.Preguntar si tercer hilo se est� ejecutando.");
			System.out.print("Indicar: ");
			try 
			{	opcion = sc.next().charAt(0);
				sc.nextLine(); 
			} catch (Exception e) 
			{	e.printStackTrace();
			} 
			
			switch (opcion)
			{	case 'b': 
					h1 = new Thread(new Ej4Tarea("h1"));
					h1.start();
            	break;
            	
				case 'c': 
					h2 = new Thread(new Ej4Tarea("h2"));
					h2.start();
				break;
        	
				case 'd': 
					h3 = new Thread(new Ej4Tarea("h3"));
					h3.start();
				break;
				case 'e':  
					if (h1 != null && h1.isAlive()==true) 
					{	showHilo1Ejecutandose("h1", true);
					} else 
					{	showHilo1Ejecutandose("h1", false);
					}
				break;

				case 'f':  
					if (h2 != null && h2.isAlive()==true) 
					{	showHilo1Ejecutandose("h2", true);
					} else 
					{	showHilo1Ejecutandose("h2", false);
					}
				break;

				case 'g':  
					if (h3 != null && h3.isAlive()==true) 
					{	showHilo1Ejecutandose("h3", true);
					} else 
					{	showHilo1Ejecutandose("h3", false);
					}
				break;

			}
			
		}while(opcion != 'a');
	}
	
	public static void showHilo1Ejecutandose(String s, boolean b)
	{	System.out.print(s + " ");
		if (b == true)
			System.out.println("se est� ejecutando");
		else
			System.out.println("no se est� ejecutando");	
	}
	
	public static void cerrar()
	{	sc.close();		
	}
	
    static void main(String[] args)
    {  menu();
       cerrar();
    }
}

