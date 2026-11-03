package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            sentencia.setString(6, medico.getConsultorio());
            sentencia.setInt(7, medico.getIdEspecialidad());

            sentencia.executeUpdate();
        }
    }
}