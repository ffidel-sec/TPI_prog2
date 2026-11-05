package Controllers;

import Models.Paciente;
import DAOs.PacienteDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class GestorPaciente{

    private List<Paciente> listaPacientes = new ArrayList<>();
    private final PacienteDAO dao = new PacienteDAO();


    public Paciente registrarPaciente(List<Object> paciente) throws SQLException{
        String nombreCompleto = (String) paciente.get(0);
        String email = (String) paciente.get(1);
        String nroTelefonico = (String) paciente.get(2);
        String dni = (String) paciente.get(3);

        Paciente p = new Paciente(nombreCompleto, email, nroTelefonico, dni);
        dao.registrar(p);
        
        return p;
    }

    public boolean verificarExistencia(String dni) throws SQLException {
        return dao.buscarPorDni(dni) != null;
    }

    public Paciente buscarPorDni(String dni) throws SQLException{
        return(dao.buscarPorDni(dni));
    }
}