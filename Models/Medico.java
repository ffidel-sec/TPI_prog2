package Models;
import Controllers.GestorEspecialidad;
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
    private Especialidad especialidad;    
    
    public Medico(int codMedico, 
    String nombreCompleto, 
    String matricula,
    String dni,
    String email,
    String nroTelefonico,
    int consultorio,
    Especialidad especialidad)
    {
        super(nombreCompleto, dni, email, nroTelefonico);
        this.codMedico = codMedico;
        this.matricula = matricula;
        this.consultorio = consultorio;
        this.especialidad = especialidad;
    }
    
    
    
    public String getNombre(){return nombreCompleto;}
    public String getMatricula() {return matricula;}
    public String getEmail() {return email;}
    public String getNumeroTelefono(){return nroTelefonico;}
    public Especialidad getEspecialidad(){return especialidad;}

    public boolean isEspecialidad(Especialidad especialidad){
        return this.especialidad.equals(especialidad);
    }

    public boolean isDisponible(){return true;}
}