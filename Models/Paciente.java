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
}