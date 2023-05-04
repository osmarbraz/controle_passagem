/**
 * Interface dos métodos do controlador de voo.
 * 
 * @author osmar
 */
public interface ControladorVoo {

    public int verificarStatus(String codigoVoo, int numeroAssento);
    
    public int marcarVoo(String codigoVoo, int numeroAssento);

}