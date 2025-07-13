package com.utp.karaoke.views.Cards;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.utp.karaoke.controllers.ReservaController;
import com.utp.karaoke.entities.Reserva;
import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.EnumKaraoke.EstadoReserva;
import com.utp.karaoke.views.Dialogs.DialogReservar;

public class CardReserva extends javax.swing.JPanel {
    private final ReservaController reservaController = new ReservaController();
    private Reserva reserva;
    private Sala box;
    private Timer timerReserva;

    public CardReserva(Sala box, Reserva reserva) {
        this.box = box;
        this.reserva = reserva;
        initComponents();
        EventoUtils.asignarEventoClick(lbl_number, this::mostrarInformacion);
        loadData();
    }

    private void actualizarDatos(Reserva reserva) {
        this.reserva = reserva;
        loadData();
    }

    private void loadData() {
        lbl_number.setText(box.getNombre());
        EstadoReserva status = (reserva != null) ? reserva.getEstado() : EstadoReserva.LIBRE;
        switch (status) {
            case LIBRE:
                lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReservaLibre.png")));
                btn_accion.setText("LIBRE");
                break;
            case OCUPADA:
                lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReservaOcupada.png")));
                btn_accion.setText("OCUPADA");
                break;
            case RESERVADO:
                lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReservaReservado.png"))); 
                btn_accion.setText("RESERVADO");
                break;
            default:
                break;
        }
    }

    private void mostrarInformacion() {
        String mensaje = String.format("Box: %s\nEstado: %s\nCliente: %s\nTiempo: %.2f minutos\nUsuario encargado: %s",
                box.getNombre(),
                reserva != null ? reserva.getEstado().toString() : "LIBRE",
                reserva != null && reserva.getCliente() != null ? reserva.getCliente().getNombre() : "N/A",
                reserva != null ? reserva.getTotal() : 0.0,
                reserva != null ? reserva.getUsuario().getNombre() : "N/A");
        JOptionPane.showMessageDialog(this, mensaje, "Información de Reserva", JOptionPane.INFORMATION_MESSAGE);
    }   

    public void iniciarTimerReserva(double minutos) {
        // Detener timer anterior si existe
        if (timerReserva != null && timerReserva.isRunning()) {
            timerReserva.stop();
        }
        
        int delay = (int)(minutos * 60 * 1000); // minutos a milisegundos
        timerReserva = new javax.swing.Timer(delay, e -> {
            JOptionPane.showMessageDialog(
                this,
                "¡El tiempo de la reserva ha terminado!",
                "Reserva finalizada",
                JOptionPane.INFORMATION_MESSAGE
            );
            // Limpiar la referencia del timer al finalizar
            timerReserva = null;
            reservaController.cancelarReserva(reserva.getId());
            reserva = null;
            loadData();
        });
        timerReserva.setRepeats(false);
        timerReserva.start();
    }

    private void registrarReserva() {
        DialogReservar dialog = new DialogReservar(null, true, box, this::iniciarTimerReserva, this::actualizarDatos);
        dialog.setVisible(true);
    }    
    
    private void cancelarReserva() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro que desea cancelar la reserva?",
            "Confirmar cancelación",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION && reserva != null) {
            // Detener el timer si está activo
            if (timerReserva != null && timerReserva.isRunning()) {
                timerReserva.stop();
                timerReserva = null;
            }
            reservaController.cancelarReserva(reserva.getId());
            reserva = null;
            loadData();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titulo = new javax.swing.JLabel();
        lbl_number = new javax.swing.JLabel();
        btn_accion = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(128, 128));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("BOX");
        add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 108, -1));

        lbl_number.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbl_number.setForeground(new java.awt.Color(255, 255, 255));
        lbl_number.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_number.setText("--");
        add(lbl_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 108, -1));

        btn_accion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_accion.setForeground(new java.awt.Color(255, 255, 255));
        btn_accion.setText("---");
        btn_accion.setBorder(null);
        btn_accion.setContentAreaFilled(false);
        btn_accion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accionActionPerformed(evt);
            }
        });
        add(btn_accion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 108, 29));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaReserva.png"))); // NOI18N
        add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 108, 108));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_accionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accionActionPerformed
        EstadoReserva status = (reserva != null) ? reserva.getEstado() : EstadoReserva.LIBRE;
        switch (status) {
            case LIBRE:
                loadData();
                registrarReserva();
                break;
            case OCUPADA:
                loadData();
                cancelarReserva();
                break;
            case RESERVADO:
                loadData();
                cancelarReserva();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btn_accionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accion;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_number;
    private javax.swing.JLabel lbl_titulo;
    // End of variables declaration//GEN-END:variables
}
