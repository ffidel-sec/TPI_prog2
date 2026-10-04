import java.util.ArrayList;
import java.util.List;

public class GestorTurnos
{
    private ArrayList<Medico> listaMedicos;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Turno> listaTurnos;
    private ArrayList<FranjaHoraria> listaFranjasHorarias;
    private ArrayList<Servicio> listaServicios;
    private ArrayList<Especialidad> listaEspecialidades;
    private ArrayList<Consultorio> listaConsultorios;
    private ArrayList<Estado> listaEstados;
    
    
    public void addMedico(Medico medico){
        listaMedicos.add(medico);
    }
        
    public ArrayList<FranjaHoraria> getFranjasHorarias(){
        ArrayList<FranjaHoraria> franjasOcupadas = new ArrayList<>();
        
        for (Turno t: listaTurnos){
            franjasOcupadas.add(t.getHorario());
        }
        
        return franjasOcupadas;
    }
    
    // Obtener especialidad por servicio y medicos por especialidad
    
    public Especialidad getEspecialidadServicio(Servicio servicio){
        return servicio.getEspecialidad();
    }
    
    public ArrayList<Medico> getMedicosEspecialidad(Especialidad especialidad){
        ArrayList<Medico> medicosEspecialidad = new ArrayList<>();
        
        for (Medico m: listaMedicos){
            if (m.getEspecialidad().equals(especialidad)){
                medicosEspecialidad.add(m);
            }
        }
        
        return(medicosEspecialidad);
    }
    
    // GET PRECIO
    
    public double getPrecio(Turno t){return t.getPrecio();}
    
    //
    // PACIENTES
    //
    
    public boolean verificarExistencia(int dni){
        for (Paciente p: listaPacientes){
            if (p.getDni() == dni){
                return true;
            }
        }
        return false;
    }
}