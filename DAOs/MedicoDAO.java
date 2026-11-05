package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Models.Medico;
import java.util.ArrayList;
import java.util.List;
import Models.Especialidad;

public class MedicoDAO {
    public void registrar(Medico medico) throws SQLException {

        String sql = """
            INSERT INTO Medico (nombreCompleto,matricula,dni,email,nroTelefonico,consultorio,idEspecialidad)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, medico.getNombreCompleto());
            sentencia.setString(2, medico.getMatricula());
            sentencia.setString(3, medico.getDni());
            sentencia.setString(4, medico.getEmail());
            sentencia.setString(5, medico.getNroTelefonico());
            sentencia.setInt(6, medico.getConsultorio());
            sentencia.setInt(7, medico.getIdEspecialidad());

            sentencia.executeUpdate();
        }
    }

    public List<Medico> getMedicoEspecialidad(String nombreServicioSeleccionado) throws SQLException {
        String sql = """
            SELECT m.nombreCompleto,
               m.id                AS idMedico,
               m.matricula,
               m.dni,
               m.email,
               m.nroTelefonico,
               m.consultorio,
               e.id                 AS idEspecialidad,
               e.NombreEspecialidad
            FROM Medico m
            INNER JOIN Especialidad e ON e.id = m.idEspecialidad
            WHERE LOWER(e.NombreEspecialidad) = LOWER(?)
            """;
        List<Medico> lista = new ArrayList<>();

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, nombreServicioSeleccionado.trim());
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                Especialidad especialidad = new Especialidad(
                    rs.getInt("idEspecialidad"),
                    rs.getString("NombreEspecialidad")
                );

                Medico m = new Medico(
                    rs.getInt("idMedico"),
                    rs.getString("nombreCompleto"),
                    rs.getString("matricula"),
                    rs.getString("dni"),
                    rs.getString("email"),
                    rs.getString("nroTelefonico"),
                    rs.getInt("consultorio"),
                    especialidad
                );
                lista.add(m);
            }
        }
        return lista;
    }
}