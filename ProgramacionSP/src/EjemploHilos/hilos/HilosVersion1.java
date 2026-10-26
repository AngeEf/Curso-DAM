package EjemploHilos.hilos;

public class HilosVersion1 implements Runnable 
{	@Override
	public void run()
	{	System.out.println("Hilo: "+Thread.currentThread().getName());
	}
	
	static void main(String[] args)
	{	HilosVersion1 a = new HilosVersion1();
		Thread h1 = new Thread(a, "Hilos 1");
		HilosVersion1 b = new HilosVersion1();
		Thread h2 = new Thread(b, "Hilos 2");
		HilosVersion1 c = new HilosVersion1();
		Thread h3 = new Thread(c, "Hilos 3");
		h1.start();
		h2.start();
		h3.start();
	}
}