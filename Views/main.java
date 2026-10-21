import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Models.*;
import Controllers.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ESPECIALIDAD
        System.out.print("==================ESPECIALIDAD==============================\n");
        System.out.print("Ingresar codigo de especialidad: ");
        int codigoEspecialidad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingresar nombre de la especialidad: ");
        String nombreInstanciaEspecialidad = scanner.nextLine();

        Especialidad e = new Especialidad(codigoEspecialidad, nombreInstanciaEspecialidad);
        Validador.agregarEspecialidad(e);


        // CREAR SERVICIO
        System.out.print("====================SERVICIO============================\n");

        System.out.print("Ingresar codigo de servicio: ");
        int codigoServicio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingresar nombre del servicio a crear: ");
        String nombreInstanciaServicio = scanner.nextLine();

        System.out.print("Ingresar nombre de la especialidad que lleva a cabo el servicio: ");
        String nombreEspecialidadServicio = scanner.nextLine();

        if(Validador.verificarEspecialidad(nombreEspecialidadServicio)){
            Servicio s = new Servicio(codigoServicio, nombreInstanciaServicio,Validador.obtenerEspecialidadPorNombre(nombreEspecialidadServicio));
            System.out.println("ADENTRO DEL IF");
            System.out.println(Validador.obtenerEspecialidadPorNombre(nombreEspecialidadServicio).getNombre());
        }
        

        // MEDICO

        if(Validador.verificarEspecialidad(nombreEspecialidad)){
            Medico m = new Medico(codigo, nombreCompleto, matricula, dni, email, nroTelefonico, nombreEspecialidad);
            System.out.println("ADENTRO DEL IF");
        }

    }
}