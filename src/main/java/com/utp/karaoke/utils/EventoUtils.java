package com.utp.karaoke.utils;

import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventoUtils {

    public static void asignarEventoClick(JComponent miComponente, Runnable accion) {
        miComponente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accion.run();
            }
        });
    }

    public static void asignarEventoEnter(JComponent componente, Runnable accion) {
        componente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    accion.run();
                }
            }
        });
    }
}
