public class Paciente
{
    private int codPaciente;
    private String nombre;
    private String apellido;
    private int dni;
    
    public Paciente(int codPaciente,
    String nombre,
    String apellido,
    int dni
    )
    {
        this.codPaciente = codPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public int getDni(){return dni;}
}