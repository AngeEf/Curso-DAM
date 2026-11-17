package DIF_EjemplosResueltosE1Enunciados1a3.ej3;

public class Alturas3 implements Aleatorios
{	/*3. Construir en el mismo proyecto clases Alturas1, Alturas2 y Alturas3, las
tres con atributos numéricos tipo double h1, h2 y h3. Crear interfaz
Aleatorios. La interfaz nombrará los métodos aleatorios y mostrar.
Emplear desde cada una de las tres clases los dos métodos de la interfaz.
a.mostrar: muestra el valor de los tres números.
b.aleatorios: da un valor aleatorio entre 1.65 y 1.70, ambos inclusive, a
cada número de alturas1, aleatorio entre 1.71 y 1.80, ambos inclusi
ve, a cada número de alturas2 y aleatorio entre 1.80 y 1.81, ambos
inclusive, a cada número de alturas3.*/

	private double h1, h2, h3;
		
	public void aleatorios()
	{	h1 = setAltura((short)180,(short)181);
		h2 = setAltura((short)180,(short)181);
		h3 = setAltura((short)180,(short)181);
	}
	
	public double getH(double h)
	{	return h;		
	}
	
	public void mostrar()
	{	System.out.println("Alturas: " + getH(h1) + ", " + getH(h2) + " y " + getH(h3));
	}
	
	public double setAltura(short min, short max)
	{	short altS = (short)(min + (Math.random()*(max-min+1)));
		double altD = ((double)(altS))/100;
		/*double altD = (double)altS;
		 * altD /= 100;*/
		return altD;
	}
	
	public static void main(String[] args) 
	{	Alturas3 a = new Alturas3();
		a.aleatorios();
		a.mostrar();
	}
}
