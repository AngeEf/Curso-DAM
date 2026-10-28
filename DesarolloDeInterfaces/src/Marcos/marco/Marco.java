package Marcos.marco;

import java.awt.*; 
import javax.swing.*; 

public class Marco 
{	private static JFrame marco = new JFrame("Marco");
	private static JPanel jp0 = new JPanel();
	private static JLabel jl0 = new JLabel("Etiqueta 0");
	private static JPanel jp1 = new JPanel();
	private static JLabel jl1 = new JLabel("Etiqueta 1");
	private static JPanel jp9 = new JPanel(); 

	public static void setMarco()
	{	marco.setSize(400,400);
	}
	
	public static void setJl0()
	{	jl0.setForeground(Color.WHITE);
		jp0.add(jl0);
	}
	
	public static void setJp0()
	{	jp0.setBackground(Color.BLUE);
		jp0.setBounds(0, 0, 195, 400);
	}
	
	public static void setJl1()
	{	jl1.setForeground(Color.YELLOW);
		jp1.add(jl1);
	}
	
	public static void setJp1()
	{	jp1.setBackground(Color.BLACK);
		jp1.setBounds(200, 0, 195, 200);
	}
	
	
	public static void setMarco2()
	{	marco.add(jp0);
		marco.add(jp1);
	}
	
	public static void show()
	{	marco.setLocationRelativeTo(null);
		marco.setVisible(true);
	}
	
	static void main(String[] args)
	{	setMarco();
		setJp0();
		setJl0();
		setJp1();
		setJl1();
		
		jp9.setBounds(500,700,0,0);
		
		setMarco2();
		
		marco.add(jp9);
		show();
	}
}
