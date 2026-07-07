import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;

public class Veiculo {
    private String Modelo;
    private double Odometro;
    private int NivelCombustivel;
    private String Placa;
    private Motorista Condutor;

    public Veiculo (String modelo, String placa, double odometro, int niveldecombustivel){
        this.Modelo = modelo;
        this.Placa = placa;
        this.Odometro = odometro;
        if(niveldecombustivel <= 50) {
            this.NivelCombustivel = niveldecombustivel;
        }
    }

    public void Registrar_viagem(int Distancia_KM){
        int combustivel_necessario = Distancia_KM / 10;
        if (combustivel_necessario > getNivelCombustivel()){
            System.out.println("Combustivel insuficiente para viagem");
          return;
        } else if (this.Condutor == null) {
            System.out.println("Veiculo sem condutor, impossivel realizar viagem");
            return;
        } else{
            Odometro = Odometro + Distancia_KM;
            NivelCombustivel = NivelCombustivel - combustivel_necessario;
            System.out.println("Viagem Registrada com sucesso");
        }
    }

    public void Status(){
        System.out.println("Modelo:" + Modelo);
        System.out.println("Placa:" + Placa);
        System.out.println("Km total:" + Odometro);
        System.out.println("Quantidade de conbustivel atual:" + NivelCombustivel);
        if(Condutor == null){
            System.out.println("Veiculo sem condutor");
        }else{
            System.out.println("Motorista:" + Condutor.getNome());
        }
    }

    //region getters e setters
    public  void setCondutor(Motorista m){
        if (m.getCategoria() != 'D'){
            System.out.println("Motorista não tem categoria D");
            return;
        }else {
            if(this.Condutor != null){
                this.Condutor.setVeiculo_atual(null);
                System.out.println("Condutor anterior desvinculado");
            }
            this.Condutor = m;
            m.setVeiculo_atual(this);
            System.out.println("Motorista cadastrado com sucesso");
        }
    }

    public void setModelo(String modelo){
        this.Modelo = modelo;
    }

    public void setOdometro(double odometro){
        this.Odometro = odometro;
    }

    public void setPlaca(String placa){
        this.Placa = placa;
    }

    public void setNivelCombustivel(int gasolina){
        if(this.NivelCombustivel + gasolina <= 50) {
            this.NivelCombustivel = gasolina;
        }
    }

    public String getModelo(){
        return Modelo;
    }

    public String getPlaca(){
        return Placa;
    }

    public double getOdometro(){
        return Odometro;
    }

    public int getNivelCombustivel(){
        return NivelCombustivel;
    }

    public String getCondutor() {
        return Condutor.getNome();
    }

    //endregion
}
