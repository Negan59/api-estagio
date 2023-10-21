package com.sgpd.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.sgpd.dao.DAOEvento;

public class Evento {
    private int id;
    private String nomeevento;
    private LocalDate dataevento;
    private String horainicio;
    private String horafim;
    private String horainiarrumacao;
    private String horafimarrumacao;
    private LocalDate dataarrumacao;
    private String telefone;
    private String observacao;
    private Aluguel aluguel;
    private String foto;
    private boolean ativo;

    public Evento(int id, String nomeevento, LocalDate dataevento, String horainicio, String horafim,
            String horainiarrumacao, String horafimarrumacao, LocalDate dataarrumacao, String telefone,
            String observacao, Aluguel aluguel, String foto, boolean ativo) {
        this.id = id;
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
        this.aluguel = aluguel;
        this.foto = foto;
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Evento() {

    }

    public Evento(String nomeevento, LocalDate dataevento, String horainicio, String horafim, String horainiarrumacao,
            String horafimarrumacao, LocalDate dataarrumacao, String telefone, String observacao, Aluguel aluguel,
            String foto) {
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
        this.aluguel = aluguel;
        this.foto = foto;
    }

    public Evento(int id, String nomeevento, LocalDate dataevento, String horainicio, String horafim,
            String horainiarrumacao, String horafimarrumacao, LocalDate dataarrumacao, String telefone,
            String observacao, Aluguel aluguel, String foto) {
        this.id = id;
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
        this.aluguel = aluguel;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Evento(String nomeevento, LocalDate dataevento, String horainicio, String horafim, String horainiarrumacao,
            String horafimarrumacao, LocalDate dataarrumacao, String telefone, String observacao) {
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public Evento(String nomeevento, LocalDate dataevento, String horainicio, String horafim, String horainiarrumacao,
            String horafimarrumacao, LocalDate dataarrumacao, String telefone, String observacao, Aluguel aluguel) {
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
        this.aluguel = aluguel;
    }

    public Evento(int id, String nomeevento, LocalDate dataevento, String horainicio, String horafim,
            String horainiarrumacao, String horafimarrumacao, LocalDate dataarrumacao, String telefone,
            String observacao, Aluguel aluguel) {
        this.id = id;
        this.nomeevento = nomeevento;
        this.dataevento = dataevento;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.horainiarrumacao = horainiarrumacao;
        this.horafimarrumacao = horafimarrumacao;
        this.dataarrumacao = dataarrumacao;
        this.telefone = telefone;
        this.observacao = observacao;
        this.aluguel = aluguel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeevento() {
        return nomeevento;
    }

    public void setNomeevento(String nomeevento) {
        this.nomeevento = nomeevento;
    }

    public LocalDate getDataevento() {
        return dataevento;
    }

    public void setDataevento(LocalDate dataevento) {
        this.dataevento = dataevento;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafim() {
        return horafim;
    }

    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }

    public String getHorainiarrumacao() {
        return horainiarrumacao;
    }

    public void setHorainiarrumacao(String horainiarrumacao) {
        this.horainiarrumacao = horainiarrumacao;
    }

    public String getHorafimarrumacao() {
        return horafimarrumacao;
    }

    public void setHorafimarrumacao(String horafimarrumacao) {
        this.horafimarrumacao = horafimarrumacao;
    }

    public LocalDate getDataarrumacao() {
        return dataarrumacao;
    }

    public void setDataarrumacao(LocalDate dataarrumacao) {
        this.dataarrumacao = dataarrumacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public boolean salvar() {
        DAOEvento dao = new DAOEvento();
        if (!dao.salvar(this)) {
            return false;
        }
        return true;
    }

    public boolean alterar() {
        DAOEvento dao = new DAOEvento();
        if (!dao.atualizar(this)) {
            return false;
        }
        return true;
    }

    public ArrayList<Evento> buscarTodos() {
        DAOEvento dao = new DAOEvento();
        return dao.buscarTodos();
    }

    public ArrayList<Evento> buscarTodosInativos() {
        DAOEvento dao = new DAOEvento();
        return dao.buscarTodosInativos();
    }

    public boolean apagar(int id) {
        DAOEvento dao = new DAOEvento();
        if (!dao.excluir(id)) {
            return false;
        }
        return true;
    }

    public boolean ativar(int id) {
        DAOEvento dao = new DAOEvento();
        if (!dao.ativar(id)) {
            return false;
        }
        return true;
    }

    public Evento buscarUm(int id) {
        DAOEvento dao = new DAOEvento();
        return dao.buscarUm(id);
    }

    public boolean atualizarAluguel(Aluguel aluguel){
        DAOEvento dao = new DAOEvento();
        if(!dao.atualizarAluguel(aluguel,this.id)){
            return false;
        }
        return true;
    }

}
