package Marcos.marcos2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Escuchar implements ActionListener 
{	@Override
	public void actionPerformed(ActionEvent e) 
	{	for (byte f=0; f<2; f++)
		{	for (byte c=0; c<2; c++)
			{	if (e.getActionCommand().equals("p"+f+c))
				{	Marcos2.setJta(f,c);
				}
			}
		}
	}
}
