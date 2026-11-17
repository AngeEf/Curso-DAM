package ContadorTotalMedia;

public class Equipo 
{	private String nombre;
	private byte nChampions;
	private static byte total = 0;
	private static byte cont = 0;
	private static float media;
		
	public void setNombre (String n)
	{	nombre = n;		
	}
	
	public void setNChampions(byte nc)
	{	nChampions = nc;		
	}
	
	public void setTotal()
	{	total = (byte) (total + nChampions);
	}
	
	public void setCont()
	{	cont++;		
	}
	
	public void setMedia()
	{	float totalM = (float)total;
		float contM = (float)cont;
		media = (totalM/(contM));
	}
	
	public String getNombre()
	{	return nombre;		
	}
	
	public byte getNChampions()
	{	return nChampions;		
	}
	
	public byte getTotal()
	{	return total;			
	}
	
	public byte getContador()
	{	return cont;		
	}
	
	public float getMedia()
	{	return media;		
	}
	
	public void show()
	{	System.out.println("Nombre: "+getNombre()+" Número Champions: "+getNChampions());
		System.out.println("\tTotal: "+getTotal()+" Número equipos: "+getContador() +
				" Media: "+getMedia());
	}

	public Equipo (String n, byte nc)
	{	setNombre(n);
		setNChampions(nc);
		setTotal();
		setCont();
		setMedia();
	}
	
	static void main(String[] args)
	{	Equipo e1 = new Equipo("Real Madrid   ", (byte)15);
		e1.show();
		Equipo e2 = new Equipo("FC Barcelona  ", (byte)5);
		e2.show();
		Equipo e3 = new Equipo("AC Milan      ", (byte)7);
		e3.show();
		Equipo e4 = new Equipo("Ajax Amsterdam", (byte)4);
		e4.show();
		e1.show();

	}

}
