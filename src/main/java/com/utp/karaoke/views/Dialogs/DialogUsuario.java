package com.utp.karaoke.views.Dialogs;

import com.utp.karaoke.controllers.UsuarioController;
import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.utils.EnumKaraoke.RolUsuario;
import com.utp.karaoke.utils.EventoUtils;

public class DialogUsuario extends DialogoSinBordes{

    UsuarioController usuarioController = new UsuarioController();
    Usuario usuario;

    public DialogUsuario(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        this.usuario = usuario;
        cargarDatos(usuario);

        EventoUtils.asignarEventoClick(lbl_close, this::dispose);
        EventoUtils.asignarEventoClick(btn_registrar, this::actualizarUsuario);
    }

    private void cargarDatos(Usuario usuario) {
        if (usuario != null) {
            this.txt_nombre.setText(usuario.getNombre());
            this.txt_correo.setText(usuario.getCorreo());
            this.txt_password.setText(usuario.getPass());
            this.cbx_rol.setSelectedItem(usuario.getRol().toString());
        }
    }

    private void actualizarUsuario() {
        String nombre = txt_nombre.getText();
        String correo = txt_correo.getText();
        String password = new String(txt_password.getPassword());
        String rol = (String) cbx_rol.getSelectedItem();

        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setPass(password);
        usuario.setRol((RolUsuario.valueOf(rol)));

        if (usuarioController.actualizarUsuario(usuario)) {
            this.dispose(); // Cerrar el diálogo si el registro fue exitoso
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        cbx_rol = new javax.swing.JComboBox<>();
        btn_registrar = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(731, 308));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconSalir.png"))); // NOI18N
        jPanel1.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nombre.setBorder(null);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 92, 480, 36));

        txt_correo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_correo.setBorder(null);
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 145, 480, 36));

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_password.setBorder(null);
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 197, 160, 36));

        cbx_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "RECEPCIONISTA", "CLIENTE" }));
        cbx_rol.setFocusable(false);
        cbx_rol.setOpaque(true);
        jPanel1.add(cbx_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 194, 242, 40));

        btn_registrar.setBorder(null);
        btn_registrar.setContentAreaFilled(false);
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 248, 240, 36));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaDialogusuarios.png"))); // NOI18N
        jPanel1.add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JComboBox<String> cbx_rol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
