package evidenciaFinalCJ;

import java.util.Scanner;

public class evidencia_Final_CJ {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String opcion;
        String res = "";
        String user, password;
        crear_Usuario admin = new crear_Usuario();
        admin.DatosAdmin();

        do {

            System.out.println("Login.");
            System.out.println("---------------------");
            System.out.println("User: ");
            user = scanner.next();
            System.out.println("Password: ");
            password = scanner.next();

            if (user.equals(admin.getUser()) && password.equals(admin.getPassword())) {
                System.out.println("Hospital Tecmilenio");
                System.out.println("Menú");
                System.out.println("------------------------");
                System.out.println("Elige una opción: ");
                System.out.println();
                System.out.println("1. Alta de doctores");
                System.out.println("2. Alta pacientes");
                System.out.println("3. Crear una cita");
                System.out.println("4. Realizar conexion");
                System.out.println("5. Lista de doctores");
                System.out.println("6. Lista de pacientes");
                System.out.println("7. Lista de citas");
                System.out.println("8. Mostrar conexion");
                System.out.println();

                opcion = scanner.next();

                switch (opcion) {
                    case "1":
                        crear_Doctor doctor = new crear_Doctor();
                        doctor.Datos();
                        doctor.darAltaDoctor();
                        break;

                    case "2":
                        crear_Paciente paciente = new crear_Paciente();
                        paciente.pedirDatos();
                        paciente.darAltaPaciente();
                        break;

                    case "3":
                        crear_Cita cita = new crear_Cita();
                        cita.DatosCita();
                        cita.crearCita();
                        break;

                    case "4":
                        conectar_IDs conexion = new conectar_IDs();
                        conexion.pedirDatos();
                        conexion.relacionarInformacion();
                        break;

                    case "5":
                        doctor = new crear_Doctor();
                        doctor.mostrarDoctores();
                        break;

                    case "6":
                        paciente = new crear_Paciente();
                        paciente.mostrarPacientes();
                        break;

                    case "7":
                        cita = new crear_Cita();
                        cita.mostrarCitas();
                        break;

                    case "8":
                        conexion = new conectar_IDs();
                        conexion.mostrarRelacionesInformacion();
                        break;

                    default:
                        System.out.println("Elige una opcion correcta");

                }
            } else {
                System.out.println("Usuario o Contraseña incorrectos");
            }

            do {
                System.out.println("¿Deseas repetir la aplicacion?");
                System.out.println("si o no: ");
                scanner.nextLine();
                res = scanner.next();
                res = res.toLowerCase();

                if (!res.equals("si") && !res.equals("no")) {
                    System.out.println("Ingresa una opcion valida.");
                }

            } while (!res.equals("si") && !res.equals("no"));

            System.out.println();

        } while (res.equals("si"));

    }



}