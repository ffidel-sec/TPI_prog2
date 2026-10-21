package Models;

public class Especialidad
{
    
    private int codEspecialidad;
    private String nombreEspecialidad;

    
    public Especialidad(int codEspecialidad, String nombreEspecialidad)
    {
        this.codEspecialidad = codEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getNombre(){
        return nombreEspecialidad;
    }
}