package Views;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VistaPaciente {
    private final Scanner scanner;
    List<Object> paciente = new ArrayList<>();

    public VistaPaciente(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Object> pedirDatosPaciente(){
        System.out.print("=================PACIENTE========================\n");
        System.out.print("Ingrese el nombre completo del paciente: ");
        String nombreCompleto = scanner.nextLine();
        paciente.add(nombreCompleto);

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        paciente.add(email);
        
        System.out.print("Ingrese su numero telefonico: ");
        String nroTelefonico = scanner.nextLine();
        paciente.add(nroTelefonico);

        System.out.print("Ingrese su DNI: ");
        String dni = scanner.nextLine();
        paciente.add(dni);

        return paciente;
    }
}