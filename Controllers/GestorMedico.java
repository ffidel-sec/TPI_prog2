package Controllers;

import Models.Medico;
import java.util.ArrayList;
import java.util.List;
import Controllers.GestorEspecialidad;

public class GestorMedico{
    private final GestorEspecialidad gestorEspecialidad;
    public GestorMedico(GestorEspecialidad gestorEspecialidad) {
        this.gestorEspecialidad = gestorEspecialidad;
    }

    private List<Medico> listaMedicos = new ArrayList<>();
    public boolean registrarMedico(List<Object> medico){
        int codMedico = (int) medico.get(0);
        String nombreCompleto = (String) medico.get(1);
        String matricula = (String) medico.get(2);
        String dni = (String) medico.get(3);
        String email = (String) medico.get(4);
        String nroTelefonico = (String) medico.get(5);
        int consultorio = (int) medico.get(6);
        String nombreEspecialidad = (String) medico.get(7);

        if(gestorEspecialidad.verificarEspecialidad(nombreEspecialidad)){
            Medico m = new Medico(codMedico, nombreCompleto, matricula, dni, email, nroTelefonico, consultorio, gestorEspecialidad.obtenerEspecialidadPorNombre(nombreEspecialidad));
            listaMedicos.add(m);
            return true;
        }
        return false;
    }
}
