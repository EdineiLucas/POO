package frota;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

public abstract class Veiculo implements Serializable {
    protected String placa;
    protected double pesoMaximo;

    public Veiculo (String placa, double pesoMaximo){
        this.placa = placa;
        this.pesoMaximo = pesoMaximo;
    }

    //region Métodos Gerais
    public abstract boolean isAptoCargaPerigosa();

    public abstract String getTipo();

    private String placaNormalizada(){
        return placa == null ? "" : placa.trim().toUpperCase();
    }
    //endregion

    //region Override
    @Override
    public String toString(){
        return  String.format("%s [Placa: %s | Capacite: %.2f t]", getTipo(), placa, pesoMaximo);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Veiculo)){
            return false;
        }
        Veiculo veiculo = (Veiculo) o;
        return placaNormalizada().equals(veiculo.placaNormalizada());
    }

    @Override
    public int hashCode(){
        return Objects.hash(placaNormalizada());
    }
    //endregion

    //region Getters Setters
    public String getPlaca() {
        return placa;
    }

    public double getPeso() {
        return pesoMaximo;
    }
    //endregion
}
