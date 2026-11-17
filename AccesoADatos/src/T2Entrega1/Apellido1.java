package T2Entrega1;

// Импорт необходимых классов для работы с базой данных (JDBC)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Apellido1 { // Замените на вашу фамилию: 'Tuapellido1'

    // Параметры конфигурации для подключения к базе данных MySQL
    private static final String URL = "jdbc:mysql://localhost:3307/productos?serverTimezone=UTC";
    private static final String USUARIO = "root";    // Имя пользователя БД
    private static final String PASSWORD = "1234";   // Пароль пользователя БД

    // Объект для хранения соединения с базой данных
    private Connection conexion = null;

   // Устанавливает соединение с базой данных MySQL на порту 3307.
    public void conectar() {
        try {
            // Загрузка драйвера MySQL в память
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Попытка установить соединение с использованием URL, логина и пароля
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            if (conexion != null) {
                System.out.println("-> Conexión establecida correctamente con la base de datos 'productos'.");
            }
        } catch (ClassNotFoundException e) {
            // Обработка ошибки: драйвер не найден в classpath
            System.err.println("Error: Driver MySQL no encontrado en el classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Обработка ошибок SQL при подключении
            System.err.println("Error de conexión SQL.");
            e.printStackTrace();
        }
    }

    /**
     * Вставляет пять пар обуви в базу данных.
     * Только три из них будут иметь длину более 15 см:
     * 1. Nike (28 cm) -> > 15
     * 2. Adidas (12 cm) -> <= 15
     * 3. Puma (24 cm) -> > 15 (Третья пара обуви)
     * 4. Converse (10 cm) -> <= 15
     * 5. Reebok (26 cm) -> > 15
     */
    public void insertarDatos() {
        // SQL-запрос для вставки данных с параметрами (?) для предотвращения SQL-инъекций
        String sql = "INSERT INTO calzado (marca, longitud) VALUES (?, ?)";

        // Использование try-with-resources для автоматического закрытия PreparedStatement
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Двумерный массив с данными для вставки: {марка, длина}
            Object[][] datos = {
                    {"Nike", 28.0},
                    {"Adidas", 12.0},
                    {"Puma", 24.0},
                    {"Converse", 10.0},
                    {"Reebok", 26.0}
            };

            // Перебор массива и подстановка значений в SQL-запрос
            for (Object[] fila : datos) {
                // Примечание: в исходном коде были ошибки индексов (fila и fila[9]).
                // Они исправлены на fila[0] и fila[1].
                ps.setString(1, (String) fila[0]); // Устанавливаем марку (первый параметр)
                ps.setDouble(2, (Double) fila[1]); // Устанавливаем длину (второй параметр)
                ps.executeUpdate();                // Выполнение запроса на вставку для каждой строки
            }
            System.out.println("-> Se han insertado 5 filas correctamente.");

        } catch (SQLException e) {
            // Обработка ошибок при выполнении SQL-запроса
            e.printStackTrace();
        }
    }

    // Выводит в консоль обувь, длина которой превышает 15 см.
    public void mostrarMayoresDe15() {
        // SQL-запрос для выборки данных с условием
        String sql = "SELECT id, marca, longitud FROM calzado WHERE longitud > 15";
        System.out.println("\n--- Calzados con longitud superior a 15 cm ---");

        // Создание Statement и выполнение запроса (executeQuery) с получением результатов в ResultSet
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            // Форматированный вывод заголовка таблицы
            System.out.printf("%-5s %-15s %-10s\n", "ID", "Marca", "Longitud (cm)");
            System.out.println("----------------------------------------");

            // Перебор результирующего набора и вывод каждой строки
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-10.2f\n",
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getDouble("longitud"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Выводит все текущее содержимое таблицы 'calzado'.
    public void mostrarTodo() {
        // SQL-запрос для выборки всех записей из таблицы без условий
        String sql = "SELECT id, marca, longitud FROM calzado";
        System.out.println("\n--- Contenido completo de la base de datos ---");

        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            System.out.printf("%-5s %-15s %-10s\n", "ID", "Marca", "Longitud (cm)");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-15s %-10.2f\n",
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getDouble("longitud"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   // Удаляет третью добавленную запись об обуви (с ID = 3).
    public void borrarTercerCalzado() {
        // SQL-запрос для удаления конкретной записи по ID
        String sql = "DELETE FROM calzado WHERE id = 3";

        try (Statement st = conexion.createStatement()) {
            // executeUpdate возвращает количество измененных/удаленных строк
            int filasAfectadas = st.executeUpdate(sql);

            // Проверка, была ли удалена строка, и вывод соответствующего сообщения
            if (filasAfectadas > 0) {
                System.out.println("\n-> Tercer calzado (ID = 3) borrado con éxito.");
            } else {
                System.out.println("\n-> No se encontró el tercer calzado para borrar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Вычитает 5 сантиметров из длины всей обуви, размер которой превышает 15 см.
    public void restarCincoCentimetros() {
        // SQL-запрос для обновления (уменьшения) значений в столбце по условию
        String sql = "UPDATE calzado SET longitud = longitud - 5 WHERE longitud > 15";

        try (Statement st = conexion.createStatement()) {
            int filasActualizadas = st.executeUpdate(sql);
            System.out.println("\n-> Se han restado 5 cm a " + filasActualizadas + " calzado(s) con longitud > 15 cm.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Закрывает активное соединение с базой данных.
    public void desconectar() {
        // Проверяем, существует ли соединение, прежде чем его закрывать
        if (conexion != null) {
            try {
                conexion.close(); // Освобождение ресурсов БД
                System.out.println("\n-> Conexión cerrada con éxito.");
            } catch (SQLException e) {
                // Ошибка при попытке закрыть соединение
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Apellido1 app = new Apellido1();

        // 1. Подключение к MySQL
        app.conectar();
        // 2. Вставка 5 строк данных (ровно 3 с длиной > 15)
        app.insertarDatos();
        // 3. Вывод обуви с длиной > 15
        app.mostrarMayoresDe15();
        // 4. Удаление третьей пары обуви
        app.borrarTercerCalzado();
        // 5. Уменьшение длины на 5 см для обуви, длина которой > 15
        app.restarCincoCentimetros();
        // 6. Вывод итогового содержимого базы данных
        app.mostrarTodo();
        // 7. Закрытие соединения и освобождение ресурсов
        app.desconectar();
    }
}