package SimilarEjsT1c.similar;

public class Ej3 implements Runnable {

	/*Hay una lista predefinida bidimensional de nombres, de dos filas y 4 
columnas. El main lanza un hilo adicional. El hilo del main va mostrando un 
nombre aleatorio de la primera fila hasta que uno cualquiera de los cuatro
se haya mostrado 4 veces. El hilo adicional va mostrando un nombre 
aleatorio de la segunda fila hasta que los cuatro se hayan mostrado al 
menos una vez cada uno. */
	
	private static String nombres [][] = 
		{	{"Jean Marco", "Alexa", "Gigi",   "Roberto"}, //Fila 0
			{"Vanessa",    "Luis",  "Joseph", "Daniel"}	  //Fila 1
//Columnas:   0             1        2         3
		};
	public static byte cont [][] = new byte[2][4];//Inicialmente, todo ceros
	
	@Override
	public void run()
	{	System.out.println("Inicio Hilo Adicional");
	
		do
		{	byte max = 3;
			byte al = (byte)(Math.random()*(max+1));//Aleatorio entre 0 y 3
			System.out.println("Nombre aleatorio de fila 1: "+
	getNombre((byte)1,al));
			cont[1][al]++;
		}while(getContandoF1() == false);
		
		System.out.println("Final Hilo Adicional");
	}
	
	public static String getNombre(byte f, byte c) 
	//Devuelve el valor del nombre de la fila f y la columna c
	{	return nombres[f][c];		
	}
	
	public static void mostrarAleatoriosF0()
	{	do
		{	byte max = 3;
			byte al = (byte)(Math.random()*(max+1));//Aleatorio entre 0 y 3
			System.out.println("Nombre aleatorio de fila 0: "+
		getNombre((byte)0,al));
			cont[0][al]++;
		}while(getContandoF0()==false);
	}
	
	public static boolean getContandoF0() 
	//Devuelve false, salvo que uno de los cuatro nombres de la fila 0 se haya mostrado
	// cuatro veces
	{	boolean cuatro = false;
		for (byte c=0; c<4; c++)
		{
            if (cont[0][c] >= 4) {
                cuatro = true;
                break;
            }
		}
		return cuatro;
	}
	
	public static boolean getContandoF1() 
	//Devuelve false, salvo que uno de los cuatro nombres de la fila 1 se hayan mostrado
	// al menos 1 vez
	{	boolean cuatro = false; /*Será false hasta que los cuatro nombres de la fila 1
	se hayan mostrado al menos 1 vez */
		byte cuantosNombres = 0;
		//cuenta cuantos nombres se muestan al menos 1 vez
		
		for (byte c=0; c<4; c++) //Se repasan los cuatro nombres de la fila 1
		{	if (cont[1][c]>=1) // Si cada uno se ha mostrado al menos 1 vez
				cuantosNombres++; // hay 1 nombre + que se ha mostrado al menos 1 vez
		}//Terminado el for
		
		if (cuantosNombres >= 4) //Si se han contado que los cuatro nombres aparecen
			//al menos 1 vez => salimos del do while
			cuatro = true; 
		//El true no cumple la condición de permanencia:
		// do{...}while(getContandoF1() == false);
			
		return cuatro;
	}
	
    static void main(String[] args)
	{	Ej3 e = new Ej3();
		Thread h = new Thread(e, "Hilo Adicional");
		h.start();		
		mostrarAleatoriosF0();
	}
}
