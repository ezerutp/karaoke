package com.utp.karaoke.entities;

import java.util.Date;

import com.utp.karaoke.utils.EnumKaraoke.EstadoReserva;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Sala sala;
    private Usuario usuariosuario;
    private Date fecha;
    private double total;
    private EstadoReserva estado;

    public Reserva() {}

    public Reserva(int id, Cliente cliente, Sala sala, Usuario usuariosuario, double total, EstadoReserva estado) {
        this.id = id;
        this.cliente = cliente;
        this.sala = sala;
        this.usuariosuario = usuariosuario;
        this.fecha = new Date();
        this.total = total;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Usuario getUsuario() {
        return usuariosuario;
    }

    public void setUsuario(Usuario usuariosuario) {
        this.usuariosuario = usuariosuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
}