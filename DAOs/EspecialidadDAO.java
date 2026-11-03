package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EspecialidadDAO {
    
    public void registrar(Especialidad especialidad) throws SQLException{
        String sql = """
            INSERT INTO Especialidad (NombreEspecialidad)
            VALUES (?)
            """;

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, especialidad.getNombre());
            sentencia.executeUpdate();
        }
    }

    public List<Especialidad> listarEspecialidades() throws SQLException{
        String sql = "SELECT id, NombreEspecialidad FROM Especialidad";
        List<Especialidad> lista = new ArrayList<>();

        try (Connection conexion = ConexionBD.conectar();
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         ResultSet rs = sentencia.executeQuery()) {

            while (rs.next()) {
                Especialidad e = new Especialidad();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("NombreEspecialidad"));
                lista.add(e);
            }  
        }
        return lista;
    }
}