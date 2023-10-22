package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Evento;
import com.sgpd.model.ItemEvento;
import com.sgpd.model.ItensSalaoParoquial;

public class ItemEventoController {
    public Erro salvar(ItemEvento item){
        if (!item.salvar()) {
            return new Erro("Erro no banco de dados", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(ItemEvento item){
        if (!item.alterar()) {
            return new Erro("Erro no banco de dados", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro apagar(int idevento, int idsalao){
        ItemEvento item = new ItemEvento();
        if (!item.apagar(idevento,idsalao)) {
            return new Erro("Erro no banco de dados", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public ItemEvento buscarum(int idevento,int idsalao){
        ItemEvento item = new ItemEvento();
        item =  item.buscarum(idevento, idsalao);
        item.setEvento(new Evento().buscarUm(item.getEvento().getId()));
        item.setItem(new ItensSalaoParoquial().buscarUm(item.getItem().getId()));
        return item;
    }

    public ArrayList<ItemEvento> buscarTodosEvento(int evento){
        ArrayList<ItemEvento>lista = new ArrayList<ItemEvento>();
        ItemEvento item = new ItemEvento();
        lista =  item.buscarTodosEvento(evento);
        for(int i = 0;i<lista.size();i++){
            lista.get(i).setEvento(new Evento().buscarUm(lista.get(i).getEvento().getId()));
            lista.get(i).setItem(new ItensSalaoParoquial().buscarUm(lista.get(i).getItem().getId()));
        }
        return lista;
    }
}
