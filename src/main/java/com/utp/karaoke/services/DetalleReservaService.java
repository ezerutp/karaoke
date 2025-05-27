package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.DetalleReserva;
import com.utp.karaoke.repositories.DetalleReservaRepository;

public class DetalleReservaService {
    private DetalleReservaRepository detalleReservaRepository;

    public DetalleReservaService (){
        this.detalleReservaRepository = new DetalleReservaRepository();
    }

    public boolean registrarDetalleReserva(DetalleReserva detalleReserva){
        return detalleReservaRepository.guardar(detalleReserva);
    }

    public DetalleReserva obtenerDetalleReservaPorId(int id){
        return detalleReservaRepository.buscarPorId(id);
    }

    public List<DetalleReserva> obtenerTodosDetalleReservas(){
        return detalleReservaRepository.listarTodos();
    }

    public boolean actualizarDetalleReserva(DetalleReserva detalleReserva){
        return detalleReservaRepository.actualizar(detalleReserva);
    }

    public boolean eliminarDetalleReserva(int id){
        return detalleReservaRepository.eliminar(id);
    }
}
