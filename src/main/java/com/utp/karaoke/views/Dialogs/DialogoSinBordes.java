package com.utp.karaoke.views.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class DialogoSinBordes extends JDialog {

    private Point mouseClickPoint;

    public DialogoSinBordes(Frame owner, boolean modal) {
        super(owner, modal);
        setUndecorated(true);
        getContentPane().setBackground(new Color(65, 50, 100));
        setLocationRelativeTo(owner);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
            }
        });
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

        habilitarArrastre();
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
        SwingUtilities.invokeLater(() -> {
            DialogoSinBordes dialogo = new DialogoSinBordes(null, true);
            dialogo.setSize(400, 300);
            dialogo.setVisible(true);
        });
    }
}
