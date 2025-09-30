package models;

public class Estudiante {
    private String nombre;
    private String apellidos;
    private String correo;
    private int cif;
    private int numRecibo;

    public Estudiante(String nombre, String apellidos, String correo, int cif, int numRecibo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cif = cif;
        this.numRecibo = numRecibo;
    }

    public void registrarse(Evento evento){
        evento.registrarParticipante(this);
    }

    public void seleccionarAsiento(Asiento asiento){
        asiento.asignar(this);
    }
}
