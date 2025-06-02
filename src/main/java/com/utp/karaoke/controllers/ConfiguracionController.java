package com.utp.karaoke.controllers;

import com.utp.karaoke.entities.Configuracion;
import com.utp.karaoke.services.ConfiguracionService;

import java.util.Date;

import javax.swing.JOptionPane;

public class ConfiguracionController {
    private ConfiguracionService configuracionService;

    public ConfiguracionController() {
        this.configuracionService = new ConfiguracionService();
    }

    public boolean registrarConfiguracion(Configuracion configuracion) {
        // Validaciones básicas
        if (configuracion.getRuc() == null || configuracion.getRuc().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El RUC no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (configuracion.getNombre() == null || configuracion.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (configuracion.getTelefono() == null || configuracion.getTelefono().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (configuracion.getDireccion() == null || configuracion.getDireccion().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La dirección no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        configuracion.setFechaRegistro(new Date());

        boolean registrado = configuracionService.registrarConfiguracion(configuracion);
        if (registrado) {
            JOptionPane.showMessageDialog(null, "Configuración registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la configuración.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Configuracion obtenerConfiguracion() {
        return configuracionService.obtenerConfiguracion();
    }

    public boolean actualizarConfiguracion(Configuracion configuracion) {
        configuracion.setFechaRegistro(new Date());
        boolean actualizado = configuracionService.actualizarConfiguracion(configuracion);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Configuración actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la configuración.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean eliminarConfiguracion(int id) {
        boolean eliminado = configuracionService.eliminarConfiguracion(id);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Configuración eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar la configuración.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
