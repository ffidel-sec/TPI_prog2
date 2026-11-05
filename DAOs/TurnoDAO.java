package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Models.Servicio;
import java.util.ArrayList;
import java.util.List;
import Models.Turno;
import Models.FranjaHoraria;
import java.time.LocalTime;

public class TurnoDAO {
    
    public ArrayList<FranjaHoraria> getFranjasHorariasPorDia(String servicio, int diaSemana) throws SQLException {
        ArrayList<FranjaHoraria> listaFranjas = new ArrayList<>();

        String sql = """
            SELECT     
            fh.id              AS idFranja,
            fh.*,
            m.id               AS idMedico,
            m.NombreCompleto,
            s.NombreServicio FROM FranjaHoraria AS fh 
            INNER JOIN MedicoFranja AS mf ON fh.id = mf.idFranjaHoraria 
            INNER JOIN Medico m          ON mf.idMedico = m.id 
            INNER JOIN Servicio s        ON m.idEspecialidad = s.idEspecialidad 
            WHERE s.NombreServicio LIKE ? AND fh.DiaSemana = ?;
            """;
        
        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {
                sentencia.setString(1, "%" + servicio + "%");
                sentencia.setInt(2, diaSemana);
                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    int idFranja = resultado.getInt("idFranja");
                    int dia = resultado.getInt("DiaSemana");
                    LocalTime horaInicio = resultado.getTime("HoraInicio").toLocalTime();
                    LocalTime horaFin = resultado.getTime("HoraFin").toLocalTime();
                    int idMedico = resultado.getInt("idMedico");
                    String nombreMedico = resultado.getString("NombreCompleto");
                    String nombreServicio = resultado.getString("NombreServicio");

                    FranjaHoraria franja = new FranjaHoraria(idFranja, dia, horaInicio, horaFin);
                    listaFranjas.add(franja);
                }
            }
            return listaFranjas;
    } 
}
