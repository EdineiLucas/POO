package frota;

import java.io.Serializable;
import java.util.Objects;

public class Motorista implements Serializable {
    private String nome;
    private boolean possuiMOPP;
    private String cnh;

    public Motorista(String nome, boolean possuiMOPP, String cnh){
        this.nome = nome;
        this.possuiMOPP = possuiMOPP;
        this.cnh = cnh;
    }


    //region Métodos
    private String cnhNormalizada(){
        return cnh == null ? "" : cnh.trim().toUpperCase();
    }
    //endregion


    //region Overrides
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Motorista)){
            return false;
        }

        Motorista motorista = (Motorista) o;
        return cnhNormalizada().equals((motorista.cnhNormalizada()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(cnhNormalizada());
    }

    @Override
    public String toString(){
        return String.format("%s [CNH: %s  | MOPP: %s]",nome,cnh,possuiMOPP ? "ATIVA" : "INATIVA");
    }
    //endregion


    //region Getters e Setters
    public void setPossuiMOPP(boolean possuiMOPP){
        this.possuiMOPP = possuiMOPP;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean isCertificadoMoppAtiva(){
        return this.possuiMOPP;
    }

    public String getCnh(){
        return cnh;
    }
    //endregion
}

