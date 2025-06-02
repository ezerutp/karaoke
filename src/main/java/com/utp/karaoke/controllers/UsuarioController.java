package com.utp.karaoke.controllers;

import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.services.AuditoriaService;
import com.utp.karaoke.services.UsuarioService;

import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public boolean registrarUsuario(Usuario usuario) {
        // Validaciones básicas
        if (usuario.getCorreo() == null || usuario.getCorreo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!usuario.getCorreo().contains("@")) {
            JOptionPane.showMessageDialog(null, "El correo no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (usuario.getPass() == null || usuario.getPass().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (usuario.getPass().length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean registrado = usuarioService.registrarUsuario(usuario);
        if (registrado) {
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Registrar auditoría
            boolean auditoriaRegistrada = new AuditoriaService().registrarAuditoriaRegistroUsuario(usuario);
            if (!auditoriaRegistrada) {
                JOptionPane.showMessageDialog(null, "Error al registrar la auditoría.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El correo ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }
}
