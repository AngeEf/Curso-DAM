package RodrigoGomez_EntregaT1.subproyecto1;

import java.util.ArrayList;
import java.util.List;

public class Matrices 
{

	static void main(String[] args)
	{	//Array estático unidimensional
		
		int[] matriz = new int [5];
		//Corchetes:  []
		//Paréntesis: ()
		//Llaves:     {}
	
		for (byte c=0; c<5; c++)
			System.out.print(matriz[c]+"\t");
		System.out.println();
		
		int max = 4;
		for (byte c=0; c<5; c++)//c = 0, 1, 2, 3, 4
			matriz[c] = (int) (Math.random()*(max+1));
				
		for (byte c=0; c<5; c++)
			System.out.print(matriz[c]+"\t");
		System.out.println();
		
		String[] matrizNombres = {"Bea", "Sandra", "Roberto", "Andrés"};
		//Nº celda:                 0      1         2          3
		for (byte c=0; c<4; c++)
			System.out.print(matrizNombres[c]+"\t");
		System.out.println();
			
		matrizNombres [1] = "Natalia";
		for (byte c=0; c<4; c++)
			System.out.print(matrizNombres[c]+"\t");
		System.out.println();
		
		//Array estático bidimensional
		short[][] nums = new short[2][3]; //2 filas y 3 columnas
		for (byte f=0;f<2;f++)//Recorre las 2 filas
		{	for (byte c=0; c<3; c++)//Recorre las 3 columnas;
			{	nums[f][c] = (short) ((f*10)+c);
			}
		}
		for (byte f=0;f<2;f++)//Recorre las 2 filas
		{	for (byte c=0; c<3; c++)//Recorre las 3 columnas;
			{	System.out.print(nums[f][c]+"\t");
			}
			System.out.println();
		}
		nums[1][1] = 44;
		System.out.println();
		for (byte f=0;f<2;f++)//Recorre las 2 filas
		{	for (byte c=0; c<3; c++)//Recorre las 3 columnas;
			{	System.out.print(nums[f][c]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		byte[][] mat =  {	{1, 2, 3, 4},//Fila 0
							{5, 6, 7, 8},//Fila 1
							{9,10,11,12}};//Fila 2
					 		//0  1  2  3  (<-columnas)
		for (byte f=0;f<3;f++)
		{	for (byte c=0;c<4;c++)
			{	System.out.print(mat[f][c]+"\t");
			}
			System.out.println();
		}
		
		//Array Dinámico 1D
		List <Integer> lista = new ArrayList<>();
		System.out.println("\nLista dinámica: "+lista);
		lista.add(5);//Nºcelda 0
		lista.add(8);//Nºcelda 1
		lista.add(10);//Nºcelda 2
		lista.add(15);//Nºcelda 3
		System.out.println("\nLista dinámica: "+lista);
		lista.add(2,12);//nº celda, valor
		System.out.println("\nLista dinámica: "+lista);
		lista.remove(3);//nº celda
		System.out.println("\nLista dinámica: "+lista);
		System.out.println("Segundo valor: "+lista.get(1));
		lista.set(1, 99);
		System.out.println("\nLista dinámica: "+lista);
	}
}