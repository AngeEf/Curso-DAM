package proyectoInterfaces;

// Запрещаем создание объектов родительского класса, делая его абстрактным
public abstract class Equipo {

    private String nombre;
    private final int agnoFundacion = 1900;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    // Методы set и get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAgnoFundacion() {
        return agnoFundacion;
    }

    public void show() {
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("Año de fundación: " + agnoFundacion);
    }

    // Обязываем определить showS во всех подклассах
    public abstract void showS();
}