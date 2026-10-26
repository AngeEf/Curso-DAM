package EjemploHilos.hilos;

public class HilosVersion2 implements Runnable 
{	@Override
	public void run()
	{	System.out.println("Inicio de hilo: "+Thread.currentThread().getName());
		try 
		{	long espera = (long)((Math.random()*(5000-1000+1))+1000);
			Thread.sleep(espera);
		} catch (InterruptedException e) 
		{	e.printStackTrace();
		}
		System.out.println("Fin de hilo: "+Thread.currentThread().getName());
	}
	
	static void main(String[] args)
	{	HilosVersion2 a = new HilosVersion2();
		Thread h1 = new Thread(a, "Hilos 1");
		HilosVersion2 b = new HilosVersion2();
		Thread h2 = new Thread(b, "Hilos 2");
		HilosVersion2 c = new HilosVersion2();
		Thread h3 = new Thread(c, "Hilos 3");
		h1.start();
		h2.start();
		h3.start();
	}
}
