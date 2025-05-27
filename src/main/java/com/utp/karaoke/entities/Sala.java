package com.utp.karaoke.entities;

import com.utp.karaoke.utils.EnumKaraoke.EstadoSala;

public class Sala {
    private int id;
    private String nombre;
    private String tipo; // VIP, estándar, etc.
    private int mesas;
    private Tarifa tarifa;
    private EstadoSala estado;


    public Sala() {}

    public Sala(int id, String nombre, String tipo, int mesas, Tarifa tarifa, EstadoSala estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.mesas = mesas;
        this.tarifa = tarifa;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public EstadoSala getEstado() {
        return estado;
    }

    public void setEstado(EstadoSala estado) {
        this.estado = estado;
    }
}