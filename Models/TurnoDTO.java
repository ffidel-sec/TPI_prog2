package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public record TurnoDTO(
        int id,
        LocalDate fecha,
        LocalTime horaInicio,
        LocalTime horaFin,
        String servicio,
        String medico,
        String dni,
        String nombrePaciente,
        Estado estado
    ) {}
