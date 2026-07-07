public class Motorista {
    private String Nome;
    private double NumeroCNH;
    private char Categoria;
    private Veiculo veiculo_atual;

    public  Motorista(String nome, double numcnh, char categoria){
        this.Nome = nome;
        this.NumeroCNH = numcnh;
        this.Categoria = Character.toUpperCase(categoria);
    }

    //region getters e setters
    public void setNome(String nome){
        this.Nome = nome;
    }

    public void setNumeroCNH(double cnh_number){
        this.NumeroCNH = cnh_number;
    }

    public void setCategoria(char categoria_cnh){
        this.Categoria = categoria_cnh;
    }

    public void setVeiculo_atual(Veiculo v){
        this.veiculo_atual = v;
    }

    public String getNome(){
        return Nome;
    }

    public double getNumeroCNH(){
        return NumeroCNH;
    }

    public char getCategoria(){
        return Categoria;
    }

    public String getVeiculo_atual(){
        return veiculo_atual.getModelo();
    }
    //endregion
}
