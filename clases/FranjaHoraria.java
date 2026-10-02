import java.time.DayOfWeek;
import java.time.LocalTime;

public class FranjaHoraria
{
    private int codFranja;
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public FranjaHoraria(int codFranja, DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin)
    {
        this.codFranja = codFranja;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}