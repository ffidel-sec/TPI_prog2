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

            //PACIENTE
            VistaPaciente vistaPaciente = new VistaPaciente(scanner);
            GestorPaciente gestorPaciente = new GestorPaciente();

            String dni = vistaPaciente.pedirDni();
            Paciente paciente = gestorPaciente.buscarPorDni(dni);

            if (paciente == null){
                paciente = gestorPaciente.registrarPaciente(vistaPaciente.pedirDatosPaciente(dni));
                vistaPaciente.mostrarRegistroExitoso(paciente);
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

            int nroFranja = vistaTurno.mostrarFranjasDisponibles(franjasDisponibles);
            FranjaHoraria franjaSeleccionada = franjasDisponibles.get(nroFranja);  // Obtener la franja seleccionada por el usuario
            

            // Registrar turno
            Servicio servicio = gestorServicio.obtenerServicioPorNombre(nombreServicioSeleccionado);
            boolean registroExitosoTurno = gestorTurnos.registrarTurno(paciente, medico, servicio, franjaSeleccionada, fechaTurno);
             
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());

        }
    }
}