package Models;

public class Especialidad
{
    private int id;
    private String nombreEspecialidad;

    
    public Especialidad( int id, String nombreEspecialidad)
    {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    // GETTERS
    public String getNombre(){return nombreEspecialidad;}
    public int getId(){return id;}

    // SETTERS
    public void setId(int id) {this.id = id;}
    public void setNombre(String NombreEspecialidad){this.nombreEspecialidad = NombreEspecialidad;}

}