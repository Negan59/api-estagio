package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOLocal;

public class Local {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String bairro;
    private String cep;

    public Local(){
        
    }

    public Local(String nome, String endereco, String telefone, String bairro, String cep) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Local(int id, String nome, String endereco, String telefone, String bairro, String cep) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean salvar() {
        DAOLocal dao = new DAOLocal();
        if (dao.salvar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DAOLocal dao = new DAOLocal();
        if (dao.alterar(this)) {
            return true;
        }
        return false;
    }

    public ArrayList<Local> buscarTodos() {
        DAOLocal dao = new DAOLocal();
        return dao.buscarTodos();
    }

    public boolean apagar(int id) {
        DAOLocal dao = new DAOLocal();
        return dao.apagar(id);
    }

    public Local buscarUm(int id) {
        DAOLocal dao = new DAOLocal();
        return dao.buscarUm(id);
    }
}
