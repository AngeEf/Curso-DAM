package DIF_EjemplosResueltosE1Enunciados1a3.ej2;

public class Numeros implements Operaciones
{	private static byte a,b,c;
	private static byte max, min;
	private static float media;

/*2.Construir clase Numeros, con atributos numéricos tipo byte 
 * a, b y c.
Crear interfaz Operaciones. La interfaz nombrará los métodos
mostrar, aleatorios, máximo, mínimo y media. 
a. mostrar: muestra el valor de los tres números.
b. aleatorios: da un valor aleatorio entre 0 y 10 a cada número.
c. máximo: muestra el valor máximo de los tres números.
d. mínimo: muestra el valor mínimo de los tres números.
e. media: muestra la media de los tres números.*/
	
	public byte aleatorios()
	{	byte z = (byte)(Math.random()*(10+1));
		return z;
	}
	
	public void setMaximo ()
	{	if ((a>=b) && (a>=c))
			max = a;
		else if (b>=c)
			max = b;
		else
			max = c;
	}
	
	public byte getMaximo()
	{	return max;		
	}
	
	public void mostrarMaximo()
	{	System.out.println("Máximo: "+getMaximo());
	}

	public void setMinimo ()
	{	if ((a<=b) && (a<=c))
			min = a;
		else if (b<=c)
			min = b;
		else
			min = c;
	}
	
	public byte getMinimo()
	{	return min;		
	}
	
	public void mostrarMinimo()
	{	System.out.println("Mínimo: "+getMinimo());
	}

	public void setMedia ()
	{	float total = (float) (a + b + c);
		media = (float)(total / 3);
	}
	
	public float getMedia()
	{	return media;		
	}
	
	public void mostrarMedia()
	{	System.out.println("Media: "+getMedia());
	}
	
	public byte getZ (byte z)
	{	return z;
	}
	
	public void mostrar()
	{	System.out.println("Numeros: "+getZ(a)+", "+getZ(b)+" y "+getZ(c));
		mostrarMaximo();
		mostrarMinimo();
		mostrarMedia();
	}
	
	public Numeros()
	{	a = aleatorios();
		b = aleatorios();
		c = aleatorios();
		setMaximo();
		setMinimo();
		setMedia();
	}

	public static void main(String[] args) 
	{	Numeros n = new Numeros();
		n.mostrar();
	}
}
