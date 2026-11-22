package T2Entrega1;

public class Proceso1 {
    public static void main(String[] args) {
        System.out.println("[Proceso 1] Inicio");

        // Math.random() возвращает число от 0.0 (включительно) до 1.0 (не включительно).
        // Умножаем на 1001 и приводим к int, чтобы получить диапазон от 0 до 1000 включительно.
        int numeroAleatorio = (int) (Math.random() * 1001);

        System.out.println("[Proceso 1] Valor aleatorio generado: " + numeroAleatorio);
        System.out.println("[Proceso 1] Fin");
    }
}
