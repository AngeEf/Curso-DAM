package EjemploHilos.hilos;

import java.util.Scanner;

public class HilosVersion3 implements Runnable 
{	private static long espera;
	public static Scanner sc = new Scanner(System.in);
	
	public static void setEspera()
	{	System.out.print("Indicar cuantos milisegundos hacemos esperar a cada hilo: ");
		espera = (Long.valueOf(sc.nextLine()));
	}
	
	public static void cerrar()
	{	sc.close();
	}

	@Override
	public void run()
	{	System.out.println("Inicio de hilo: "+Thread.currentThread().getName());
		try 
		{	Thread.sleep(espera);
		} catch (InterruptedException e) 
		{	e.printStackTrace();
		}
		System.out.println("Fin de hilo: "+Thread.currentThread().getName());
	}
	
	static void main(String[] args)
	{	setEspera();
		HilosVersion3 a = new HilosVersion3();
		Thread h1 = new Thread(a, "Hilos 1");
		HilosVersion3 b = new HilosVersion3();
		Thread h2 = new Thread(b, "Hilos 2");
		HilosVersion3 c = new HilosVersion3();
		Thread h3 = new Thread(c, "Hilos 3");
		h1.start();
		h2.start();
		h3.start();
		cerrar();
	}
}
