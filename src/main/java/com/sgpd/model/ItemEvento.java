package com.sgpd.model;

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


}
