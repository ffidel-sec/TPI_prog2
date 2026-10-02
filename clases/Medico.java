import java.util.ArrayList;

public class Medico
{
    private int codMedico;
    private String nombre;
    private String apellido;
    private String matricula;
    private String dni;
    private String email;
    private String nroTelefonico;
    private ArrayList<FranjaHoraria> horariosDisponibles;
    private ArrayList<Especialidad> especialidades;
    
    
    public Medico(int codMedico, 
    String nombre, 
    String apellido, 
    String matricula,
    String dni,
    String email,
    String nroTelefonico)
    {
        this.codMedico = codMedico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.dni = dni;
        this.email = email;
        this.nroTelefonico = nroTelefonico;
        horariosDisponibles = new ArrayList<>();
        especialidades = new ArrayList<>();
    }
    
    public void addHorario(FranjaHoraria horario){
        horariosDisponibles.add(horario);
    }
    
    public void addEspecialidad(Especialidad especialidad){
        especialidades.add(especialidad);
    }
    
    public String getNombre(){return nombre;}
    public String getApellido() {return apellido;}
    public String getMatricula() {return matricula;}
    public String getEmail() {return email;}
    public String getNumeroTelefono(){return nroTelefonico;}
    public ArrayList<FranjaHoraria> getHorariosDisponibles(){return horariosDisponibles;}
    public ArrayList<Especialidad> getEspecialidades(){return especialidades;}
}