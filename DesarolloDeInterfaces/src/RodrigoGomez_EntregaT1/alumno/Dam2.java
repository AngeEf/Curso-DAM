package RodrigoGomez_EntregaT1.alumno;

public class Dam2 extends Alumno
{	private float psp;
	
	public Dam2(String a, float p)
	{	super(a);
		setPsp(p);
	}
	
	public void setPsp(float p)
	{	psp = p;		
	}
	
	public float getPsp()
	{	return psp;		
	}
	
	public void showS()
	{	show();
		System.out.println("Programación de Servicios y procesos: "+getPsp());
	}
}
