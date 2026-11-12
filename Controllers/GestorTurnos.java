package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import DAOs.TurnoDAO;
import java.sql.SQLException;
import Models.*;

public class GestorTurnos
{
    private final TurnoDAO dao = new TurnoDAO();   
    
    public int getDiaSemana(LocalDate fecha){
        return fecha.getDayOfWeek().getValue();
    }

    public ArrayList<FranjaHoraria> getFranjasHorariasPorDia(String servicio, int diaSemana) throws SQLException {
        return dao.getFranjasHorariasPorDia(servicio, diaSemana);
    }

    public boolean registrarTurno(Paciente paciente, Medico medico, Servicio servicio, FranjaHoraria horario, LocalDate fechaReserva) throws SQLException {
        Turno turno = new Turno(paciente, medico, servicio, horario, Estado.PENDIENTE, fechaReserva);
        return dao.registrarTurno(turno, paciente.getDni());
        return true;
    }
}