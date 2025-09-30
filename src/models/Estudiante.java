package models;

public class Estudiante {
    private String nombre;
    private String apellidos;
    private String correo;
    private int cif;
    private int numRecibo;
    private Asiento asiento;

    public Estudiante(String nombre, String apellidos, String correo, int cif, int numRecibo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cif = cif;
        this.numRecibo = numRecibo;
    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getCorreo() { return correo; }
    public int getCif() { return cif; }
    public int getNumRecibo() { return numRecibo; }
    public Asiento getAsiento() { return asiento; }

    //Metodo para registrar un estudiante a un evento
    public void registrarse(Evento evento) {
        evento.registrarParticipante(this);
    }

    //Metodo para seleccionar un asiento en el evento
    public void seleccionarAsiento(Asiento asiento) {
        if (this.asiento != null) {
            this.asiento.liberarAsiento();
        }
        asiento.asignar(this);
        this.asiento = asiento;
    }
}
