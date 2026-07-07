package excecoes;

public class DadosInvalidosException extends TransBRException {
    public DadosInvalidosException(String motivo) {
        super("Dados inválidos! " + motivo);
    }
}
