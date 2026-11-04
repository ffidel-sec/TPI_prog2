package Views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Models.Servicio;

public class VistaServicio {
    private final Scanner scanner;

    public VistaServicio(Scanner scanner) {
        this.scanner = scanner;
    }

    /*public List<Object> pedirDatosServicio() {
        System.out.print("==================SERVICIO==============================\n");

        System.out.print("Ingresar nombre del servicio: ");
        String nombreServicio = scanner.nextLine();
        servicio.add(nombreServicio);

        System.out.print("Ingresar nombre de la especialidad que lleva a cabo el servicio: ");
        String nombreEspecialidadServicio = scanner.nextLine();
        servicio.add(nombreEspecialidadServicio);

        System.out.println("Ingrese el precio del servicio: ");
        double precio = scanner.nextDouble();
        servicio.add(precio);

        return servicio;
    }*/
    public String mostrarListaServicios(List<Servicio> listaServicios) {
        System.out.println("Lista de servicios disponibles:");
        for (Servicio servicio : listaServicios) {
            System.out.println("Nombre del servicio: " + servicio.getNombreServicio());
            System.out.println("Especialidad: " + servicio.getEspecialidad().getNombre());
            System.out.println("Precio: " + servicio.getPrecio());
            System.out.println("-----------------------------");
        }
        System.out.println("Ingrese el nombre del servicio que desea seleccionar: ");
        String nombreServicioSeleccionado = scanner.nextLine();
        return nombreServicioSeleccionado;
    }

}
