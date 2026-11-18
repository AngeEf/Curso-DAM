package T2Entrega1;

// код для работы со счётчиком кликов и кнопкой выхода

import javax.swing.*;
import java.awt.*;

public class JBoton {
    // Создаем главное окно
    public JFrame marco = new JFrame("Marco");

    // Массив из 3-х панелей для размещения элементов друг под другом
    public JPanel jps[] = new JPanel[3];

    // 1. Статическая переменная-счётчик (начинается с 0)
    // Она статическая, чтобы класс-слушатель (Escuchar) имел к ней прямой доступ
    public static byte np = 0;

    // Метка, которая сразу отображает начальное значение счётчика.
    // Прием (np + "") используется для быстрого перевода числа в строку.
    public static JLabel jl = new JLabel(np + "");

    // Кнопка для увеличения счётчика
    public JButton jb0 = new JButton("Pulsar");

    // Кнопка для выхода из программы
    public JButton jb1 = new JButton("Salir");

    // Массив цветов для фона трех панелей (черный, синий, красный)
    public Color cols[] = {Color.BLACK, Color.BLUE, Color.RED};

    // Создаем экземпляр слушателя событий для обработки кликов
    public Escuchar2 esc = new Escuchar2();

    public JPanel jp99 = new JPanel(); // Вспомогательная техническая панель

    public JBoton() {
        // Настройка окна
        marco.setSize(200, 300); // ширина 200, высота 300
        marco.setLayout(null);   // Отключаем автоматическую компоновку

        // Инициализация панелей в цикле и покраска их в разные цвета
        for (byte f = 0; f < 3; f++) {
            jps[f] = new JPanel();
            jps[f].setBackground(cols[f]);
            jps[f].setBounds(0, 100 * f, 200, 100); // Каждая панель высотой 100px
        }

        // Настройка метки со счётчиком (желтый текст, добавляется на первую панель)
        jl.setForeground(Color.YELLOW);
        jps[0].add(jl);
        marco.add(jps[0]);

        // Настройка кнопки "Pulsar" (добавляется на вторую панель)
        jb0.setActionCommand("p"); // Устанавливаем идентификатор команды "p" (pulsar)
        jb0.addActionListener(esc); // Подключаем нашего слушателя к кнопке
        jps[1].add(jb0);
        marco.add(jps[1]);

        // Настройка кнопки "Salir" (добавляется на третью панель)
        jb1.setActionCommand("s"); // Устанавливаем идентификатор команды "s" (salir)
        jb1.addActionListener(esc); // Подключаем того же слушателя
        jps[2].add(jb1);
        marco.add(jps[2]);

        // Добавляем вспомогательную панель и выводим окно по центру экрана
        jp99.setBounds(100, 300, 0, 0);
        marco.add(jp99);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        new JBoton();
    }
}
