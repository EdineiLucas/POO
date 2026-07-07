import java.time.LocalTime;

public class Main {
    public static double calcularCustoPorPessoa(double total, int pessoas) {
        if (pessoas == 0) {
            throw new ArithmeticException("Não é possível dividir o custo por 0 pessoas");
        }
        return total / pessoas;
    }

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

        System.out.println("\n--- Validação de Capacidade ---");
        try {
            SalaReuniao salaInvalida = new SalaReuniao(1, 50);
            System.out.println("Sala criada com sucesso!");
        } catch (RuntimeException ex) {
            System.out.println("Erro ao criar sala: " + ex.getMessage());
        }

        System.out.println("\n--- Custo por Pessoa ---");
        try {
            double custo = calcularCustoPorPessoa(150.0, 0);
            System.out.println("Custo por pessoa: " + custo);
        } catch (ArithmeticException ex) {
            System.out.println("Erro no cálculo: " + ex.getMessage());
        }

        System.out.println("\n --- Captura Múltipla ---");
        String[] entradas = {"abc", "-7", "15"};
        for (String entrada : entradas) {
            try {
                int numero = Integer.parseInt(entrada);
                if (numero < 0) {
                    throw new IllegalArgumentException("O número não pode ser negativo: " + numero);
                }
                System.out.println("Número convertido com sucesso: " + numero);
            } catch (NumberFormatException ex) {
                System.out.println("Erro de formato: '" + entrada + "' não é um número válido.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Erro de valor: " + ex.getMessage());
            }
        }
    }
}
