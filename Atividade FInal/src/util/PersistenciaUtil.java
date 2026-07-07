package util;

import logistica.GerenciadorLogistica;

import java.io.*;
import java.util.GregorianCalendar;

public class PersistenciaUtil {
    private static final String CAMINHO_ARQUIVO = "transbr_dados.dat";

    public static void salvar(GerenciadorLogistica gerenciador){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO_ARQUIVO))){
            oos.writeObject((gerenciador));
            System.out.println("> Dados salvos com sucesso em " + CAMINHO_ARQUIVO);
        }catch (IOException e){
            System.out.println("> Erro ao salvar os dados " + e.getMessage());
        }
    }

    public static GerenciadorLogistica carregar(){
        File arquivo = new File (CAMINHO_ARQUIVO);
        if(!arquivo.exists()){
            System.out.println("Nenhum arquivo de dao encontrado. Iniciando sistema do zero");
            return new GerenciadorLogistica();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
            GerenciadorLogistica gerenciador = (GerenciadorLogistica) ois.readObject();
            gerenciador.sincronizarContadorDeViagens();
            System.out.println("> Dados carregador com sucesso de " + CAMINHO_ARQUIVO);
            return gerenciador;
        }catch (IOException | ClassNotFoundException e){
            System.out.println("> Erro ao carregar os dados " + e.getMessage());
            System.out.println("> Iniciando sistema vazio.");
            return new GerenciadorLogistica();
        }
    }
}
