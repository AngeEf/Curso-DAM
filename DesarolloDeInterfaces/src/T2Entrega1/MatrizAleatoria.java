package T2Entrega1;

public class MatrizAleatoria {
    // 1. Объявление двумерной матрицы
    public byte[][] matriz;

    // Конструктор, принимающий количество строк, колонок и диапазон чисел (min, max)
    public MatrizAleatoria(int filas, int columnas, byte min, byte max) {

        // 2. Инициализация матрицы указанным размером
        matriz = new byte[filas][columnas];

        // 3. Обход сетки через вложенные циклы (строки и колонки)
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {

                // 4. Генерация случайного числа и запись в текущую ячейку
                matriz[f][c] = (byte) ((Math.random() * (max - min + 1)) + min);

                // Вывод сгенерированного числа в консоль (с табуляцией)
                System.out.print(matriz[f][c] + "\t");
            }
            // Переход на новую строку после завершения колонки
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Пример вызова: матрица размером 3 строки на 5 колонок с числами от 1 до 9
        new MatrizAleatoria(3, 5, (byte) 1, (byte) 9);
    }
}
