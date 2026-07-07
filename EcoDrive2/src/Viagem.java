import java.lang.classfile.instruction.LocalVariable;
import java.time.*;

public class Viagem {
    private LocalDate data;
    private int distancia_da_viagem;

    public Viagem(int distancia, LocalDate data){
        this.distancia_da_viagem = distancia;
        this.data = data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public int getDistancia_da_viagem(){
        return distancia_da_viagem;
    }

    public LocalDate getData(){
        return data;
    }
}
