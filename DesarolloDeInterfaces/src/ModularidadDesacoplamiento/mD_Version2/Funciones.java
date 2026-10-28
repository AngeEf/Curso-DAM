package ModularidadDesacoplamiento.mD_Version2;

public class Funciones 
{	private static float m;
	
	public static void setMinAl()
	{	m = (float) (Clase.getMin()+(Math.random()*(Clase.getMax()-Clase.getMin())));
	}
	
	public static float getM()
	{	return m;		
	}

}
