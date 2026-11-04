package Views;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Models.*;
import Controllers.*;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException{
        try{
            Scanner scanner = new Scanner(System.in);

            /*// ESPECIALIDAD
            VistaEspecialidad vistaEspecialidad = new VistaEspecialidad(scanner);
            GestorEspecialidad gestorEspecialidad = new GestorEspecialidad();

            List<Object> especialidad = vistaEspecialidad.pedirDatosEspecialidad();

            boolean registroExitosoEspecialidad = gestorEspecialidad.registrarEspecialidad(especialidad);
            System.out.println("Registro exitoso de especialidad: " +  registroExitosoEspecialidad);
            */

            //PACIENTE
            VistaPaciente vistaPaciente = new VistaPaciente(scanner);
            GestorPaciente gestorPaciente = new GestorPaciente();

            List<Object> paciente = vistaPaciente.pedirDatosPaciente();
            boolean registroExitosoPaciente = gestorPaciente.registrarPaciente(paciente);
            System.out.println("Registro exitoso: " + registroExitosoPaciente);

            // CREAR SERVICIO
            VistaServicio vistaServicio = new VistaServicio(scanner);
            GestorServicio gestorServicio = new GestorServicio();
            String nombreServicioSeleccionado = vistaServicio.mostrarListaServicios(gestorServicio.obtenerListaServicios());

            //MEDICO
            VistaMedico vistaMedico = new VistaMedico(scanner);
            GestorMedico gestorMedico = new GestorMedico();
            vistaMedico.mostrarListaMedicos(gestorMedico.obtenerListaMedicosPorEspecialidad(nombreServicioSeleccionado));

        } catch (SQLException e) {
            System.out.println("Error en la base de datos" + e.getMessage());

        }
    }
}