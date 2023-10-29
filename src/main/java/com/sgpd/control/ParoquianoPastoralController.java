package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Paroquiano;
import com.sgpd.model.ParoquianoPastoral;
import com.sgpd.model.Pastoral;

public class ParoquianoPastoralController {

    public Erro salvar(ParoquianoPastoral pas){
        ParoquianoPastoral aux = pas.buscarUm(pas.getPastoral().getId(), pas.getParoquiano().getId());
        if(aux.getParoquiano() == null){
            if(pas.salvar()){
                return new Erro("Salvo com sucesso!!", false, 200);
            }
            else{
                return new Erro("Não foi possível salvar, contate o suporte", true, 500);
            }
        }
        else if(pas.getDatafim() != null){
            return new Erro("Paroquiano já faz parte da pastoral", true, 400);
        }
        else{
            if(pas.reativarLigacao()){
                return new Erro("Salvo com sucesso!!", false, 200);
            }
            else{
                return new Erro("Não foi possível salvar, contate o suporte", true, 500);
            }
        }
    }

    public Erro encerrarLigacao(ParoquianoPastoral pas){
        if(pas.encerrarLigacao()){
            return new Erro("Ligação encerrada com sucesso!!", false, 200);
        }
        else{
            return new Erro("Não foi possível encerrar a ligação, contate o suporte", true, 500);
        }
    }

    public Erro reativarLigacao(ParoquianoPastoral pas){
        if(pas.reativarLigacao()){
            return new Erro("Ligação ativada com sucesso!!", false, 200);
        }
        else{
            return new Erro("Não foi possível ativar a ligação, contate o suporte", true, 500);
        }
    }

    public ParoquianoPastoral buscarUm(int idpastoral,int idparoquiano){
        ParoquianoPastoral pas =  new ParoquianoPastoral().buscarUm(idpastoral, idparoquiano);
        Paroquiano paroquiano = new Paroquiano();
        Pastoral pastoral = new Pastoral();
        if(pas != null){
            pastoral = pastoral.buscarUm(idpastoral);
            pastoral.setCoordenador(paroquiano.buscarUm(pastoral.getCoordenador().getId()));
            pas.setPastoral(pastoral);
            pas.setParoquiano(paroquiano.buscarUm(idparoquiano));
        }
        return pas;
    }

    public ArrayList<ParoquianoPastoral> buscarTodos(int idpastoral){
        ArrayList<ParoquianoPastoral> listaPas = new ArrayList<>();
        ArrayList<ParoquianoPastoral> listaAux = new ParoquianoPastoral().buscarTodos(idpastoral);
        for(ParoquianoPastoral pas : listaAux){
            Paroquiano paroquiano = new Paroquiano();
            Pastoral pastoral = new Pastoral();
            pastoral = pastoral.buscarUm(pas.getPastoral().getId());
            pastoral.setCoordenador(paroquiano.buscarUm(pastoral.getCoordenador().getId()));
            pas.setPastoral(pastoral);
            pas.setParoquiano(paroquiano.buscarUm(pas.getParoquiano().getId()));
            listaPas.add(pas);
        }
        return listaPas;
    }

}
