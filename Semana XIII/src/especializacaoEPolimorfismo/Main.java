package especializacaoEPolimorfismo;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        Estacao e1 = new Estacao(100);

        Reserva r1 = new Reserva ("Joao", 2, LocalTime.of(8, 0));
        Reserva r2 = new Reserva ("Maria", 2, LocalTime.of(9, 0));
        Reserva r3 = new Reserva ("Carlos", 1, LocalTime.of(10, 0));
        Reserva r4 = new Reserva ("Ana", 4, LocalTime.of(7, 0));

        System.out.println(e1.FazerReserva(r1));
        System.out.println(e1.FazerReserva(r2));
        System.out.println(e1.FazerReserva(r3));
        System.out.println(e1.FazerReserva(r4));
        e1.ListaDeReserva();

        // Atividade 2: testando o polimorfismo com o GerenciadorFinanceiro
        CabineCall c1 = new CabineCall(200);

        ArrayList<Estacao> estacoes = new ArrayList<>();
        estacoes.add(e1);
        estacoes.add(c1);

        GerenciadorFinanceiro gerenciador = new GerenciadorFinanceiro();
        gerenciador.imprimirFaturamento(estacoes, 3);
    }
}
