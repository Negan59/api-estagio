package com.sgpd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgpd.model.Funcionario;
import com.sgpd.model.SingletonConexao;

public class DAOFuncionario {
    public boolean salvar(Funcionario u) {
        try {
            System.out.println("chega aqui?");
            String sql = "insert into Pessoa (nome, foto, telefone, email) values ('$1', '$2', '$3', '$4')";
            sql = sql.replace("$1", u.getNome());
            sql = sql.replace("$2", u.getFoto());
            sql = sql.replace("$3", u.getTelefone());
            sql = sql.replace("$4", u.getEmail());
            SingletonConexao con = SingletonConexao.getConexao();
            boolean flag = con.manipular(sql);
            System.out.println(flag);
            if (flag) {
                Funcionario p = buscarEmail(u.getEmail());
                sql = "insert into funcionario (senha, Pessoa_idPessoa) values ('$1', $2)";
                sql = sql.replace("$1", u.getSenha());
                sql = sql.replace("$2", "" + p.getId());
                con = SingletonConexao.getConexao();
                flag = con.manipular(sql);
            }
            con.fecharConexao();
            return flag;
        } catch (Exception e) {
            System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public Funcionario buscarEmail(String email){
        Funcionario novo = null;
        String sql = "select * from pessoa where email LIKE " + "'" + email + "'";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Funcionario(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),rs.getString("telefone"),rs.getString("email"));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return novo;
    }

    public boolean alterar(Funcionario p){
        String sql = "update pessoa set nome='$1',foto='$2',telefone='$3', email='$4' where idPessoa = "+p.getId();
        sql = sql.replace("$1", p.getNome());
        sql = sql.replace("$2", p.getFoto());
        sql = sql.replace("$3", p.getTelefone());
        sql = sql.replace("$4", p.getEmail());
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        if(flag){
            sql = "update funcionario set senha='$1' where Pessoa_idPessoa = "+p.getId();
            sql = sql.replace("$1", p.getSenha());
            con = SingletonConexao.getConexao();
            flag = con.manipular(sql);
        }
        con.fecharConexao();
        return flag;
    }

    public boolean apagar(int id){
        String sql = "delete from paroquiano where Pessoa_idPessoa = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        if(flag){
            sql = "delete from pessoa where idPessoa = "+id;
            con = SingletonConexao.getConexao();
            flag = con.manipular(sql);
        }
        con.fecharConexao();
        return flag;

    }

    public boolean desativar(int id){
        String sql = "update funcionario set fun_status = 0 where Pessoa_idPessoa = "+id;
        System.out.println(sql);
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean ativar(int id){
        String sql = "update funcionario set fun_status = 1 where Pessoa_idPessoa = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public ArrayList<Funcionario> buscarTodos() {
        ArrayList<Funcionario> Lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa PE inner join funcionario F where PE.idPessoa = F.Pessoa_idPessoa and F.fun_status = 1;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Funcionario(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),
                                rs.getString("telefone"), rs.getString("email"), rs.getString("senha"),rs.getBoolean("fun_status")));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return Lista;
    }

    public ArrayList<Funcionario> buscarTodosInativos() {
        ArrayList<Funcionario> Lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa PE inner join funcionario F where PE.idPessoa = F.Pessoa_idPessoa and F.fun_status = 0;";
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next())
                Lista.add(
                        new Funcionario(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),
                                rs.getString("telefone"), rs.getString("email"), rs.getString("senha"),rs.getBoolean("fun_status")));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return Lista;
    }

    public Funcionario buscarUm(int id){
        Funcionario novo = null;
        String sql = "SELECT * FROM pessoa PE inner join funcionario F where PE.idPessoa = F.Pessoa_idPessoa AND PE.idPessoa = "+id;
        SingletonConexao con = SingletonConexao.getConexao();
        ResultSet rs = con.consultar(sql);

        try {
            if (rs.next())
                novo = new Funcionario(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("foto"),rs.getString("telefone"),rs.getString("email"),rs.getString("senha"),rs.getBoolean("fun_status"));
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return novo;
    }
}
