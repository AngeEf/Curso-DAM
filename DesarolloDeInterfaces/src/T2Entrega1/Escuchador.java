package T2Entrega1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Escuchador implements ActionListener {
    private boolean estadoColumna1 = false;
    private boolean estadoColumna2 = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        // 1. При нажатии на кнопку "Nombre" (Имя)
        if (comando.equals("nombre")) {
            Principal.jls[0].setText("Angelina");
            Principal.jls[1].setText("Angelina");
            Principal.jtas[0].setText("Angelina");
            Principal.jtas[1].setText("Angelina");

            if (!estadoColumna1) {
                Principal.jls[0].setBackground(Color.YELLOW);
                Principal.jls[0].setForeground(Color.BLACK);
                Principal.jtas[0].setBackground(Color.YELLOW);
                Principal.jtas[0].setForeground(Color.BLACK);
                estadoColumna1 = true;
            } else {
                Principal.jls[0].setBackground(Color.BLACK);
                Principal.jls[0].setForeground(Color.YELLOW);
                Principal.jtas[0].setBackground(Color.BLACK);
                Principal.jtas[0].setForeground(Color.YELLOW);
                estadoColumna1 = false;
            }
        }

        // 2. При нажатии на кнопку "Apellido" (Фамилия)
        if (comando.equals("apellido")) {
            Principal.jls[0].setText("Efremova");
            Principal.jls[1].setText("Efremova");
            Principal.jtas[0].setText("Efremova");
            Principal.jtas[1].setText("Efremova");

            if (!estadoColumna2) {
                // Вариант А
                Principal.jls[1].setBackground(Color.RED);
                Principal.jls[1].setForeground(Color.WHITE);
                Principal.jtas[1].setBackground(Color.RED);
                Principal.jtas[1].setForeground(Color.WHITE);
                estadoColumna2 = true;
            } else {
                // Вариант Б
                Principal.jls[1].setBackground(Color.WHITE);
                Principal.jls[1].setForeground(Color.RED);
                Principal.jtas[1].setBackground(Color.WHITE);
                Principal.jtas[1].setForeground(Color.RED);
                estadoColumna2 = false;
            }
        }
    }
}
