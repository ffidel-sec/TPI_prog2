package Views;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class VistaMedico {
    private final Scanner scanner;
    List<Object> medico = new ArrayList<>();

    public VistaMedico(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Object> pedirDatosMedicos(){
        System.out.print("=================MEDICO===============================\n");
        System.out.print("Ingresar codigo: ");
        int codMedico = scanner.nextInt();
        scanner.nextLine();
        medico.add(codMedico);

        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        medico.add(nombreCompleto);

        System.out.print("Ingrese su matricula: ");
        String matricula = scanner.nextLine();
        medico.add(matricula);

        System.out.print("Ingrese su DNI: ");
        String dni = scanner.nextLine();
        medico.add(dni);

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        medico.add(email);

        System.out.print("Ingrese su numero telefonico: ");
        String nroTelefonico = scanner.nextLine();
        medico.add(nroTelefonico);

        System.out.print("Ingresar numero de consultorio: ");
        int consultorio = scanner.nextInt();
        scanner.nextLine();
        medico.add(consultorio);

        System.out.print("Ingresar Especialidad: ");
        String nombreEspecialidad = scanner.nextLine();
        medico.add(nombreEspecialidad); 

        return medico;
    }
}