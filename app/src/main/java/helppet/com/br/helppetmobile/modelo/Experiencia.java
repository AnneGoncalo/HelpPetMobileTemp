package helppet.com.br.helppetmobile.modelo;

/**
 * Created by aluno on 18/05/17.
 */

public class Experiencia {
    private int idExperiencia;
    private String tituloExperiencia;
    private String tipoExperiencia;
    private String texto;
    private String dataCadastro;

    public Experiencia(){

    }

    public Experiencia(int idExperiencia, String tituloExperiencia, String tipoExperiencia, String texto, String dataCadastro) {
        this.idExperiencia = idExperiencia;
        this.tituloExperiencia = tituloExperiencia;
        this.tipoExperiencia = tipoExperiencia;
        this.texto = texto;
        this.dataCadastro = dataCadastro;
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getTituloExperiencia() {
        return tituloExperiencia;
    }

    public void setTituloExperiencia(String tituloExperiencia) {
        this.tituloExperiencia = tituloExperiencia;
    }

    public String getTipoExperiencia() {
        return tipoExperiencia;
    }

    public void setTipoExperiencia(String tipoExperiencia) {
        this.tipoExperiencia = tipoExperiencia;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
