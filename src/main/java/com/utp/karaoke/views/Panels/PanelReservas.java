package com.utp.karaoke.views.Panels;

import com.utp.karaoke.views.Cards.CardReserva;

import com.utp.karaoke.utils.EnumKaraoke;

public class PanelReservas extends javax.swing.JPanel {

    public PanelReservas() {
        initComponents();
        //Ejemplo simple jijijijji
        CardReserva cr = new CardReserva("01", EnumKaraoke.EstadoReserva.LIBRE);
        pnl_contenedor.add(cr);
        CardReserva cr2 = new CardReserva("02", EnumKaraoke.EstadoReserva.OCUPADA);
        pnl_contenedor.add(cr2);
        CardReserva cr3 = new CardReserva("03", EnumKaraoke.EstadoReserva.RESERVADO);
        pnl_contenedor.add(cr3);
        CardReserva cr4 = new CardReserva("04", EnumKaraoke.EstadoReserva.LIBRE);
        pnl_contenedor.add(cr4);
        CardReserva cr5 = new CardReserva("05", EnumKaraoke.EstadoReserva.OCUPADA);
        pnl_contenedor.add(cr5);
        CardReserva cr6 = new CardReserva("06", EnumKaraoke.EstadoReserva.RESERVADO);
        pnl_contenedor.add(cr6);
        CardReserva cr7 = new CardReserva("07", EnumKaraoke.EstadoReserva.LIBRE);
        pnl_contenedor.add(cr7);
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
