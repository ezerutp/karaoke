package com.utp.karaoke.views.Panels;

import java.util.List;

import com.utp.karaoke.AbstracTablas.UsuariosTabla;
import com.utp.karaoke.controllers.UsuarioController;
import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.EnumKaraoke.RolUsuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

public class PanelUsuario extends javax.swing.JPanel {

    private final UsuarioController controller;
    private List<Usuario> usuarios;

    public PanelUsuario() {
        initComponents();
        this.controller = new UsuarioController();
        this.cbx_rol.setBackground(Color.WHITE);              // Fondo blanco
        this.cbx_rol.setForeground(Color.BLACK);              // Letras negras
        this.cbx_rol.setFont(new Font("Arial", Font.PLAIN, 14));
        this.cbx_rol.setBorder(BorderFactory.createLineBorder(Color.WHITE));
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
        this.tbl_Usuarios.setModel(new UsuariosTabla(usuarios));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_contenedor = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        cbx_rol = new javax.swing.JComboBox<>();
        btn_registrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Usuarios = new javax.swing.JTable();
        lbl_background = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(970, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_contenedor.setOpaque(false);
        pnl_contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nombre.setBorder(null);
        pnl_contenedor.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 39, 570, 36));

        txt_correo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_correo.setBorder(null);
        pnl_contenedor.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 91, 570, 36));

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_password.setBorder(null);
        pnl_contenedor.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 143, 210, 36));

        cbx_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "RECEPCIONISTA", "CLIENTE" }));
        cbx_rol.setFocusable(false);
        cbx_rol.setOpaque(true);
        pnl_contenedor.add(cbx_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 141, 240, 40));

        btn_registrar.setBorder(null);
        btn_registrar.setContentAreaFilled(false);
        pnl_contenedor.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 195, 230, 36));

        tbl_Usuarios.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        tbl_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Usuarios.setRowHeight(30);
        tbl_Usuarios.setRowMargin(2);
        jScrollPane1.setViewportView(tbl_Usuarios);

        pnl_contenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 900, 320));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaFormuarioRegistrarUsuario.png"))); // NOI18N
        pnl_contenedor.add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 12, 900, 610));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JComboBox<String> cbx_rol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JTable tbl_Usuarios;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
