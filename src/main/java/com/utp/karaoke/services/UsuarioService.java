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
        // Validaciones básicas
        if (usuario == null) return false;
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) return false;
        if (usuario.getCorreo() == null || usuario.getCorreo().isEmpty()) return false;
        if (usuario.getPass() == null || usuario.getPass().isEmpty()) return false;
        if (usuario.getRol() == null || usuario.getRol().isEmpty()) return false;

        // Validación de correo simple
        if (!usuario.getCorreo().contains("@")) return false;

        // Validación de longitud de contraseña
        if (usuario.getPass().length() < 6) return false;

        // Validacion de que no exista un usuario con el mismo correo
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