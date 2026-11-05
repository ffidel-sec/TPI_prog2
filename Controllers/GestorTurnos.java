package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import DAOs.TurnoDAO;
import java.sql.SQLException;
import Models.FranjaHoraria;

public class GestorTurnos
{
    private final TurnoDAO dao = new TurnoDAO();   
    
    public int getDiaSemana(LocalDate fecha){
        return fecha.getDayOfWeek().getValue();
    }

    public ArrayList<FranjaHoraria> getFranjasHorariasPorDia(String servicio, int diaSemana) throws SQLException {
        return dao.getFranjasHorariasPorDia(servicio, diaSemana);
    }
}