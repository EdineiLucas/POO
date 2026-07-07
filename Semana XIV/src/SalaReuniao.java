public class SalaReuniao extends Estacao {
    private int numeroDePessoas;

    public SalaReuniao (int idSala, int numPessoas){
        super(idSala);
        if (numPessoas < 2 || numPessoas > 20) {
            throw new RuntimeException("Capacidade inválida");
        }
        this.numeroDePessoas = numPessoas;
    }

    public int getNumeroDePessoas(){
        return this.numeroDePessoas;
    }
}
