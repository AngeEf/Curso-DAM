package Esperas.esperas;

public class Esperas implements Runnable
{	@Override
	public void run()
	{	System.out.println("Hilo en ejecución: "+Thread.currentThread().getName());
	}

    static void main(String[] args)
	{	Esperas es = new Esperas();
		Thread h1 = new Thread(es, "Hilo 1");
		h1.start();
		try 
		{	Thread.sleep(3000);	//Esperar 3 segundos
		} catch (InterruptedException e) 
		{	e.printStackTrace();
		}
		Thread h2 = new Thread(es, "Hilo 2");
		h2.start();
		while (h2.isAlive()) {} //Esperar a que h2 termine
		System.out.println("Hilo 2 ha finalizado");
		Thread h3 = new Thread(es, "Hilo 3");
		h3.start();
	}
}
