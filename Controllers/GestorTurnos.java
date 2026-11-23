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

    public LinkedHashMap<FranjaHoraria, Integer> getFranjasHorariasPorDia(String servicio, int diaSemana, LocalDate fechaTurno) throws SQLException {
        return dao.getFranjasHorariasPorDia(servicio, diaSemana, fechaTurno);
    }

    public boolean registrarTurno(Paciente paciente, int idMedico, Servicio servicio, FranjaHoraria horario, LocalDate fechaReserva) throws SQLException {
        return dao.registrarTurno(paciente.getDni(), idMedico, servicio, horario, fechaReserva);
    }

    public ArrayList<TurnoDTO> getListaTurnos() throws SQLException {
        return dao.listarTurnos();
    }

    public ArrayList<TurnoDTO> getListaTurnosActivos() throws SQLException {
        ArrayList<TurnoDTO> listaTurnosActivos = new ArrayList<>();
        for(TurnoDTO t: dao.listarTurnos()){
            if(t.estado() == Estado.PENDIENTE || t.estado() == Estado.EN_CURSO){
                listaTurnosActivos.add(t);
            }
        }
        return listaTurnosActivos;
    }

    public ArrayList<TurnoDTO> getListaTurnosCancelados() throws SQLException {
        ArrayList<TurnoDTO> listaTurnosCancelados = new ArrayList<>();
        for(TurnoDTO t: dao.listarTurnos()){
            if(t.estado() == Estado.CANCELADO){
                listaTurnosCancelados.add(t);
            }
        }
        return listaTurnosCancelados;
    }

    public boolean cancelarTurno(int id) throws SQLException{
        return dao.cancelarTurno(id);
    }


}