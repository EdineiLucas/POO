package excecoes;

public class LiscencaAmbientalInvalidaException extends TransBRException {
    public LiscencaAmbientalInvalidaException(String idCarga) {
        super(String.format("Licença ambiental inválida! A carga %s não possui licença ambiental válida para transporte", idCarga));
    }
}
