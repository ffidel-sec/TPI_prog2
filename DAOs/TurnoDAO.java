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
import java.util.LinkedHashMap;
import java.time.LocalDate;
import Models.TurnoDTO;
import Models.Estado;

public class TurnoDAO {
    
    public LinkedHashMap<FranjaHoraria, Integer> getFranjasHorariasPorDia(String servicio, int diaSemana, LocalDate fechaTurno) throws SQLException {
        LinkedHashMap<FranjaHoraria, Integer> franjasConIdMedico = new LinkedHashMap<>();

        String sql = """
            SELECT fh.id          AS idFranja,
             fh.DiaSemana,
                fh.horaInicio,
                fh.horaFin,
                MIN(m.id)      AS idMedico
                FROM Servicio s
                INNER JOIN Medico m         ON m.idEspecialidad = s.idEspecialidad
                INNER JOIN MedicoFranja mf  ON mf.idMedico = m.id
                INNER JOIN FranjaHoraria fh ON fh.id = mf.idFranjaHoraria
                LEFT  JOIN Turno t          ON t.idMedico = m.id
                           AND t.idFranjaHoraria = fh.id
                           AND t.fecha = ?
                           AND t.estado IN ('PENDIENTE','EN_CURSO')
                WHERE s.nombreServicio LIKE ?
                AND fh.DiaSemana = ?
                AND t.id IS NULL
                GROUP BY fh.id, fh.DiaSemana, fh.horaInicio, fh.horaFin
                ORDER BY fh.horaInicio;
        """;
        
        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {
                sentencia.setDate(1, java.sql.Date.valueOf(fechaTurno));
                sentencia.setString(2, "%" + servicio + "%");
                sentencia.setInt(3, diaSemana);
                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    int idFranja = resultado.getInt("idFranja");
                    int dia = resultado.getInt("DiaSemana");
                    LocalTime horaInicio = resultado.getTime("HoraInicio").toLocalTime();
                    LocalTime horaFin = resultado.getTime("HoraFin").toLocalTime();
                    int idMedico = resultado.getInt("idMedico");

                    FranjaHoraria franja = new FranjaHoraria(idFranja, dia, horaInicio, horaFin);
                    franjasConIdMedico.put(franja, idMedico);

                }
            }
            return franjasConIdMedico;
    }
    
    public boolean registrarTurno(String dni, int idMedico, Servicio servicio, FranjaHoraria horario, LocalDate fechaReserva) throws SQLException {
        String sql = 
        """
        INSERT INTO Turno (idPaciente, idServicio, idMedico, idFranjaHoraria, fecha)
        SELECT p.id, ?, ?, ?, ?
        FROM Paciente p
        WHERE p.dni = ?
        """;
        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, servicio.getId());
            sentencia.setInt(2, idMedico);
            sentencia.setInt(3, horario.getId());
            sentencia.setDate(4, java.sql.Date.valueOf(fechaReserva));
            sentencia.setString(5, dni);
            int filasAfectadas = sentencia.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    public ArrayList<TurnoDTO> listarTurnos() throws SQLException {
        ArrayList<TurnoDTO> listaTurnos = new ArrayList<>(); 
        String sql =
        """
        SELECT t.id,
            t.fecha,
            fh.horaInicio,
            fh.horaFin,
            s.NombreServicio,
            m.NombreCompleto  AS medico,
            t.estado
        FROM Turno t
        INNER JOIN Paciente p       ON p.id = t.idPaciente
        INNER JOIN Servicio s       ON s.id = t.idServicio
        INNER JOIN Medico m         ON m.id = t.idMedico
        INNER JOIN FranjaHoraria fh ON fh.id = t.idFranjaHoraria
        ORDER BY t.fecha, fh.horaInicio
        """;
        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery()){
                while (rs.next()){
                    listaTurnos.add(new TurnoDTO(
                    rs.getInt("id"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getTime("horaInicio").toLocalTime(),
                    rs.getTime("horaFin").toLocalTime(),
                    rs.getString("NombreServicio"),
                    rs.getString("medico"),
                    Estado.valueOf(rs.getString("estado"))
                ));
                }
            } 
        return listaTurnos;    
    }

    public boolean cancelarTurno(int id) throws SQLException{
        String sql =
        """
        UPDATE Turno SET estado = 'CANCELADO' WHERE id = ?
        """;

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)){
                sentencia.setInt(1, id);
                int filasAfectadas = sentencia.executeUpdate();
                return filasAfectadas > 0;
            }
    }
}
