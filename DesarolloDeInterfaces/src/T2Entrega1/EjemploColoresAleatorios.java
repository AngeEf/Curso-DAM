package T2Entrega1;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjemploColoresAleatorios {
    public JFrame marco = new JFrame("Colores");
    public JPanel[] jps = new JPanel[5];
    public JLabel[] jls = new JLabel[5];

    // Создание собственных цветов (RGB в формате float от 0.0f до 1.0f)
    public Color miVerde = new Color(0.0f, 0.9f, 0.0f);
    public Color miMarron = new Color(0.2f, 0.0f, 0.0f);

    public Color[] paleta = {Color.CYAN, Color.MAGENTA, Color.YELLOW, miVerde, miMarron};

    public EjemploColoresAleatorios() {
        marco.setSize(300, 400);
        marco.setLayout(null);

        for (byte i = 0; i < 5; i++) {
            jps[i] = new JPanel();
            jps[i].setBounds(10, 10 + (70 * i), 260, 60);

            // Случайный выбор цвета из палитры
            byte indiceColor = (byte) (Math.random() * 5);
            jps[i].setBackground(paleta[indiceColor]);

            jls[i] = new JLabel("Panel " + i);
            jls[i].setForeground(Color.WHITE);
            jps[i].add(jls[i]);

            marco.add(jps[i]);
        }

        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploColoresAleatorios();
    }
}
