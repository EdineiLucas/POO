import java.util.ArrayList;

public class Estacao {
    private int numero_estacao;
    private ArrayList<Reserva> reserve_list; // limite de reserva de 10 horas totais

    public Estacao (int numero){
        this.numero_estacao = numero;
        this.reserve_list = new ArrayList<>();
    }

    boolean AdicionaReserva(Reserva r){
        int somahoras = 0;
        for(Reserva res : reserve_list){
            somahoras = somahoras + res.getHoras();
        }
        if(somahoras + r.getHoras() <= 10){
            reserve_list.add(r);
            return true;
        }else{
            return false;
        }
    }

    void ReserveList(){
        System.out.println("Estação:" + this.numero_estacao);
        if(reserve_list.isEmpty()){
            System.out.println("Estacao sem nenhuma reserva");
        }else {
            System.out.println("Lista de usuarios desssa estacao:");
            for (Reserva r : reserve_list) {
                System.out.println("Nome: " + r.getUsuario() + "/ Horas reservadas: " + r.getHoras());
            }
        }
        return ;
    }

    //region getters e setters
    void setNumero_estacao(int id_estacao){
        this.numero_estacao = id_estacao;
    }

    int getNumero_estacao(){
        return numero_estacao;
    }

    //endregion
}
