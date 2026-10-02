
public class Turno
{
    private int codTurno;
    private Paciente paciente;
    private Medico medico;
    private Servicio servicio;
    private Consultorio consultorio;
    private FranjaHoraria horario;
    private Estado estado;

    
    public Turno(int codTurno, 
    Paciente paciente, 
    Medico medico,
    Servicio servicio,
    Consultorio consultorio, 
    FranjaHoraria horario, 
    Estado estado)
    {
        this.codTurno = codTurno;
        this.paciente = paciente;
        this.medico = medico;
        this.servicio = servicio;
        this.consultorio = consultorio;
        this.horario = horario;
        this.estado = estado;
    }
    
    public int getCodTurno(){return codTurno;}
    public Paciente getPaciente(){return paciente;}
    public Medico getMedico(){return medico;}
    public Servicio getServicio(){return servicio;}
    public Consultorio getConsultorio(){return consultorio;}
    public FranjaHoraria getHorario(){return horario;}
    public Estado getEstado(){return estado;}
}