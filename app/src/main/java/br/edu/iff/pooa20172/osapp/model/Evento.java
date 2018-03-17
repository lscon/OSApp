package br.edu.iff.pooa20172.osapp.model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by fazenda on 15/12/17.
 */

public class Evento extends RealmObject implements Serializable {

    private int id;
    private String descricao, autorCadastro, dataRegistro;

    public Evento(int id, String descricao, String autorCadastro, String dataRegistro) {
        this.id = id;
        this.descricao = descricao;
        this.autorCadastro = autorCadastro;
        this.dataRegistro = dataRegistro;
    }

    public Evento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
