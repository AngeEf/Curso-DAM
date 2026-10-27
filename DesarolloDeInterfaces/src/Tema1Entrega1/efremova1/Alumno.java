package Tema1Entrega1.efremova1;

public class Alumno implements Angelina {
    private String ciclo;
    private byte curso;

    public Alumno(String ciclo, byte curso) {
        this.ciclo = ciclo;
        this.curso = curso;
    }

    @Override
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public void setCurso(byte curso) {
        this.curso = curso;
    }

    @Override
    public String getCiclo() {
        return this.ciclo;
    }

    @Override
    public byte getCurso() {
        return this.curso;
    }

    @Override
    public void show() {
        System.out.println("Alumno [Ciclo: " + ciclo + ", Curso: " + curso + "]");
    }

    static void main(String[] args) {
        Alumno alumno1 = new Alumno("DAM", (byte) 1);
        Alumno alumno2 = new Alumno("DAW", (byte) 2);
        Alumno alumno3 = new Alumno("ASIR", (byte) 1);

        System.out.println("--- Lista de estudiantes ---");
        alumno1.show();
        alumno2.show();
        alumno3.show();
    }
}
