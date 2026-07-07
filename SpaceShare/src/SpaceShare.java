import org.w3c.dom.ls.LSOutput;

public class SpaceShare {
    public static void main (String[] args){
        Estacao mesa_01 = new Estacao(100);
        Reserva res_01 = new Reserva("Joao", 5);
        System.out.println("Joao (5hrs)" + mesa_01.AdicionaReserva(res_01));
        Reserva res_02 = new Reserva("Maria", 4);
        System.out.println("Maria (4hrs)" + mesa_01.AdicionaReserva(res_02));
        Reserva res_03 = new Reserva("Joana", 2);
        System.out.println("Joana (2hrs)" + mesa_01.AdicionaReserva(res_03));

        mesa_01.ReserveList();
    }
}
