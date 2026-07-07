package excecoes;

public class MotoristaSemMoppException extends TransBRException {
    public MotoristaSemMoppException(String nomeMotorista) {
        super(String.format("Motorista %s não possui certificação MOPP ativa", nomeMotorista));
    }
}
