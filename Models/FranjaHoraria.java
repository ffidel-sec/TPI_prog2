package Models;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class FranjaHoraria
{
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public FranjaHoraria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin)
    {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}