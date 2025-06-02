package com.utp.karaoke.views;

import java.util.List;

import com.utp.karaoke.utils.Botones;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.SessionLogin;
import com.utp.karaoke.views.Buttons.ButtonPanelMenu;
import com.utp.karaoke.views.Buttons.ButtonsFactory;
import com.utp.karaoke.views.Buttons.ButtonsMenu;
import com.utp.karaoke.views.Panels.PanelUsuario;

public class MainPanel extends VentanaSinBordes {
    private SessionLogin sessionLogin;

    public MainPanel() {
        this.sessionLogin = SessionLogin.getInstance();
        initComponents();

        EventoUtils.asignarEventoClick(lbl_close, () -> {
            System.exit(0);
        });

        List<ButtonsMenu> botones = ButtonsFactory.createMenuButtons(Botones.lista);
        ButtonPanelMenu.addButtons(botones, pnl_botones, 10);

        PanelUsuario panelUsuario = new PanelUsuario();
        pnl_contenedor.add(panelUsuario, "PanelUsuario");
        pnl_contenedor.setVisible(true);

        ((java.awt.CardLayout) pnl_contenedor.getLayout()).show(pnl_contenedor, "PanelUsuario");

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_background = new javax.swing.JPanel();
        pnl_contenedor = new javax.swing.JPanel();
        pnl_menu = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        Lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pnl_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_contenedor.setOpaque(false);
        pnl_contenedor.setLayout(new java.awt.CardLayout());
        Pnl_background.add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 940, 630));

        pnl_menu.setBackground(new java.awt.Color(34, 30, 54));
        pnl_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_botones.setBackground(new java.awt.Color(34, 30, 54));
        pnl_botones.setLayout(new javax.swing.BoxLayout(pnl_botones, javax.swing.BoxLayout.Y_AXIS));
        pnl_menu.add(pnl_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 275, 220, 380));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logotitulo.png"))); // NOI18N
        pnl_menu.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, -1, -1));

        Pnl_background.add(pnl_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 670));

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconSalir.png"))); // NOI18N
        Pnl_background.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, -1, -1));

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
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JPanel pnl_menu;
    // End of variables declaration//GEN-END:variables
}
