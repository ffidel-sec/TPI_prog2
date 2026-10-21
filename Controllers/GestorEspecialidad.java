package Controllers;

import Models.Especialidad;
import java.util.ArrayList;
import java.util.List;

public class GestorEspecialidad {
    private List<Especialidad> listaEspecialidades = new ArrayList<>();
    public boolean registrarEspecialidad(List<Object> especialidad){
        int codEspecialidad = (int) especialidad.get(0);
        String nombreEspecialidad = (String) especialidad.get(1);

        Especialidad e = new Especialidad(codEspecialidad, nombreEspecialidad);
        listaEspecialidades.add(e);
        return true;
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
