package Models;

public class Paciente extends Persona
{
    private String nombreCompleto;
    private String dni;
    
    public Paciente(
    String nombreCompleto,
    String email,
    String nroTelefonico,
    String dni)
    
    {
        super(nombreCompleto, dni, email, nroTelefonico);
    }

    public String getNombreCompleto(){return nombreCompleto;}
    public String getEmail(){return email;}
    public String getNroTelefonico(){return nroTelefonico;}
    public String getDni(){return dni;}
}