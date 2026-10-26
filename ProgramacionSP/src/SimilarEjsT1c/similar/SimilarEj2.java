package SimilarEjsT1c.similar;

public class SimilarEj2 implements Runnable
{	/*2.El main lanza un hilo adicional. El hilo del main va calculando y mostrando 
números aleatorios entre -2 y 5.5, primero inclusive, segundo no inclusive,
hasta que se hayan mostrado 4 negativos. El hilo adicional va calculando y mostrando 
números aleatorios entre -5 y 5, hasta que se hayan mostrado 5 negativos. */
	@Override
	public void run()
	{	System.out.println("Hilo adicional");
		byte min = -5, max = 5, cneg = 0;
		while (cneg < 5)
		{	byte al = (byte)(min+(Math.random()*(max-min+1)));
			System.out.println("Aleatorio hilo adicional: " + al);
			if (al < 0)
				cneg++;
		}
		System.out.println("Final del hilo adicional");
	}

	static void main(String[] args)
	{	SimilarEj2 h = new SimilarEj2();
		Thread th = new Thread(h, "Hilo Adicional");
		th.start();	
		
		//hilo del main:
		byte cneg=0;
		do
		{	float min = -2F, max = 5.5F;
			float al = (float)(min+(Math.random()*(max-min)));
			System.out.println("Aleatorio del main: "+al);
			if (al<0)
				cneg++;
		}while(cneg < 4);
	}
}
