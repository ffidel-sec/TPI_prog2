import java.time.LocalDate;

public class Turno
{
    private int codTurno;
    private Paciente paciente;
    private Medico medico;
    private Servicio servicio;
    private Consultorio consultorio;
    private FranjaHoraria horario;
    private Estado estado;
    private LocalDate fechaReserva;
    
    
    public Turno(int codTurno, 
    Paciente paciente, 
    Medico medico,
    Servicio servicio,
    Consultorio consultorio, 
    FranjaHoraria horario, 
    Estado estado,
    LocalDate fechaReserva)
    {
        this.codTurno = codTurno;
        this.paciente = paciente;
        this.medico = medico;
        this.servicio = servicio;
        this.consultorio = consultorio;
        this.horario = horario;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
    }
    
    public int getCodTurno(){return codTurno;}
    public Paciente getPaciente(){return paciente;}
    public Medico getMedico(){return medico;}
    public Servicio getServicio(){return servicio;}
    public Consultorio getConsultorio(){return consultorio;}
    public FranjaHoraria getHorario(){return horario;}
    public Estado getEstado(){return estado;}
    public int getCodEstado(){return estado.getCodEstado();}
    public double getPrecio(){return servicio.getPrecio();}
    
    
}