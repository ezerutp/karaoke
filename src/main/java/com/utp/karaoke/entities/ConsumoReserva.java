package com.utp.karaoke.entities;

public class ConsumoReserva {
    private int id;
    private Reserva reserva;
    private Producto producto;
    private int cantidad;
    private String comentario;

    public ConsumoReserva() {
    }

    public ConsumoReserva(int id, Reserva reserva, Producto producto, int cantidad, String comentario) {
        this.id = id;
        this.reserva = reserva;
        this.producto = producto;
        this.cantidad = cantidad;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}