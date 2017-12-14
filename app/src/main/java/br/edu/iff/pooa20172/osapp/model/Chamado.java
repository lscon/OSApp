package br.edu.iff.pooa20172.osapp.model;

/**
 * Created by fazenda on 14/12/17.
 */

public class Chamado {

    private String descricao, categoria, setor, usuario, dataRegistro;

    public Chamado(String descricao, String categoria, String setor, String usuario, String dataRegistro) {
        this.descricao = descricao;
        this.usuario = usuario;
        this.dataRegistro = dataRegistro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
