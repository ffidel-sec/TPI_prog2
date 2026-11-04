package Models;

public abstract class Persona{
    private String nombreCompleto;
    private String dni;
    private String email;
    private String nroTelefonico;

    public Persona(String nombreCompleto, String dni, String email, String nroTelefonico){
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.email = email;
        this.nroTelefonico = nroTelefonico;
    }

    // GETTERS
    public String getNombreCompleto(){return nombreCompleto;}
    public String getEmail(){return email;}
    public String getNroTelefonico(){return nroTelefonico;}
    public String getDni(){return dni;}
}