package com.sgpd.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.sgpd.dao.DAOParoquianoPastoral;

public class ParoquianoPastoral {
    private Paroquiano paroquiano;
    private Pastoral pastoral;
    private LocalDate datainicio;
    private LocalDate datafim;
    public ParoquianoPastoral() {
    }
    public Paroquiano getParoquiano() {
        return paroquiano;
    }
    public void setParoquiano(Paroquiano paroquiano) {
        this.paroquiano = paroquiano;
    }
    public Pastoral getPastoral() {
        return pastoral;
    }
    public void setPastoral(Pastoral pastoral) {
        this.pastoral = pastoral;
    }
    public LocalDate getDatainicio() {
        return datainicio;
    }
    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }
    public LocalDate getDatafim() {
        return datafim;
    }
    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
    }
    public ParoquianoPastoral(Paroquiano paroquiano, Pastoral pastoral, LocalDate datainicio, LocalDate datafim) {
        this.paroquiano = paroquiano;
        this.pastoral = pastoral;
        this.datainicio = datainicio;
        this.datafim = datafim;
    }
    
    public boolean salvar(){
        DAOParoquianoPastoral dao = new DAOParoquianoPastoral();
        return dao.salvar(this);
    }

    public boolean encerrarLigacao(){
        DAOParoquianoPastoral dao = new DAOParoquianoPastoral();
        return dao.encerrarLigacao(this);
    }

    public boolean reativarLigacao(){
        DAOParoquianoPastoral dao = new DAOParoquianoPastoral();
        return dao.reativarLigacao(this);
    }

    public ParoquianoPastoral buscarUm(int idpastoral, int idparoquiano){
        DAOParoquianoPastoral dao = new DAOParoquianoPastoral();
        return dao.buscarUm(idpastoral, idparoquiano);
    }

    public ArrayList<ParoquianoPastoral> buscarTodos(int idpastoral){
         DAOParoquianoPastoral dao = new DAOParoquianoPastoral();
        return dao.buscarTodos(idpastoral);
    }
}
