package com.utp.karaoke.controllers;

import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.services.ConfiguracionService;
import com.utp.karaoke.services.UsuarioService;
import com.utp.karaoke.utils.SessionLogin;
import javax.swing.JOptionPane;

public class LoginController {
    private UsuarioService usuarioService;
    private ConfiguracionService configuracionService;

    public LoginController() {
        this.usuarioService = new UsuarioService();
        this.configuracionService = new ConfiguracionService();
    }

    public SessionLogin validarCredenciales(String correo, String pass) {

        // Validaciones básicas
        if (correo == null || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (pass == null || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Validación de correo simple
        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(null, "El correo no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Validación de longitud de contraseña
        if (pass.length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Usuario user = usuarioService.autenticarUsuario(correo, pass);
        if (user != null) {
            return SessionLogin.getInstance().setData(user, configuracionService.obtenerConfiguracion());
        }
        JOptionPane.showMessageDialog(null, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

}