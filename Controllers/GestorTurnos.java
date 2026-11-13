package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import DAOs.TurnoDAO;
import java.sql.SQLException;
import Models.*;
import java.util.LinkedHashMap;

public class GestorTurnos
{
    private final TurnoDAO dao = new TurnoDAO();   
    
    public int getDiaSemana(LocalDate fecha){
        return fecha.getDayOfWeek().getValue();
    }

    public LinkedHashMap<FranjaHoraria, Integer> getFranjasHorariasPorDia(String servicio, int diaSemana) throws SQLException {
        return dao.getFranjasHorariasPorDia(servicio, diaSemana);
    }

    public boolean registrarTurno(Paciente paciente, int idMedico, Servicio servicio, FranjaHoraria horario, LocalDate fechaReserva) throws SQLException {
        return dao.registrarTurno(paciente.getDni(), idMedico, servicio, horario, fechaReserva);
    }
}