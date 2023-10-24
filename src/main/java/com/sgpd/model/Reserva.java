package com.sgpd.model;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private LocalDate data;
    private String horainicio;
    private String horafim;
    private Pastoral pastoral;
    private Paroquiano paroquiano;
    private Sala sala;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
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
    public Pastoral getPastoral() {
        return pastoral;
    }
    public void setPastoral(Pastoral pastoral) {
        this.pastoral = pastoral;
    }
    public Paroquiano getParoquiano() {
        return paroquiano;
    }
    public void setParoquiano(Paroquiano paroquiano) {
        this.paroquiano = paroquiano;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Reserva(int id, LocalDate data, String horainicio, String horafim, Pastoral pastoral, Paroquiano paroquiano,
            Sala sala) {
        this.id = id;
        this.data = data;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.pastoral = pastoral;
        this.paroquiano = paroquiano;
        this.sala = sala;
    }
    public Reserva(LocalDate data, String horainicio, String horafim, Pastoral pastoral, Paroquiano paroquiano,
            Sala sala) {
        this.data = data;
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.pastoral = pastoral;
        this.paroquiano = paroquiano;
        this.sala = sala;
    }
    public Reserva() {
    }
}
