package Marcos.marco;

import java.awt.*; 
import javax.swing.*; 
 
public class marcos 
{ 
 public JFrame marco = new JFrame("Primer marco"); 
 public JPanel jp = new JPanel(); 
 public JPanel jp0= new JPanel(); 
 public JPanel jp1= new JPanel(); 
 public JPanel jp2= new JPanel();  
 public JPanel jp9= new JPanel(); 
 public JLabel jl = new JLabel("Primera etiqueta"); 
 public JLabel jl0= new JLabel("Segunda etiqueta"); 
 public JLabel jl1= new JLabel("Tercera etiqueta"); 
 public JLabel jl2= new JLabel("Cuarta etiqueta");  
   
 public marcos() 
 { 
  marco.setSize(500, 700);//(anchura, altura) 
  jp. setBackground(Color.CYAN); 
  jp. setBounds(0,0,240,340); 
  jp .add(jl ); 
   
  jp0.setBackground(Color.GREEN); 
  jp0.setBounds(250,0,240,340); 
  jp0.add(jl0); 
 
  jp1. setBackground(Color.BLUE); 
  jl1.setForeground(Color.WHITE); 
  jp1. setBounds(0,350,240,340); 
  jp1.add(jl1); 
   
  jp2. setBackground(Color.RED); 
  jp2. setBounds(250,350,240,340); 
  jp2.add(jl2); 
   
  jp9.setBounds(500,700,0,0); 
   
  marco.add(jp ); 
  marco.add(jp0); 
  marco.add(jp1); 
  marco.add(jp2);   
  marco.add(jp9); 
   
  marco.setLocationRelativeTo(null); 
  marco.setVisible(true); 
 } 
 static void main(String[] args)
 { 
 new marcos(); 
 } 
 }
