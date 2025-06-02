package com.utp.karaoke.views.Buttons;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class ButtonsFactory {

    public static class ButtonConfig {
        public final String texto;
        public final String icono;
        public final Runnable accion;

        public ButtonConfig(String texto, String icono, Runnable accion) {
            this.texto = texto;
            this.icono = icono;
            this.accion = accion;
        }
    }

    public static ButtonsMenu createMenuButton(String texto, String icono, Runnable accion) {
        Icon iconoDefault = new ImageIcon(ButtonsFactory.class.getResource(icono));
        ButtonsMenu btn = new ButtonsMenu(texto, iconoDefault);
        btn.addActionListener(e -> accion.run());
        return btn;
    }

    public static List<ButtonsMenu> createMenuButtons(List<ButtonConfig> configs) {
        List<ButtonsMenu> botones = new ArrayList<>();
        for (ButtonConfig config : configs) {
            botones.add(createMenuButton(config.texto, config.icono, config.accion));
        }
        return botones;
    }
}
