import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args){
        HashSet<Funcionario> funcionarios = new HashSet<>();
        Funcionario f1 = new Funcionario(10);
        funcionarios.add(f1);
        System.out.println("Funcionario f1");
        System.out.println(funcionarios);
        f1.setId(20);
        funcionarios.remove(f1);
        System.out.println("Funcionarios");
        System.out.println(funcionarios);
        funcionarios.remove(f1);
        f1.setId(10);
        funcionarios.remove(f1);
        System.out.println("Funcionarios 2");
        System.out.println(funcionarios);

    }
}
