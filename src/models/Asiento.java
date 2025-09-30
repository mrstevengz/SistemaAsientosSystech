package models;

public class Asiento {
    private int idAsiento;
    private String estado;
    private int numero;
    private Estudiante estudiante;

    public Asiento(int idAsiento, int numero) {
        this.idAsiento = idAsiento;
        this.numero = numero;
        this.estado = "libre";
        this.estudiante = null;
    }

    public int getIdAsiento() { return idAsiento; }
    public String getEstado() { return estado; }
    public int getNumero() { return numero; }
    public Estudiante getEstudiante() { return estudiante; }

    //Metodos para asignar un asiento a un estudiante y liberarlo
    public void asignar(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.estado = "ocupado";
    }

    public void liberarAsiento() {
        this.estudiante = null;
        this.estado = "libre";
    }
}
