package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Reserva;
import com.utp.karaoke.repositories.ReservaRepository;

public class ReservaService {
    private ReservaRepository reservaRepository;

    public ReservaService() {
        this.reservaRepository = new ReservaRepository();
    }

    public boolean registrarReserva(Reserva reserva) {
        return reservaRepository.guardar(reserva);
    }

    public Reserva obtenerReservaPorId(int id) {
        return reservaRepository.buscarPorId(id);
    }

    public List<Reserva> obtenerTodasReservas() {
        return reservaRepository.listarTodos();
    }

    public boolean actualizarReserva(Reserva reserva) {
        return reservaRepository.actualizar(reserva);
    }

    public boolean eliminarReserva(int id) {
        return reservaRepository.eliminar(id);
    }
}
