package Views;
import java.util.Scanner;
import Models.Medico;


public class VistaMedico {
    Scanner scanner = new Scanner(System.in);

    public Medico pedirDatosMedicos(){
        System.out.print("=================MEDICO===============================\n");
        System.out.print("Ingresar codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        System.out.print("Ingrese su matricula: ");
        String matricula = scanner.nextLine();

        System.out.print("Ingrese su DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su numero telefonico: ");
        String nroTelefonico = scanner.nextLine();

        System.out.print("Ingresar numero de consultorio: ");
        int consultorio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingresar Especialidad: ");
        String nombreEspecialidad = scanner.nextLine();

        Medico medico = new Medico (codigo,nombreCompleto,matricula,dni,email,nroTelefonico,consultorio,nombreEspecialidad);
        return medico;
    }
}