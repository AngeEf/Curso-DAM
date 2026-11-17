package DIF_FernandoMagallanes_T1PE.magallanes1;

public class Deportista implements LosDeportistas, UnDeporte
{	public byte edad;
	public String deporte;
	
	public Deportista(byte e, String d)
	{	setEdad(e);
		setDeporte(d);
	}

	public void setEdad(byte e)
	{	edad = e;
	}
	
	public void setDeporte(String d)
	{	deporte = d;		
	}

	public String getDeporte()
	{	return deporte;
	}
	
	public byte getEdad()
	{	return edad;		
	}
	
	public void show()
	{	System.out.println("Edad: " + getEdad() + " Deporte: " + getDeporte());
	}

	public static void main(String[] args) 
	{	Deportista d1 = new Deportista((byte)18,"Baloncesto");
		d1.show();
		Deportista d2 = new Deportista((byte)25,"Salto con pértiga");
		d2.show();
		Deportista d3 = new Deportista((byte)30,"50 km marcha");
		d3.show();
	}
}
