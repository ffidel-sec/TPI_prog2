package Views;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VistaEspecialidad {
    private final Scanner scanner;
    List<Object> especialidad = new ArrayList<>();
    
    public VistaEspecialidad(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Object> pedirDatosEspecialidad() {
        System.out.print("==================ESPECIALIDAD==============================\n");
        System.out.print("Ingresar codigo de especialidad: ");
        int codigoEspecialidad = scanner.nextInt();
        scanner.nextLine();
        especialidad.add(codigoEspecialidad);

        System.out.print("Ingresar nombre de la especialidad: ");
        String nombreInstanciaEspecialidad = scanner.nextLine();
        especialidad.add(nombreInstanciaEspecialidad);

        return especialidad;
    }
}
