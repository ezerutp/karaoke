package com.utp.karaoke.views.Dialogs;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import com.utp.karaoke.controllers.ClienteController;
import com.utp.karaoke.controllers.ReservaController;
import com.utp.karaoke.entities.Cliente;
import com.utp.karaoke.entities.Reserva;
import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.utils.EnumKaraoke.EstadoReserva;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.SessionLogin;

public class DialogReservar extends DialogoSinBordes{
    private ClienteController clienteController = new ClienteController();
    private final ReservaController reservaController = new ReservaController();
    private Sala box;
    private Consumer<Double> timer;
    private Consumer<Reserva> actualizarReserva;

    public DialogReservar(java.awt.Frame parent, boolean modal, Sala box, Consumer<Double> timer, Consumer<Reserva> actualizarReserva) {
        super(parent, modal);
        initComponents();
        EventoUtils.asignarEventoClick(btn_reserva, this::realizarReserva);
        EventoUtils.asignarEventoClick(lbl_close, this::dispose);
        fillComboClientes();
        this.box = box;
        this.timer = timer;
        EventoUtils.validarNumeroDecimal(txt_tiempo);
        this.actualizarReserva = actualizarReserva;
        this.txt_tarifa.setText(box.getTarifa().toString());
    }

    private void fillComboClientes() {
        List<Cliente> clientes = clienteController.obtenerClientes();
        EventoUtils.cargarComboBoxDesdeLista(cbx_cliente, clientes);
    }

    private void realizarReserva() {
        Reserva reserva = new Reserva();
        reserva.setCliente((Cliente) cbx_cliente.getSelectedItem());
        reserva.setSala(box);
        reserva.setUsuario(SessionLogin.getInstance().getUsuario());
        reserva.setTotal(Double.parseDouble(txt_tiempo.getText()));
        reserva.setEstado(EstadoReserva.OCUPADA);
        reserva.setFecha(new Date());
        reservaController.crearReserva(reserva);
        timer.accept(reserva.getTotal());
        actualizarReserva.accept(reserva);
        this.dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbx_cliente = new javax.swing.JComboBox<>();
        txt_tiempo = new javax.swing.JTextField();
        txt_tarifa = new javax.swing.JTextField();
        btn_reserva = new javax.swing.JButton();
        lbl_close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(cbx_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 90, 513, 41));

        txt_tiempo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_tiempo.setBorder(null);
        jPanel1.add(txt_tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 145, 90, 36));

        txt_tarifa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_tarifa.setBorder(null);
        txt_tarifa.setEnabled(false);
        jPanel1.add(txt_tarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 145, 260, 36));

        btn_reserva.setText("                  ");
        btn_reserva.setBorderPainted(false);
        btn_reserva.setContentAreaFilled(false);
        jPanel1.add(btn_reserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 200, 240, 40));

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconSalir.png"))); // NOI18N
        jPanel1.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaDialogoReserva.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reserva;
    private javax.swing.JComboBox<Cliente> cbx_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JTextField txt_tarifa;
    private javax.swing.JTextField txt_tiempo;
    // End of variables declaration//GEN-END:variables

}
