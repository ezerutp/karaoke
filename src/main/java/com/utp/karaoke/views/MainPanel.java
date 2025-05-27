package com.utp.karaoke.views;

import com.utp.karaoke.utils.SessionLogin;
import com.utp.karaoke.views.Buttons.ButtonsMenu;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MainPanel extends VentanaSinBordes {
    private SessionLogin sessionLogin;

    public MainPanel() {
        this.sessionLogin = SessionLogin.getInstance();
        initComponents();
        
        Icon iconoMicrofono = new ImageIcon(getClass().getResource("/images/iconReserva.png"));
        ButtonsMenu boton = new ButtonsMenu("Reserva", iconoMicrofono);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        Icon iconoTarifa = new ImageIcon(getClass().getResource("/images/iconTarifa.png"));
        ButtonsMenu boton2 = new ButtonsMenu("Tarifa", iconoTarifa);
        boton2.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        pnl_botones.add(boton);
        pnl_botones.add(boton2);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_background = new javax.swing.JPanel();
        pnl_menu = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        Lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pnl_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_menu.setBackground(new java.awt.Color(34, 30, 54));
        pnl_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_botones.setBackground(new java.awt.Color(34, 30, 54));
        pnl_menu.add(pnl_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 205, 220, 450));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logotitulo.png"))); // NOI18N
        pnl_menu.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, -1, -1));

        Pnl_background.add(pnl_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 670));

        Lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoMain.png"))); // NOI18N
        Pnl_background.add(Lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_background;
    private javax.swing.JPanel Pnl_background;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_menu;
    // End of variables declaration//GEN-END:variables
}
