package com.utp.karaoke.views;

import java.awt.CardLayout;
import java.util.List;

import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.SessionLogin;
import com.utp.karaoke.views.Buttons.ButtonPanelMenu;
import com.utp.karaoke.views.Buttons.ButtonsFactory;
import com.utp.karaoke.views.Buttons.ButtonsFactory.ButtonConfig;
import com.utp.karaoke.views.Buttons.ButtonsMenu;
import com.utp.karaoke.views.Panels.PanelConfiguracion;
import com.utp.karaoke.views.Panels.PanelReservas;
import com.utp.karaoke.views.Panels.PanelTarifas;
import com.utp.karaoke.views.Panels.PanelUsuario;

public class MainPanel extends VentanaSinBordes {

    private CardLayout cl;

    public MainPanel() {
        initComponents();
        cl = (CardLayout) pnl_contenedor.getLayout();
        EventoUtils.asignarEventoClick(lbl_close, () -> {
            System.exit(0);
        });

        pnl_contenedor.setVisible(true);
        cargarPaneles();
        cargarInformacionUsuario();
    }

    private void cargarInformacionUsuario() {
        lbl_nombre.setText(SessionLogin.getInstance().getUsuario().getNombre());
        lbl_correo.setText(SessionLogin.getInstance().getUsuario().getCorreo());
    }

    private void cargarPaneles(){
        PanelReservas panelReservas = new PanelReservas();
        PanelTarifas panelTarifas = new PanelTarifas();
        PanelUsuario panelUsuario = new PanelUsuario();
        PanelConfiguracion panelConfiguracion = new PanelConfiguracion();

        pnl_contenedor.add(panelReservas, "Reservas");
        pnl_contenedor.add(panelTarifas, "Tarifas");
        pnl_contenedor.add(panelConfiguracion, "Configuracion");
        pnl_contenedor.add(panelUsuario, "Usuarios");

        List<ButtonConfig> lista = List.of(
            new ButtonConfig("Reservas", "/images/iconReserva.png", () -> cl.show(pnl_contenedor, "Reservas")),
            new ButtonConfig("Tarifas", "/images/iconTarifa.png", () -> cl.show(pnl_contenedor, "Tarifas")),
            new ButtonConfig("Boxes", "/images/iconBoxes.png", () -> cl.show(pnl_contenedor, "Reservas")),
            new ButtonConfig("Configuracion", "/images/iconConfiguracion.png", () -> cl.show(pnl_contenedor, "Configuracion")),
            new ButtonConfig("Usuarios", "/images/iconUsuarios.png", () -> cl.show(pnl_contenedor, "Usuarios"))
        );

        List<ButtonsMenu> botones = ButtonsFactory.createMenuButtons(lista);
        ButtonPanelMenu.addButtons(botones, pnl_botones, 10);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_background = new javax.swing.JPanel();
        pnl_contenedor = new javax.swing.JPanel();
        pnl_menu = new javax.swing.JPanel();
        pnl_botones = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_background_name = new javax.swing.JLabel();
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
        pnl_menu.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nombre.setText("Username");
        pnl_menu.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 32, -1, -1));

        lbl_correo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_correo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_correo.setText("Correo electronico");
        pnl_menu.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        lbl_background_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaMainName.png"))); // NOI18N
        lbl_background_name.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnl_menu.add(lbl_background_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 30, 188, 46));

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
    private javax.swing.JLabel lbl_background_name;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JPanel pnl_botones;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JPanel pnl_menu;
    // End of variables declaration//GEN-END:variables
}
