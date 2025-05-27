package com.utp.karaoke.entities;

public class Tarifa {
    private int id;
    private String nombre;
    private double precio;
    private String fecha;

    public Tarifa() {}

    public Tarifa(int id, String nombre, double precio, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
