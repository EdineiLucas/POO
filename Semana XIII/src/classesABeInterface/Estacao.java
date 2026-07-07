package classesABeInterface;

import java.util.ArrayList;

public abstract class Estacao {
    protected int num_estacao;
    private ArrayList<Reserva> lista_de_reserva;

    public Estacao(int num_estacao){
        this.num_estacao = num_estacao;
        this.lista_de_reserva = new ArrayList<>();
    }

    // Valor fixo de R$20,00 por hora, definido aqui na propria Estacao.
    // Como e um metodo concreto (nao abstrato), CabineCall e SalaReuniao
    // herdam este calculo automaticamente, sem precisar reescreve-lo.
    // A classe Mesa (desafio) sobrescreve este metodo para cobrar R$10,00/hora.
    public double calcularPreco(int horas){
        return horas * 20.0;
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

    public void listaDeReserva(){
        int tempo_total = 0;
        if (lista_de_reserva == null){
            System.out.println("Sem nenhuma reserva");
            return;
        }else{
            System.out.println("Estacao:" + getNum_estacao());
            for (Reserva res : lista_de_reserva){
                tempo_total = tempo_total + res.getTempoDuracao();
                System.out.println("Usuario:" + res.getUsuario());
                System.out.println("Hora e inicio:" + res.getHoraInicio());
                System.out.println("Hora de termino:" + res.getHoraTermino());
                System.out.println("Tempo total:" + res.getTempoDuracao());
                System.out.println("Preco:R$" + calcularPreco(res.getTempoDuracao()));
                System.out.println("---------------------");
            }
            System.out.println("Tempo total reservado:" + tempo_total);
        }
    }

    public void setNum_estacao(int num){
        this.num_estacao = num;
    }

    public int getNum_estacao(){
        return this.num_estacao;
    }
}

