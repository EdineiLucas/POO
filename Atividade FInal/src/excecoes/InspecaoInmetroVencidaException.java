package excecoes;

public class InspecaoInmetroVencidaException extends TransBRException {
    public InspecaoInmetroVencidaException(String placa) {
        super(String.format("Inspeção do Inmetro vencida! A carreta tanque de placa %s não possui inspeção ativa do Inmetro", placa));
    }
}
