package logistica;

import  java.io.Serializable;
import frota.*;
import cargas.*;
import excecoes.*;

public class Viagem implements Serializable{

    public enum Status{
        PENDENTE,
        AUTORIZADA
    }

    private static int contadorId = 1;

    private int id;
    private Veiculo veiculo;
    private Motorista motorista;
    private Carga carga;
    private Status status;
    private double valorSeguroCalculado;

    public Viagem(Veiculo veiculo, Motorista motorista, Carga carga){
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.carga = carga;
        this.status = Status.PENDENTE;
        this.valorSeguroCalculado = 0.0;
        this.id = contadorId++;
    }


    //region override
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Viagem #%d [%s]%n", id, status));
        sb.append(String.format("   Veiculo:   %s%n", veiculo));
        sb.append(String.format("   Motorista: %s%n", motorista));
        sb.append(String.format("   Carga:     %s%n", carga));
        if(valorSeguroCalculado > 0){
            sb.append(String.format(" Seguro:  R$ %.2f%n", valorSeguroCalculado));
        }
        return sb.toString();
    }
    //endregion


    //region métodos
    public void autorizar(){
        this.status = Status.AUTORIZADA;
    }
    public static void atualizarContador(int ultimoIdUsado){
        if(ultimoIdUsado >= contadorId){
            contadorId = ultimoIdUsado + 1;
        }
    }
    //endregion


    //region getters setters
    public int getId(){
        return id;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public Motorista getMotorista(){
        return motorista;
    }

    public Carga getCarga(){
        return carga;
    }

    public Status getStatus(){
        return status;
    }

    public double getValorSeguroCalculado(){
        return valorSeguroCalculado;
    }

    public void setValorSeguroCalculado(double valorSeguroCalculado){
        this.valorSeguroCalculado = valorSeguroCalculado;
    }
    //endregion
}
