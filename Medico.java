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
    private Consultorio consultorio;
    private Especialidad especialidad;
    private ArrayList<FranjaHoraria> horariosDisponibles;
    
    
    public Medico(int codMedico, 
    String nombre, 
    String apellido, 
    String matricula,
    String dni,
    String email,
    String nroTelefonico,
    Especialidad especialidad)
    {
        this.codMedico = codMedico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.dni = dni;
        this.email = email;
        this.nroTelefonico = nroTelefonico;
        horariosDisponibles = new ArrayList<>();
        this.especialidad = especialidad;
    }
    
    public void addHorario(FranjaHoraria horario){
        horariosDisponibles.add(horario);
    }
    
    
    public String getNombre(){return nombre;}
    public String getApellido() {return apellido;}
    public String getMatricula() {return matricula;}
    public String getEmail() {return email;}
    public String getNumeroTelefono(){return nroTelefonico;}
    public ArrayList<FranjaHoraria> getHorarios(){return horariosDisponibles;}
    public Especialidad getEspecialidad(){return especialidad;}
}