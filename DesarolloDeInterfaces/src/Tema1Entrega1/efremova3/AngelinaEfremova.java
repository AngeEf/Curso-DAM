package Tema1Entrega1.efremova3;

public class AngelinaEfremova {
    private String nombreS;
    private static final String[] LISTA_NOMBRES = {"Angelina", "Carlos", "Giego", "Fernando", "Elena"};

    private SetNombreS setterLambda = () -> {
        int index = (int) (Math.random() * LISTA_NOMBRES.length);
        this.nombreS = LISTA_NOMBRES[index];
    };

    private GetNombreS getterLambda = () -> this.nombreS;

    public AngelinaEfremova() {
        setNombreS();
    }

    public void setNombreS() {
        setterLambda.setNombreS();
    }

    public String getNombreS() {
        return getterLambda.getNombreS();
    }

    public void show() {
        System.out.println("AngelinaEfremova [nombreS: " + getNombreS() + "]");
    }

    static void main(String[] args) {
        AngelinaEfremova obj1 = new AngelinaEfremova();
        AngelinaEfremova obj2 = new AngelinaEfremova();
        AngelinaEfremova obj3 = new AngelinaEfremova();

        System.out.println("--- Resultados de la tarea 3 ---");
        obj1.show();
        obj2.show();
        obj3.show();
    }

}
