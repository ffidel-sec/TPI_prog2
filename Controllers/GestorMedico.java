package Controllers;

import Models.Medico;
import DAOs.MedicoDAO;
import java.util.ArrayList;
import java.util.List;
import Controllers.GestorEspecialidad;
import java.sql.SQLException;


public class GestorMedico{
    private final MedicoDAO dao = new MedicoDAO();


    private List<Medico> listaMedicos = new ArrayList<>();

    /*  public boolean registrarMedico(List<Object> medico) throws SQLException{
        String nombreCompleto = (String) medico.get(0);
        String matricula = (String) medico.get(1);
        String dni = (String) medico.get(2);
        String email = (String) medico.get(3);
        String nroTelefonico = (String) medico.get(4);
        int consultorio = (int) medico.get(5);
        String nombreEspecialidad = (String) medico.get(6);

        if(gestorEspecialidad.verificarEspecialidad(nombreEspecialidad)){
            Medico m = new Medico(nombreCompleto, matricula, dni, email, nroTelefonico, consultorio, gestorEspecialidad.obtenerEspecialidadPorNombre(nombreEspecialidad));
            dao.registrar(m);
            return true;
        }
        return false;
    }*/
    
    public List<Medico> obtenerListaMedicosPorEspecialidad(String nombreServicioSeleccionado) throws SQLException {
        listaMedicos = dao.getMedicoEspecialidad(nombreServicioSeleccionado);
        return listaMedicos;
    }

    
}
