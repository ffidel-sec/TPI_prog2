package Controllers;

import Models.Paciente;
import DAOs.PacienteDAO;
import java.util.ArrayList;
import java.util.List;

public class GestorPaciente{

    private List<Paciente> listaPacientes = new ArrayList<>();

    public boolean registrarPaciente(List<Object> paciente){
        String nombreCompleto = (String) paciente.get(0);
        String email = (String) paciente.get(1);
        String nroTelefonico = (String) paciente.get(2);
        String dni = (String) paciente.get(3);

        Paciente p = new Paciente(nombreCompleto, email, nroTelefonico, dni);
        PacienteDAO.registrar(p);
        
        return true;
    }
}