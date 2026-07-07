package especializacaoEPolimorfismo;

public class CabineCall extends Estacao {

    boolean isolamentoAcustico;

    public CabineCall(int idEstacao){
        super(idEstacao);
        this.isolamentoAcustico = true;
    }

    @Override
    public double calcularPreco(int horas){
        double preco = super.calcularPreco(horas);
        if(this.isolamentoAcustico){
            preco = preco * 1.2;
        }
        return preco;
    }

    public void entrarEmChamada(){
        if(this.isolamentoAcustico){
            System.out.println("Silencio Ativo");
        }
    }
}

