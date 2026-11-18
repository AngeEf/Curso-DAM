package T2Entrega1;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjemploMatrices {
    public JFrame marco = new JFrame("Marco con Matrices");
    public JPanel[][] jps = new JPanel[2][2];
    public JLabel[][] jls = new JLabel[2][2];

    public Color[][] cols = {
            {Color.CYAN, Color.GREEN},
            {Color.BLUE, Color.RED}
    };

    public EjemploMatrices() {
        marco.setSize(500, 700);
        marco.setLayout(null);

        for (byte f = 0; f < 2; f++) {
            for (byte c = 0; c < 2; c++) {
                jps[f][c] = new JPanel();
                jls[f][c] = new JLabel("Fila " + f + " Col " + c);

                jps[f][c].setBackground(cols[f][c]);
                jps[f][c].setBounds(250 * c, 350 * f, 240, 340);
                jps[f][c].add(jls[f][c]);

                marco.add(jps[f][c]);
            }
        }

        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploMatrices();
    }
}
