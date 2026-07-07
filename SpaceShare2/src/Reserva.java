import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private String usuario;
    private LocalTime hora_inicio;
    private int tempo_duracao;

    public Reserva(String nome_usuario, int tempo_duracao, LocalTime hora_inicio){
        this.usuario = nome_usuario;
        this.tempo_duracao = tempo_duracao;
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHoraTermino(){
        return hora_inicio.plusHours(tempo_duracao);
    }

    public String getUsuario(){
        return this.usuario;
    }

    public int getTempoDuracao(){
        return tempo_duracao;
    }

    public LocalTime getHoraInicio(){
        return this.hora_inicio;
    }
}
