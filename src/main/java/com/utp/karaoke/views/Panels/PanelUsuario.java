package com.utp.karaoke.views.Panels;

import java.util.List;

import com.utp.karaoke.AbstracTablas.UsuariosTabla;
import com.utp.karaoke.controllers.UsuarioController;
import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.EnumKaraoke.RolUsuario;

public class PanelUsuario extends javax.swing.JPanel {
    private final UsuarioController controller;
    private List<Usuario> usuarios;

    public PanelUsuario() {
        initComponents();
        this.controller = new UsuarioController();
        EventoUtils.asignarEventoClick(btn_registrar, this::registrarUsuario);

        cargarTabla();
    }

    private void registrarUsuario() {
        Usuario user = new Usuario();
        user.setNombre(this.txt_nombre.getText());
        user.setCorreo(this.txt_correo.getText());
        user.setPass(new String(this.txt_password.getPassword()));
        user.setRol(RolUsuario.valueOf((String) this.cbx_rol.getSelectedItem()));
        if (controller.registrarUsuario(user)) {
            // Limpiar campos
            this.txt_nombre.setText("");
            this.txt_correo.setText("");
            this.txt_password.setText("");
            this.cargarTabla();
        }
    }
    
    private void cargarTabla() {
        this.usuarios = controller.obtenerUsuarios();
        this.jTable1.setModel(new UsuariosTabla(usuarios));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnl_contenedor = new javax.swing.JPanel();
        btn_registrar = new javax.swing.JButton();
        cbx_rol = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        tg_rol = new javax.swing.JLabel();
        tg_correo = new javax.swing.JLabel();
        tg_nombre = new javax.swing.JLabel();
        tg_password = new javax.swing.JLabel();
        lbl_background = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(970, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 440, 40));

        pnl_contenedor.setOpaque(false);
        pnl_contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_registrar.setBorder(null);
        btn_registrar.setBorderPainted(false);
        btn_registrar.setContentAreaFilled(false);
        pnl_contenedor.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 200, 50));

        cbx_rol.setBackground(new java.awt.Color(41, 20, 64));
        cbx_rol.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbx_rol.setForeground(new java.awt.Color(255, 255, 255));
        cbx_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "RECEPCIONISTA", "CLIENTE" }));
        cbx_rol.setBorder(null);
        cbx_rol.setFocusable(false);
        cbx_rol.setOpaque(true);
        pnl_contenedor.add(cbx_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 155, 180, 48));

        txt_nombre.setBackground(new java.awt.Color(41, 20, 64));
        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setBorder(null);
        txt_nombre.setOpaque(true);
        pnl_contenedor.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 39, 460, 40));

        txt_correo.setBackground(new java.awt.Color(41, 20, 64));
        txt_correo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_correo.setForeground(new java.awt.Color(255, 255, 255));
        txt_correo.setBorder(null);
        txt_correo.setOpaque(true);
        pnl_contenedor.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 101, 460, 40));

        txt_password.setBackground(new java.awt.Color(41, 20, 64));
        txt_password.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        txt_password.setOpaque(true);
        pnl_contenedor.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 159, 210, 40));

        tg_rol.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tg_rol.setForeground(new java.awt.Color(255, 255, 255));
        tg_rol.setText("Rol");
        pnl_contenedor.add(tg_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 167, 30, 30));

        tg_correo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tg_correo.setForeground(new java.awt.Color(255, 255, 255));
        tg_correo.setText("Correo");
        pnl_contenedor.add(tg_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 105, 100, 30));

        tg_nombre.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tg_nombre.setForeground(new java.awt.Color(255, 255, 255));
        tg_nombre.setText("Nombre");
        pnl_contenedor.add(tg_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 43, 100, 30));

        tg_password.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tg_password.setForeground(new java.awt.Color(255, 255, 255));
        tg_password.setText("Contraseña");
        pnl_contenedor.add(tg_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 167, 100, 30));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/formUsuarios.png"))); // NOI18N
        pnl_contenedor.add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 16, -1, -1));

        add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 820, 280));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 840, 250));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JComboBox<String> cbx_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JLabel tg_correo;
    private javax.swing.JLabel tg_nombre;
    private javax.swing.JLabel tg_password;
    private javax.swing.JLabel tg_rol;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
