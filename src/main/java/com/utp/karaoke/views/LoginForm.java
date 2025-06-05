package com.utp.karaoke.views;

import javax.swing.SwingUtilities;

import com.utp.karaoke.controllers.LoginController;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.SessionLogin;

public class LoginForm extends VentanaSinBordes {

    public LoginForm() {
        initComponents();
        SwingUtilities.invokeLater(() -> Lbl_salir.requestFocusInWindow());
        EventoUtils.asignarEventoClick(Lbl_salir, () -> {
            this.dispose();
        });
        EventoUtils.asignarEventoClick(btn_Login, this::login);
        EventoUtils.asignarEventoEnter(txt_password, this::login);
        EventoUtils.aplicarPlaceholder(txt_correo, "Correo electrónico");
        EventoUtils.aplicarPlaceholder(txt_password, "Contraseña");
    }

    private void login() {
        String correo = txt_correo.getText();
        String password = new String(txt_password.getPassword());
        LoginController controller = new LoginController();
        SessionLogin session = controller.validarCredenciales(correo, password);
        if (session != null) {
            MainPanel mainPanel = new MainPanel();
            mainPanel.setVisible(true);
            this.dispose();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_background = new javax.swing.JPanel();
        btn_Login = new javax.swing.JButton();
        txt_correo = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        Lbl_salir = new javax.swing.JLabel();
        Lbl_login = new javax.swing.JLabel();
        Lbl_logo = new javax.swing.JLabel();
        Lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pnl_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Login.setBorder(null);
        btn_Login.setBorderPainted(false);
        btn_Login.setContentAreaFilled(false);
        Pnl_background.add(btn_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 433, 230, 40));

        txt_correo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_correo.setBorder(null);
        Pnl_background.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 317, 216, 30));

        txt_password.setBorder(null);
        Pnl_background.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 369, 216, 30));

        Lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconSalir.png"))); // NOI18N
        Pnl_background.add(Lbl_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        Lbl_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        Pnl_background.add(Lbl_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 270, -1, -1));

        Lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        Pnl_background.add(Lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, 210));

        Lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo2.png"))); // NOI18N
        Lbl_background.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_background.add(Lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Pnl_background, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Pnl_background, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_background;
    private javax.swing.JLabel Lbl_login;
    private javax.swing.JLabel Lbl_logo;
    private javax.swing.JLabel Lbl_salir;
    private javax.swing.JPanel Pnl_background;
    private javax.swing.JButton btn_Login;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
