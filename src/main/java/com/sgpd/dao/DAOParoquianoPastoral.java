package com.sgpd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.sgpd.model.Paroquiano;
import com.sgpd.model.ParoquianoPastoral;
import com.sgpd.model.Pastoral;
import com.sgpd.model.SingletonConexao;

public class DAOParoquianoPastoral {
    public boolean salvar(ParoquianoPastoral pas) {
        String sql = "INSERT INTO paroquiano_pastoral (Pastoral_idPastoral,Paroquiano_Pessoa_idPessoa,datainicio_pastoral,datafim_pastoral) VALUES ($1,$2,'$3','$4')";
        sql = sql.replace("$1", "" + pas.getPastoral().getId());
        sql = sql.replace("$2", "" + pas.getParoquiano().getId());
        sql = sql.replace("$3", "" + pas.getDatainicio());
        sql = sql.replace("$4", "" + pas.getDatafim());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean encerrarLigacao(ParoquianoPastoral pas) {
        LocalDate dataatual = LocalDate.now();
        String sql = "UPDATE paroquiano_pastoral SET datafim_pastoral = '$1' where Pastoral_idPastoral = "
                + pas.getPastoral().getId() + " AND Paroquiano_Pessoa_idPessoa = " + pas.getParoquiano().getId();
        sql = sql.replace("$1", "" + dataatual);
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean reativarLigacao(ParoquianoPastoral pas) {
        String sql = "UPDATE paroquiano_pastoral SET datafim_pastoral = NULL where Pastoral_idPastoral = "
                + pas.getPastoral().getId() + " AND Paroquiano_Pessoa_idPessoa = " + pas.getParoquiano().getId();
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public ArrayList<ParoquianoPastoral> buscarTodos(int idpastoral) {
        ArrayList<ParoquianoPastoral> registros = new ArrayList<>();
        String sql = "SELECT * FROM paroquiano_pastoral where Pastoral_idPastoral = " + idpastoral
                + " AND datafim_pastoral IS NULL";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next()) {
                Pastoral pastoral = new Pastoral();
                Paroquiano paroquiano = new Paroquiano();
                ParoquianoPastoral pas = new ParoquianoPastoral();
                pastoral.setId(rs.getInt("Pastoral_idPastoral"));
                paroquiano.setId(rs.getInt("Paroquiano_Pessoa_idPessoa"));
                pas.setDatainicio(rs.getDate("datainicio_pastoral").toLocalDate());
                pas.setParoquiano(paroquiano);
                pas.setPastoral(pastoral);
                registros.add(pas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return registros;
    }

    public ParoquianoPastoral buscarUm(int pastoralId, int pessoaId) {
        ParoquianoPastoral registro = null;
        String sql = "SELECT * FROM paroquiano_pastoral WHERE Pastoral_idPastoral = " + pastoralId
                + " AND Paroquiano_Pessoa_idPessoa = " + pessoaId;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next()) {
                Pastoral pastoral = new Pastoral();
                Paroquiano paroquiano = new Paroquiano();
                ParoquianoPastoral pas = new ParoquianoPastoral();
                pastoral.setId(rs.getInt("Pastoral_idPastoral"));
                paroquiano.setId(rs.getInt("Paroquiano_Pessoa_idPessoa"));
                pas.setDatainicio(rs.getDate("datainicio_pastoral").toLocalDate());
                if (rs.getDate("datafim_pastoral") != null) {
                    pas.setDatafim(rs.getDate("datafim_pastoral").toLocalDate());
                }
                pas.setParoquiano(paroquiano);
                pas.setPastoral(pastoral);
                registro = pas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return registro;
    }
}
