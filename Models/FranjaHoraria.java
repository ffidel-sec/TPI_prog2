package Models;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class FranjaHoraria
{   
    private int id;
    private int dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public FranjaHoraria(int id, int dia, LocalTime horaInicio, LocalTime horaFin)
    {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public int getDia() {
        return dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
}