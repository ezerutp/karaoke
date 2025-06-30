package com.utp.karaoke.entities;

import java.util.Date;

public class Tarifa {
    private int id;
    private String nombre;
    private double precio;
    private Date fecha;

    public Tarifa() {
    }

    public Tarifa(int id, String nombre, double precio, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return nombre + " - S/" + precio;
    }
}