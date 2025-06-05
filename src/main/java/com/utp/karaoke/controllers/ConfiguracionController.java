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

    // Método privado para validar campos obligatorios
    private boolean validarCampos(Configuracion configuracion) {
        if (configuracion.getRuc() == null || configuracion.getRuc().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El RUC no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (configuracion.getNombre() == null || configuracion.getNombre().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (configuracion.getTelefono() == null || configuracion.getTelefono().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (configuracion.getDireccion() == null || configuracion.getDireccion().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La dirección no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean registrarConfiguracion(Configuracion configuracion) {
        if (!validarCampos(configuracion)) {
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
        if (!validarCampos(configuracion)) {
            return false;
        }
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
