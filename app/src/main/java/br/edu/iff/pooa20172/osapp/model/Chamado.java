package br.edu.iff.pooa20172.osapp.model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by fazenda on 14/12/17.
 */

public class Chamado extends RealmObject implements Serializable {

    private int id;
    private String descricao, categoria, setor, usuario, dataRegistro;

    public Chamado( int id, String descricao, String categoria, String setor, String usuario, String dataRegistro) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.setor = setor;
        this.usuario = usuario;
        this.dataRegistro = dataRegistro;
    }

    public Chamado( int id, String descricao, String setor, String dataRegistro) {
        this.id = id;
        this.descricao = descricao;
        this.setor = setor;
        this.dataRegistro = dataRegistro;
    }

    public Chamado(){

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
