public class Paciente
{
    private int codPaciente;
    private String nombre;
    private String apellido;
    private String dni;
    
    public Paciente(int codPaciente,
    String nombre,
    String apellido,
    String dni
    )
    {
        this.codPaciente = codPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getDni(){return dni;}
}