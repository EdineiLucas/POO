package SpaceShare;

import java.time.LocalTime;
import java.util.HashMap;

public class SpaceShare {
    public static void main(String[] args) {
        HashMap<Integer, Estacao> estacaoHashMap = new HashMap<>();

        estacaoHashMap.put(101, new Estacao(10));
        estacaoHashMap.put(102, new Estacao(20));
        estacaoHashMap.put(103, new Estacao(30));

        int numero_busca = 101;
        Estacao estacaoEncontrada = estacaoHashMap.get(numero_busca);

        if(estacaoEncontrada != null){
            System.out.println("Estação encontrada:  " + estacaoEncontrada);
        }
        else{
            System.out.println("Estação nao encontrada");
        }

    }
}
