package com.utp.karaoke.services;

import com.utp.karaoke.entities.Configuracion;
import com.utp.karaoke.repositories.ConfiguracionRepository;

public class ConfiguracionService {
    private ConfiguracionRepository configuracionRepository;

    public ConfiguracionService() {
        this.configuracionRepository = new ConfiguracionRepository();
    }

    public boolean registrarConfiguracion(Configuracion configuracion) {
        return configuracionRepository.guardar(configuracion);
    }

    public Configuracion obtenerConfiguracionPorId(int id) {
        return configuracionRepository.buscarPorId(id);
    }

    public Configuracion obtenerConfiguracion() {
        return configuracionRepository.listarTodos().isEmpty() ? null : configuracionRepository.listarTodos().get(0);
    }

    public boolean actualizarConfiguracion(Configuracion configuracion) {
        return configuracionRepository.actualizar(configuracion);
    }

    public boolean eliminarConfiguracion(int id){
        return configuracionRepository.eliminar(id);
    }

}
