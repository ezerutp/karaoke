package com.utp.karaoke.views.Panels;

import java.util.List;

import com.utp.karaoke.controllers.BoxesController;
import com.utp.karaoke.entities.Reserva;
import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.views.Cards.CardReserva;

public class PanelReservas extends javax.swing.JPanel {
    private final BoxesController boxesController =  new BoxesController();
    private List<Sala> boxes;

    public PanelReservas() {
        initComponents();
        cargarReservas();
    }

    private void cargarReservas() {
        boxes = boxesController.obtenerSalas();

        pnl_contenedor.removeAll();
        for (Sala sala : boxes) {
            Reserva reserva = boxesController.obtenerReservaPorSala(sala);
            CardReserva cardReserva = new CardReserva(sala, reserva);
            pnl_contenedor.add(cardReserva);
        }
        pnl_contenedor.revalidate();
        pnl_contenedor.repaint();
    }

    /**
     * Método público para actualizar los datos del panel
     */
    public void actualizarDatos() {
        cargarReservas();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_contenedor = new javax.swing.JPanel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(970, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_contenedor.setOpaque(false);
        pnl_contenedor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 112, 830, 500));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnl_contenedor;
    // End of variables declaration//GEN-END:variables
}
