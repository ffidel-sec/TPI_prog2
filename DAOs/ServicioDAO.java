package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Models.Servicio;
import java.util.ArrayList;
import java.util.List;
import Models.Especialidad;

public class ServicioDAO {  

    /*public void registrar(Servicio servicio) throws SQLException {

        String sql = """
            INSERT INTO Servicio (NombreServicio, idEspecialidad, precio)
            VALUES (?, ?, ?)
            """;

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, servicio.getNombre());
            sentencia.setInt(2, servicio.getEspecialidad().getId());
            sentencia.setDouble(3, servicio.getPrecio());



            sentencia.executeUpdate();
        }
    } */    
    
    public List<Servicio> listarServicios() throws SQLException {
        String sql = "SELECT s.NombreServicio, s.precio, e.id AS idEspecialidad, e.NombreEspecialidad FROM Servicio s JOIN Especialidad e ON e.id = s.idEspecialidad";
        List<Servicio> lista = new ArrayList<>();

        try (Connection conexion = ConexionBD.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery()) {

            while (rs.next()) {
                Especialidad especialidad = new Especialidad(
                    rs.getInt("idEspecialidad"),
                    rs.getString("NombreEspecialidad")
                );

                Servicio s = new Servicio(
                    rs.getInt("id"),
                    rs.getString("NombreServicio"),
                    especialidad,
                    rs.getDouble("precio")
                );
                lista.add(s);
            }
        }
        return lista;
    }
} 
