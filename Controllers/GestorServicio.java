package Controllers;

import Models.Servicio;
import java.util.ArrayList;
import java.util.List;

public class GestorServicio {
    private final GestorEspecialidad gestorEspecialidad;
    public GestorServicio(GestorEspecialidad gestorEspecialidad) {
        this.gestorEspecialidad = gestorEspecialidad;
    }

    private List<Servicio> listaServicios = new ArrayList<>();
    public boolean registrarServicio(List<Object> servicio){
        int codServicio = (int) servicio.get(0);
        String nombreServicio = (String) servicio.get(1);
        String nombreEspecialidad = (String) servicio.get(2);
        double precio = (double) servicio.get(3);

        if(gestorEspecialidad.verificarEspecialidad(nombreEspecialidad)){
            Servicio s = new Servicio(codServicio, nombreServicio, gestorEspecialidad.obtenerEspecialidadPorNombre(nombreEspecialidad), precio);
            listaServicios.add(s);
            return true;
        }
        return false;
    }
}
