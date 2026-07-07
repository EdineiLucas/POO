import jdk.jshell.Snippet;

public class EcoDrive1 {
    public static void main (String[] args){

        Veiculo v1;
        Motorista mA = new Motorista("Joao", 12345678, 'B');
        Motorista mB = new Motorista("Edinei", 12345578, 'D');
        v1 = new Veiculo("Corsa", "RVZ2D66", 0, 30);
        v1.setCondutor(mA);
        System.out.println("----------------------------");
        v1.setCondutor(mB);
        System.out.println("----------------------------");
        v1.Status();
        System.out.println("----------------------------");
        v1.Registrar_viagem(40);
        System.out.println("----------------------------");
        v1.Status();
    }
}
