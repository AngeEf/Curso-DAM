package EDC_CompararString.compararString;

public class CompararString 
{	private static boolean iguales = false;
	private static final String[] st = {"Tardígrado","Tardígrado","Mixino"};
	
	public static void setIguales(String s1, String s2)
	{    //No poner s1==s2
        iguales = s1.equals(s2); // profe: if (s1.equals(s2)==true)
	}
	
	public static String getSt(byte b)
	{	return st[b];		
	}
	
	public static boolean getIguales()
	{	return iguales;		
	}
	
	public static void show()
	{	System.out.print("Cadenas de caracteres ");
		if (getIguales()) //	profe:  if (getIguales()==true)
			System.out.println("iguales");
		else
			System.out.println("diferentes");
	}
	
    static void main(String[] args)
	{	setIguales(st[0], st[1]);
		show();
		setIguales(st[0], st[2]);
		show();
	}
}
