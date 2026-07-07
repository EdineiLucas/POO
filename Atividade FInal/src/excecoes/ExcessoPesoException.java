package excecoes;

public class ExcessoPesoException extends TransBRException {
    public ExcessoPesoException(double pesoCarga, double capacidadeDoVeiculo) {
        super(String.format("Excesso de carga! A carga pesa %.2f t, mas o veículo suporta apenas %.2f t.", pesoCarga, capacidadeDoVeiculo));
    }
}
