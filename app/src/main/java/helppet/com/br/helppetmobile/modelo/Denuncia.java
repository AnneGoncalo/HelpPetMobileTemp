package helppet.com.br.helppetmobile.modelo;
/**
 *
 * @author Ana Gonçalo
 */

public class Denuncia {
    private int id;
    private String titulo;
    private String descricao;
    private String foto;
    private String tipo;
    private String data;
    private String localizacao;

    public Denuncia() {
    }

    public Denuncia(int idDenuncia, String tituloDenuncia, String descricaoDenuncia, String fotoDenuncia, String tipoDenuncia, String dataDenuncia, String localizacao) {
        this.id = idDenuncia;
        this.titulo = tituloDenuncia;
        this.descricao = descricaoDenuncia;
        this.tipo = tipoDenuncia;
        this.foto = fotoDenuncia;
        this.data = dataDenuncia;
        this.localizacao = localizacao;
    }

    public Denuncia(String tituloDenuncia, String descricaoDenuncia, String tipoDenuncia, String localizacao) {
        this.titulo = tituloDenuncia;
        this.descricao = descricaoDenuncia;
        this.tipo = tipoDenuncia;
        this.localizacao = localizacao;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}