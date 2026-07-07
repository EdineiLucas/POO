package SpaceShare;

import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Objects;

public class Estacao {
    protected int num_estacao;
    private ArrayList<Reserva> lista_de_reserva;

    public Estacao(int num_estacao){
        this.num_estacao = num_estacao;
        this.lista_de_reserva = new ArrayList<>();
    }

    public boolean fazerReserva(Reserva nova){
        if(lista_de_reserva.isEmpty()){
            this.lista_de_reserva.add(nova);
            return true;
        }
        else{
            for (Reserva res : lista_de_reserva){
                if(nova.getHoraInicio().isBefore(res.getHoraTermino()) && nova.getHoraTermino().isAfter(res.getHoraInicio()))
                    return false;
            }
            this.lista_de_reserva.add(nova);
            return true;
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Estacao e = (Estacao) o;
        return java.util.Objects.equals(this.num_estacao, ((Estacao) o).num_estacao);
    }

    @Override
    public int hashCode(){
        return Objects.hash(num_estacao);
    }

    @Override
    public String toString(){
        return "Num_estação: " + num_estacao;
    }

    public void listaDeReserva(){
        int tempo_total = 0;
        if (lista_de_reserva == null){
            System.out.println("Sem nenhuma reserva");
            return ;
        }else{
            System.out.println("Estacao:" + getNum_estacao());
            for (Reserva res : lista_de_reserva){
                tempo_total = tempo_total + res.getTempoDuracao();
                System.out.println("Usuario:" + res.getUsuario());
                System.out.println("Hora e inicio:" + res.getHoraInicio());
                System.out.println("Hora de termino:" + res.getHoraTermino());
                System.out.println("Tempo total:" + res.getTempoDuracao());
                System.out.println("---------------------");
            }
            System.out.println("Tempo total reservado:" + tempo_total);
        }
        return;
    }

    public void setNum_estacao(int num){
        this.num_estacao = num;
    }

    public int getNum_estacao(){
        return this.num_estacao;
    }

}