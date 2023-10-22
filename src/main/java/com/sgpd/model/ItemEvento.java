package com.sgpd.model;

import java.util.ArrayList;

import com.sgpd.dao.DAOItemEvento;

public class ItemEvento {
    private ItensSalaoParoquial item;
    private Evento evento;
    private int quantidade;
    private boolean reutilizavel;
    public ItensSalaoParoquial getItem() {
        return item;
    }
    public void setItem(ItensSalaoParoquial item) {
        this.item = item;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public boolean isReutilizavel() {
        return reutilizavel;
    }
    public void setReutilizavel(boolean reutilizavel) {
        this.reutilizavel = reutilizavel;
    }
    public ItemEvento(ItensSalaoParoquial item, Evento evento, int quantidade, boolean reutilizavel) {
        this.item = item;
        this.evento = evento;
        this.quantidade = quantidade;
        this.reutilizavel = reutilizavel;
    }
    public ItemEvento() {
    }

    public boolean salvar(){
        DAOItemEvento dao = new DAOItemEvento();
        if(dao.salvar(this)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean alterar(){
        DAOItemEvento dao = new DAOItemEvento();
        if(dao.alterar(this)){
            return true;
        }
        else{
            return false;
        }
    }

    public ItemEvento buscarum(int idevento,int iditemsalao){
        DAOItemEvento dao = new DAOItemEvento();
        return dao.buscarUm(idevento, iditemsalao);
    }

    public ArrayList<ItemEvento> buscarTodosEvento(int id){
        DAOItemEvento dao = new DAOItemEvento();
        return dao.buscarTodosEvento(id);
    }

    public boolean apagar(int idevento, int idsalao){
        DAOItemEvento dao = new DAOItemEvento();
        return dao.apagar(idevento, idsalao);
    }


}
