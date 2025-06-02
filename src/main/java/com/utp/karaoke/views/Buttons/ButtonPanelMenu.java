package com.utp.karaoke.views.Buttons;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.Box;

public class ButtonPanelMenu {
    public static void addButtons(List<ButtonsMenu> botones, JPanel panel, int spacing) {
        for (int i = 0; i < botones.size(); i++) {
            ButtonsMenu boton = botones.get(i);
            boton.setMaximumSize(new java.awt.Dimension(panel.getWidth(), 45));
            panel.add(boton);
            if (i < botones.size() - 1) {
                panel.add(Box.createVerticalStrut(spacing));
            }
        }
    }   
}