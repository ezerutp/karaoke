package com.utp.karaoke.views.Buttons;

import javax.swing.*;
import java.awt.*;

public class ButtonsMenu extends JButton {

    public ButtonsMenu(String texto, Icon icono) {
        super(texto, icono);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 16));
        setHorizontalAlignment(SwingConstants.LEFT);
        setIconTextGap(15);
        setPreferredSize(new Dimension(200, 50));
        //setMargin(new Insets(0, 0, 10, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Fondo
        g2.setColor(new Color(50, 45, 100)); // fondo tipo púrpura oscuro
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Sombra
        g2.setColor(new Color(0, 0, 0, 50));
        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

        super.paintComponent(g2);
        g2.dispose();
    }
}
