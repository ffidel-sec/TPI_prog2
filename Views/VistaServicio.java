package Views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VistaServicio {
    private final Scanner scanner;
    List<Object> servicio = new ArrayList<>();

    public VistaServicio(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Object> pedirDatosServicio() {
        System.out.print("==================SERVICIO==============================\n");
        System.out.print("Ingresar codigo de servicio: ");
        int codServicio = scanner.nextInt();
        scanner.nextLine();
        servicio.add(codServicio);

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
    }
}
