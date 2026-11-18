package T2Entrega1;

// Задания 2 (ввод текста и изменение цветов)
// Динамический ввод и набор текста через кнопки (виртуальная клавиатура / стенография)
// Посимвольный ввод: несколько кнопок JButton отвечают за конкретные буквы[4]. При клике символ дописывается к уже имеющемуся тексту в JTextArea

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Основной класс реализует интерфейс ActionListener для обработки нажатий кнопок
public class Principal2 implements ActionListener {
    // 1. Создаем элементы окна
    public JFrame marco = new JFrame("Ввод текста и цвета");
    public JPanel jpBotones = new JPanel(); // Панель для кнопок ввода текста
    public JPanel jpTexto = new JPanel();   // Панель для текстового поля
    public JPanel jpColores = new JPanel(); // Панель для кнопок цвета
    public JPanel jpEtiqueta = new JPanel();// Панель для метки

    // Кнопки для ввода букв и перевода строки
    public JButton jbA = new JButton("A");
    public JButton jbB = new JButton("B");
    public JButton jbC = new JButton("C");
    public JButton jbEnter = new JButton("Enter");

    // Текстовая область, куда будет добавляться текст
    public JTextArea jta = new JTextArea("");

    // Метка, у которой будем менять цвета
    public JLabel jlEtiqueta = new JLabel("Etiqueta");

    // Кнопки для изменения цвета (3 для фона, 3 для текста)
    public JButton jbFondoRojo = new JButton("Фон: Красный");
    public JButton jbFondoVerde = new JButton("Фон: Зеленый");
    public JButton jbFondoAzul = new JButton("Фон: Синий");
    public JButton jbTextoBlanco = new JButton("Текст: Белый");
    public JButton jbTextoAmarillo = new JButton("Текст: Желтый");
    public JButton jbTextoNegro = new JButton("Текст: Черный");

    public Principal2() {
        // Настройка окна
        marco.setSize(600, 400);
        marco.setLayout(null); // Отключаем менеджер компоновки для ручного позиционирования

        // 2. Настройка панели с кнопками для текста (сверху слева)
        jpBotones.setBounds(10, 10, 200, 150);

        // Назначаем команды (идентификаторы) для каждой текстовой кнопки и добавляем слушателя (this)
        jbA.setActionCommand("A");
        jbA.addActionListener(this);
        jbB.setActionCommand("B");
        jbB.addActionListener(this);
        jbC.setActionCommand("C");
        jbC.addActionListener(this);
        jbEnter.setActionCommand("Enter");
        jbEnter.addActionListener(this);

        // Добавляем кнопки на панель
        jpBotones.add(jbA);
        jpBotones.add(jbB);
        jpBotones.add(jbC);
        jpBotones.add(jbEnter);
        marco.add(jpBotones);

        // 3. Настройка панели с текстовым полем (сверху справа)
        jpTexto.setBounds(220, 10, 350, 150);
        jpTexto.setLayout(new java.awt.BorderLayout()); // Чтобы JTextArea заполнила всю панель
        jpTexto.add(jta);
        marco.add(jpTexto);

        // 4. Настройка панели с меткой (снизу слева)
        jpEtiqueta.setBounds(10, 170, 200, 180);
        jlEtiqueta.setOpaque(true); // Обязательно делаем метку непрозрачной, иначе фон не изменится
        jlEtiqueta.setBackground(Color.GRAY);
        jlEtiqueta.setForeground(Color.WHITE);
        jpEtiqueta.add(jlEtiqueta);
        marco.add(jpEtiqueta);

        // 5. Настройка панели с кнопками цветов (снизу справа)
        jpColores.setBounds(220, 170, 350, 180);

        // Назначаем команды и слушателя для кнопок цвета
        jbFondoRojo.setActionCommand("FRojo");
        jbFondoRojo.addActionListener(this);
        jbFondoVerde.setActionCommand("FVerde");
        jbFondoVerde.addActionListener(this);
        jbFondoAzul.setActionCommand("FAzul");
        jbFondoAzul.addActionListener(this);

        jbTextoBlanco.setActionCommand("TBlanco");
        jbTextoBlanco.addActionListener(this);
        jbTextoAmarillo.setActionCommand("TAmarillo");
        jbTextoAmarillo.addActionListener(this);
        jbTextoNegro.setActionCommand("TNegro");
        jbTextoNegro.addActionListener(this);

        // Добавляем цветовые кнопки на панель
        jpColores.add(jbFondoRojo);
        jpColores.add(jbFondoVerde);
        jpColores.add(jbFondoAzul);
        jpColores.add(jbTextoBlanco);
        jpColores.add(jbTextoAmarillo);
        jpColores.add(jbTextoNegro);
        marco.add(jpColores);

        // Показываем окно
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }

    // 6. Метод, который срабатывает при нажатии любой кнопки
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand(); // Получаем идентификатор нажатой кнопки

        // Обработка текстовых кнопок: берем текущий текст и прибавляем новую букву (или перевод строки)
        if (comando.equals("A")) {
            jta.setText(jta.getText() + "A");
        } else if (comando.equals("B")) {
            jta.setText(jta.getText() + "B");
        } else if (comando.equals("C")) {
            jta.setText(jta.getText() + "C");
        } else if (comando.equals("Enter")) {
            jta.setText(jta.getText() + "\n"); // \n - символ перевода строки
        }

        // Обработка цветовых кнопок для фона метки (setBackground)
        else if (comando.equals("FRojo")) {
            jlEtiqueta.setBackground(Color.RED);
        } else if (comando.equals("FVerde")) {
            jlEtiqueta.setBackground(Color.GREEN);
        } else if (comando.equals("FAzul")) {
            jlEtiqueta.setBackground(Color.BLUE);
        }

        // Обработка цветовых кнопок для текста метки (setForeground)
        else if (comando.equals("TBlanco")) {
            jlEtiqueta.setForeground(Color.WHITE);
        } else if (comando.equals("TAmarillo")) {
            jlEtiqueta.setForeground(Color.YELLOW);
        } else if (comando.equals("TNegro")) {
            jlEtiqueta.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new Principal2();
    }
}
