package com.utp.karaoke.entities;

public class DetalleReserva {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private String comentario;
    private Reserva reserva;

    public DetalleReserva() {}

    public DetalleReserva(int id, String nombre, double precio, int cantidad, String comentario, Reserva reserva) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.reserva = reserva;
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

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
