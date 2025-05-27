package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Cliente;
import com.utp.karaoke.repositories.ClienteRepository;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    public boolean registrarCliente(Cliente cliente) {
        return clienteRepository.guardar(cliente);
    }

    public Cliente obtenerClientePorId(int id) {
        return clienteRepository.buscarPorId(id);
    }

    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.listarTodos();
    }

    public boolean actualizarCliente(Cliente cliente) {
        return clienteRepository.actualizar(cliente);
    }

    public boolean eliminarCliente(int id) {
        return clienteRepository.eliminar(id);
    }
}