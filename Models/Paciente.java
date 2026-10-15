package Models;

public class Paciente extends Persona
{
    private int codPaciente;
    private String nombreCompleto;
    private String dni;
    
    public Paciente(int codPaciente,
    String nombreCompleto,
    String email,
    String nroTelefonico,
    String dni)
    {
        super(nombreCompleto, dni, email, nroTelefonico);
        this.codPaciente = codPaciente;
    }
    
    public String getNombre(){return nombreCompleto;}
    public String getDni(){return dni;}
}