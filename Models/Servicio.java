package Models;

import java.util.ArrayList;

public class Servicio
{
    private int id;
    private String nombreServicio;
    private Especialidad especialidad;
    private double precio;

    public Servicio(int id, String nombreServicio, Especialidad especialidad, double precio)
    {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.especialidad = especialidad;
        this.precio = precio;
    }
    
    
    public int getId(){return id;}
    public String getNombreServicio(){return nombreServicio;}
    public Especialidad getEspecialidad(){return especialidad;}
    public double getPrecio(){return precio;}
}