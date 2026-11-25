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
    
    public List<Medico> obtenerListaMedicosPorEspecialidad(String nombreServicioSeleccionado) throws SQLException {
        listaMedicos = dao.getMedicoEspecialidad(nombreServicioSeleccionado);
        return listaMedicos;
    }
}
