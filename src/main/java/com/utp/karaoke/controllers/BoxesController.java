package com.utp.karaoke.controllers;

import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.services.SalasService;

import javax.swing.JOptionPane;
import java.util.List;

public class BoxesController {
    private SalasService boxesService;

    public BoxesController() {
        this.boxesService = new SalasService();
    }

    public boolean registrarSala(Sala sala) {
        // Validaciones básicas
        if (sala.getNombre() == null || sala.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getTipo() == null || sala.getTipo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tipo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getMesas() <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de mesas debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getTarifa() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarifa.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getEstado() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un estado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean registrado = boxesService.registrarSala(sala);
        if (registrado) {
            JOptionPane.showMessageDialog(null, "Sala registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la sala.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean actualizarSala(Sala sala) {
        if (sala.getNombre() == null || sala.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getTipo() == null || sala.getTipo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El tipo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getMesas() <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de mesas debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getTarifa() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarifa.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (sala.getEstado() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un estado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean actualizado = boxesService.actualizarSala(sala);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Sala actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la sala.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Sala> obtenerSalas() {
        return boxesService.obtenerTodasSalas();
    }

    public Sala obtenerSalaPorNombre(String nombre) {
        List<Sala> salas = boxesService.obtenerTodasSalas();
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombre)) {
                return sala;
            }
        }
        return null;
    }

    public boolean eliminarSala(int id) {
        boolean eliminado = boxesService.eliminarSala(id);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Sala eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar la sala.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
