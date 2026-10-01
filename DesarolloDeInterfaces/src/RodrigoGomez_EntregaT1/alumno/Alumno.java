package RodrigoGomez_EntregaT1.alumno;

public abstract class Alumno 
//abstract: prohibe crear objetos de la superclase 
{	private String apellido;
	
	public void setApellido(String apellido)
	{	this.apellido = apellido;		
	}

	public String getApellido()
	{	return apellido;		
	}
	
	public void show()
	{	System.out.print("Apellido: "+getApellido()+", ");
	}
	
	public Alumno(String a)
	{	setApellido(a);		
	}
	
	public abstract void showS(); //Obliga a las subclases
	//a definir su propio showS
	
	static void main(String[] args)
	{	//Alumno a = new Alumno("Gutiérrez");
		// No se puede ejecutar al ser clase abstract
		Dam1 d11 = new Dam1("González",6.5F);
		d11.showS();
		Dam1 d12 = new Dam1("Delgado",7F);
		d12.showS();
		Dam2 d21 = new Dam2("Jiang",7.5F);
		d21.showS();
		Dam2 d22 = new Dam2("Tellez",8.0F);
		d22.showS();
	}
}
