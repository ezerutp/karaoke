package com.utp.karaoke.utils;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

    public static void validarNumero(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textField.getText();

                // Permitir solo dígitos y un solo punto decimal
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                } else if (c == '.' && text.contains(".")) {
                    e.consume();
                }
            }
        });
    }

    public static void aplicarPlaceholder(JTextField textField, String placeholder) {
        Color placeholderColor = Color.LIGHT_GRAY;
        Color normalColor = Color.BLACK;

        textField.setText(placeholder);
        textField.setForeground(placeholderColor);

        final boolean[] placeholderActivo = { true };

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (placeholderActivo[0]) {
                    textField.setText("");
                    textField.setForeground(normalColor);
                    placeholderActivo[0] = false;
                }
            }
        });
    }
}
