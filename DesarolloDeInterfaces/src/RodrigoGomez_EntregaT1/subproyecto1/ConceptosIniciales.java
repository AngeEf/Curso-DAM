package RodrigoGomez_EntregaT1.subproyecto1;

public class ConceptosIniciales 
{//Inicio de la clase
	static void main(String[] args)
	{	//Inicio del main
		float f = -3.3F;
		double d = 3.5; 
		char ch = 'e';
		System.out.println("f:"+f+", d:"+d+'\n');
		System.out.print("\tch:"+ch+"\n");
		byte a=3, b=4, c;
		c = (byte)(a + b);
		System.out.println("c:"+c);
		c = (byte)(a + c);// c = 3 + 7 = 10
		System.out.println("c:"+c);
		c += a; //c = (byte)(a + c);
		System.out.println("c:"+c);
		c--; // c = c - 1
		System.out.println("c:"+c);
		c = (byte)(c - 4);
		System.out.println("c:"+c);
		c = (byte)(c * 2);
		System.out.println("c:"+c);
		c+=3;
		System.out.println("c:"+c);
		c/=5; //c = 19 / 5 = 3.8 = 3
		System.out.println("c:"+c);
		a = 20; 
		b = 5;
		c = (byte)(a % b); //20 / 5 = 4 + (0/20) => resto 0
		System.out.println("c:"+c);
		a = 22;
		c = (byte)(a % b); //22 / 5 = 4 + (2/20) => resto 2
		System.out.println("c:"+c);
		

	}//Final del main
}//Final de la clase
