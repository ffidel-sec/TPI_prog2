package Views;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Models.*;
import Controllers.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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

            String dni = vistaPaciente.pedirDni();
            Paciente paciente = gestorPaciente.buscarPorDni(dni);

            if (paciente == null){
                Paciente pacienteCreado = gestorPaciente.registrarPaciente(vistaPaciente.pedirDatosPaciente(dni));
                vistaPaciente.mostrarRegistroExitoso(pacienteCreado);
            } else {
                vistaPaciente.mostrarBienvenida(paciente);
            }


            // CREAR SERVICIO
            VistaServicio vistaServicio = new VistaServicio(scanner);
            GestorServicio gestorServicio = new GestorServicio();
            String nombreServicioSeleccionado = vistaServicio.mostrarListaServicios(gestorServicio.obtenerListaServicios());

            //TURNO
            VistaTurno vistaTurno = new VistaTurno(scanner);
            GestorTurnos gestorTurnos = new GestorTurnos();
            LocalDate fechaTurno = vistaTurno.getFechaTurno();
            int diaSemana = gestorTurnos.getDiaSemana(fechaTurno);

            ArrayList<FranjaHoraria> franjasDisponibles = gestorTurnos.getFranjasHorariasPorDia(nombreServicioSeleccionado, diaSemana);

            vistaTurno.mostrarFranjasDisponibles(franjasDisponibles);

            //MEDICO
            VistaMedico vistaMedico = new VistaMedico(scanner);
            GestorMedico gestorMedico = new GestorMedico();
            vistaMedico.mostrarListaMedicos(gestorMedico.obtenerListaMedicosPorEspecialidad(nombreServicioSeleccionado));


        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());

        }
    }
}