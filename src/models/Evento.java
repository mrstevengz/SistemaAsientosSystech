package models;

import java.util.Date;

public class Evento {

    // Atributos propios del UML
    private int idEvento;
    private String nombre;
    private Date fecha;
    private String lugar;

    // Constructor
    public Evento(int idEvento, String nombre, Date fecha, String lugar) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    // Getters y Setters
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    // Métodos del UML
    public void registrarParticipante(Estudiante estudiante) {
        // Aquí debería ir la lógica de registro
        System.out.println("Estudiante " + estudiante.getNombre() + " registrado en el evento " + nombre);
    }

    public Credencial generarCredencial(Estudiante estudiante) {
        // Aquí debería generar y devolver la credencial
        return new Credencial(estudiante, this);
    }
}
