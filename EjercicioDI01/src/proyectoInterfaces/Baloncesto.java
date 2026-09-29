package proyectoInterfaces;

public class Baloncesto extends Equipo {

    private int numEuroligas;

    public Baloncesto(String nombre) {
        super(nombre);
    }

    public void setNumEuroligas(int numEuroligas) {
        this.numEuroligas = numEuroligas;
    }

    public int getNumEuroligas() {
        return numEuroligas;
    }

    // Обязательная реализация абстрактного метода showS
    @Override
    public void showS() {
        System.out.println("--- Equipo de Baloncesto ---");
        show();
        System.out.println("Número de Euroligas: " + numEuroligas);
        System.out.println("----------------------------");
    }
}