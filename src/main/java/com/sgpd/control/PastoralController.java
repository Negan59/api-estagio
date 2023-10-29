package com.sgpd.control;

import java.time.LocalDate;
import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Paroquiano;
import com.sgpd.model.Pastoral;

public class PastoralController {
    public Erro salvar(Pastoral pastoral) {
        if (!pastoral.getNomepastoral().isEmpty()) {
            if (!pastoral.getDescricaopastoral().isEmpty()) {
                if (pastoral.getDatacriacao().isBefore(LocalDate.now())
                        || pastoral.getDatacriacao().isEqual(LocalDate.now())) {
                    if (!pastoral.salvar()) {
                        return new Erro("Erro no banco de dados", true, 500);
                    }
                } else {
                    return new Erro("Senha muito curta", true, 400);
                }
            } else {
                return new Erro("Por favor, preencha a descrição da pastoral", true, 400);
            }
        } else {
            return new Erro("Por favor, preencha o nome da pastoral", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(Pastoral pastoral) {
        if (!pastoral.getNomepastoral().isEmpty()) {
            if (!pastoral.getDescricaopastoral().isEmpty()) {
                if (pastoral.getDatacriacao().isBefore(LocalDate.now())
                        || pastoral.getDatacriacao().isEqual(LocalDate.now())) {
                    if (!pastoral.alterar()) {
                        return new Erro("Erro no banco de dados", true, 500);
                    }
                } else {
                    return new Erro("Senha muito curta", true, 400);
                }
            } else {
                return new Erro("Por favor, preencha a descrição da pastoral", true, 400);
            }
        } else {
            return new Erro("Por favor, preencha o nome da pastoral", true, 500);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro desativar(int id) {
        Pastoral p = new Pastoral();
        if (p.desativar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Não é possível desativar esta pastoral", true, 400);
        }
    }

    public Erro ativar(int id) {
        Pastoral p = new Pastoral();
        if (p.ativar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Não é possível desativar esta pastoral", true, 400);
        }
    }

    public ArrayList<Pastoral> buscarAtivas() {
        ArrayList<Pastoral> pastoraisAtivas = new Pastoral().buscarAtivas();
        for (Pastoral pastoral : pastoraisAtivas) {
            Paroquiano paroquiano = new Paroquiano();
            pastoral = pastoral.buscarUm(pastoral.getId());
            paroquiano = pastoral.getCoordenador().buscarUm(pastoral.getCoordenador().getId());
            pastoral.setCoordenador(paroquiano);
            System.out.println(pastoral.getNomepastoral());
        }
        return pastoraisAtivas;
    }

    public ArrayList<Pastoral> buscarInativas() {
        ArrayList<Pastoral> pastoraisInativas = new Pastoral().buscarInativas();
        for (Pastoral pastoral : pastoraisInativas) {
            Paroquiano paroquiano = new Paroquiano();
            pastoral = pastoral.buscarUm(pastoral.getId());
            paroquiano = pastoral.getCoordenador().buscarUm(pastoral.getCoordenador().getId());
            pastoral.setCoordenador(paroquiano);
            System.out.println(pastoral.getNomepastoral());
        }
        return pastoraisInativas;
    }

    public Pastoral buscarUm(int id) {
        Pastoral pastoral = new Pastoral();
        Paroquiano paroquiano = new Paroquiano();
        pastoral = pastoral.buscarUm(id);
        paroquiano = pastoral.getCoordenador().buscarUm(pastoral.getCoordenador().getId());
        pastoral.setCoordenador(paroquiano);
        System.out.println(pastoral.getNomepastoral());
        return pastoral;
    }
}
