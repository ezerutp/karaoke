package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.repositories.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public boolean registrarUsuario(Usuario usuario) {
        Usuario tempUsuario = usuarioRepository.buscarPorCorreo(usuario.getCorreo());
        if (tempUsuario != null) { return false; }
        return usuarioRepository.guardar(usuario);
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioRepository.buscarPorId(id);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.listarTodos();
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

    public boolean eliminarUsuario(int id) {
        return usuarioRepository.eliminar(id);
    }

    public Usuario autenticarUsuario(String correo, String pass) {
        return usuarioRepository.autenticar(correo, pass);
    }
}