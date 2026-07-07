package excecoes;

public class CarroceriaIncompativelException extends TransBRException {
    public CarroceriaIncompativelException(String tipoVeiculo) {
                super(String.format("Incompatibilidade de carroceria. " +
                        "%s.", tipoVeiculo));
    }
}
