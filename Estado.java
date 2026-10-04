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
    
    // 0 -> Reservado
    // 1 -> En Curso
    // 2 -> Finalizado
}