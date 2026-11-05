package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Models.Paciente;

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

    public boolean verificarDni(String dni) throws SQLException {
        
        String sql = """
            SELECT EXISTS (
            SELECT 1 FROM Paciente WHERE dni = ?
            ) AS ExisteUsuario;
            """;

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, dni);

            try (ResultSet rs = sentencia.executeQuery()) {
            if (rs.next()) {
                return rs.getBoolean("ExisteUsuario");
            }
            return false; // no debería pasar con EXISTS, pero por seguridad
            }
        }
    }

    public Paciente buscarPorDni(String dni) throws SQLException {
        String sql = """
            SELECT nombre_completo, email, nroTelefonico, dni
            FROM Paciente
            WHERE dni = ?
            """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, dni);

            try (ResultSet rs = sentencia.executeQuery()) {
                if (rs.next()) {
                    return new Paciente(
                        rs.getString("nombre_completo"),
                        rs.getString("email"),
                        rs.getString("nroTelefonico"),
                        rs.getString("dni")
                    );
                }
            }
        }
        return null;   // no existe
    }
}


