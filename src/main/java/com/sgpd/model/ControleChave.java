package com.sgpd.model;

import java.time.LocalDate;

public class ControleChave {
    private int id;
    private LocalDate dataretirada;
    private String horaretirada;
    private String horadevolucao;
    private Chave chave;
    private Paroquiano paroquiano;
    private LocalDate datadevolucao;
    private Funcionario funcionario;
    private Reserva reserva;
    public ControleChave() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDataretirada() {
        return dataretirada;
    }
    public void setDataretirada(LocalDate dataretirada) {
        this.dataretirada = dataretirada;
    }
    public String getHoraretirada() {
        return horaretirada;
    }
    public void setHoraretirada(String horaretirada) {
        this.horaretirada = horaretirada;
    }
    public String getHoradevolucao() {
        return horadevolucao;
    }
    public void setHoradevolucao(String horadevolucao) {
        this.horadevolucao = horadevolucao;
    }
    public Chave getChave() {
        return chave;
    }
    public void setChave(Chave chave) {
        this.chave = chave;
    }
    public Paroquiano getParoquiano() {
        return paroquiano;
    }
    public void setParoquiano(Paroquiano paroquiano) {
        this.paroquiano = paroquiano;
    }
    public LocalDate getDatadevolucao() {
        return datadevolucao;
    }
    public void setDatadevolucao(LocalDate datadevolucao) {
        this.datadevolucao = datadevolucao;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public ControleChave(int id, LocalDate dataretirada, String horaretirada, String horadevolucao, Chave chave,
            Paroquiano paroquiano, LocalDate datadevolucao, Funcionario funcionario, Reserva reserva) {
        this.id = id;
        this.dataretirada = dataretirada;
        this.horaretirada = horaretirada;
        this.horadevolucao = horadevolucao;
        this.chave = chave;
        this.paroquiano = paroquiano;
        this.datadevolucao = datadevolucao;
        this.funcionario = funcionario;
        this.reserva = reserva;
    }
    public ControleChave(int id, LocalDate dataretirada, String horaretirada, String horadevolucao, Chave chave,
            Paroquiano paroquiano, LocalDate datadevolucao, Funcionario funcionario) {
        this.id = id;
        this.dataretirada = dataretirada;
        this.horaretirada = horaretirada;
        this.horadevolucao = horadevolucao;
        this.chave = chave;
        this.paroquiano = paroquiano;
        this.datadevolucao = datadevolucao;
        this.funcionario = funcionario;
    }
    public ControleChave(LocalDate dataretirada, String horaretirada, String horadevolucao, Chave chave,
            Paroquiano paroquiano, LocalDate datadevolucao, Funcionario funcionario) {
        this.dataretirada = dataretirada;
        this.horaretirada = horaretirada;
        this.horadevolucao = horadevolucao;
        this.chave = chave;
        this.paroquiano = paroquiano;
        this.datadevolucao = datadevolucao;
        this.funcionario = funcionario;
    }
    
}
