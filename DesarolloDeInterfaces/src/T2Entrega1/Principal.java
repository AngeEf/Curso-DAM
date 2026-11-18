package T2Entrega1;
import T2Entrega1.Escuchador;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Principal {
    // 1. Массив из двух окон JFrame
    public JFrame[] marcos = new JFrame[2];

    // 2. Панели для первого окна
    public JPanel[] jps0 = new JPanel[2];

    public JButton jbNombre = new JButton("Angelina");
    public JButton jbApellido = new JButton("Efremova");

    // 3. Панели для второго окна (сетка 2х2)
    public JPanel[][] jps1 = new JPanel[2][2];
    public static JLabel[] jls = new JLabel[2];
    public static JTextArea[] jtas = new JTextArea[2];
    public JPanel jp99 = new JPanel();

    // Экземпляр слушателя событий (предполагается, что класс Escuchador существует)
    public Escuchador esc = new Escuchador();

    public Principal(){
        // Окно 1: две кнопки (Имя и Фамилия)
        marcos[0] = new JFrame("Окно управления (кнопки)");
        marcos[0].setSize(250, 300); // Размеры окна (ширина, высота)
        marcos[0].setLayout(null);

        // Инициализация двух панелей первого окна
        for (byte i = 0; i < 2; i++) {
            jps0[i] = new JPanel();
            jps0[i].setBounds(0, 100 * i, 230, 90); // Абсолютное позиционирование
        }

        // Настройка кнопки имени
        jbNombre.setActionCommand("nombre"); // Идентификатор команды
        jbNombre.addActionListener(esc);
        jps0[0].add(jbNombre);

        // Настройка кнопки фамилии
        jbApellido.setActionCommand("apellido"); // Идентификатор команды
        jbApellido.addActionListener(esc);
        jps0[1].add(jbApellido);

        // Добавление панелей в первое окно
        marcos[0].add(jps0[0]);
        marcos[0].add(jps0[1]);

        jp99.setBounds(250, 300, 0, 0);
        marcos[0].add(jp99);

        marcos[0].setLocation(100, 150); // Позиция окна на экране
        marcos[0].setVisible(true);

        // Окно 2: сетка 2х2 (JLabel и JTextArea)
        marcos[1] = new JFrame("Окно отображения (2x2)");
        marcos[1].setSize(500, 350);
        marcos[1].setLayout(null);

        // Инициализация массива элементов JLabel (первая строка)
        jls[0] = new JLabel("Ожидание клика...");
        jls[1] = new JLabel("Ожидание клика...");

        // Инициализация массива элементов JTextArea (вторая строка)
        jtas[0] = new JTextArea("Ожидание клика...");
        jtas[1] = new JTextArea("Ожидание клика...");

        // Делаем метки и текстовые области непрозрачными (чтобы был виден фон, если он задан)
        jls[0].setOpaque(true);
        jls[1].setOpaque(true);
        jtas[0].setOpaque(true);
        jtas[1].setOpaque(true);

        // Создание таблицы 2x2 из панелей JPanel
        for (byte f = 0; f < 2; f++) {
            for (byte c = 0; c < 2; c++) {
                jps1[f][c] = new JPanel();
                jps1[f][c].setBounds(230 * c, 130 * f, 220, 120);

                // Заполнение всей доступной области панели
                jps1[f][c].setLayout(new java.awt.BorderLayout());

                // Первая строка (f == 0): добавляем JLabel
                if (f == 0) {
                    jps1[f][c].add(jls[c]);
                } else { // Вторая строка (f == 1): добавляем JTextArea
                    jps1[f][c].add(jtas[c]);
                }

                marcos[1].add(jps1[f][c]);
            }
        }

        JPanel jp99_2 = new JPanel();
        jp99_2.setBounds(500, 350, 0, 0);
        marcos[1].add(jp99_2);

        marcos[1].setLocation(380, 150); // Позиция второго окна на экране
        marcos[1].setVisible(true);
    }

    static void main(String[] args) {
        new Principal();
    }
}