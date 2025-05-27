package com.utp.karaoke.entities;

import java.util.Date;

public class Auditoria {
    private int id;
    private String tablaAfectada;
    private String accion;
    private String usuario;
    private Date fecha;
    private String descripcion;

    public Auditoria() {
    }

    public Auditoria(int id, String tablaAfectada, String accion, String usuario, Date fecha, String descripcion) {
        this.id = id;
        this.tablaAfectada = tablaAfectada;
        this.accion = accion;
        this.usuario = usuario;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTablaAfectada() {
        return tablaAfectada;
    }

    public void setTablaAfectada(String tablaAfectada) {
        this.tablaAfectada = tablaAfectada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}