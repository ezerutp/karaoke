package com.utp.karaoke.views.Panels;

import com.utp.karaoke.controllers.ConfiguracionController;
import com.utp.karaoke.entities.Configuracion;
import com.utp.karaoke.utils.EventoUtils;

public class PanelConfiguracion extends javax.swing.JPanel {

    private final ConfiguracionController controller;
    private Configuracion configuracion;

    public PanelConfiguracion() {
        initComponents();
        this.controller = new ConfiguracionController();
        EventoUtils.asignarEventoClick(btn_guardar, this::actualizarConfiguracion);
        cargarDatos();
    }

    private void actualizarConfiguracion() {
        Configuracion config = new Configuracion();
        config.setRuc(this.txt_ruc.getText());
        config.setNombre(this.txt_nombre1.getText());
        config.setTelefono(this.txt_telefono.getText());
        config.setDireccion(this.txt_direccion.getText());
        config.setMensaje(this.txt_message.getText());

        if (configuracion == null) {
            controller.registrarConfiguracion(config);
        } else {
            config.setId(configuracion.getId());
            controller.actualizarConfiguracion(config);
        }
    }

    private void cargarDatos() {
        configuracion = controller.obtenerConfiguracion();
        if (configuracion != null) {
            this.txt_ruc.setText(configuracion.getRuc());
            this.txt_nombre1.setText(configuracion.getNombre());
            this.txt_telefono.setText(configuracion.getTelefono());
            this.txt_direccion.setText(configuracion.getDireccion());
            this.txt_message.setText(configuracion.getMensaje());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_contenedor = new javax.swing.JPanel();
        lbl_icono = new javax.swing.JLabel();
        lbl_text = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JTextField();
        txt_ruc = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_message = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(970, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_contenedor.setOpaque(false);
        pnl_contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconBusiness.png"))); // NOI18N
        pnl_contenedor.add(lbl_icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 15, -1, -1));

        lbl_text.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_text.setForeground(new java.awt.Color(255, 255, 255));
        lbl_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_text.setText("Configuración de la empresa");
        lbl_text.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnl_contenedor.add(lbl_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 156, 900, 30));

        txt_nombre1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nombre1.setBorder(null);
        pnl_contenedor.add(txt_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 263, 570, 36));

        txt_ruc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_ruc.setBorder(null);
        pnl_contenedor.add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 316, 206, 36));

        txt_telefono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_telefono.setBorder(null);
        pnl_contenedor.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 316, 206, 36));

        txt_direccion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_direccion.setBorder(null);
        pnl_contenedor.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 369, 570, 36));

        txt_message.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_message.setBorder(null);
        pnl_contenedor.add(txt_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 422, 570, 36));

        btn_guardar.setBorder(null);
        btn_guardar.setContentAreaFilled(false);
        pnl_contenedor.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 487, 230, 36));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaFormularioConfiguracion.png"))); // NOI18N
        pnl_contenedor.add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 350));

        add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 12, 900, 610));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_icono;
    private javax.swing.JLabel lbl_text;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_message;
    private javax.swing.JTextField txt_nombre1;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
