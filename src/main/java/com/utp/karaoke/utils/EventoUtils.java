package com.utp.karaoke.utils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Utilidad para la gestión de eventos y componentes en interfaces gráficas
 * Swing.
 * Proporciona métodos estáticos para asignar eventos, validar entradas y
 * manipular componentes comunes.
 */
public class EventoUtils {

    /**
     * Asigna un evento de clic a un componente Swing.
     *
     * @param miComponente El componente al que se le asignará el evento.
     * @param accion       La acción a ejecutar cuando se haga clic.
     */
    public static void asignarEventoClick(JComponent miComponente, Runnable accion) {
        miComponente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accion.run();
            }
        });
    }

    /**
     * Asigna un evento para la tecla Enter a un componente Swing.
     *
     * @param componente El componente al que se le asignará el evento.
     * @param accion     La acción a ejecutar cuando se presione Enter.
     */
    public static void asignarEventoEnter(JComponent componente, Runnable accion) {
        componente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    accion.run();
                }
            }
        });
    }

    /**
     * Valida que la entrada en un JTextField sea un número decimal.
     * Solo permite dígitos y un solo punto decimal.
     *
     * @param textField El campo de texto a validar.
     */
    public static void validarNumeroDecimal(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textField.getText();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                } else if (c == '.' && text.contains(".")) {
                    e.consume();
                }
            }
        });
    }

    /**
     * Valida que la entrada en un JTextField sea un número entero.
     * Solo permite dígitos.
     *
     * @param textField El campo de texto a validar.
     */
    public static void validarNumeroEntero(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    /**
     * Aplica un placeholder (texto de sugerencia) a un JTextField.
     * El placeholder se muestra en color gris claro hasta que el campo recibe foco.
     *
     * @param textField   El campo de texto al que se le aplicará el placeholder.
     * @param placeholder El texto del placeholder.
     */
    public static void aplicarPlaceholder(JTextField textField, String placeholder) {
        Color placeholderColor = Color.LIGHT_GRAY;
        Color normalColor = Color.BLACK;

        textField.setText(placeholder);
        textField.setForeground(placeholderColor);

        final boolean[] placeholderActivo = { true };

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (placeholderActivo[0]) {
                    textField.setText("");
                    textField.setForeground(normalColor);
                    placeholderActivo[0] = false;
                }
            }
        });
    }

    /**
     * Carga una lista de cadenas en un JComboBox.
     *
     * @param combo El JComboBox a llenar.
     * @param lista La lista de elementos a agregar.
     */
    public static void cargarComboBoxConLista(JComboBox<String> combo, List<String> lista) {
        combo.removeAllItems();
        for (String item : lista) {
            combo.addItem(item);
        }
    }

    /**
     * Carga una lista de objetos que implementan la interfaz Comboxeable en un
     * JComboBox.
     * Utiliza el método getValueString() de cada objeto para obtener el valor a
     * mostrar.
     *
     * @param <T>   Tipo de los elementos.
     * @param combo El JComboBox a llenar.
     * @param lista La lista de elementos a agregar.
     */
    public static <T> void cargarComboBoxDesdeLista(JComboBox<T> combo, List<T> lista) {
        combo.removeAllItems();
        DefaultComboBoxModel<T> model = new DefaultComboBoxModel<>();
        lista.forEach(model::addElement);
        combo.setModel(model);
    }

    /**
     * Agrega un listener a un JTextField para actualizar un JLabel con el valor
     * numérico ingresado,
     * formateando con ceros a la izquierda si es necesario.
     *
     * @param txt_nombre    El JTextField donde se ingresa el número.
     * @param txt_numeroBox El JLabel que muestra el número formateado.
     */
    public static void addNumeroListener(JTextField txt_nombre, JLabel txt_numeroBox) {
        txt_nombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarNumeroBox();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarNumeroBox();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarNumeroBox();
            }

            private void actualizarNumeroBox() {
                String nombre = txt_nombre.getText();
                if (nombre.isEmpty()) {
                    txt_numeroBox.setText("00");
                    return;
                }
                try {
                    int numero = Integer.parseInt(nombre);
                    if (numero >= 1 && numero <= 9) {
                        txt_numeroBox.setText(String.format("0%d", numero));
                    } else {
                        txt_numeroBox.setText(nombre);
                    }
                } catch (NumberFormatException ex) {
                    txt_numeroBox.setText(nombre);
                }
            }
        });
    }
}
