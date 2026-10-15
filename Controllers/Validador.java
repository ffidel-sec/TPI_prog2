package Controllers;
import Models.*;
import java.util.ArrayList;

public class Validador{
    
    // ESPECIALIDAD EXISTE EN LA LISTA
    private static final ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();

    public static void agregarEspecialidad(Especialidad e) {
        listaEspecialidades.add(e);
    }

    public static ArrayList<Especialidad> getListaEspecialidades() {
        return listaEspecialidades;
    }
    
    public static boolean verificarEspecialidad(String nombreEspecialidad){
        for (Especialidad e: getListaEspecialidades()){
            if(e.getNombre().equalsIgnoreCase(nombreEspecialidad)){
                return true;
            }
        }
        return false;
    }

    public static boolean verificarEspecialidadServicio(String nombreEspecialidadServicio){
        for (Especialidad e: getListaEspecialidades()){
            if(e.getNombre().equalsIgnoreCase(nombreEspecialidadServicio)){
                return true;
            }
        }
        return false;
    }


    public static Especialidad obtenerEspecialidadPorNombre(String nombreEspecialidad){
        for (Especialidad e: getListaEspecialidades()){
            if(e.getNombre().equals(nombreEspecialidad)){
                return e;
            }
        }
        return null;
    }

}