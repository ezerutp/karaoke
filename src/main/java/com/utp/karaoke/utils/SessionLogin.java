package com.utp.karaoke.utils;

import com.utp.karaoke.entities.Configuracion;
import com.utp.karaoke.entities.Usuario;

public class SessionLogin {
    private static SessionLogin instancia;
    private Usuario usuario;
    private Configuracion configuracion;

    private SessionLogin() {
    }

    public static SessionLogin getInstance() {
        if (instancia == null) {
            instancia = new SessionLogin();
        }
        return instancia;
    }

    public SessionLogin setData(Usuario usuario, Configuracion configuracion) {
        this.usuario = usuario;
        this.configuracion = configuracion;
        return this;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Configuracion getConfiguracion() {
        return this.configuracion;
    }

}
