package logistica;

import frota.*;

import java.lang.module.ModuleReader;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import excecoes.*;
import cargas.*;

public class GerenciadorLogistica implements Serializable {

    private List<Veiculo> veiculos;
    private List<Motorista> motoristas;
    private List<Carga> cargas;
    private List<Viagem> viagens;

    public GerenciadorLogistica (){
        this.veiculos = new ArrayList<>();
        this.motoristas = new ArrayList<>();
        this.cargas = new ArrayList<>();
        this.viagens = new ArrayList<>();
    }

    //region Cadastros
    public void cadastrarVeiculo(Veiculo veiculo){
        if(veiculo.getPlaca() == null || veiculo.getPlaca().trim().isEmpty()){
            throw new DadosInvalidosException("A placa do veículo não pode ser vazia");
        }
        if(veiculos.contains(veiculo)){
            throw new DadosInvalidosException("Já existe um veículo cadastrado com essa placa " + veiculo.getPlaca());
        }
        if(veiculo.getPeso() <= 0){
            throw new DadosInvalidosException("O peso maximo do veículo deve ser maior que zero");
        }
        veiculos.add(veiculo);
    }

    public void cadastrarMotorista (Motorista motorista){
        if(motorista.getCnh() == null || motorista.getNome().trim().isEmpty()){
            throw new DadosInvalidosException("O motorista precisa de um nome para ser cadastrado");
        }
        if(motoristas.contains(motorista)){
            throw new DadosInvalidosException("Esse motorista já foi cadastrado");
        }
        motoristas.add(motorista);
    }

    public void cadastrarCarga(Carga carga){
        if(carga.getPeso() <= 0){
            throw new DadosInvalidosException("O peso da carga deve ser positivo");
        }
        if(carga.getValorCarga() < 0){
            throw new DadosInvalidosException("A carga deve ter valor maior que zero");
        }
        if(cargas.contains(carga)){
            throw new DadosInvalidosException("Essa carga já foi cadastrada");
        }
        if(carga instanceof  CargaPerigosa){
            CargaPerigosa cp = (CargaPerigosa) carga;
            if(cp.getNumeroONU() == null || cp.getNumeroONU().trim().isEmpty()){
                throw new DadosInvalidosException("Carga perigosa existe número ONU válido");
            }
        }
        cargas.add(carga);
    }
    //endregion


    //region regras de negócio
    public Viagem criarViagem(Veiculo veiculo, Motorista motorista, Carga carga){
        //Excesso de carga
        if(carga.getPeso() > veiculo.getPeso()){
            throw new ExcessoPesoException(carga.getPeso(), veiculo.getPeso());
        }

        //Carreta com inspeção do imetro vencida
        if(veiculo instanceof CaminhaoTanque){
            CaminhaoTanque tanque = (CaminhaoTanque) veiculo;
            if(!tanque.isInspecaoInmetroAtiva()){
                throw new InspecaoInmetroVencidaException(tanque.getPlaca());
            }
        }

        //Validação para carga regular
        if(carga instanceof CargaRegular){
            CargaRegular cr = (CargaRegular) carga;
            if(veiculo instanceof CaminhaoTanque){
                throw new CarroceriaIncompativelException(veiculo.getTipo());
            }
        }

        //Validações para carga perigosa
        if(carga instanceof CargaPerigosa){
            CargaPerigosa cp = (CargaPerigosa) carga;

            //Incompatibilidade com liscenca MOPP
            if(!motorista.isCertificadoMoppAtiva()){
                throw new MotoristaSemMoppException(motorista.getNome());
            }

            //Incompatibilidade de carroceria
            if(cp.isInflamavelOuLiquida() && !veiculo.isAptoCargaPerigosa()){
                throw new CarroceriaIncompativelException(veiculo.getTipo());
            }

            //Licença ambiental valida
            if(!cp.isLicencaAmbientalValida()){
                throw new LiscencaAmbientalInvalidaException(cp.getId());
            }
        }

        Viagem viagem = new Viagem(veiculo, motorista, carga);
        double valorSeguro = calcularSeguroSeAplicavel(carga);
        viagem.setValorSeguroCalculado(valorSeguro);

        viagem.autorizar();
        viagens.add(viagem);
        return viagem;
    }
    //endregion


    //region métodos úteis
    private double calcularSeguroSeAplicavel(Carga carga){
        if(carga instanceof CargaPerigosa){
            Seguravel seguravel = (Seguravel) carga;
            return  seguravel.calcularSeguro();
        }
        if(carga instanceof CargaRegular){
            CargaRegular cr = (CargaRegular) carga;
            if(cr.exigeSeguro()){
                return cr.calcularSeguro();
            }
        }
        return 0.0;
    }

    public void sincronizarContadorDeViagens(){
        int maiorID = 0;
        for(Viagem v : viagens){
            if(v.getId() > maiorID){
                maiorID = v.getId();
            }
        }
        Viagem.atualizarContador(maiorID);
    }
    //endregion


    //region Listagem
    public List<Veiculo> getVeiculos(){
        return veiculos;
    }

    public List<Motorista> getMotoristas(){
        return motoristas;
    }

    public List<Carga> getCargas(){
        return cargas;
    }

    public List<Viagem> getViagens(){
        return viagens;
    }

    public List<Viagem> getViagensAtivas(){
        List<Viagem> ativas = new ArrayList<>();
        for(Viagem v : viagens){
            if(v.getStatus() == Viagem.Status.AUTORIZADA){
                ativas.add(v);
            }
        }
        return ativas;
    }
    //endregion
}
