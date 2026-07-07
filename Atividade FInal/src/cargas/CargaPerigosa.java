package cargas;

public class CargaPerigosa extends Carga implements Seguravel{
    private String numeroONU;
    private boolean licencaAmbientalValida;
    private boolean inflamavelOuLiquida;

    private static final double TAXA_SEGURO_PERIGOSA = 0.05;

    public CargaPerigosa(String id, String descricao, double pesoMaximo, double valor, String numeroONU, boolean licencaAmbientalValida, boolean inflamavelOuLiquida){
        super(id, descricao, pesoMaximo, valor);
        this.numeroONU = numeroONU;
        this.licencaAmbientalValida = licencaAmbientalValida;
        this.inflamavelOuLiquida = inflamavelOuLiquida;
    }

    //Region Override
    @Override
    public double calcularSeguro(){
        return valorCarga * TAXA_SEGURO_PERIGOSA;
    }

    @Override
    public boolean isPerigosa(){
        return true;
    }

    @Override
    public String getTipo(){
        return "Carga Perigosa";
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" | ONU %s | Licença Ambiental: %s | Inflamavel/Liquida: %s", numeroONU,
                                                    licencaAmbientalValida ? "Valida" : "Invalida/Ausente", inflamavelOuLiquida ? "SIM" : "Não" );
    }
    //endregion


    //region Getter Setters
    public String getNumeroONU(){
        return numeroONU;
    }

    public boolean isLicencaAmbientalValida() {
        return licencaAmbientalValida;
    }

    public boolean isInflamavelOuLiquida(){
        return inflamavelOuLiquida;
    }
    //endregion
}
