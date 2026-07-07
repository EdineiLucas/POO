package app;

import java.util.Scanner;
import java.util.List;

import cargas.*;
import excecoes.*;
import frota.*;
import logistica.*;
import util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static GerenciadorLogistica gerenciador;

    public static void main(String[] args){

        System.out.println("--- SISTEMA INICIADO ---");

        gerenciador = PersistenciaUtil.carregar();

        boolean continuar = true;
        while(continuar){
            exibirMenu();
            int opcao = lerOpcaoInteira();

            switch (opcao){
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    cadastrarMotorista();
                    break;
                case 3:
                    cadastrarCarga();
                    break;
                case 4:
                    criarViagem();
                    break;
                case 5:
                    listarViagens();
                    break;
                case 6:
                    listarVeiculos();
                    break;
                case 7:
                    listarMotoristas();
                    break;
                case 8:
                    listarCargas();
                    break;
                case 0:
                    PersistenciaUtil.salvar(gerenciador);
                    System.out.println("Encerrando sistema");
                    continuar = false;
                    break;
                default:
                    System.out.println(">>> Opção inválida. Por favor digite uma opção válida");
            }
        }
        scanner.close();
    }

    private static void exibirMenu(){
        System.out.println(" --- Menu Principal --- ");
        System.out.println("Digite: ");
        System.out.println("1 - Cadastrar veiculo");
        System.out.println("2 - Cadastrar Motorista");
        System.out.println("3 - Cadastrar Carga");
        System.out.println("4 - Criar Viagem");
        System.out.println("5 - Listar Viagens");
        System.out.println("6 - Listar Veículos");
        System.out.println("7 - Listar Motoristas");
        System.out.println("8 - Listar Cargas");
        System.out.println("0 - Salvar e sair");
        System.out.print("Opção: ");
    }

    //  ---  Cadastros

    public static void cadastrarVeiculo(){
        System.out.println(" --- Menu cadastrar veículo ---");
        System.out.println("Digite:");
        System.out.println("1 - Caminhão bau");
        System.out.println("2 - Carreta tanque");
        System.out.println("Tipo de veículo: ");
        int tipo = lerOpcaoInteira();

        System.out.println("Placa: ");
        String placa = scanner.nextLine().trim();

        System.out.println("Peso máximo(t): ");
        double pesoMaximo = lerDouble();

        try{
            Veiculo veiculo;
            if(tipo == 1){
                veiculo = new CaminhaoBau(placa,pesoMaximo);
            } else if (tipo == 2) {
                System.out.println("Possui inspeção do inmetro ativa ? Digite S para sim N para não");
                boolean inspecaoAtiva = lerSimNao();
                veiculo = new CaminhaoTanque(placa, pesoMaximo, inspecaoAtiva);
            }else {
                System.out.println("Tipo de veículo inválido, cadastro cancelado.");
                return;
            }
            gerenciador.cadastrarVeiculo(veiculo);
            System.out.println("Veiculo cadastrado com sucesso" + veiculo);
        }catch (TransBRException e){
            System.out.println("Alerta: " + e.getMessage());
        }
    }

    private static void cadastrarMotorista(){
        System.out.println(" --- Menu cadastro Motorista --- ");
        System.out.println("Nome: ");
        String nome = scanner.nextLine().trim();

        System.out.println("CNH; ");
        String cnh = scanner.nextLine().trim();

        System.out.println("Possui certificação MOPP? S(sim) N(não): ");
        boolean mopp = lerSimNao();

        try{
            Motorista motorista = new Motorista(nome, mopp, cnh);
            gerenciador.cadastrarMotorista(motorista);
            System.out.println("Motorista cadastrado com sucesso.");
        }catch (TransBRException e){
            System.out.println("Alerta!" + e.getMessage());
        }
    }

    private static void cadastrarCarga(){
        System.out.println(" --- Menu cadastro Carga --- ");
        System.out.println("Digite:");
        System.out.println("1 - Carga Regular");
        System.out.println("2 - Carga Perigosa");
        int tipo = lerOpcaoInteira();

        System.out.println("ID da carga: ");
        String id = scanner.nextLine().trim();

        System.out.println("Descrição: ");
        String descricao = scanner.nextLine().trim();

        System.out.println("Pesa da carga em T: ");
        double peso = lerDouble();

        System.out.println("Valor da carga em R$: ");
        double preco = lerDouble();

        try{
            Carga carga;
            if(tipo == 1){
                carga = new CargaRegular(id, descricao, peso, preco);
            } else if (tipo == 2) {
                System.out.println("Numero ONU da carga: ");
                String numeroOnu = scanner.nextLine().trim();

                System.out.println("Possui licença ambiental? S(sim) N(não): ");
                boolean licencaValida = lerSimNao();

                System.out.println("Inflamável ou liquida? S(sim) N(não): ");
                boolean inflamavelLiquida = lerSimNao();
                carga = new CargaPerigosa(id, descricao, peso, preco, numeroOnu, licencaValida, inflamavelLiquida);
            }else{
                System.out.println("Tipo escolhido inválido. Cadastro cancelado.");
                return;
            }
            gerenciador.cadastrarCarga(carga);
            System.out.println("Carga Cadastrada com sucesso.");
        }catch (TransBRException e){
            System.out.println("Alerta!" + e.getMessage());
        }
    }

    public static void criarViagem(){
        System.out.println(" --- Menu criar Viagem --- ");

        if(gerenciador.getVeiculos().isEmpty() || gerenciador.getCargas().isEmpty() || gerenciador.getMotoristas().isEmpty()){
            System.out.println("6Sistema não tem o necessário para realizar uma viagem");
            return;
        }

        listarVeiculos();
        Veiculo veiculo = selecionarDaLista(gerenciador.getVeiculos(), "veiculo");
        if(veiculo == null){
            return;
        }

        listarMotoristas();
        Motorista motorista = selecionarDaLista(gerenciador.getMotoristas(), "motorista");
        if(motorista == null){
            return;
        }

        listarCargas();
        Carga carga = selecionarDaLista(gerenciador.getCargas(), "carga");
        if(carga == null){
            return;
        }

        try {
            Viagem viagem = gerenciador.criarViagem(veiculo, motorista, carga);
            System.out.println("Viagem autorizada com sucesso");
            System.out.println(viagem);
        }catch (TransBRException e){
            System.out.println("Alerta!" + e.getMessage());
        }
    }

    //  --- Listagem
    private static void listarVeiculos(){
        System.out.println("\n -- Lista de veículos --");
        List<Veiculo> veiculoList = gerenciador.getVeiculos();
        if(veiculoList.isEmpty()){
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for(int i = 0; i < veiculoList.size(); i++){
            System.out.println((i + 1) + " - " + veiculoList.get(i));
        }
    }

    private static void listarMotoristas(){
        System.out.println("\n --- Lista de Motoristas ---");
        List<Motorista> motoristas = gerenciador.getMotoristas();
        if(motoristas.isEmpty()){
            System.out.println("Nenhum motorista cadastrado");
            return;
        }
        for(int i = 0 ; i < motoristas.size(); i++){
            System.out.println((i+1) + " - " + motoristas.get(i));
        }
    }

    private static void listarCargas(){
        System.out.println("\n -- Cargas Cadastradas --");
        List<Carga> cargas = gerenciador.getCargas();
        if(cargas.isEmpty()){
            System.out.println("Nenhuma carga cadastrada");
            return;
        }
        for(int i = 0; i < cargas.size(); i++){
            System.out.println((i + 1) + " - " + cargas.get(i));
        }
    }

    private static void listarViagens(){
        System.out.println("\n --- Lista de viagens autorizadas ---");
        List<Viagem> viagens = gerenciador.getViagensAtivas();
        if(viagens.isEmpty()){
            System.out.println("Nenhuma viagem cadastrada");
            return;
        }
        for(Viagem v : viagens){
            System.out.println(v);
        }
    }
    //  --- Leituras

    private static <T> T selecionarDaLista(List<T> lista, String entidade){
        System.out.println("Escolha o numero do " + entidade + ": ");
        int escolha = lerOpcaoInteira();
        if(escolha < 1 || escolha > lista.size()){
            System.out.println("Seleção inválida. Operação cancelada.");
            return null;
        }
        return lista.get(escolha - 1);
    }

    private static int lerOpcaoInteira(){
        while(true){
            String linha = scanner.nextLine().trim();
            try{
                return Integer.parseInt(linha);
            }catch (NumberFormatException e){
                System.out.print(">> Digite um número válido");
            }
        }
    }

    private static double lerDouble(){
        while(true){
            String linha = scanner.nextLine().trim();
            try {
                return Double.parseDouble(linha);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido: ");
            }
        }
    }

    private static boolean lerSimNao(){
        while (true){
            String linha = scanner.nextLine().trim().toUpperCase();
            if(linha.equals("S")) {
                return true;
            }
            if(linha.equals("N")){
                return false;
            }
            System.out.println("Digite S ou N: ");
        }
    }
}
