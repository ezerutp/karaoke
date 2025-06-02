package com.utp.karaoke.utils;

import java.util.List;

import com.utp.karaoke.views.Buttons.ButtonsFactory.ButtonConfig;

public class Botones {
    public static List<ButtonConfig> lista = List.of(
        new ButtonConfig("Reserva", "/images/iconReserva.png", () -> System.out.println("Reserva")),
        new ButtonConfig("Tarifas", "/images/iconTarifa.png", () -> System.out.println("Tarifas")),
        new ButtonConfig("Boxes", "/images/iconBoxes.png", () -> System.out.println("Boxes")),
        new ButtonConfig("Configuracion", "/images/iconConfiguracion.png", () -> System.out.println("Configuracion")),
        new ButtonConfig("Usuarios", "/images/iconUsuarios.png", () -> System.out.println("Usuarios"))
    );
}
