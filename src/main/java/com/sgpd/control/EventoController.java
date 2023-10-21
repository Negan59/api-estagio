package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Aluguel;
import com.sgpd.model.Erro;
import com.sgpd.model.Evento;

public class EventoController {
    public Erro salvar(Evento evento){
        if(!evento.getNomeevento().isEmpty()){
            if(!evento.salvar()){
                return new Erro("Erro no banco de dados", true, 500);
            }
        }else{
            return new Erro("Por favor, preencha o email do usuário", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(Evento evento){
        if(!evento.getNomeevento().isEmpty()){
            if(!evento.alterar()){
                return new Erro("Erro no banco de dados", true, 500);
            }
        }else{
            return new Erro("Por favor, preencha o email do usuário", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public ArrayList<Evento> buscarTodos(){
        return new Evento().buscarTodos();
    }

    public ArrayList<Evento> buscarTodosInativos(){
        return new Evento().buscarTodosInativos();
    }

    public Evento buscarUm(int id){
        return new Evento().buscarUm(id);
    }

    public Erro ativar(int id){
        Evento p = new Evento();
        if(p.ativar(id)){
            return new Erro("Sucesso", false, 200);
        }
        else{
            return new Erro("Ero ao ativar evento", true, 400);
        }
    }

     public Erro desativar(int id){
        Evento p = new Evento();
        if(p.apagar(id)){
            return new Erro("Sucesso", false, 200);
        }
        else{
            return new Erro("Ero ao desativar evento", true, 400);
        }
    }

    public Erro atualizarAluguel(Aluguel aluguel, int id){
        Evento evento = new Evento();
        evento.setId(id);
        if(evento.atualizarAluguel(aluguel)){
            return new Erro("Sucesso", false, 200);
        }else{
            return new Erro("Ero ao desativar evento", true, 400);
        }
    }
}
