package helppet.com.br.helppetmobile.modelo;

/**
 * Created by aluno on 18/05/17.
 */

public class Evento {
    private int id;
    private String nome;
    private String data;
    private String horario;
    private String localizacao;
    private String descricao;
    private String foto;

    public Evento() {
    }

    public Evento(int idEvento, String nomeEvento, String dataEvento, String horarioEvento, String localEvento, String descricaoEvento) {
        this.id = idEvento;
        this.nome = nomeEvento;
        this.data = dataEvento;
        this.horario = horarioEvento;
        this.localizacao = localEvento;
        this.descricao = descricaoEvento;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getData() { return data; }

    public void setData(String data) { this.data = data; }

    public String getHorario() { return horario; }

    public void setHorario(String horario) { this.horario = horario; }

    public String getLocalizacao() { return localizacao; }

    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getFoto() { return foto; }

    public void setFoto(String foto) { this.foto = foto; }
}
