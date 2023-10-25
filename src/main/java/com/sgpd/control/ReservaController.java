package com.sgpd.control;

import java.util.ArrayList;

import com.sgpd.model.Erro;
import com.sgpd.model.Reserva;

public class ReservaController {
    public Erro salvar(Reserva reserva) {
        if (reserva.getData() != null) {
            if (!reserva.getHorainicio().isEmpty() && !reserva.getHorafim().isEmpty()) {
                if (reserva.getPastoral() != null && reserva.getPastoral().getId() > 0) {
                    if (reserva.getParoquiano() != null && reserva.getParoquiano().getId() > 0) {
                        if (reserva.getSala() != null && reserva.getSala().getId() > 0) {
                            if (!reserva.salvar()) {
                                return new Erro("Erro no banco de dados", true, 500);
                            }
                        } else {
                            return new Erro("Sala não especificada", true, 400);
                        }
                    } else {
                        return new Erro("Paroquiano não especificado", true, 400);
                    }
                } else {
                    return new Erro("Pastoral não especificada", true, 400);
                }
            } else {
                return new Erro("Horário de início ou fim não especificado", true, 400);
            }
        } else {
            return new Erro("Data não especificada", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }

    public Erro alterar(Reserva reserva) {
        if (reserva.getId() > 0) {
            if (reserva.getData() != null) {
                if (!reserva.getHorainicio().isEmpty() && !reserva.getHorafim().isEmpty()) {
                    if (reserva.getPastoral() != null && reserva.getPastoral().getId() > 0) {
                        if (reserva.getParoquiano() != null && reserva.getParoquiano().getId() > 0) {
                            if (reserva.getSala() != null && reserva.getSala().getId() > 0) {
                                if (!reserva.alterar()) {
                                    return new Erro("Erro no banco de dados", true, 500);
                                }
                            } else {
                                return new Erro("Sala não especificada", true, 400);
                            }
                        } else {
                            return new Erro("Paroquiano não especificado", true, 400);
                        }
                    } else {
                        return new Erro("Pastoral não especificada", true, 400);
                    }
                } else {
                    return new Erro("Horário de início ou fim não especificado", true, 400);
                }
            } else {
                return new Erro("Data não especificada", true, 400);
            }
        } else {
            return new Erro("ID da reserva não é válido", true, 400);
        }
        return new Erro("Sucesso", false, 200);
    }


    public Erro apagar(int id) {
        Reserva p = new Reserva();
        if (p.apagar(id)) {
            return new Erro("Sucesso", false, 200);
        } else {
            return new Erro("Reserva possui funções atribuídas, não pode ser excluido", true, 400);
        }
    }

    public ArrayList<Reserva> buscarTodos() {
        return new Reserva().buscarTodos();
    }

    public Reserva buscarPorId(int id) {
        return new Reserva().buscarPorId(id);
    }
}
