package Controllers;

import Models.Servicio;
import java.util.ArrayList;
import java.util.List;
import DAOs.ServicioDAO;
import java.sql.SQLException;

public class GestorServicio {
    private final ServicioDAO dao = new ServicioDAO();
    

    private List<Servicio> listaServicios = new ArrayList<>();
    /*public boolean registrarServicio(List<Object> servicio){
        String nombreServicio = (String) servicio.get(0);
        String nombreEspecialidad = (String) servicio.get(1);
        double precio = (double) servicio.get(2);

        if(gestorEspecialidad.verificarEspecialidad(nombreEspecialidad)){
            Servicio s = new Servicio(nombreServicio, gestorEspecialidad.obtenerEspecialidadPorNombre(nombreEspecialidad), precio);
            listaServicios.add(s);
            return true;
        }
        return false;
    }*/
    public List<Servicio> obtenerListaServicios() throws SQLException {
        listaServicios = dao.listarServicios();
        return listaServicios;
    }

}
