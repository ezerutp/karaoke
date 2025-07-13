package com.utp.karaoke.views.Panels;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.utp.karaoke.AbstracTablas.ClienteTabla;
import com.utp.karaoke.controllers.ClienteController;
import com.utp.karaoke.entities.Cliente;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.PopUpTabla;
import com.utp.karaoke.views.Dialogs.DialogCliente;

public class PanelClientes extends javax.swing.JPanel {

    private final ClienteController controller;
    private List<Cliente> clientes;

    public PanelClientes() {
        initComponents();
        SwingUtilities.invokeLater(() -> btn_registrar.requestFocusInWindow());
        this.controller = new ClienteController();
        EventoUtils.asignarEventoClick(btn_registrar, this::registrarCliente);
        aplicarPlaceholder();
        // Cargar la tabla de usuarios al iniciar
        cargarTabla();
        addPopupMenu();
    }

    private void aplicarPlaceholder() {
        EventoUtils.aplicarPlaceholder(txt_correo, "Correo electrónico");
        EventoUtils.aplicarPlaceholder(txt_nombre, "Nombre completo");
        EventoUtils.aplicarPlaceholder(txt_telefono, "Teléfono");
        EventoUtils.aplicarPlaceholder(txt_dni, "DNI");
        EventoUtils.validarNumeroEntero(txt_telefono);
        EventoUtils.validarNumeroEntero(txt_dni);
    }

    private void registrarCliente() {
        Cliente user = new Cliente();
        user.setNombre(this.txt_nombre.getText());
        user.setCorreo(this.txt_correo.getText());
        user.setTelefono(this.txt_telefono.getText());
        user.setDni(this.txt_dni.getText());
        if (controller.registrarCliente(user)) {
            aplicarPlaceholder();
            this.cargarTabla();
        }
    }

    private void cargarTabla() {
        this.clientes = controller.obtenerClientes();
        this.tbl_Usuarios.setModel(new ClienteTabla(clientes));
    }

    private void addPopupMenu() {
        PopUpTabla.addPopupMenu(
                tbl_Usuarios,
                3,
                controller::obtenerClientePorDni,
                cliente -> {
                    DialogCliente dialog = new DialogCliente(null, true, cliente);
                    dialog.setVisible(true);
                    cargarTabla();
                },
                cliente -> {
                    int confirmacion = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de que deseas eliminar al cliente " + cliente.getNombre() + "?",
                            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        controller.eliminarCliente(cliente.getId());
                        cargarTabla();
                    }
                }, fila -> ((ClienteTabla) tbl_Usuarios.getModel()).removeRow(fila), this::cargarTabla);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_contenedor = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
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

        txt_telefono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_telefono.setBorder(null);
        pnl_contenedor.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 143, 200, 36));

        txt_dni.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_dni.setBorder(null);
        pnl_contenedor.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 143, 200, 36));

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

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaFormuarioRegistraCliente.png"))); // NOI18N
        pnl_contenedor.add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 12, 900, 610));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JTable tbl_Usuarios;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
