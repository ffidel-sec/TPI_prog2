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
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws SQLException{
        try{
            Scanner scanner = new Scanner(System.in);
        
        VistaGeneral vistaGeneral = new VistaGeneral(scanner);
        VistaPaciente vistaPaciente = new VistaPaciente(scanner);
        GestorPaciente gestorPaciente = new GestorPaciente();
        VistaServicio vistaServicio = new VistaServicio(scanner);
        GestorServicio gestorServicio = new GestorServicio();
        VistaTurno vistaTurno = new VistaTurno(scanner);
        GestorTurnos gestorTurnos = new GestorTurnos();

        int opcion = -1;
        while (opcion != 0){
            opcion = vistaGeneral.mostrarMenu();
            
            if (opcion == 1){
                //PACIENTE
                String dni = vistaPaciente.pedirDni();
                Paciente paciente = gestorPaciente.buscarPorDni(dni);

                if (paciente == null){
                    paciente = gestorPaciente.registrarPaciente(vistaPaciente.pedirDatosPaciente(dni));
                    vistaPaciente.mostrarRegistroExitoso(paciente);
                } else {
                    vistaPaciente.mostrarBienvenida(paciente);
                }

                // CREAR SERVICIO
                String nombreServicioSeleccionado = vistaServicio.mostrarListaServicios(gestorServicio.obtenerListaServicios());

                //TURNO
                LocalDate fechaTurno = vistaTurno.getFechaTurno();
                int diaSemana = gestorTurnos.getDiaSemana(fechaTurno);

                LinkedHashMap<FranjaHoraria, Integer> franjasDisponibles = gestorTurnos.getFranjasHorariasPorDia(nombreServicioSeleccionado, diaSemana, fechaTurno);
                ArrayList<FranjaHoraria> franjasList = new ArrayList<>(franjasDisponibles.keySet());
                int nroFranja = vistaTurno.mostrarFranjasDisponibles(franjasList);
                FranjaHoraria franjaSeleccionada = franjasList.get(nroFranja);  // Obtener la franja seleccionada por el usuario
                int idMedico = franjasDisponibles.get(franjaSeleccionada);

                // Registrar turno
                Servicio servicio = gestorServicio.obtenerServicioPorNombre(nombreServicioSeleccionado);
                boolean registroExitosoTurno = gestorTurnos.registrarTurno(paciente, idMedico, servicio, franjaSeleccionada, fechaTurno);
                System.out.println(registroExitosoTurno ? "Turno registrado exitosamente." : "Error al registrar el turno.");
            }
            else if(opcion == 2){
                //Obtener Lista Turnos
                vistaTurno.listarTurnos(gestorTurnos.getListaTurnos());
            }
            else if(opcion == 3){
                vistaTurno.listarTurnos(gestorTurnos.getListaTurnosActivos());
            }   
            else if(opcion == 4){
                vistaTurno.listarTurnos(gestorTurnos.getListaTurnosCancelados());
            }
            else if(opcion == 5){
                boolean cancelado = gestorTurnos.cancelarTurno(vistaTurno.pedirId());
                if (cancelado){
                    System.out.println("El turno fue cancelado exitosamente");
                }
                else{
                    System.out.println("Error al cancelar el turno");
                }
            }
            else if(opcion == 0){
                System.out.println("Adios");
                break;
            }

            
        }

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());

        }
    }
}