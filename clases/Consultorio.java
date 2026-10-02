import java.util.ArrayList;

public class Consultorio
{
    private int nroConsultorio;
    private ArrayList<Servicio> servicios;

    public Consultorio(int nroConsultorio)
    {
        this.nroConsultorio = nroConsultorio;
        servicios = new ArrayList<>();
    }
    
    public void addServicio(Servicio servicio){
        servicios.add(servicio);
    }
    
    public ArrayList<Servicio> getServicios(){return servicios;}
}