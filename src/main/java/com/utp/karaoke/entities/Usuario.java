package com.utp.karaoke.entities;

import com.utp.karaoke.utils.EnumKaraoke.RolUsuario;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String pass;
    private RolUsuario rol;

    public enum Rol {
        ADMINISTRADOR,
        RECEPCIONISTA,
        CLIENTE
    }

    public Usuario() {}

    public Usuario(int id, String nombre, String correo, String pass, RolUsuario rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.rol = rol;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}