package Models;
import Controllers.GestorEspecialidad;
import java.util.ArrayList;
import Controllers.Disponibilidad;

public class Medico extends Persona implements Disponibilidad
{
    private String nombreCompleto;
    private String matricula;
    private String dni;
    private String email;
    private String nroTelefonico;
    private int consultorio;
    private Especialidad especialidad;    
    
    public Medico(
    String nombreCompleto, 
    String matricula,
    String dni,
    String email,
    String nroTelefonico,
    int consultorio,
    Especialidad especialidad)
    {
        super(nombreCompleto, dni, email, nroTelefonico);
        this.matricula = matricula;
        this.consultorio = consultorio;
        this.especialidad = especialidad;
    }
    
    
    
    public String getNombreCompleto(){return nombreCompleto;}
    public String getMatricula() {return matricula;}
    public String getDni() {return dni;}
    public String getEmail() {return email;}
    public String getNroTelefonico(){return nroTelefonico;}
    public int getConsultorio(){return consultorio;}
    public int getIdEspecialidad(){return especialidad.getId()}
    public Especialidad getEspecialidad(){return especialidad;}

    public boolean isEspecialidad(Especialidad especialidad){
        return this.especialidad.equals(especialidad);
    }

    public boolean isDisponible(){return true;}
}