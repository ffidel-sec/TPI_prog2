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