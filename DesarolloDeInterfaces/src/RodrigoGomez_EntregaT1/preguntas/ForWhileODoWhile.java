package RodrigoGomez_EntregaT1.preguntas;

public class ForWhileODoWhile 
{	static void main(String[] args)
	{	//Mostrar todos los números impares desde 5 hasta 15, ambos inclusive.
		// Flujo con número de pasos predeterminado => for
		for (byte b=5; b<=15; b+=2)
			System.out.print(b+" ");
		System.out.println();
		
		//Mostrar un número aleatorio entre 0 y 10, a partir del cálculo entre 0 y 12,
		// hasta que salga un número mayor que 10. El primer valor siempre se muestra.
		// Flujo con número de pasos no predeterminado => while o do while
		// El primer valor siempre se muestra => empleamos do while
		byte max = 12;
		byte c = (byte) (Math.random()*(max+1));
		do
		{	System.out.print(c+" ");
			c = (byte) (Math.random()*(max+1));
		}while(c<=10);
		System.out.println();
		
		//Mostrar un número aleatorio entre 0 y 10, a partir del cálculo entre 0 y 16,
		// hasta que salga un número mayor que 10. El primer valor no se muestra si no
		//cumple la condición.
		// Flujo con número de pasos no predeterminado => while o do while
		// El primer valor no se muestra si no cumple la condición => empleamos while
		
		max = 16;
		c = (byte) (Math.random()*(max+1));
		while(c<=10)
		{	System.out.print(c+" ");
			c = (byte) (Math.random()*(max+1));
		}
		System.out.println();
		

	}
}
