package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Tarifa;
import com.utp.karaoke.repositories.TarifasRepository;

public class TarifasService {
    private TarifasRepository tarifasRepository;

    public TarifasService() {
        this.tarifasRepository = new TarifasRepository();
    }

    public boolean registrarTarifa(Tarifa tarifa) {
        return tarifasRepository.guardar(tarifa);
    }

    public Tarifa obtenerTarifaPorId(int id) {
        return tarifasRepository.buscarPorId(id);
    }

    public List<Tarifa> obtenerTodasTarifas() {
        return tarifasRepository.listarTodos();
    }

    public boolean actualizarTarifa(Tarifa tarifa) {
        return tarifasRepository.actualizar(tarifa);
    }

    public boolean eliminarTarifa(int id) {
        return tarifasRepository.eliminar(id);
    }
}
