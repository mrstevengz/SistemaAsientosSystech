package models;

public class Asiento {

    private int idAsiento;
    private  boolean estado = false;
    private int numero;
    private Estudiante estudiante;

    public Asiento(int idAsiento, int numero) {
        this.idAsiento = idAsiento;
        this.numero = numero;
    }

    public void asignar(Estudiante estudiante) {

        if (!estado) {
            this.estudiante = estudiante;
            this.estado = true;
        } else {
            System.out.println("Asiento ya ocupado");
        }
    }
}