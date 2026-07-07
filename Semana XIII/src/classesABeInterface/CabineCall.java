package classesABeInterface;

public class CabineCall extends Estacao implements Promocional {

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

    // Metodo que existe na classe CabineCall, mas NAO faz parte
    // da interface Promocional. So pode ser chamado se a variavel
    // for do tipo CabineCall (ou Estacao), nunca do tipo Promocional.
    public int getNumero(){
        return this.getNum_estacao();
    }

    @Override
    public void aplicarDesconto(double percentual){
        double precoOriginal = calcularPreco(1);
        double precoComDesconto = precoOriginal * (1 - percentual / 100.0);
        System.out.println("Desconto de " + percentual + "% aplicado. Preco de R$"
                + precoOriginal + " passa para R$" + precoComDesconto);
    }
}
