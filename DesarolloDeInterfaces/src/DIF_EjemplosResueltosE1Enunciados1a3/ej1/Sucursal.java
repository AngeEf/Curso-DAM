package DIF_EjemplosResueltosE1Enunciados1a3.ej1;

public class Sucursal implements Compra/*, Venta*/ 
{	private long caja = 0;
	private int precioC;
	private int precioV;

	public void comprar()
	{	setCajaC();
	}
	
	public void vender()
	{	setCajaV();
	}
	
	public void setPrecioC()
	{	precioC = (int)(Math.random()*(100+1));
	}
	
	public void setPrecioV()
	{	precioV = (int)(Math.random()*(100+1));
	}

	public int getPrecioC()
	{	return precioC;
	}

	public int getPrecioV()
	{	return precioV;
	}
	
	public void setCajaC()
	{	setPrecioC();
		caja -= precioC;
	}
	
	public void setCajaV()
	{	setPrecioV();
		caja += precioV;
	}
	
	public long getCaja()
	{	return caja;
	}
	
	public void show(String s)
	{	System.out.println("Se ha realizado una "+s+
			". Caja: " + getCaja() + " €");
		System.out.print("\t" + s +": ");
		if (s.equals("compra"))
			System.out.print(getPrecioC());
		else
			System.out.print(getPrecioV());
		System.out.println(" €");
	}

	public static void main(String[] args) 
	{	Sucursal s = new Sucursal();
		s.comprar();
		s.show("compra");
		s.comprar();
		s.show("compra");
		s.vender();
		s.show("venta");
		s.comprar();
		s.show("compra");
		s.vender();
		s.show("venta");
	}
}
