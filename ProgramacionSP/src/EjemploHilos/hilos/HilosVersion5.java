package EjemploHilos.hilos;

import java.util.Scanner;

public class HilosVersion5 implements Runnable 
{	private static long espera[] = new long[3];
	public static Scanner sc = new Scanner(System.in);
	private static byte nh = 0;
	
	public static void setNh()
	{	nh++;		
	}
	
	public byte getNh()
	{	return nh;		
	}
			
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
	{	byte b = getNh();
		setNh();
		System.out.println("Inicio de hilo: "+Thread.currentThread().getName());
		
		try 
		{	Thread.sleep(espera[b]);
		} catch (InterruptedException e) 
		{	e.printStackTrace();
		}
		System.out.println("Fin de hilo: "+Thread.currentThread().getName());
	}
	
	static void main(String[] args)
	{	setEspera();
		HilosVersion5 a = new HilosVersion5();
		Thread h1 = new Thread(a, "Hilos 1");
		//                         0123456
		HilosVersion5 b = new HilosVersion5();
		Thread h2 = new Thread(b, "Hilos 2");
		HilosVersion5 c = new HilosVersion5();
		Thread h3 = new Thread(c, "Hilos 3");
		h1.start();
		h2.start();
		h3.start();
		cerrar();
	}
}
