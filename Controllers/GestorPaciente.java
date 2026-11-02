package Controllers;

import Models.Paciente;
import java.util.ArrayList;
import java.util.List;

public class GestorPaciente{

    private List<Paciente> listaPacientes = new ArrayList<>();

    public boolean registrarPaciente(List<Object> paciente){
        int codPaciente = (int) paciente.get(0);
        String nombreCompleto = (String) paciente.get(1);
        String email = (String) paciente.get(2);
        String nroTelefonico = (String) paciente.get(3);
        String dni = (String) paciente.get(4);

        
        Paciente p = new Paciente(codPaciente, nombreCompleto, email, nroTelefonico, dni);
        listaPacientes.add(p);

        return true;
    }
}