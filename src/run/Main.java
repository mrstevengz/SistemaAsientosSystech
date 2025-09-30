package run;

import models.*;
import java.util.*;

public class Main {
    //Se inicializan las Listas y Mapas necesarios
    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<Asiento> asientos = new ArrayList<>();
    private static List<Evento> eventos = new ArrayList<>();
    private static List<ServicioComida> servicios = new ArrayList<>();
    private static Map<Estudiante, String> credenciales = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Se agrega un nuevo Evento y un Servicio de Comida
        Evento evento = new Evento(1, "Congreso Systech", new Date(), "Auditorio");
        eventos.add(evento);
        ServicioComida servicio = new ServicioComida(1, 1, "CRED-1-1000:CRED-1-9999");
        servicios.add(servicio);

        int opcion;
        do {
            System.out.println("\n--- Sistema de Asientos Systech ---");
            System.out.println("1. Crear estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Registrar estudiante a evento");
            System.out.println("5. Generar credencial");
            System.out.println("6. Asignar turno comida");
            System.out.println("7. Atender comida");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: crearEstudiante(); break;
                case 2: listarEstudiantes(); break;
                case 3: eliminarEstudiante(); break;
                case 4: registrarEstudianteEvento(); break;
                case 5: generarCredencial(); break;
                case 6: asignarTurnoComida(); break;
                case 7: atenderComida(); break;
            }
        } while (opcion != 8);
    }

    //Metodo para crear un estidnate y agregarlo a la Lista
    private static void crearEstudiante() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("CIF: ");
        int cif = scanner.nextInt();
        System.out.print("Num Recibo: ");
        int numRecibo = scanner.nextInt();
        scanner.nextLine();
        estudiantes.add(new Estudiante(nombre, apellidos, correo, cif, numRecibo));
        System.out.println("Estudiante creado.");
    }

    //Metodo para imprimir todos los estudiantes de la lista
    private static void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes.");
            return;
        }
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            System.out.println((i+1) + ". " + e.getNombre() + " " + e.getApellidos() + " (CIF: " + e.getCif() + ")");
        }
    }


    //Metodo para borrar a un estudiante por ID de la lista
    private static void eliminarEstudiante() {
        listarEstudiantes();
        if (estudiantes.isEmpty()) return;
        System.out.print("Seleccione el número de estudiante a eliminar: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < estudiantes.size()) {
            estudiantes.remove(idx);
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    //Metodo para registrar a un estudiante en el evento
    private static void registrarEstudianteEvento() {
        listarEstudiantes();
        if (estudiantes.isEmpty()) return;
        System.out.print("Seleccione el número de estudiante a registrar: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < estudiantes.size()) {
            Evento evento = eventos.get(0);
            evento.registrarParticipante(estudiantes.get(idx));
            System.out.println("Estudiante registrado en el evento.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    //Metodo para generar una credencial y asignarsela a un estudiante
    private static void generarCredencial() {
        listarEstudiantes();
        if (estudiantes.isEmpty()) return;
        System.out.print("Seleccione el número de estudiante: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < estudiantes.size()) {
            Evento evento = eventos.get(0);
            String credencial = evento.generarCredencial(estudiantes.get(idx));
            credenciales.put(estudiantes.get(idx), credencial);
            System.out.println("Credencial generada y guardada: " + credencial);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    //Metodos para asignar turno a una credencial y atenderla
    private static void asignarTurnoComida() {
        listarEstudiantes();
        if (estudiantes.isEmpty()) return;
        System.out.print("Seleccione el número de estudiante: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < estudiantes.size()) {
            String credencial = credenciales.get(estudiantes.get(idx));
            if (credencial == null) {
                System.out.println("Primero genere la credencial.");
                return;
            }
            ServicioComida servicio = servicios.get(0);
            servicio.asignarTurno(credencial);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void atenderComida() {
        listarEstudiantes();
        if (estudiantes.isEmpty()) return;
        System.out.print("Seleccione el número de estudiante: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < estudiantes.size()) {
            String credencial = credenciales.get(estudiantes.get(idx));
            if (credencial == null) {
                System.out.println("Primero genere la credencial.");
                return;
            }
            ServicioComida servicio = servicios.get(0);
            servicio.atender(credencial);
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
