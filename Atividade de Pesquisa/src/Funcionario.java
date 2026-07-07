import java.util.Objects;

public class Funcionario {
    private int id;

    public Funcionario(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Funcionario f = (Funcionario) o;
        return java.util.Objects.equals(this.id, f.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public String toString(){
        return "ID:" + id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
