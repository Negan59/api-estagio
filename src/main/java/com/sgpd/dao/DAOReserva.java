package com.sgpd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sgpd.model.Paroquiano;
import com.sgpd.model.Pastoral;
import com.sgpd.model.Reserva;
import com.sgpd.model.Sala;
import com.sgpd.model.SingletonConexao;

public class DAOReserva {
    public boolean salvar(Reserva reserva) {
        System.out.println("chega aqui pelo menos?");
        String sql = "insert into reserva_sala (data_reserva,\n" + //
                "horarioinicio_reserva,\n" + //
                "horariofim_reserva,\n" + //
                "Paroquiano_pastoral_Pastoral_idPastoral,\n" + //
                "Paroquiano_pastoral_Paroquiano_Pessoa_idPessoa,\n" + //
                "Sala_idSala) values ('$1','$2','$3',$4,$5,$6)";
        sql = sql.replace("$1", "" + reserva.getData());
        sql = sql.replace("$2", reserva.getHorainicio());
        sql = sql.replace("$3", reserva.getHorafim());
        sql = sql.replace("$4", "" + reserva.getPastoral().getId());
        sql = sql.replace("$5", "" + reserva.getParoquiano().getId());
        sql = sql.replace("$6", "" + reserva.getSala().getId());
        SingletonConexao con = SingletonConexao.getConexao();
        System.out.println(sql);
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean alterar(Reserva reserva) {
        String sql = "update reserva_sala set " +
                "data_reserva = $1, " +
                "horarioinicio_reserva = '$2', " +
                "horariofim_reserva = $3, " +
                "Paroquiano_pastoral_Pastoral_idPastoral = '$4', " +
                "Paroquiano_pastoral_Paroquiano_Pessoa_idPessoa = $5, " +
                "Sala_idSala = $6 " +
                "where idReserva_Sala = $7";
        sql = sql.replace("$1", "" + reserva.getData());
        sql = sql.replace("$2", reserva.getHorainicio());
        sql = sql.replace("$3", reserva.getHorafim());
        sql = sql.replace("$4", "" + reserva.getPastoral().getId());
        sql = sql.replace("$5", "" + reserva.getParoquiano().getId());
        sql = sql.replace("$6", "" + reserva.getSala().getId());
        sql = sql.replace("$7", "" + reserva.getId());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean apagar(int id) {
        String sql = "delete from reserva_sala where idReserva_Sala = " + id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public Reserva buscarPorId(int id) {
        String sql = "select * from reserva_sala where idReserva_Sala = " + id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        Reserva reserva = new Reserva();
        try {
            if (rs.next()) {
                reserva.setId(rs.getInt("idReserva_Sala"));
                reserva.setData(rs.getDate("data_reserva").toLocalDate());
                reserva.setHorainicio(rs.getString("horarioinicio_reserva"));
                reserva.setHorafim(rs.getString("horariofim_reserva"));
                Pastoral pastoral = new Pastoral();
                Paroquiano paroquiano = new Paroquiano();
                Sala sala = new Sala();
                pastoral.setId(rs.getInt("Paroquiano_pastoral_Pastoral_idPastoral"));
                paroquiano.setId(rs.getInt("Paroquiano_pastoral_Paroquiano_Pessoa_idPessoa"));
                sala.setId(rs.getInt("Sala_idSala"));
                reserva.setPastoral(pastoral);
                reserva.setParoquiano(paroquiano);
                reserva.setSala(sala);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.fecharConexao();
        return reserva;
    }

    public ArrayList<Reserva> buscarTodos() {
        String sql = "select * from reserva_sala order by data_reserva desc";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        ArrayList<Reserva> reservas = new ArrayList<>();
        try {
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("idReserva_Sala"));
                reserva.setData(rs.getDate("data_reserva").toLocalDate());
                reserva.setHorainicio(rs.getString("horarioinicio_reserva"));
                reserva.setHorafim(rs.getString("horariofim_reserva"));
                Pastoral pastoral = new Pastoral();
                Paroquiano paroquiano = new Paroquiano();
                Sala sala = new Sala();
                pastoral.setId(rs.getInt("Paroquiano_pastoral_Pastoral_idPastoral"));
                paroquiano.setId(rs.getInt("Paroquiano_pastoral_Paroquiano_Pessoa_idPessoa"));
                sala.setId(rs.getInt("Sala_idSala"));
                reserva.setPastoral(pastoral);
                reserva.setParoquiano(paroquiano);
                reserva.setSala(sala);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.fecharConexao();
        return reservas;
    }

}
