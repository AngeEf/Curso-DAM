package T2Entrega1;

// реализации логики сохранения состояний (очереди/истории).
// В одном окне находится большая матрица JTextArea (например, 3 строки на 5 колонок)
// Во втором окне находятся кнопки строк (Fila 1, Fila 2, Fila 3) и колонок (Columna 1 ... Columna 5)
// Логика состояния очереди: программа запоминает три последних выбранных координаты (ячейки)
// Последняя выбранная ячейка получает статус и текст «Último» с одним стилем (например, темно-зеленый на светло-зеленом)
// Предыдущая сдвигается в статус «Penúltimo» с инверсией цветов
// Еще более ранняя становится «Antepenúltimo» (например, в синей палитре)
// Все остальные сбрасываются в исходный вид (белый на черном)

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ExamenMatriz implements ActionListener {
    // 1. Создаем два независимых окна
    public JFrame marcoTextos = new JFrame("Матрица JTextArea (3x5)");
    public JFrame marcoBotones = new JFrame("Панель управления");

    // 2. Двумерные массивы для сетки 3 строки на 5 колонок
    public JTextArea[][] jtas = new JTextArea[3][5];
    public JPanel[][] jps = new JPanel[3][5];

    // 3. Одномерные массивы для кнопок строк и колонок
    public JButton[] btnFilas = new JButton[3];
    public JButton[] btnCols = new JButton[5];

    // 4. Переменные состояния для хранения текущего выбора
    // Изначально -1 означает, что кнопка еще не нажималась
    public int filaActual = -1;
    public int colActual = -1;

    // 5. Очередь координат (история): хранит [строку, колонку]
    public int[] ultimo = {-1, -1};        // Последний клик
    public int[] penultimo = {-1, -1};     // Предпоследний клик
    public int[] antepenultimo = {-1, -1}; // Пред-предпоследний клик

    // 6. Создаем кастомные цвета с помощью RGB
    public Color verdeOscuro = new Color(0, 100, 0);
    public Color verdeClaro = new Color(144, 238, 144);
    public Color azulOscuro = new Color(0, 0, 139);
    public Color azulClaro = new Color(173, 216, 230);

    public ExamenMatriz() {
        // --- НАСТРОЙКА ПЕРВОГО ОКНА (Матрица 3х5) ---
        marcoTextos.setSize(600, 400);
        marcoTextos.setLayout(null);

        // Вложенные циклы для создания 15 панелей и текстовых областей
        for (byte f = 0; f < 3; f++) {
            for (byte c = 0; c < 5; c++) {
                jps[f][c] = new JPanel();
                jps[f][c].setBounds(10 + c * 110, 10 + f * 110, 100, 100);
                jps[f][c].setLayout(new java.awt.BorderLayout());

                jtas[f][c] = new JTextArea();
                jtas[f][c].setOpaque(true);
                // Базовый (дефолтный) стиль для всех ячеек
                jtas[f][c].setBackground(Color.BLACK);
                jtas[f][c].setForeground(Color.WHITE);

                jps[f][c].add(jtas[f][c]);
                marcoTextos.add(jps[f][c]);
            }
        }

        // --- НАСТРОЙКА ВТОРОГО ОКНА (Кнопки управления) ---
        marcoBotones.setSize(200, 450);
        marcoBotones.setLayout(null);

        // Генерация кнопок для СТРОК (Filas)
        for (byte i = 0; i < 3; i++) {
            btnFilas[i] = new JButton("Fila " + (i + 1));
            btnFilas[i].setBounds(10, 10 + i * 40, 160, 30);
            btnFilas[i].setActionCommand("F" + i); // Идентификатор, например "F0", "F1"
            btnFilas[i].addActionListener(this);
            marcoBotones.add(btnFilas[i]);
        }

        // Генерация кнопок для КОЛОНОК (Columnas)
        for (byte i = 0; i < 5; i++) {
            btnCols[i] = new JButton("Columna " + (i + 1));
            btnCols[i].setBounds(10, 150 + i * 40, 160, 30);
            btnCols[i].setActionCommand("C" + i); // Идентификатор, например "C0", "C1"
            btnCols[i].addActionListener(this);
            marcoBotones.add(btnCols[i]);
        }

        // Размещаем окна так, чтобы они не перекрывали друг друга
        marcoTextos.setLocation(100, 100);
        marcoBotones.setLocation(750, 100);

        marcoTextos.setVisible(true);
        marcoBotones.setVisible(true);
    }

    // --- ОБРАБОТКА КЛИКОВ И ЛОГИКА ОЧЕРЕДИ ---
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        // 1. Проверяем, что нажал пользователь: строку (F) или колонку (C)
        // И извлекаем индекс (убираем первую букву и превращаем строку в число)
        if (comando.startsWith("F")) {
            filaActual = Integer.parseInt(comando.substring(1));
        } else if (comando.startsWith("C")) {
            colActual = Integer.parseInt(comando.substring(1));
        }

        // 2. Магия задания: координата считается "выбранной", только если
        // у нас есть и строка, и колонка (ни одна из них не равна -1)
        if (filaActual != -1 && colActual != -1) {

            // СДВИГАЕМ ИСТОРИЮ (эффект конвейера):

            // Старый "Предпоследний" становится "Пред-предпоследним"
            antepenultimo[0] = penultimo[0];
            antepenultimo[1] = penultimo[1];

            // Старый "Последний" становится "Предпоследним"
            penultimo[0] = ultimo[0];
            penultimo[1] = ultimo[1];

            // Текущая выбранная ячейка становится "Последней"
            ultimo[0] = filaActual;
            ultimo[1] = colActual;

            // Запускаем метод обновления визуала
            actualizarMatriz();
        }
    }

    // Метод, который перерисовывает все цвета в матрице на основе истории
    public void actualizarMatriz() {

        // Шаг 1: Сброс абсолютно всех ячеек в дефолтное состояние (как ластик)
        for (byte f = 0; f < 3; f++) {
            for (byte c = 0; c < 5; c++) {
                jtas[f][c].setBackground(Color.BLACK);
                jtas[f][c].setForeground(Color.WHITE);
                jtas[f][c].setText(""); // Очищаем текст
            }
        }

        // Шаг 2: Отрисовываем историю "поверх" чистой доски.
        // Рисуем от старых к новым, чтобы если координаты совпадают,
        // более свежий статус перекрыл собой старый.

        // А) Оформляем Antepenúltimo (самый старый из памяти)
        if (antepenultimo[0] != -1) {
            int f = antepenultimo[0];
            int c = antepenultimo[1];
            jtas[f][c].setBackground(azulOscuro);
            jtas[f][c].setForeground(azulClaro);
            jtas[f][c].setText("Antepenúltimo");
        }

        // Б) Оформляем Penúltimo (промежуточный)
        if (penultimo[0] != -1) {
            int f = penultimo[0];
            int c = penultimo[1];
            jtas[f][c].setBackground(verdeOscuro);
            jtas[f][c].setForeground(verdeClaro);
            jtas[f][c].setText("Penúltimo");
        }

        // В) Оформляем Último (самый свежий выбор)
        if (ultimo[0] != -1) {
            int f = ultimo[0];
            int c = ultimo[1];
            jtas[f][c].setBackground(verdeClaro);
            jtas[f][c].setForeground(verdeOscuro);
            jtas[f][c].setText("Último");
        }
    }

    public static void main(String[] args) {
        new ExamenMatriz();
    }
}
