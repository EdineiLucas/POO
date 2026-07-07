 public class CabineCall extends Estacao {

    boolean isolamentoAcustico;

    public CabineCall (int idEstacao){
        super(idEstacao);
        isolamentoAcustico = true;
    }

    public void entrarEmChamada(){
        if(this.isolamentoAcustico){
            System.out.println("Silencio Ativo");
        }
    }
}
