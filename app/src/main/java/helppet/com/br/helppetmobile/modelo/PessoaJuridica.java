package helppet.com.br.helppetmobile.modelo;

/**
 * Created by aluno on 18/05/17.
 */

public class PessoaJuridica {
    private int idUsuario;
    private String nomeUsuario;
    private String email;
    private String dataNascimento;
    private String foto;
    private String localizacao;
    private String telefone;
    private String cnpj;
    private String funcionamento;
    private String descricao;
    private String site;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int idUsuario, String nomeUsuario, String email, String dataNascimento, String foto, String localizacao, String telefone, String cnpj, String funcionamento, String descricao, String site) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
        this.localizacao = localizacao;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.funcionamento = funcionamento;
        this.descricao = descricao;
        this.site = site;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(String funcionamento) {
        this.funcionamento = funcionamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
