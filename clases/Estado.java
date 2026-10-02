public class Estado
{
    private int codEstado;
    private String nombreEstado;
    
    public Estado(int codEstado, String nombreEstado)
    {
        this.codEstado = codEstado;
        this.nombreEstado = nombreEstado;
    }
    
    public int getCodEstado(){return codEstado;}
    
    public String getNombre(){return nombreEstado;}
}