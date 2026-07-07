package cargas;

public class CargaRegular extends Carga implements Seguravel{

    private static final double LIMITE_ALTO_VALOR = 100_000.00;
    private static final double TAXA_SEGURO_REGULAR = 0.05;

    public CargaRegular(String id, String descricao, double pesoMaximo, double valorCarga){
        super(id, descricao, pesoMaximo, valorCarga);
    }


    //region métodos
    public boolean exigeSeguro(){
        return valorCarga > LIMITE_ALTO_VALOR;
    }
    //endregion


    //region Override
    @Override
    public double calcularSeguro(){
        return valorCarga * TAXA_SEGURO_REGULAR;
    }

    @Override
    public boolean isPerigosa(){
        return false;
    }

    @Override
    public String getTipo(){
        return "Carga Regular";
    }
    //endregion
}
