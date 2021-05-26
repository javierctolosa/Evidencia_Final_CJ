package evidenciaFinalCJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


    public class conectar_IDs {

        URL url1 = new URL();

        // Atributos.
        private int idDoc;
        private int idPaciente;
        private int idCita;
        private Connection conexion;
        private Scanner scanner = new Scanner(System.in);


        public void pedirDatos() {
            System.out.println("Ingrese el ID del doctor: ");
            this.idDoc = scanner.nextInt();
            System.out.println("Ingrese el ID del paciente: ");
            this.idPaciente = scanner.nextInt();
            System.out.println("Ingrese el ID de la cita: ");
            this.idCita = scanner.nextInt();
        }


        public void relacionarInformacion() {
            try {
                // Establecer conexión.
                Class.forName("org.sqlite.JDBC");
                Connection conexion = DriverManager.getConnection(url1.url());

                Statement enunciado;
                enunciado = conexion.createStatement();

                // Insertar datos.
                enunciado.execute("INSERT INTO Conexion (idDoctor, idPaciente, idCita) VALUES('" + this.idDoc + "','" + this.idPaciente + "','" + this.idCita + "');'");

                System.out.println("Se realizo la conexion exitosamente");

                enunciado.close();
                conexion.close();

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        public void mostrarRelacionesInformacion() {
            ResultSet dato = null;

            try {

                Class.forName("org.sqlite.JDBC");
                Connection conexion = DriverManager.getConnection(url1.url());


                PreparedStatement query = conexion.prepareStatement("SELECT Doctores.*, Pacientes.*, Citas.* FROM Conexion INNER JOIN Doctores "
                        + "ON Conexion.idDoctor = Doctores.id "
                        + "INNER JOIN Pacientes ON Conexion.idPaciente = Pacientes.id "
                        + "INNER JOIN Citas ON Conexion.idCita = Citas.id");

                dato = query.executeQuery();

                while(dato.next()) {

                    System.out.println("Datos Doctor: ");
                    System.out.print("Nombre del doctor: ");
                    System.out.println(dato.getString(2));
                    System.out.print("Especialidad del doctor: ");
                    System.out.println(dato.getString(3));
                    System.out.println("");

                    System.out.println("Datos Paciente: ");
                    System.out.print("Nombre del paciente: ");
                    System.out.println(dato.getString(5));
                    System.out.println("");

                    System.out.println("Datos Cita: ");
                    System.out.print("Fecha de la cita: ");
                    System.out.println(dato.getString(7));
                    System.out.print("Hora de la cita: ");
                    System.out.println(dato.getString(8));
                    System.out.print("Motivo de la cita: ");
                    System.out.println(dato.getString(9));
                    System.out.println("");
                }

                query.close();
                conexion.close();

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

