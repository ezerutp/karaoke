package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.repositories.SalasRepository;

public class SalasService {
    private SalasRepository salasRepository;

    public SalasService() {
        this.salasRepository = new SalasRepository();
    }

    public boolean registrarSala(Sala sala) {
        return salasRepository.guardar(sala);
    }

    public Sala obtenerSalaPorId(int id) {
        return salasRepository.buscarPorId(id);
    }

    public List<Sala> obtenerTodasSalas() {
        return salasRepository.listarTodos();
    }

    public boolean actualizarSala(Sala sala) {
        return salasRepository.actualizar(sala);
    }

    public boolean eliminarSala(int id) {
        return salasRepository.eliminar(id);
    }
}
