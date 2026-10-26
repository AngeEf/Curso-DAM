package EjemploHilos.hilos;

import java.util.Scanner;

public class HilosVersion4 implements Runnable 
{	private static long espera[] = new long[3];
	public static Scanner sc = new Scanner(System.in);
		
	public static void setEspera()
	{	for (byte n=1; n<=3; n++)
		{	System.out.print("Indicar cuantos milisegundos hacemos esperar a Hilos "+n+": ");
			espera[n-1] = (Long.valueOf(sc.nextLine()));
		}
	}
	
	public static void cerrar()
	{	sc.close();
	}

	@Override
	public void run()
	{	System.out.println("Inicio de hilo: "+Thread.currentThread().getName());
		String texto =Thread.currentThread().getName();
		char ch = texto.charAt(6);
		int i = Character.getNumericValue(ch);
		i--;
		try 
		{	Thread.sleep(espera[i]);
		} catch (InterruptedException e) 
		{	e.printStackTrace();
		}
		System.out.println("Fin de hilo: "+Thread.currentThread().getName());
	}
	
    static void main(String[] args)
	{	setEspera();
		HilosVersion4 a = new HilosVersion4();
		Thread h1 = new Thread(a, "Hilos 1");
		//                         0123456
		HilosVersion4 b = new HilosVersion4();
		Thread h2 = new Thread(b, "Hilos 2");
		HilosVersion4 c = new HilosVersion4();
		Thread h3 = new Thread(c, "Hilos 3");
		h1.start();
		h2.start();
		h3.start();
		cerrar();
	}
}
