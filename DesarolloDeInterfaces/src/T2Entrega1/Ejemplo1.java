package T2Entrega1;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejemplo1 {
    public JFrame marco = new JFrame("Primer marco");
    public JPanel jp = new JPanel();
    public JPanel jp0 = new JPanel();
    public JLabel jl = new JLabel("Primera etiqueta");
    public JLabel jl0 = new JLabel("Segunda etiqueta");

    public Ejemplo1() {
        marco.setSize(500, 700);
        marco.setLayout(null); // Отключаем стандартный менеджер компоновки

        jp.setBackground(Color.CYAN);
        jp.setBounds(0, 0, 240, 340);
        jp.add(jl);

        jp0.setBackground(Color.GREEN);
        jp0.setBounds(250, 0, 240, 340);
        jp0.add(jl0);

        marco.add(jp);
        marco.add(jp0);

        marco.setLocationRelativeTo(null); // Центрируем на экране
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo1();
    }
}