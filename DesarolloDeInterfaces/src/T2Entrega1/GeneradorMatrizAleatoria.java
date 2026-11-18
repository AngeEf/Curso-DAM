package T2Entrega1;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GeneradorMatrizAleatoria {
    // Главное окно
    public JFrame marco = new JFrame("Случайная матрица (10x10)");

    // 1. Двумерные массивы для компонентов: 10 строк и 10 колонок
    public JPanel[][] jps = new JPanel[10][10];
    public JTextArea[][] jtas = new JTextArea[10][10];

    // 2. Трехмерный массив байтов для хранения данных:
    // 10 строк, 10 колонок, и по 2 случайных числа в каждой ячейке
    public byte[][][] nums = new byte[10][10][2];

    // 3. Массив-палитра (11 цветов) для случайного выбора фона
    public Color[] cols = {
            Color.CYAN, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW,
            Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK
    };

    // Техническая панель-заглушка
    public JPanel jp99 = new JPanel();

    public GeneradorMatrizAleatoria() {
        // Настройка окна (ширина 220, высота 440)
        marco.setSize(220, 440);
        marco.setLayout(null); // Отключаем авто-компоновку для работы с координатами

        // Переменные для хранения случайных сгенерированных значений
        byte al1, al2;

        // 4. Вложенные циклы для заполнения сетки 10x10
        for (byte f = 0; f < 10; f++) {
            for (byte c = 0; c < 10; c++) {
                jps[f][c] = new JPanel();

                // 5. Генерация первого случайного числа (от 0 до 9)
                // Формула: (Math.random() * (max - min + 1)) + min
                al1 = (byte) ((Math.random() * (9 - 0 + 1)) + 0);
                nums[f][c][0] = al1; // Сохраняем в первую "ячейку" третьего измерения

                // 6. Генерация второго случайного числа (от 0 до 9)
                al1 = (byte) ((Math.random() * (9 - 0 + 1)) + 0);
                nums[f][c][1] = al1; // Сохраняем во вторую "ячейку" третьего измерения

                // 7. Создаем многострочный JTextArea, сшивая два числа через перенос строки (\n)
                jtas[f][c] = new JTextArea("" + nums[f][c][0] + "\n" + nums[f][c][1]);

                // 8. Случайный выбор цвета для фона
                // Индекс от 0 до 10 (так как в массиве cols 11 элементов)
                al2 = (byte) ((Math.random() * (10 - 0 + 1)) + 0);
                jps[f][c].setBackground(cols[al2]); // Назначаем случайный цвет панели

                // Текстовая область всегда остается черно-белой
                jtas[f][c].setForeground(Color.WHITE);
                jtas[f][c].setBackground(Color.BLACK);

                // 9. Размещение панелей в окне
                // Ширина панели 19, высота 38. Шаг по сетке (20*c и 40*f) чуть больше,
                // чтобы оставить пиксель расстояния между ячейками.
                jps[f][c].setBounds(20 * c, 40 * f, 19, 38);

                // Вкладываем текстовую область в панель, а панель в окно
                jps[f][c].add(jtas[f][c]);
                marco.add(jps[f][c]);
            }
        }

        // Финальная сборка и вывод на экран
        jp99.setBounds(600, 600, 0, 0);
        marco.add(jp99);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        new GeneradorMatrizAleatoria();
    }
}
