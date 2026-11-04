package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Models.Especialidad;

public class EspecialidadDAO {
    
    public void registrar(String nombreEspecialidad) throws SQLException{
        String sql = """
            INSERT INTO Especialidad (NombreEspecialidad)
            VALUES (?)
            """;

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1,nombreEspecialidad);
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
                Especialidad e = new Especialidad(
                rs.getInt("id"),
                rs.getString("NombreEspecialidad"));
                
                lista.add(e);
            }  
        }
        return lista;
    }
}