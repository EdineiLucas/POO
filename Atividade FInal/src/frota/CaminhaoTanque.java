package frota;

public class CaminhaoTanque extends Veiculo{

    private boolean inspecaoInmetroAtiva;

    public CaminhaoTanque(String placa, double pesoMaximo, boolean inspecaoInmetroAtiva){
        super(placa, pesoMaximo);
        this.inspecaoInmetroAtiva = inspecaoInmetroAtiva;
    }

    public boolean isInspecaoInmetroAtiva(){
        return inspecaoInmetroAtiva;
    }

    public void setInspecaoInmetroAtiva(boolean inspecaoInmetroAtiva){
        this.inspecaoInmetroAtiva = inspecaoInmetroAtiva;
    }

    //region Overrides
    @Override
    public boolean isAptoCargaPerigosa(){
        return true;
    }

    @Override
    public String getTipo(){
        return "Carreta Tanque";
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" [Inspeção do inmetro: %s]", inspecaoInmetroAtiva ? "ATIVA" : "Vencida ou Desativa");
    }
    //endregion
}
