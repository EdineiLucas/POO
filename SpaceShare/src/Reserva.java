
public class Reserva {
    private String usuario;
    private int horas;

    public Reserva (String usuario, int horas){
        this.usuario = usuario;
        this.horas = horas;
    }

    //region getters e setters

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public void setHoras(int horas){
        this.horas = horas;
    }

    public String getUsuario(){
        return usuario;
    }

    public int getHoras(){
        return horas;
    }

    //endregion
}
