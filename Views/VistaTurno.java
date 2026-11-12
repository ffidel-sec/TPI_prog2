package Views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Models.Turno;
import java.time.LocalDate;
import Models.FranjaHoraria;

public class VistaTurno {

    private final Scanner scanner;
    
    public VistaTurno(Scanner scanner) {
        this.scanner = scanner;
    }

    public LocalDate getFechaTurno() {
        System.out.print("Ingrese la fecha del turno (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        return LocalDate.parse(fechaStr);
    }

    public int mostrarFranjasDisponibles(List<FranjaHoraria> franjasDisponibles) {
        System.out.println("Franjas horarias disponibles:");
        int contador = 1;
        for (FranjaHoraria franja : franjasDisponibles) {
            System.out.println("ID: " + contador + ", Día: " + franja.getDia() + ", Hora inicio: " + franja.getHoraInicio() + ", Hora fin: " + franja.getHoraFin());
            contador++;
        }
        System.out.print("Seleccione la franja horaria por ID: ");
        int numero = scanner.nextInt();
        return numero - 1; // Restamos 1 para obtener el índice correcto en la lista      
    }
}
