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

    public int getIdServicio() {
        return idServicio;
    }

    public int getTurno() {
        return turno;
    }

    public String getRangoCredencial() {
        return rangoCredencial;
    }

    //Metodos para asignar un turno a una credencial y atenderla
    public void asignarTurno(String credencial) {
        String[] partes = rangoCredencial.split(":");
        if (partes.length == 2) {
            String inicio = partes[0];
            String fin = partes[1];
            if (credencial.compareTo(inicio) >= 0 && credencial.compareTo(fin) <= 0) {
                System.out.println("Turno " + turno + " asignado a credencial " + credencial);
            } else {
                System.out.println("Credencial fuera de rango para este servicio.");
            }
        }
    }

    public void atender(String credencial) {
        String[] partes = rangoCredencial.split(":");
        if (partes.length == 2) {
            String inicio = partes[0];
            String fin = partes[1];
            if (credencial.compareTo(inicio) >= 0 && credencial.compareTo(fin) <= 0) {
                System.out.println("Atendiendo a credencial " + credencial + " en turno " + turno);
            } else {
                System.out.println("No se puede atender: credencial fuera de rango.");
            }
        }
    }
}