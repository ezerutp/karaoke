package com.utp.karaoke.controllers;

import com.utp.karaoke.entities.Tarifa;
import com.utp.karaoke.services.TarifasService;

import javax.swing.JOptionPane;
import java.util.List;

public class TarifaController {
    private TarifasService tarifasService;

    public TarifaController() {
        this.tarifasService = new TarifasService();
    }

    public boolean registrarTarifa(Tarifa tarifa) {
        // Validaciones básicas
        if (tarifa.getNombre() == null || tarifa.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tarifa.getPrecio() <= 0) {
            JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tarifa.getFecha() == null) {
            JOptionPane.showMessageDialog(null, "La fecha no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean registrado = tarifasService.registrarTarifa(tarifa);
        if (registrado) {
            JOptionPane.showMessageDialog(null, "Tarifa registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la tarifa.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean actualizarTarifa(Tarifa tarifa) {
        if (tarifa.getNombre() == null || tarifa.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tarifa.getPrecio() <= 0) {
            JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tarifa.getFecha() == null) {
            JOptionPane.showMessageDialog(null, "La fecha no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean actualizado = tarifasService.actualizarTarifa(tarifa);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Tarifa actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la tarifa.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Tarifa> obtenerTarifas() {
        return tarifasService.obtenerTodasTarifas();
    }

    public Tarifa obtenerTarifaPorNombre(String nombre) {
        List<Tarifa> tarifas = tarifasService.obtenerTodasTarifas();
        for (Tarifa tarifa : tarifas) {
            if (tarifa.getNombre().equalsIgnoreCase(nombre)) {
                return tarifa;
            }
        }
        return null;
    }

    public boolean eliminarTarifa(int id) {
        boolean eliminado = tarifasService.eliminarTarifa(id);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Tarifa eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar la tarifa.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}