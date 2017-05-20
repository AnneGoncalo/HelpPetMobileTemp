package helppet.com.br.helppetmobile.modelo;

/**
 * Created by aluno on 18/05/17.
 */

public class Evento {
    private int idEvento;
    private String nomeEvento;
    private String dataEvento;
    private String horarioEvento;
    private String localEvento;
    private String descricaoEvento;

    public Evento() {
    }

    public Evento(int idEvento, String nomeEvento, String dataEvento, String horarioEvento, String localEvento, String descricaoEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.horarioEvento = horarioEvento;
        this.localEvento = localEvento;
        this.descricaoEvento = descricaoEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getHorarioEvento() {
        return horarioEvento;
    }

    public void setHorarioEvento(String horarioEvento) {
        this.horarioEvento = horarioEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }
}
