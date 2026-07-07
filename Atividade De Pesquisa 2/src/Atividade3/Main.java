package Atividade3;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Estacao e1 = new Estacao(100);
        CabineCall c1 = new CabineCall(10);

        // Reservas adicionadas fora de ordem para testar o TreeSet<Reserva>
        Reserva r1 = new Reserva("Carlos", 1, LocalTime.of(14, 0));
        Reserva r2 = new Reserva("Joao", 1, LocalTime.of(8, 0));
        Reserva r3 = new Reserva("Maria", 1, LocalTime.of(10, 0));

        e1.fazerReserva(r1);
        e1.fazerReserva(r2);
        e1.fazerReserva(r3);

        // Se o TreeSet + Comparable estiverem corretos, a impressao sai em ordem cronologica
        e1.listaDeReserva();

        c1.entrarEmChamada();
    }
}
