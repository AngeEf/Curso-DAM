package SimilarEjsT1c.similar;

import java.util.Scanner;

/*El primer hilo pregunta 2 veces al usuario una matrícula. El segundo hilo
 * pregunta al usuario un año. Tras finalizar ambos hilos, se muestran todos los valores 
 * introducidos en el orden inverso al que fueron introducidos. 
 * */

public class SimilarEj1 implements Runnable{
	
	/*Los atributos static tienen el mismo valor para todos los objetos, en este
	caso: e y f.*/
	
	private static String matricula [] = {"",""};//Atributo
	private static short agno [] = {0,0};        //Atributo
	
	private static byte nh=0;					//Atributo auxiliar
	//Número de hilo
	
	public static Scanner sc = new Scanner (System.in);
	//Flujo de caracteres desde el teclado hasta el código
	
	public void setNh() //Da valor a nh
	{	nh++;		
	}
	
	public byte getNh() //Devuelve el valor de nh
	{	return nh;		
	}
	
	public String getMatricula(byte c) //Devuelve el valor de la matrícula nºc
	{	return (matricula[c]);
	}
	
	public short getAgno(byte c)//Devuelve el valor del año nºc
	{	return (agno[c]);
	}
	
	public void show()	//Muestra los valores de todos los atributos no auxiliares
	{	for (byte c=2;c>=1;c--)
			System.out.println("Años "+c+": "+getAgno((byte)(c-1)));	
		for (byte c=2;c>=1;c--)
			System.out.println("Matrícula "+c+": "+getMatricula((byte)(c-1)));
	}
	
	public void setMatricula(byte c)  //Da valor a matrícula nºc
	{	System.out.print("Introduzca matrícula "+c+": ");/*1º en set cuando escribe usuario,
	siempre, preguntar*/
			matricula[c-1]= sc.nextLine();//Atributos String = objetoScanner.nextLine();
			//nextLine devuelve un String
			/*Recordar:
			 * public static Scanner sc = new Scanner (System.in);
			 * */
	}
	
	public void setAgno(byte c)//Da valor a año nºc
	{	System.out.print("Introduzca año "+c+": ");/*1º en set cuando escribe usuario,
	siempre, preguntar*/
			agno[c-1]= Short.valueOf(sc.nextLine());
			//Atributos short = Short.valueOf(objetoScanner.nextLine());
			//nextLine devuelve un String
			/*Recordar:
			 * public static Scanner sc = new Scanner (System.in);
			 * */
	}
	
	public void cerrar()
	{	sc.close();	//Cerrar el flujo	
	}
	
	@Override
	public void run()	//Lanzamos el hilo
	{	System.out.println("Hilo: "+Thread.currentThread().getName());
		//Mostramos nombre del hilo
		setNh();
		if (getNh()==1)
		{	for (byte c=1; c<=2; c++)
			{	setMatricula(c);
			}
		}
		else if (getNh()==2)
		{	for (byte c=1; c<=2; c++)
			{	setAgno(c);
			}
		}
	}
	
	static void main(String[] args)
	{	SimilarEj1 e      = new   SimilarEj1();//Creamos un objeto de la clase
		//Clase    objeto = nuevo Constructor(); 
		//Clase y constructor se llaman igual que Archivo.java
	
		Thread h1 = new   Thread(e,                  "H1");
		//Hilo h1 = nuevo Hilo  (objeto de la clase, nombre del hilo);
		h1.start();
      //h1.comienza();
		
		while (h1.isAlive()==true) {} /*Mientras h1 "esté vivo", esté ejecutándose
		no pasamos al siguiente comando */
	
		SimilarEj1 f = new SimilarEj1();
		//Creamos el segundo objeto
		
		Thread h2 = new Thread(f, "H2");
		//Creamos el segundo hilo
		
		h2.start(); 
		//Comienza el segundo hilo
		
		while (h2.isAlive()==true) {}
		//Esperamos que el segundo hilo termine
		
		e.show();
		//Mostramos los valores de las matrículas y años
		
		e.cerrar();
		//Cerrar el flujo
	}
}
