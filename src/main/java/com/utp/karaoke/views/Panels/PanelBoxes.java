package com.utp.karaoke.views.Panels;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.entities.Tarifa;

import com.utp.karaoke.utils.EnumKaraoke;
import com.utp.karaoke.utils.EnumKaraoke.TipoBox;
import com.utp.karaoke.AbstracTablas.SalaTabla;
import com.utp.karaoke.controllers.BoxesController;
import com.utp.karaoke.controllers.TarifaController;
import com.utp.karaoke.utils.EventoUtils;
import com.utp.karaoke.utils.PopUpTabla;
import com.utp.karaoke.views.Dialogs.DialogBoxes;

public class PanelBoxes extends javax.swing.JPanel {

    private final BoxesController controller = new BoxesController();
    private final TarifaController tarifaController = new TarifaController();

    public PanelBoxes() {
        initComponents();
        EventoUtils.validarNumeroEntero(this.txt_personas);
        EventoUtils.validarNumeroEntero(this.txt_numero);
        addTipoBoxListener();
        EventoUtils.addNumeroListener(txt_numero, txt_numeroBox);
        EventoUtils.asignarEventoClick(cbx_tarifa, this::aplicarListaTarifa);
        EventoUtils.asignarEventoClick(btn_agregar, this::registrarBox);
        cargarTabla();
        aplicarPlaceholder();
        aplicarListaTarifa();
        addPopupMenu();
        this.txt_numeroBox.setText("00");
    }

    private void aplicarListaTarifa() {
        EventoUtils.cargarComboBoxDesdeLista(cbx_tarifa, tarifaController.obtenerTarifas());
    }

    private void aplicarPlaceholder() {
        EventoUtils.aplicarPlaceholder(this.txt_numero, "Número");
        EventoUtils.aplicarPlaceholder(this.txt_personas, "Cantidad");
    }

    private void addPopupMenu() {
        PopUpTabla.addPopupMenu(
                tbl_Usuarios,
                0,
                controller::obtenerSalaPorNombre,
                box -> {
                    DialogBoxes dialog = new DialogBoxes(null, true, box);
                    dialog.setVisible(true);
                    cargarTabla();
                },
                box -> {
                    int confirmacion = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de que deseas eliminar la sala " + box.getNombre() + "?",
                            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        controller.eliminarSala(box.getId());
                        cargarTabla();
                    }
                },
                fila -> ((SalaTabla) tbl_Usuarios.getModel()).removeRow(fila),
                this::cargarTabla
        );
    }

    private void registrarBox() {
        Sala box = new Sala();
        box.setNombre(this.txt_numero.getText());
        box.setTipo(TipoBox.values()[cbx_tipo.getSelectedIndex()].name());
        box.setMesas(Integer.parseInt(this.txt_personas.getText())); // Asignar 0 mesas por defecto
        box.setTarifa((Tarifa) cbx_tarifa.getSelectedItem());
        box.setEstado(EnumKaraoke.EstadoSala.LIBRE);
        if (controller.registrarSala(box)) {
            aplicarPlaceholder();
            cargarTabla();
            this.txt_numeroBox.setText("00");
        }
    }

    private void addTipoBoxListener() {
        cbx_tipo.addActionListener(e -> {
            int selectedIndex = cbx_tipo.getSelectedIndex();
            TipoBox tipo = TipoBox.values()[selectedIndex];
            cambiarImagenBox(tipo);
        });
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

    private void cargarTabla() {
        tbl_Usuarios.setModel(new SalaTabla(controller.obtenerSalas()));
    }

    /*
     * private void addPopupMenu() {
     * popupMenu = new JPopupMenu();
     * menuItemEditar = new JMenuItem("Editar");
     * menuItemEliminar = new JMenuItem("Eliminar");
     * popupMenu.add(menuItemEditar);
     * popupMenu.add(menuItemEliminar);
     * 
     * // Agregar el listener a la tabla
     * tbl_Usuarios.addMouseListener(new MouseAdapter() {
     * 
     * @Override
     * public void mousePressed(MouseEvent e) {
     * mostrarMenu(e);
     * }
     * 
     * @Override
     * public void mouseReleased(MouseEvent e) {
     * mostrarMenu(e);
     * }
     * 
     * private void mostrarMenu(MouseEvent e) {
     * if (e.isPopupTrigger()) {
     * int fila = tbl_Usuarios.rowAtPoint(e.getPoint());
     * if (fila >= 0 && fila < tbl_Usuarios.getRowCount()) {
     * tbl_Usuarios.setRowSelectionInterval(fila, fila);
     * popupMenu.show(e.getComponent(), e.getX(), e.getY());
     * }
     * }
     * }
     * });
     * 
     * // Acción de editar
     * menuItemEditar.addActionListener(evt -> {
     * int fila = tbl_Usuarios.getSelectedRow();
     * if (fila != -1) {
     * String nombre = (String) tbl_Usuarios.getValueAt(fila, 0);
     * Tarifa tarifa = controller.obtenerTarifaPorNombre(nombre);
     * if (tarifa != null) {
     * DialogTarifa dialog = new DialogTarifa(null, true, tarifa);
     * dialog.setVisible(true);
     * cargarTabla();
     * }
     * }
     * });
     * 
     * // Acción de eliminar
     * menuItemEliminar.addActionListener(evt -> {
     * int fila = tbl_Usuarios.getSelectedRow();
     * if (fila != -1) {
     * String nombre = (String) tbl_Usuarios.getValueAt(fila, 0);
     * Tarifa tarifa = controller.obtenerTarifaPorNombre(nombre);
     * if (tarifa != null) {
     * // confirmar la eliminación
     * int confirmacion = JOptionPane.showConfirmDialog(null,
     * "¿Estás seguro de que deseas eliminar la tarifa " + tarifa.getNombre() + "?",
     * "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
     * if (confirmacion != JOptionPane.YES_OPTION) {
     * return; // Si el usuario no confirma, no se elimina
     * }
     * controller.eliminarTarifa(tarifa.getId());
     * }
     * ((TarifaTabla) tbl_Usuarios.getModel()).removeRow(fila);
     * }
     * });
     * }
     */

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_contenedor = new javax.swing.JPanel();
        txt_numero = new javax.swing.JTextField();
        txt_personas = new javax.swing.JTextField();
        cbx_tipo = new javax.swing.JComboBox<>();
        cbx_tarifa = new javax.swing.JComboBox<>();
        btn_agregar = new javax.swing.JButton();
        txt_numeroBox = new javax.swing.JLabel();
        lbl_box = new javax.swing.JLabel();
        lbl_fondoFormulario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Usuarios = new javax.swing.JTable();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(970, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_contenedor.setOpaque(false);
        pnl_contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_numero.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_numero.setBorder(null);
        pnl_contenedor.add(txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 39, 100, 36));

        txt_personas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_personas.setBorder(null);
        pnl_contenedor.add(txt_personas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 100, 36));

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BÁSICO", "CLÁSICO", "VIP" }));
        pnl_contenedor.add(cbx_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 89, 273, 43));

        pnl_contenedor.add(cbx_tarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 143, 273, 43));

        btn_agregar.setBorder(null);
        btn_agregar.setBorderPainted(false);
        btn_agregar.setContentAreaFilled(false);
        pnl_contenedor.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 360, 40));

        txt_numeroBox.setFont(new java.awt.Font("Segoe UI", 1, 100)); // NOI18N
        txt_numeroBox.setForeground(new java.awt.Color(255, 255, 255));
        txt_numeroBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_numeroBox.setText("01");
        pnl_contenedor.add(txt_numeroBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 260, 110));

        lbl_box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaBoxBasico.png"))); // NOI18N
        pnl_contenedor.add(lbl_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        lbl_fondoFormulario
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/figmaBoxesFormulario.png"))); // NOI18N
        pnl_contenedor.add(lbl_fondoFormulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

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

        pnl_contenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 315, 900, 280));

        add(pnl_contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 900, 600));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JComboBox<Tarifa> cbx_tarifa;
    private javax.swing.JComboBox<String> cbx_tipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_box;
    private javax.swing.JLabel lbl_fondoFormulario;
    private javax.swing.JPanel pnl_contenedor;
    private javax.swing.JTable tbl_Usuarios;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JLabel txt_numeroBox;
    private javax.swing.JTextField txt_personas;
    // End of variables declaration//GEN-END:variables
}
