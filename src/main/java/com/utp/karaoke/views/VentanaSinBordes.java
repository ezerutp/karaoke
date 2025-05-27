package com.utp.karaoke.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class VentanaSinBordes extends JFrame {

    private Point mouseClickPoint;

    public VentanaSinBordes() {
        // Quitar borde
        setUndecorated(true);

        // Fondo (color de ejemplo)
        getContentPane().setBackground(new Color(65, 50, 100));

        // Centrar
        setLocationRelativeTo(null);

        // Salir al cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Poner esquinas redondeadas al iniciar y al cambiar tamaño
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
            }
        });
        // También al crear la ventana (por si ya tiene tamaño)
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

        // Permitir arrastrar la ventana
        habilitarArrastre();

        // Layout nulo si quieres usar posición absoluta
        setLayout(null);
    }

    private void habilitarArrastre() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseClickPoint = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseClickPoint.x;
                int y = e.getYOnScreen() - mouseClickPoint.y;
                setLocation(x, y);
            }
        });
    }

    public static void main(String[] args) {
        // Asegúrate de tener decoraciones compatibles
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(() -> {
            VentanaSinBordes ventana = new VentanaSinBordes();
            ventana.setVisible(true);
        });
    }
}
