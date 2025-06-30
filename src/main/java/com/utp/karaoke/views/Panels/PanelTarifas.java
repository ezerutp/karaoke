package com.utp.karaoke.views.Panels;

import java.util.Date;

import javax.swing.JOptionPane;

import com.utp.karaoke.AbstracTablas.TarifaTabla;
import com.utp.karaoke.controllers.TarifaController;
import com.utp.karaoke.entities.Tarifa;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.PopUpTabla;

import com.utp.karaoke.views.Dialogs.DialogTarifa;

public class PanelTarifas extends javax.swing.JPanel {

    private final TarifaController controller;

    public PanelTarifas() {
        initComponents();
        this.controller = new TarifaController();
        EventoUtils.validarNumeroDecimal(this.txt_precio);
        EventoUtils.asignarEventoClick(jButton1, this::registrarTarifa);
        aplicarPlaceholder();
        cargarTabla();
        addPopupMenu();
    }

    private void aplicarPlaceholder() {
        EventoUtils.aplicarPlaceholder(this.txt_nombre, "Nombre de la tarifa");
        EventoUtils.aplicarPlaceholder(this.txt_precio, "Precio");
    }

    private void registrarTarifa() {
        Tarifa tarifa = new Tarifa();
        tarifa.setNombre(this.txt_nombre.getText());
        if (this.txt_precio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El precio no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tarifa.setPrecio(Double.parseDouble(this.txt_precio.getText()));
        tarifa.setFecha(new Date());
        if (controller.registrarTarifa(tarifa)) {
            aplicarPlaceholder();
            cargarTabla();
        }
    }

    private void cargarTabla() {
        tbl_Usuarios.setModel(new TarifaTabla(controller.obtenerTarifas()));
    }

    private void addPopupMenu() {
        PopUpTabla.addPopupMenu(
                tbl_Usuarios,
                0,
                controller::obtenerTarifaPorNombre,
                tarifa -> {
                    DialogTarifa dialog = new DialogTarifa(null, true, tarifa);
                    dialog.setVisible(true);
                    cargarTabla();
                },
                tarifa -> {
                    int confirmacion = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de que deseas eliminar la tarifa " + tarifa.getNombre() + "?",
                            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion != JOptionPane.YES_OPTION) {
                        return;
                    }
                    controller.eliminarTarifa(tarifa.getId());
                    cargarTabla();
                }, fila -> ((TarifaTabla) tbl_Usuarios.getModel()).removeRow(fila), this::cargarTabla);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_contenedor = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbl_header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Usuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(970, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_contenedor.setOpaque(false);
        pnl_contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nombre.setBorder(null);
        pnl_contenedor.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 113, 250, 36));

        txt_precio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_precio.setBorder(null);
        pnl_contenedor.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 113, 100, 36));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        pnl_contenedor.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 150, 40));

        lbl_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaTarifas.png"))); // NOI18N
        pnl_contenedor.add(lbl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 105, -1, -1));

        tbl_Usuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        tbl_Usuarios.setRowHeight(40);
        tbl_Usuarios.setRowMargin(2);
        jScrollPane1.setViewportView(tbl_Usuarios);

        pnl_contenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 840, 320));

        add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 900, 510));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaHeaderTarifa.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 531, 97));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JTable tbl_Usuarios;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
