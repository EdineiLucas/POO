
public class EcoDrive2 {
    public static void main (String[] args){
        Veiculo v1 = new Veiculo("Corsa", "RVZ2D66", 0, 40);
        Motorista m1 = new Motorista("Edinei", 12345678, 'D');
        v1.setCondutor(m1);
        System.out.println("------------------------");
        System.out.println("veiculo v1:");
        v1.Status();
        System.out.println("-------------------------");
        v1.Registrar_viagem(20);
        System.out.println("-------------------------");
        v1.Registrar_viagem(50);
        System.out.println("-------------------------");
        v1.Registrar_viagem(15);
        System.out.println("-------------------------");
        v1.relatorio();
        System.out.println("-------------------------");
        v1.Status();
    }
}
