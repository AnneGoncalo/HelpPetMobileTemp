package helppet.com.br.helppetmobile.modelo;
/**
 *
 * @author Ana Gonçalo
 */

public class Denuncia {
    private int idDenuncia;
    private String tituloDenuncia;
    private String descricaoDenuncia;
    private String fotoDenuncia;
    private String tipoDenuncia;
    private String dataDenuncia;
    private String localizacao;

    public Denuncia() {
    }

    public Denuncia(int idDenuncia, String tituloDenuncia, String descricaoDenuncia, String fotoDenuncia, String tipoDenuncia, String dataDenuncia, String localizacao) {
        this.idDenuncia = idDenuncia;
        this.tituloDenuncia = tituloDenuncia;
        this.descricaoDenuncia = descricaoDenuncia;
        this.fotoDenuncia = fotoDenuncia;
        this.tipoDenuncia = tipoDenuncia;
        this.dataDenuncia = dataDenuncia;
        this.localizacao = localizacao;
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getTituloDenuncia() {
        return tituloDenuncia;
    }

    public void setTituloDenuncia(String tituloDenuncia) {
        this.tituloDenuncia = tituloDenuncia;
    }

    public String getDescricaoDenuncia() {
        return descricaoDenuncia;
    }

    public void setDescricaoDenuncia(String descricaoDenuncia) {
        this.descricaoDenuncia = descricaoDenuncia;
    }

    public String getFotoDenuncia() {
        return fotoDenuncia;
    }

    public void setFotoDenuncia(String fotoDenuncia) {
        this.fotoDenuncia = fotoDenuncia;
    }

    public String getTipoDenuncia() {
        return tipoDenuncia;
    }

    public void setTipoDenuncia(String tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public String getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(String dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }




}