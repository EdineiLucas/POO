import java.time.LocalTime;

public class SpaceShare3 {
    public static void main(String[] args) {
        Estacao e1 = new Estacao(100);
        CabineCall c1 = new CabineCall(10);
        Reserva r1 = new Reserva("Joao", 2, LocalTime.of(8, 0));
        Reserva r2 = new Reserva("Maria", 2, LocalTime.of(9, 0));
        Reserva r3 = new Reserva("Carlos", 1, LocalTime.of(10, 0));
        Reserva r4 = new Reserva("Ana", 4, LocalTime.of(7, 0));
        System.out.println(c1.fazerReserva(r1));
        c1.entrarEmChamada();
        c1.listaDeReserva();
    }
}