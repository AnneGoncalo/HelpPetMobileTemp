package helppet.com.br.helppetmobile.modelo;

/**
 * Created by aluno on 18/05/17.
 */

public class Experiencia {
    private int id;
    private String titulo;
    private String tipo;
    private String texto;
    private String foto;
    private String cadastro;

    public Experiencia(){

    }

    public Experiencia(int id, String titulo, String tipo, String texto, String foto, String cadastro) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.texto = texto;
        this.foto = foto;
        this.cadastro = cadastro;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }
}
