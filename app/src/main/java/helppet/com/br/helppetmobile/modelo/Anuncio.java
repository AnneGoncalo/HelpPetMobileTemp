package helppet.com.br.helppetmobile.modelo;

/**
 * Created by aluno on 18/05/17.
 */

public class Anuncio {
    private int id;
    private String titulo;
    private String tipo;
    private String descricao;
    private String foto;

    public Anuncio(){

    }

    public Anuncio(int idAnuncio, String tituloAnuncio, String tipoAnuncio, String descricaoAnuncio) {
        this.id = idAnuncio;
        this.titulo = tituloAnuncio;
        this.tipo = tipoAnuncio;
        this.descricao = descricaoAnuncio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
