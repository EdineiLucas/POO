package classesABeInterface;

public class Mesa extends Estacao {

    public Mesa(int idMesa){
        super(idMesa);
    }

    // Sobrescreve o preco fixo de R$20/hora da Estacao para cobrar
    // apenas R$10,00 por hora nas mesas.
    @Override
    public double calcularPreco(int horas){
        return horas * 10.0;
    }
}
