package Views;

import java.util.Scanner;
import java.util.ArrayList;

public class VistaGeneral {
    
    private final Scanner scanner;

    public VistaGeneral(Scanner scanner) {
        this.scanner = scanner;
    }

    public int mostrarMenu(){
        System.out.println("\n=== MENU TURNOS ===");
        System.out.println("[1] Registrar un Turno");
        System.out.println("[2] Obtener lista de Turnos");
        System.out.println("[3] Obtener lista de Turnos activos");
        System.out.println("[4] Obtener lista de Turnos cancelados");
        System.out.println("[5] Cancelar un Turno");
        System.out.println("[6] Obtener lista de turnos por paciente");
        System.out.println("[7] Obtener turno por id");
        System.out.println("[0] Salir\n");  


        System.out.println("Selecciona una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        return opcion;
    } 
}
