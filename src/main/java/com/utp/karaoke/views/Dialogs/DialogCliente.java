package com.utp.karaoke.views.Dialogs;

import com.utp.karaoke.controllers.ClienteController;
import com.utp.karaoke.entities.Cliente;
import com.utp.karaoke.utils.EventoUtils;

public class DialogCliente extends DialogoSinBordes{

    ClienteController clienteController = new ClienteController();
    Cliente cliente;

    public DialogCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
        cargarDatos(cliente);

        EventoUtils.asignarEventoClick(lbl_close, this::dispose);
        EventoUtils.asignarEventoClick(btn_registrar, this::actualizarCliente);
    }

    private void cargarDatos(Cliente cliente) {
        if (cliente != null) {
            this.txt_nombre.setText(cliente.getNombre());
            this.txt_correo.setText(cliente.getCorreo());
            this.txt_telefono.setText(cliente.getTelefono());
            this.txt_dni.setText(cliente.getDni());
        }
    }

    private void actualizarCliente() {
        String nombre = txt_nombre.getText();
        String correo = txt_correo.getText();
        String telefono = txt_telefono.getText();
        String dni = txt_dni.getText();

        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setDni(dni);

        if (clienteController.actualizarCliente(cliente)) {
            this.dispose(); // Cerrar el diálogo si el registro fue exitoso
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        btn_registrar = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconSalir.png"))); // NOI18N
        jPanel1.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nombre.setBorder(null);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 92, 480, 36));

        txt_correo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_correo.setBorder(null);
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 145, 480, 36));

        txt_telefono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_telefono.setBorder(null);
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 197, 160, 36));

        txt_dni.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_dni.setBorder(null);
        jPanel1.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 197, 160, 36));

        btn_registrar.setBorder(null);
        btn_registrar.setContentAreaFilled(false);
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 248, 240, 36));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaDialogcliente.png"))); // NOI18N
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
