package Barras.barras;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class EscucharBarras implements AdjustmentListener 
{	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{	
		if (e.getSource()==Barras.barraH)
		{	System.out.println("Barra Horizontal: "+ e.getValue());
			Barras.jl2.setText("Barra Horizontal: "+ e.getValue());
		}
		else
		{	System.out.println("Barra Vertical: " + e.getValue());
			Barras.jl2.setText("Barra Vertical: " + e.getValue());
		}
	}

}
