import java.time.LocalTime;

public class SpaceShare2 {
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
    }
}
