package com.utp.karaoke.controllers;

import java.util.List;

import com.utp.karaoke.entities.Reserva;
import com.utp.karaoke.services.ReservaService;

public class ReservaController {

    private ReservaService reservaService;

    public ReservaController() {
        this.reservaService = new ReservaService();
    }

    public void crearReserva(Reserva reserva) {
        reservaService.registrarReserva(reserva);
    }

    public Reserva obtenerReserva(int id) {
        return reservaService.obtenerReservaPorId(id);
    }

    public List<Reserva> obtenerReservas() {
        return reservaService.obtenerTodasReservas();
    }

    public void actualizarReserva(Reserva reserva) {
        reservaService.actualizarReserva(reserva);
    }

    public boolean cancelarReserva(int id) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        if (reserva != null) {
            reservaService.eliminarReserva(id);
            return true;
        }
        return false;
    }

    public void eliminarReserva(int id) {
        reservaService.eliminarReserva(id);
    }
}