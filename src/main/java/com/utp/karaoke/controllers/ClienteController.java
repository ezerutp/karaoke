package com.utp.karaoke.controllers;

import com.utp.karaoke.entities.Cliente;
import com.utp.karaoke.services.ClienteService;

import java.util.List;

import javax.swing.JOptionPane;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController() {
        this.clienteService = new ClienteService();
    }

    public boolean registrarCliente(Cliente cliente) {
        // Validaciones básicas
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getDni() == null || cliente.getDni().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El DNI no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getDni().length() != 8) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener 8 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getTelefono() == null || cliente.getTelefono().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getCorreo() == null || cliente.getCorreo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!cliente.getCorreo().contains("@")) {
            JOptionPane.showMessageDialog(null, "El correo no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean registrado = clienteService.registrarCliente(cliente);
        if (registrado) {
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente. Es posible que el DNI ya esté registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean actualizarCliente(Cliente cliente) {
        // Validaciones básicas
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getDni() == null || cliente.getDni().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El DNI no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getDni().length() != 8) {
            JOptionPane.showMessageDialog(null, "El DNI debe tener 8 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getTelefono() == null || cliente.getTelefono().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cliente.getCorreo() == null || cliente.getCorreo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!cliente.getCorreo().contains("@")) {
            JOptionPane.showMessageDialog(null, "El correo no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        boolean actualizado = clienteService.actualizarCliente(cliente);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Cliente> obtenerClientes() {
        return clienteService.obtenerTodosClientes();
    }

    public Cliente obtenerClientePorId(int id) {
        return clienteService.obtenerClientePorId(id);
    }

    public Cliente obtenerClientePorDni(String dni) {
        List<Cliente> clientes = clienteService.obtenerTodosClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean eliminarCliente(int id) {
        boolean eliminado = clienteService.eliminarCliente(id);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}