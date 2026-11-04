package Views;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import Models.Medico;


public class VistaMedico {
    private final Scanner scanner;

    public VistaMedico(Scanner scanner) {
        this.scanner = scanner;
    }

    /*public List<Object> pedirDatosMedicos(){
        System.out.print("=================MEDICO===============================\n");

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
    }*/
    public String mostrarListaMedicos(List<Medico> listaMedicos) {
        System.out.println("Lista de medicos disponibles:");
        for (Medico medico : listaMedicos) {
            System.out.println("Nombre del medico: " + medico.getNombreCompleto());
            System.out.println("Matricula: " + medico.getMatricula());
            System.out.println("DNI: " + medico.getDni());
            System.out.println("Email: " + medico.getEmail());
            System.out.println("Numero telefonico: " + medico.getNroTelefonico());
            System.out.println("Consultorio: " + medico.getConsultorio());
            System.out.println("Especialidad: " + medico.getEspecialidad().getNombre());
            System.out.println("-----------------------------");
        }
        System.out.println("Ingrese el nombre del medico que desea seleccionar: ");
        String nombreMedicoSeleccionado = scanner.nextLine();
        return nombreMedicoSeleccionado;
    }
}