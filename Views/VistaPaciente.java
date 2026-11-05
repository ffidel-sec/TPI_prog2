package Views;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Models.Paciente;

public class VistaPaciente {
    private final Scanner scanner;
    List<Object> paciente = new ArrayList<>();

    public VistaPaciente(Scanner scanner) {
        this.scanner = scanner;
    }

    public String pedirDni(){
        System.out.print("=================PACIENTE========================\n");
        System.out.println("Ingrese su DNI: ");
        return scanner.nextLine().trim();
    }

    public List<Object> pedirDatosPaciente(String dni){
        System.out.print("Ingrese el nombre completo del paciente: ");
        String nombreCompleto = scanner.nextLine();
        paciente.add(nombreCompleto);

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        paciente.add(email);
        
        System.out.print("Ingrese su numero telefonico: ");
        String nroTelefonico = scanner.nextLine();
        paciente.add(nroTelefonico);

        paciente.add(dni);

        return paciente;
    }

    public void mostrarBienvenida(Paciente paciente) {
        System.out.println("Bienvenido de nuevo, " + paciente.getNombreCompleto() + ".");
    }

    public void mostrarRegistroExitoso(Paciente paciente) {
        System.out.println("Paciente registrado con éxito.");
    }
}