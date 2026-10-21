package Models;
import Controllers.Validador;
import java.util.ArrayList;
import Controllers.Disponibilidad;

public class Medico extends Persona implements Disponibilidad
{
    private int codMedico;
    private String nombreCompleto;
    private String matricula;
    private String dni;
    private String email;
    private String nroTelefonico;
    private int consultorio;
    private String nombreEspecialidad;
    private ArrayList<FranjaHoraria> horariosDisponibles;
    
    
    public Medico(int codMedico, 
    String nombreCompleto, 
    String matricula,
    String dni,
    String email,
    String nroTelefonico,
    String nombreEspecialidad)
    {
        super(nombreCompleto, dni, email, nroTelefonico);
        this.codMedico = codMedico;
        this.matricula = matricula;
        horariosDisponibles = new ArrayList<>();
        this.especialidad = validador.obtenerEspecialidadPorNombre(nombreEspecialidad);
    }
    
    public void addHorario(FranjaHoraria horario){
        horariosDisponibles.add(horario);
    }
    
    
    public String getNombre(){return nombreCompleto;}
    public String getMatricula() {return matricula;}
    public String getEmail() {return email;}
    public String getNumeroTelefono(){return nroTelefonico;}
    public ArrayList<FranjaHoraria> getHorarios(){return horariosDisponibles;}
    public Especialidad getEspecialidad(){return especialidad;}

    public boolean isEspecialidad(Especialidad especialidad){
        return this.especialidad.equals(especialidad);
    }

    public boolean isDisponible(){return true;}
}