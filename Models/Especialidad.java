package Models;

public class Especialidad
{
    
    private int codEspecialidad;
    private String nombre;

    
    public Especialidad(int codEspecialidad, String nombre)
    {
        this.codEspecialidad = codEspecialidad;
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
}