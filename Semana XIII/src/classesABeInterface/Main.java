package classesABeInterface;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {


        CabineCall c1 = new CabineCall(10);
        SalaReuniao sala1 = new SalaReuniao(20, 8);
        Mesa mesa1 = new Mesa(30);

        Reserva r1 = new Reserva("Joao", 2, LocalTime.of(8, 0));
        Reserva r2 = new Reserva("Maria", 2, LocalTime.of(9, 0));

        System.out.println("Reserva CabineCall: " + c1.fazerReserva(r1));
        c1.entrarEmChamada();
        c1.listaDeReserva();

        System.out.println();
        System.out.println("Preco Mesa (10R$/h) para 3h: R$" + mesa1.calcularPreco(3));
        System.out.println("Preco SalaReuniao (20R$/h) para 3h: R$" + sala1.calcularPreco(3));

        // ---------- Desafio 2: Contrato de limpeza ----------

        System.out.println();
        Higienizavel salaHigienizavel = sala1;
        salaHigienizavel.realizarLimpeza();


        // ---------- Desafio 3: Teste de polimorfismo com interfaces ----------

        System.out.println();
        Promocional promo = new CabineCall(505);


        promo.aplicarDesconto(10.0);

    }
}
