package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacienteDAO{

    public void registrar(Paciente paciente) throws SQLException {

        String sql = """
            INSERT INTO Paciente (nombre_completo,email,nroTelefonico, dni)
            VALUES (?, ?, ?, ?)
            """;

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, paciente.getNombreCompleto());
            sentencia.setString(2, paciente.getEmail());
            sentencia.setString(3, paciente.getNroTelefonico());
            sentencia.setString(4, paciente.getDni());

            sentencia.executeUpdate();
        }
    }
}


