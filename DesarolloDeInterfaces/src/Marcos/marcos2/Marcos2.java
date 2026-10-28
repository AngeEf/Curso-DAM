package Marcos.marcos2;

import java.awt.Color;

import javax.swing.*;

public class Marcos2 
{	public static JFrame marcos [][] = new JFrame[2][2];
	public static JPanel jps [][][] = new JPanel[2][2][2];
	public static JTextArea jtas [][] = new JTextArea[2][2];
	public static JButton jbs [][] = new JButton[2][2];
	public static JPanel jp9 = new JPanel();
	public static Escuchar esc = new Escuchar();

	public static void setMarcos()
	{	for (byte f=0; f<2; f++)
		{	for (byte c=0; c<2; c++)
			{	marcos[f][c] = new JFrame();
				marcos[f][c].setBounds(200+(c*240),200+(f*240),217,240);
			}
		}
	}
	
	public static void setJps()
	{	for (byte f=0; f<2; f++)
		{	for (byte c=0; c<2; c++)
			{	for (byte f2=0; f2<2; f2++)
				{	jps[f][c][f2] = new JPanel();
					jps[f][c][f2].setBounds(0,f2*100,195,95);
					jps[f][c][f2].setBackground(Color.BLACK);
				}
			}
		}
	}
	
	public static void setJp9()
	{	jp9 = new JPanel();
		jp9.setBounds(300, 300, 0, 0);
	}

	public static void setJtas()
	{	for (byte f=0; f<2; f++)
		{	for (byte c=0; c<2; c++)
			{	jtas [f][c] = new JTextArea("Texto "+f+c+"\nInicial");
				jps [f][c][0].add(jtas[f][c]);
			}
		}
	}
	
	public static void setJta(byte f, byte c)
	{	jtas [f][c].setText("Se ha pulsado Botón"+f+c);
	}
	
	public static void setBts()
	{	for (byte f=0; f<2; f++)
		{	for (byte c=0; c<2; c++)
			{	jbs [f][c] = new JButton("Botón"+f+c);
				jbs [f][c].setActionCommand("p"+f+c);
				jbs [f][c].addActionListener(esc);
				jps [f][c][1].add(jbs[f][c]);
			}
		}
	}
	
	
	public static void setMarcos2()
	{	for (byte f=0; f<2; f++)
		{	for (byte c=0; c<2; c++)
			{	for (byte f2=0; f2<2; f2++)	
				{	marcos[f][c].add(jps[f][c][f2]);
				}
				marcos[f][c].add(jp9);
			}
		}
	}
	
	public static void show()
	{	for (byte f=0; f<2; f++)
		{	for (byte c=0; c<2; c++)
			{	marcos[f][c].setVisible(true);	
			}
		}
	}
	
	static void main(String[] args)
	{	setMarcos();
		setJps();
		setJp9();
		setJtas();
		setBts();
		setMarcos2();
		show();
	}
}
