public class SalaReuniao extends Estacao {
    private int numeroDePessoas;

    public SalaReuniao (int idSala, int numPessoas){
        super(idSala);
        if (numPessoas < 2 || numPessoas > 20) {
            throw new CapacidadeExcedidaException("Capacidade inválida: a sala deve suportar entre 2 e 20 pessoas");
        }
        this.numeroDePessoas = numPessoas;
    }

    public int getNumeroDePessoas(){
        return this.numeroDePessoas;
    }

    // Atividade 1: se o número de pessoas da reserva for maior que a
    // capacidade suportada pela sala, lança CapacidadeExcedidaException
    public void realizarReserva(Reserva reserva, int qtdPessoasReserva){
        if (qtdPessoasReserva > this.numeroDePessoas) {
            throw new CapacidadeExcedidaException("A reserva tem " + qtdPessoasReserva
                    + " pessoas, mas a sala suporta no máximo " + this.numeroDePessoas + " pessoas");
        }

        boolean sucesso = super.fazerReserva(reserva);
        if (!sucesso) {
            throw new RuntimeException("Não foi possível realizar a reserva: horário indisponível");
        }
    }
}