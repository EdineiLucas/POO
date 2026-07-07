package cargas;

import java.io.Serializable;
import java.util.Objects;

public abstract class Carga implements Serializable {
    protected String id;
    protected String descricao;
    protected double peso;
    protected double valorCarga;

    public Carga(String id, String descricao, double peso, double valorCarga){
        this.id = id;
        this.descricao = descricao;
        this.peso = peso;
        this.valorCarga = valorCarga;
    }

    //region Métodos
    public abstract boolean isPerigosa();

    public abstract String getTipo();

    private String idNormalizado(){
        return id == null ? "" : id.trim().toUpperCase();
    }
    //endregion


    //region Overrides
    @Override
    public String toString(){
        return String.format("[%s] %s - %s | Peso: %.2f t | Valor: R$ %.2f", id, getTipo(), descricao, peso, valorCarga);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Carga)){
            return false;
        }
        Carga carga = (Carga) o;
        return idNormalizado().equals(carga.idNormalizado());
    }

    @Override
    public int hashCode(){
        return Objects.hash(idNormalizado());
    }
    //endregion


    //region Getters Setters
    public String getDescricao(){
        return descricao;
    }

    public String getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public double getValorCarga(){
        return  valorCarga;
    }
    //endregion
}
