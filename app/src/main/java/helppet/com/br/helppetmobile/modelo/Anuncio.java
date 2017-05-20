package helppet.com.br.helppetmobile.modelo;

/**
 * Created by aluno on 18/05/17.
 */

public class Anuncio {
    private int idAnuncio;
    private String tituloAnuncio;
    private String tipoAnuncio;
    private String descricaoAnuncio;

    public Anuncio(){

    }

    public Anuncio(int idAnuncio, String tituloAnuncio, String tipoAnuncio, String descricaoAnuncio) {
        this.idAnuncio = idAnuncio;
        this.tituloAnuncio = tituloAnuncio;
        this.tipoAnuncio = tipoAnuncio;
        this.descricaoAnuncio = descricaoAnuncio;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getTituloAnuncio() {
        return tituloAnuncio;
    }

    public void setTituloAnuncio(String tituloAnuncio) {
        this.tituloAnuncio = tituloAnuncio;
    }

    public String getTipoAnuncio() {
        return tipoAnuncio;
    }

    public void setTipoAnuncio(String tipoAnuncio) {
        this.tipoAnuncio = tipoAnuncio;
    }

    public String getDescricaoAnuncio() {
        return descricaoAnuncio;
    }

    public void setDescricaoAnuncio(String descricaoAnuncio) {
        this.descricaoAnuncio = descricaoAnuncio;
    }
}
