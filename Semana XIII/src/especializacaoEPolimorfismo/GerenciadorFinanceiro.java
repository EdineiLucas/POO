package especializacaoEPolimorfismo;

import java.util.ArrayList;

public class GerenciadorFinanceiro {

    public void imprimirFaturamento(ArrayList<Estacao> lista, int horas) {
        for (Estacao e : lista) {
            System.out.println("Estação " + e.getNumero() + " | Total: R$ " + e.calcularPreco(horas)); // O polimorfismo acontece aqui
        }
    }
}

