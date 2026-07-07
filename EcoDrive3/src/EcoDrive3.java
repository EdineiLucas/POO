import java.util.HashSet;

public class EcoDrive3 {
    public static void main (String[] args){
        HashSet<Veiculo> set = new HashSet<>();
        Veiculo v1 = new Veiculo("Corsa", "RVZ2D66", 0, 40);
        Veiculo v2 = new Veiculo("Corsa", "RVZ2D66", 0, 40);
        Motorista m1 = new Motorista("Edinei", 12345678, 'D');
        set.add(v1);
        set.add(v2);
        for (Veiculo  a: set){
            System.out.println(a);
        }

    }
}
