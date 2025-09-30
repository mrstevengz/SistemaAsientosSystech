package models;

public class ServicioComida {

    private int idServicio;
    private int turno;
    private String rangoCredencial;

    public ServicioComida(int idServicio, int turno, String rangoCredencial) {
        this.idServicio = idServicio;
        this.turno = turno;
        this.rangoCredencial = rangoCredencial;
    }


    public void asignarTurno(Credencial credencial) {
        System.out.println("Servicio de comida asignado al estudiante " + credencial.getNombre() + " en el turno " + turno);
    }

    public void atender(Credencial credencial) {
        System.out.println("Atendiendo al estudiante " + credencial.getNombre() + " en el turno " + turno);
    }
}
