package RodrigoGomez_EntregaT1.alumno;

public class Dam1 extends Alumno //Dam1 es subclase de Alumno 
{	private float programacion;

	public Dam1(String a, float p)
	{	super(a);
		setProgramacion(p);
	}
	
	public void setProgramacion(float p)
	{	programacion = p;		
	}
	
	public float getProgramacion()
	{	return programacion;		
	}
	
	public void showS()
	{	show();
		System.out.println("Programacion: "+getProgramacion());
	}
}
