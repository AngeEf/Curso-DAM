package T2Entrega1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EjemploBotones implements ActionListener {
    public JFrame marco = new JFrame("Botones y Textos");
    public JPanel jp = new JPanel();
    public JTextArea jta = new JTextArea("Texto inicial\nLinea 2");
    public JButton jbPulsar = new JButton("Pulsar");

    public EjemploBotones() {
        marco.setSize(300, 200);
        marco.setLayout(null);

        jp.setBounds(0, 0, 300, 200);
        jp.setBackground(Color.DARK_GRAY);

        jta.setForeground(Color.WHITE);
        jta.setBackground(Color.BLACK);
        jp.add(jta);

        jbPulsar.setActionCommand("pulsar");
        jbPulsar.addActionListener(this); // Текущий класс выступает как слушатель
        jp.add(jbPulsar);

        marco.add(jp);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("pulsar")) {
            jta.setText("¡Botón pulsado!\nTexto cambiado.");
        }
    }

    public static void main(String[] args) {
        new EjemploBotones();
    }
}
