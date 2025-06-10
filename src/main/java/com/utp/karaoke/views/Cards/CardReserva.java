package com.utp.karaoke.views.Cards;

import com.utp.karaoke.utils.EnumKaraoke.EstadoReserva;

public class CardReserva extends javax.swing.JPanel {
    private String boxNumber;
    private EstadoReserva status;

    public CardReserva(String boxNumber, EstadoReserva status) {
        this.boxNumber = boxNumber;
        this.status = status;
        initComponents();
        loadData();
    }

    private void loadData() {
        lbl_number.setText(boxNumber);
        switch (status) {
            case LIBRE:
                lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReservaLibre.png")));
                btn_accion.setText("LIBRE");
                break;
            case OCUPADA:
                lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReservaOcupada.png")));
                btn_accion.setText("OCUPADA");
                break;
            case RESERVADO:
                lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReservaReservado.png"))); 
                btn_accion.setText("RESERVADO");
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titulo = new javax.swing.JLabel();
        lbl_number = new javax.swing.JLabel();
        btn_accion = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(128, 128));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("BOX");
        add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 108, -1));

        lbl_number.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbl_number.setForeground(new java.awt.Color(255, 255, 255));
        lbl_number.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_number.setText("--");
        add(lbl_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 108, -1));

        btn_accion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_accion.setForeground(new java.awt.Color(255, 255, 255));
        btn_accion.setText("---");
        btn_accion.setBorder(null);
        btn_accion.setContentAreaFilled(false);
        add(btn_accion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 108, 29));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReserva.png"))); // NOI18N
        add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 108, 108));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accion;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_number;
    private javax.swing.JLabel lbl_titulo;
    // End of variables declaration//GEN-END:variables
}
