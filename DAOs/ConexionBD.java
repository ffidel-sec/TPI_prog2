package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private static final String URL =
        "jdbc:mariadb://localhost:3306/sistema_turnos";

    private static final String USUARIO = "ffidel"; //usuario de la base de datos

    private static final String CLAVE = "Prueba123"; //clave de la base de datos

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
            URL, USUARIO, CLAVE
        );
    }
}
