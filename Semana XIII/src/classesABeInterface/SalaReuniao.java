package classesABeInterface;

public class SalaReuniao extends Estacao implements Higienizavel {
    private int numeroDePessoas;

    public SalaReuniao (int idSala, int numPessoas){
        super(idSala);
        this.numeroDePessoas = numPessoas;
    }

    @Override
    public void realizarLimpeza(){
        System.out.println("Limpando sala, trocando café e higienizando projetor.");
    }
}
