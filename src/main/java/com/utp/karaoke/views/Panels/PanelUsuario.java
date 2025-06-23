package com.utp.karaoke.views.Panels;

import java.util.List;

import com.utp.karaoke.AbstracTablas.UsuariosTabla;
import com.utp.karaoke.controllers.UsuarioController;
import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.EnumKaraoke.RolUsuario;
import com.utp.karaoke.views.Dialogs.DialogUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class PanelUsuario extends javax.swing.JPanel {

    private final UsuarioController controller;
    private List<Usuario> usuarios;

    // Popup menu para la tabla
    private JPopupMenu popupMenu;
    private JMenuItem menuItemEditar;
    private JMenuItem menuItemEliminar;

    public PanelUsuario() {
        initComponents();
        SwingUtilities.invokeLater(() -> btn_registrar.requestFocusInWindow());
        this.controller = new UsuarioController();
        this.cbx_rol.setBackground(Color.WHITE); // Fondo blanco
        this.cbx_rol.setForeground(Color.BLACK); // Letras negras
        this.cbx_rol.setFont(new Font("Arial", Font.PLAIN, 14));
        this.cbx_rol.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        EventoUtils.asignarEventoClick(btn_registrar, this::registrarUsuario);
        aplicarPlaceholder();
        // Cargar la tabla de usuarios al iniciar
        cargarTabla();
        addPopupMenu();
    }

    private void aplicarPlaceholder() {
        EventoUtils.aplicarPlaceholder(txt_correo, "Correo electrónico");
        EventoUtils.aplicarPlaceholder(txt_nombre, "Nombre completo");
        EventoUtils.aplicarPlaceholder(txt_password, "Contraseña");
    }

    private void registrarUsuario() {
        Usuario user = new Usuario();
        user.setNombre(this.txt_nombre.getText());
        user.setCorreo(this.txt_correo.getText());
        user.setPass(new String(this.txt_password.getPassword()));
        user.setRol(RolUsuario.valueOf((String) this.cbx_rol.getSelectedItem()));

        if (controller.registrarUsuario(user)) {
            aplicarPlaceholder();
            this.cargarTabla();
        }
    }

    private void cargarTabla() {
        this.usuarios = controller.obtenerUsuarios();
        this.tbl_Usuarios.setModel(new UsuariosTabla(usuarios));
    }

    private void addPopupMenu() {
        popupMenu = new JPopupMenu();
        menuItemEditar = new JMenuItem("Editar");
        menuItemEliminar = new JMenuItem("Eliminar");
        popupMenu.add(menuItemEditar);
        popupMenu.add(menuItemEliminar);

        // Agregar el listener a la tabla
        tbl_Usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mostrarMenu(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mostrarMenu(e);
            }

            private void mostrarMenu(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int fila = tbl_Usuarios.rowAtPoint(e.getPoint());
                    if (fila >= 0 && fila < tbl_Usuarios.getRowCount()) {
                        tbl_Usuarios.setRowSelectionInterval(fila, fila);
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

        // Acción de editar
        menuItemEditar.addActionListener(evt -> {
            int fila = tbl_Usuarios.getSelectedRow();
            if (fila != -1) {
                String correo = (String) tbl_Usuarios.getValueAt(fila, 1); // Cambia el índice si no es la columna
                Usuario usuario = controller.obtenerUsuarioPorCorreo(correo);
                if (usuario != null) {
                    DialogUsuario dialog = new DialogUsuario(null, true, usuario);
                    dialog.setVisible(true);
                    cargarTabla();
                }
            }
        });

        // Acción de eliminar
        menuItemEliminar.addActionListener(evt -> {
            int fila = tbl_Usuarios.getSelectedRow();
            if (fila != -1) {
                String correo = (String) tbl_Usuarios.getValueAt(fila, 1); // Cambia el índice si no es la columna
                Usuario usuario = controller.obtenerUsuarioPorCorreo(correo);
                if (usuario != null) {
                    // confirmar la eliminación
                    int confirmacion = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de que deseas eliminar al usuario " + usuario.getNombre() + "?",
                            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion != JOptionPane.YES_OPTION) {
                        return; // Si el usuario no confirma, no se elimina
                    }
                    controller.eliminarUsuario(usuario.getId());
                }
                ((UsuariosTabla) tbl_Usuarios.getModel()).removeRow(fila);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
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

        cbx_rol.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "RECEPCIONISTA", "CLIENTE" }));
        cbx_rol.setFocusable(false);
        cbx_rol.setOpaque(true);
        pnl_contenedor.add(cbx_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 141, 240, 40));

        btn_registrar.setBorder(null);
        btn_registrar.setContentAreaFilled(false);
        pnl_contenedor.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 195, 230, 36));

        tbl_Usuarios.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        tbl_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        tbl_Usuarios.setRowHeight(30);
        tbl_Usuarios.setRowMargin(2);
        jScrollPane1.setViewportView(tbl_Usuarios);

        pnl_contenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 900, 320));

        lbl_background.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/images/figmaFormuarioRegistrarUsuario.png"))); // NOI18N
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
