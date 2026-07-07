import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class GameHub {
    public static void main(String[] args){
        try (PrintWriter caneta = new PrintWriter(new FileWriter("meus_jogos.csv"))){
            caneta.println("League Of Legends;PC;2009");
            caneta.println("Cs2;PC;2023");
            caneta.println("Word of Warcraft;PC;2004");
        }catch(IOException e){
            System.out.println("Ops, aconteceu um erro de Entrada/Saida:" + e.getMessage());
        }

        try(BufferedReader leitor = new BufferedReader(new FileReader("meus_jogos.csv"))){
            String linha;
            while((linha = leitor.readLine()) != null){
                String [] dadosSeparados = linha.split(";");
                for(String s : dadosSeparados){
                    System.out.println(s);
                }
                System.out.println();
            }
        }catch(IOException e){
            System.out.println("Erro ao tentar ler o arquivo" + e.getMessage());
        }

    }
}
