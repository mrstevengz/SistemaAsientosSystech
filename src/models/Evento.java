package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private int idEvento;
    private String nombre;
    private Date fecha;
    private String lugar;
    private List<Estudiante> participantes;

    public Evento(int idEvento, String nombre, Date fecha, String lugar) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.participantes = new ArrayList<>();
    }

    public int getIdEvento() { return idEvento; }
    public String getNombre() { return nombre; }
    public Date getFecha() { return fecha; }
    public String getLugar() { return lugar; }
    public List<Estudiante> getParticipantes() { return participantes; }

    //Metodo para registrar a un estudiante / participante al evento
    public void registrarParticipante(Estudiante estudiante) {
        if (!participantes.contains(estudiante)) {
            participantes.add(estudiante);
        }
    }

    //Metodo para generar una credencial aleatoria al estudiante
    public String generarCredencial(Estudiante estudiante) {
        // Generar una credencial simple en forma de String
        return "CRED-" + idEvento + "-" + estudiante.getCif();
    }
}
