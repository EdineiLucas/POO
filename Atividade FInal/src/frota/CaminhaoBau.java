package frota;

public class CaminhaoBau extends Veiculo{

    public CaminhaoBau(String placa, double pesoMaximo){
        super(placa,pesoMaximo);
    }

    //region Overrides
    @Override
    public boolean isAptoCargaPerigosa(){
        return false;
    }

    @Override
    public String getTipo(){
        return "Caminha Bau";
    }
}
