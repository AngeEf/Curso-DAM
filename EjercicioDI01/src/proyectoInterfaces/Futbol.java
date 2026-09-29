package proyectoInterfaces;

public class Futbol extends Equipo {

    private int numChampions;

    public Futbol(String nombre) {
        super(nombre); // Передаем nombre в конструктор родительского класса

        // numChampions - случайное число от 2 до 15 включительно
        this.numChampions = (int) (Math.random() * 14) + 2;
    }

    public void setNumChampions(int numChampions) {
        this.numChampions = numChampions;
    }

    public int getNumChampions() {
        return numChampions;
    }

    // Обязательная реализация абстрактного метода showS
    @Override
    public void showS() {
        System.out.println("--- Equipo de Fútbol ---");
        show(); // Вызываем родительский метод show() для вывода nombre и agnoFundacion
        System.out.println("Número de Champions: " + numChampions);
        System.out.println("------------------------");
    }
}