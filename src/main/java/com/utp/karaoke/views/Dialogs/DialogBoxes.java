package com.utp.karaoke.views.Dialogs;

import javax.swing.ImageIcon;

import com.utp.karaoke.controllers.BoxesController;
import com.utp.karaoke.controllers.TarifaController;
import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.entities.Tarifa;
import com.utp.karaoke.utils.EnumKaraoke.TipoBox;
import com.utp.karaoke.utils.EventoUtils;

public class DialogBoxes extends DialogoSinBordes {

    private final BoxesController controller = new BoxesController();
    private final TarifaController tarifaController = new TarifaController();

    Sala box;

    public DialogBoxes(java.awt.Frame parent, boolean modal, Sala box) {
        super(parent, modal);
        initComponents();
        this.box = box;
        cargarDatos(box);

        EventoUtils.validarNumeroEntero(txt_numero);
        EventoUtils.validarNumeroEntero(txt_personas);
        EventoUtils.addNumeroListener(txt_numero, txt_numeroBox);
        EventoUtils.asignarEventoClick(lbl_close, this::dispose);
        EventoUtils.asignarEventoClick(btn_agregar, this::actualizarTarifa);

        addTipoBoxListener();
        aplicarListaTarifa();
    }

    private void actualizarTarifa() {
        String numero = txt_numero.getText();
        int personas = Integer.parseInt(txt_personas.getText());
        String tipo = (String) cbx_tipo.getSelectedItem();
        Tarifa tarifa = (Tarifa) cbx_tarifa.getSelectedItem();

        box.setNombre(numero);
        box.setMesas(personas);
        box.setTipo(tipo);
        box.setTarifa(tarifa);

        if (controller.actualizarSala(box)) {
            this.dispose(); // Cerrar el diálogo si el registro fue exitoso
        }
    }

    private void aplicarListaTarifa() {
        EventoUtils.cargarComboBoxDesdeLista(cbx_tarifa, tarifaController.obtenerTarifas());
    }

    private void addTipoBoxListener() {
        cbx_tipo.addActionListener(e -> {
            int selectedIndex = cbx_tipo.getSelectedIndex();
            TipoBox tipo = TipoBox.values()[selectedIndex];
            cambiarImagenBox(tipo);
        });
    }

    private void cargarDatos(Sala box) {
        txt_numero.setText(box.getNombre());
        txt_personas.setText(String.valueOf(box.getMesas()));
        cbx_tipo.setSelectedItem(box.getTipo());
        cbx_tarifa.setSelectedItem(box.getTarifa());
        cambiarImagenBox(TipoBox.valueOf(box.getTipo().toUpperCase()));
        txt_numeroBox.setText(box.getNombre());
    }

    private void cambiarImagenBox(TipoBox tipo) {
        switch (tipo) {
            case BASICO:
                lbl_box.setIcon(new ImageIcon(getClass().getResource("/images/figmaBoxBasico.png")));
                break;
            case CLASICO:
                lbl_box.setIcon(new ImageIcon(getClass().getResource("/images/figmaBoxClasico.png")));
                break;
            case VIP:
                lbl_box.setIcon(new ImageIcon(getClass().getResource("/images/figmaBoxVip.png")));
                break;
            default:
                lbl_box.setIcon(null);
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txt_numeroBox = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        lbl_box = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        cbx_tarifa = new javax.swing.JComboBox<>();
        cbx_tipo = new javax.swing.JComboBox<>();
        txt_personas = new javax.swing.JTextField();
        txt_numero = new javax.swing.JTextField();
        lbl_fondoFormulario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(54, 49, 75));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_numeroBox.setFont(new java.awt.Font("Segoe UI", 1, 100)); // NOI18N
        txt_numeroBox.setForeground(new java.awt.Color(255, 255, 255));
        txt_numeroBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_numeroBox.setText("01");
        jPanel2.add(txt_numeroBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 110));

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconSalir.png"))); // NOI18N
        jPanel2.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 10, -1, -1));

        lbl_box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaBoxBasico.png"))); // NOI18N
        jPanel2.add(lbl_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btn_agregar.setBorder(null);
        btn_agregar.setBorderPainted(false);
        btn_agregar.setContentAreaFilled(false);
        jPanel2.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 360, 40));

        jPanel2.add(cbx_tarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 182, 273, 43));

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BASICO", "CLÁSICO", "VIP" }));
        jPanel2.add(cbx_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 273, 43));

        txt_personas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_personas.setBorder(null);
        jPanel2.add(txt_personas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 100, 36));

        txt_numero.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_numero.setBorder(null);
        jPanel2.add(txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 78, 100, 36));

        lbl_fondoFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaBoxesFormulario.png"))); // NOI18N
        jPanel2.add(lbl_fondoFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JComboBox<Tarifa> cbx_tarifa;
    private javax.swing.JComboBox<String> cbx_tipo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_box;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_fondoFormulario;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JLabel txt_numeroBox;
    private javax.swing.JTextField txt_personas;
    // End of variables declaration//GEN-END:variables
}
