package Barras.barras;

import java.awt.*;
import javax.swing.*;

public class Barras 
{	public static JFrame marco = new JFrame("Marco");
	public static JPanel jp0 = new JPanel();
	public static JPanel jp1 = new JPanel();
	public static JPanel jp2 = new JPanel();
	public static JPanel jp9 = new JPanel();
	
	public static JLabel jl2 = new JLabel();
	
	public static JScrollBar barraH = new JScrollBar();
	public static JScrollBar barraV = new JScrollBar();
	
	public static EscucharBarras eb = new EscucharBarras();
	
	public static void setMarco()
	{	marco.setBounds(100, 100, 700, 700);
		marco.setVisible(true);
	}
	
	public static void setJp0()
	{	jp0.setBounds(100,0,600,100);
		jp0.setBackground(new Color (0.7f,0.7f,1f));
		jp0.setLayout(null);
		marco.add(jp0);
	}
	
	public static void setJScrollBarH()
	{	barraH.setOrientation(0);
		barraH.setBounds(50,25,500,50);
		barraH.setValues(5, 0, 1, 10);
		barraH.addAdjustmentListener(eb);
		jp0.add(barraH);
	}
	
	public static void setJp1()
	{	jp1.setBounds(0,100,100,600);
		jp1.setBackground(new Color (0.7f,0.7f,1f));
		jp1.setLayout(null);
		marco.add(jp1);
	}
	
	public static void setJScrollBarV()
	{	barraV.setOrientation(1);
		barraV.setBounds(25,50,50,470);
		barraV.setValues(5, 0, 1, 10);
		barraV.addAdjustmentListener(eb);
		jp1.add(barraV);
	}
	
	public static void setJp2()
	{	jp2.setBounds(100,100,600,600);
		jp2.setBackground(new Color (0.4f,0.4f,1f));
		marco.add(jp2);
	}
	
	public static void setJl2()
	{	jl2.setForeground(new Color(1f,1f,1f));
		jl2.setFont(new Font("Arial", Font.PLAIN, 26));
		jp2.add(jl2);		
	}

	public static void setJp9()
	{	jp9.setBounds(700,700,0,0);
		marco.add(jp9);
	}

	static void main(String[] args)
	{	setMarco();
		setJp0();
		setJScrollBarH();
		setJp1();
		setJScrollBarV();
		setJl2();
		setJp2();
		setJp9();
	}
}
