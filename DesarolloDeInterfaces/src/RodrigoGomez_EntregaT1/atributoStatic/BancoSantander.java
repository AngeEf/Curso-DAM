package RodrigoGomez_EntregaT1.atributoStatic;

public class BancoSantander 
{	private static String nombre;
	private short nSucursal;
	private static short ultimaSucursal=1;
	
	public BancoSantander(String n)
	{	nombre = n;
		setNsucursal();
	}
	
	public BancoSantander()
	{	setNsucursal();
	}
	
	public void setNsucursal()
	{	nSucursal = ultimaSucursal;
		ultimaSucursal++;
	}
	
	public short getNSucursal()
	{	return nSucursal;		
	}
	
	public String getNombre()
	{	return nombre;		
	}
	
	public void show()
	{	System.out.println("Nombre: "+getNombre()+" Número de Sucursal: "+getNSucursal());
	}

	static void main(String[] args)
	{	BancoSantander s1 = new BancoSantander("Banco Santander");
		s1.show();
		BancoSantander s2 = new BancoSantander();
		s2.show();
		BancoSantander s3 = new BancoSantander();
		s3.show();
		BancoSantander s4 = new BancoSantander("Banco Cantabria");
		s4.show();
		BancoSantander s5 = new BancoSantander();
		s5.show();
		s1.show();
		

	}

}
