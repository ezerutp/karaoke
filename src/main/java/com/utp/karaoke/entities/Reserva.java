package com.utp.karaoke.entities;

public class Reserva {
    private int id;
    private Sala sala;
    private int num_mesa;
    private String fecha;
    private double total;
    private Usuario usuario;
    private String estado;

    public Reserva() {}

    public Reserva(int id, Sala sala, int num_mesa, String fecha, double total, Usuario usuario, String estado) {
        this.id = id;
        this.sala = sala;
        this.num_mesa = num_mesa;
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        this.estado = estado;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getNum_mesa() {
        return this.num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
