package SimilarEjsT1c.similar;

public class Ej5 implements Runnable 
{	/*Se lanzan tres hilos. El cuarto hilo espera a que uno de los dos primeros 
	haya finalizado para comenzar. Todos esperan entre 5 y 20 segundos 
	aleatoriamente hasta finalizar. Cada hilo indica cuando ha comenzado y 
	cuando ha finalizado. */
	
	@Override
	public void run()
	{	System.out.println("Se inicia: "+Thread.currentThread().getName());
		short min = 5000, max = 20000;
		short al = (short)(min+(Math.random()*(max-min+1)));
		try 
		{	Thread.sleep((int)al);
		} 
		catch (InterruptedException e) 
		{	e.printStackTrace();
		}
		System.out.println("Finaliza: "+Thread.currentThread().getName());
	}
    static void main(String[] args)
	{	Ej5 e = new Ej5();
		Thread h1 = new Thread(e, "H1");
		Thread h2 = new Thread(e, "H2");
		Thread h3 = new Thread(e, "H3");
		h1.start();
		h2.start();
		h3.start();
		Thread h4 = new Thread(e, "H4");
		while ((h1.isAlive()==true)&&(h2.isAlive()==true))
		{}
		h4.start();
	}
}
