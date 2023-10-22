package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.Evento;
import com.sgpd.model.ItemEvento;
import com.sgpd.model.ItensSalaoParoquial;
import com.sgpd.model.SingletonConexao;

public class DAOItemEvento {
    public boolean salvar(ItemEvento item){
        try {
            String sql = "insert into itemevento (ItemSalao_idItemSalao,Evento_idEvento,quantidade_itemevento,reutilizavel_itemevento) values ($1,$2,$3,$4)";
            sql = sql.replace("$1", ""+item.getItem().getId());
            sql = sql.replace("$2", ""+item.getEvento().getId());
            sql = sql.replace("$3", ""+item.getQuantidade());
            sql = sql.replace("$4", ""+item.isReutilizavel());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            con.fecharConexao();
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public boolean alterar(ItemEvento item){
        try {
            String sql = "update itemevento set quantidade_itemevento = $3,reutilizavel_itemevento = $4 where ItemSalao_idItemSalao = $1 and Evento_idEvento = $2,";
            sql = sql.replace("$1", ""+item.getItem().getId());
            sql = sql.replace("$2", ""+item.getEvento().getId());
            sql = sql.replace("$3", ""+item.getQuantidade());
            sql = sql.replace("$4", ""+item.isReutilizavel());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            con.fecharConexao();
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<ItemEvento> buscarTodosEvento(int id){
        ArrayList<ItemEvento> Lista = new ArrayList<>();
        ItemEvento item = new ItemEvento();
        Evento evento = new Evento();
        ItensSalaoParoquial isalao = new ItensSalaoParoquial();
        String sql = "SELECT * FROM itemevento where Evento_idEvento = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next()){
                evento.setId(rs.getInt("Evento_idEvento"));
                isalao.setId(rs.getInt("ItemSalao_idItemSalao"));
                item.setEvento(evento);
                item.setItem(isalao);
                item.setQuantidade(rs.getInt("quantidade_itemevento"));
                item.setReutilizavel(rs.getBoolean("reutilizavel_itemevento"));
                Lista.add(item);
            }
                
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return Lista;
    }

    public ItemEvento buscarUm(int idevento,int iditemsalao){
        ItemEvento item = new ItemEvento();
        String sql = "SELECT * FROM itemevento where Evento_idEvento = "+idevento+" and ItemSalao_idItemSalao = "+iditemsalao;
        SingletonConexao con = SingletonConexao.getConexao();
        Evento evento = new Evento();
        ItensSalaoParoquial isalao = new ItensSalaoParoquial();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next()){
                evento.setId(rs.getInt("Evento_idEvento"));
                isalao.setId(rs.getInt("ItemSalao_idItemSalao"));
                item.setEvento(evento);
                item.setItem(isalao);
                item.setQuantidade(rs.getInt("quantidade_itemevento"));
                item.setReutilizavel(rs.getBoolean("reutilizavel_itemevento"));
            }
                
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return item;
    }

    public boolean apagar(int idevento,int iditemsalao){
        String sql = "delete from itemevento where Evento_idEvento = "+idevento+" and ItemSalao_idItemSalao = "+iditemsalao;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    

}
