package T2Entrega1;

// код для работы со счётчиком кликов и кнопкой выхода
// При клике на кнопку «Pulsar» происходит инкремент (np++), и новое значение сразу же выводится в JLabel
// Отдельная кнопка «Salir» для завершения работы приложения с помощью System.exit(0);

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Класс-слушатель для обработки нажатий на кнопки
class Escuchar2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
        // 2. Обработка клика по кнопке "Pulsar"
        if (a.getActionCommand().equals("p")) {
            System.out.println("Pulsar"); // Вывод в консоль для отладки

            JBoton.np++; // Инкремент: увеличиваем значение счётчика на 1

            // Сразу же обновляем текст в метке JLabel, чтобы пользователь увидел новое число
            JBoton.jl.setText(JBoton.np + "");
        }
        // 3. Обработка клика по кнопке "Salir"
        else if (a.getActionCommand().equals("s")) {
            System.out.println("Ha pulsado salir"); // Вывод в консоль для отладки

            // Команда закрытия приложения. 0 означает успешное завершение без ошибок
            System.exit(0);
        }
    }
}
