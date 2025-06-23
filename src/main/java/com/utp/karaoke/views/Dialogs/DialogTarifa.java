package com.utp.karaoke.views.Dialogs;

import com.utp.karaoke.controllers.TarifaController;
import com.utp.karaoke.entities.Tarifa;
import com.utp.karaoke.utils.EventoUtils;

public class DialogTarifa extends DialogoSinBordes{

    TarifaController controller = new TarifaController();
    Tarifa tarifa;

    public DialogTarifa(java.awt.Frame parent, boolean modal, Tarifa tarifa) {
        super(parent, modal);
        initComponents();
        this.tarifa = tarifa;
        cargarDatos(tarifa);

        EventoUtils.validarNumero(txt_precio);
        EventoUtils.asignarEventoClick(lbl_close, this::dispose);
        EventoUtils.asignarEventoClick(btn_registrar, this::actualizarTarifa);
    }

    private void cargarDatos(Tarifa tarifa) {
        if (tarifa != null) {
            this.txt_nombre.setText(tarifa.getNombre());
            this.txt_precio.setText(tarifa.getPrecio() + "");
        }
    }

    private void actualizarTarifa() {
        String nombre = txt_nombre.getText();
        double precio = Double.parseDouble(txt_precio.getText());

        tarifa.setNombre(nombre);
        tarifa.setPrecio(precio);
        if (controller.actualizarTarifa(tarifa)) {
            this.dispose(); // Cerrar el diálogo si el registro fue exitoso
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_close = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        btn_registrar = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconSalir.png"))); // NOI18N
        jPanel1.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_nombre.setBorder(null);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 92, 480, 36));

        txt_precio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_precio.setBorder(null);
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 145, 200, 36));

        btn_registrar.setBorder(null);
        btn_registrar.setContentAreaFilled(false);
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 144, 240, 40));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaDialogtarifa.png"))); // NOI18N
        jPanel1.add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
