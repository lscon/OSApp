package br.edu.iff.pooa20172.osapp.model;

/**
 * Created by fazenda on 15/12/17.
 */

public class Evento {

    private String descricao, autorCadastro, dataRegistro;

    public Evento(String descricao, String autorCadastro, String dataRegistro) {
        this.descricao = descricao;
        this.autorCadastro = autorCadastro;
        this.dataRegistro = dataRegistro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutorCadastro() {
        return autorCadastro;
    }

    public void setAutorCadastro(String autorCadastro) {
        this.autorCadastro = autorCadastro;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
