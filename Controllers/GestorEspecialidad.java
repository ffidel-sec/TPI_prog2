package Controllers;

import Models.Especialidad;
import DAOs.EspecialidadDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class GestorEspecialidad {
    private List<Especialidad> listaEspecialidades = new ArrayList<>();
    private final EspecialidadDAO dao = new EspecialidadDAO();

    public boolean registrarEspecialidad(List<Object> especialidad) throws SQLException{
        String nombreEspecialidad = (String) especialidad.get(0);

        Especialidad e = new Especialidad(nombreEspecialidad);
        dao.registrar(e);
        getListaEspecialidades();
        return true;
    }
    
    public List<Especialidad> getListaEspecialidades() throws SQLException{
        private List<Especialidad> listaEspecialidades = new ArrayList<>();
        listaEspecialidades = dao.listarEspecialidades();
        
        return listaEspecialidades;
    }

    
    public boolean verificarEspecialidad(String nombreEspecialidad){
        for (Especialidad e: listaEspecialidades){
            if(e.getNombre().equalsIgnoreCase(nombreEspecialidad)){
                return true;
            }
        }
        return false;
    }

    public boolean verificarEspecialidadServicio(String nombreEspecialidadServicio){
        for (Especialidad e: listaEspecialidades){
            if(e.getNombre().equalsIgnoreCase(nombreEspecialidadServicio)){
                return true;
            }
        }
        return false;
    }


    public Especialidad obtenerEspecialidadPorNombre(String nombreEspecialidad){
        for (Especialidad e: listaEspecialidades){
            if(e.getNombre().equals(nombreEspecialidad)){
                return e;
            }
        }
        return null;
    }
}
