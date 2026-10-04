import java.util.ArrayList;

public class Servicio
{
    private int codServicio;
    private String nombreServicio;
    private Especialidad especialidad;
    private double precio;

    public Servicio(int codServicio, String nombreServicio, Especialidad especialidad)
    {
       this.codServicio = codServicio;
       this.nombreServicio = nombreServicio;
       this.especialidad = especialidad;
    }
    
    public String getNombre(){return nombreServicio;}
    public Especialidad getEspecialidad(){return especialidad;}
    public double getPrecio(){return precio;}
}