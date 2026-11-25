package T2Entrega1;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class LeerUniversal {
    private Connection conexion = null;

    public void leerUniversal(String nombreTabla) {
        String sql = "SELECT * FROM " + nombreTabla;

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            // Получаем метаданные (информацию о структуре результата)
            ResultSetMetaData metaData = rs.getMetaData();
            int numColumnas = metaData.getColumnCount(); // Количество столбцов

            System.out.println("\nTabla: " + nombreTabla);
            // Выводим заголовки столбцов (нумерация в JDBC начинается с 1)
            for (int n = 1; n <= numColumnas; n++) {
                System.out.printf("%-12s\t", metaData.getColumnName(n));
            }
            System.out.println();

            // Выводим содержимое каждой строки
            while (rs.next()) {
                for (int n = 1; n <= numColumnas; n++) {
                    System.out.printf("%-12s\t", rs.getObject(n));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void leerConControlDeNulos() {
        String sql = "SELECT nombreUsuario, altura FROM usuarios";

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String usuario = rs.getString("nombreUsuario");
                if (rs.wasNull()) {
                    usuario = null; // Явно фиксируем отсутствие строки
                }

                double altura = rs.getDouble("altura");
                if (rs.wasNull()) {
                    altura = 3.0; // Маркерное значение из задания E2 (5d)
                    System.out.println(usuario + " -> " + altura + " (altura no introducida.)");
                } else {
                    System.out.println(usuario + " -> " + altura);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarConReintentos(int idUsuario, double nuevaAltura) throws SQLException {
        String sql = "UPDATE usuarios SET altura = ? WHERE IdNum = ?";

        // До 5 попыток выполнения (в задании 5c — 3 попытки: 1 основная + 2 повторные)
        for (int intento = 1; intento <= 5; intento++) {
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setDouble(1, nuevaAltura);
                ps.setInt(2, idUsuario);
                ps.executeUpdate();
                System.out.println("Actualización completada en el intento " + intento);
                break; // Выходим из цикла при успешном выполнении

            } catch (SQLTransactionRollbackException e) {
                // Если исчерпали все попытки — пробрасываем исключение дальше
                if (intento == 5) {
                    throw e;
                }
                try {
                    // Случайная задержка от 1000 до 3000 мс (можно умножать на intento для роста)
                    long tiempoEspera = (long) (1000 + Math.random() * (3000 - 1000 + 1)) * intento;
                    System.out.println("Interbloqueo detectado. Reintentando en " + tiempoEspera + " ms...");
                    Thread.sleep(tiempoEspera);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    public void leerEnArrays() {
        int[] numMesas = new int[5];
        int[] metrosCuadrados = new int[5];
        double[] longitudBarra = new double[5];

        String sql = "SELECT numMesas, m2, longitudBarra FROM restaurantes LIMIT 5";

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            int i = 0;
            while (rs.next() && i < 5) {
                numMesas[i] = rs.getInt("numMesas");
                metrosCuadrados[i] = rs.getInt("m2");
                longitudBarra[i] = rs.getDouble("longitudBarra");
                i++;
            }

            System.out.println("Mesas: " + Arrays.toString(numMesas));
            System.out.println("M2:    " + Arrays.toString(metrosCuadrados));
            System.out.println("Barra: " + Arrays.toString(longitudBarra));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Параметризованное обновление (аналог примера Modificar из конспекта)
    public void restarLongitudConParametro(double descuento, double limite) {
        String sql = "UPDATE calzado SET longitud = longitud - ? WHERE longitud > ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDouble(1, descuento); // Первый '?'
            ps.setDouble(2, limite);    // Второй '?'

            int numFilas = ps.executeUpdate();
            if (numFilas > 0) {
                System.out.println("Se han modificado " + numFilas + " filas.");
            } else {
                System.out.println("No se ha modificado ninguna fila.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удаление записи по переданному идентификатору (аналог Borrar(int nf))
    public void borrarPorId(int id) {
        String sql = "DELETE FROM calzado WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            System.out.println("Filas borradas: " + filas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void consultaCondicionCompuesta() {
        // Выбираем только конкретные столбцы и комбинируем условия через AND / OR
        String sql = "SELECT ciudad, gasolina, diesel FROM gasolineras " +
                "WHERE gasolina >= ? AND diesel <= ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, 2);
            ps.setInt(2, 1);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            rs.getString("ciudad") + " | Gasolina: " +
                                    rs.getInt("gasolina") + " | Diesel: " +
                                    rs.getInt("diesel")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarAlturaDesdeTeclado() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la nueva altura para la primera persona: ");
        double nuevaAltura = sc.nextDouble();

        String sql = "UPDATE usuarios SET altura = ? WHERE IdNum = 1";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDouble(1, nuevaAltura);
            int actualizadas = ps.executeUpdate();
            System.out.println("Filas actualizadas: " + actualizadas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void main(String[] args) {
        new LeerUniversal();
    }

}
