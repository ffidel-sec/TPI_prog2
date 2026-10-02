import java.util.ArrayList;

public class Servicio
{
    private int codServicio;
    private String nombreServicio;
    private ArrayList<Especialidad> especialidades;

    public Servicio(int codServicio, String nombreServicio)
    {
       this.codServicio = codServicio;
       this.nombreServicio = nombreServicio;
       especialidades = new ArrayList<>();
    }
    
    public void addEspecialidad(Especialidad especialidad){
        especialidades.add(especialidad);
    }
    
    public String getNombre(){return nombreServicio;}
    public ArrayList<Especialidad> getEspecialidades(){return especialidades;}
}