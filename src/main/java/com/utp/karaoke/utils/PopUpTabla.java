package com.utp.karaoke.utils;

import java.awt.event.MouseAdapter;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import java.util.function.Function;

public class PopUpTabla {

    /**
     * Método para agregar un menú emergente a una tabla.
     *
     * @param tabla        La tabla a la que se le agregará el menú emergente.
     * @param columna      La columna que se utilizará para buscar el objeto a
     *                     editar o eliminar.
     * @param find         Función para encontrar el objeto basado en el valor de la
     *                     celda.
     * @param editar       Consumidor para editar el objeto encontrado.
     * @param eliminar     Consumidor para eliminar el objeto encontrado.
     * @param eliminarFila Consumidor para eliminar la fila de la tabla.
     * @param cargarTabla  Runnable para recargar la tabla después de editar o
     *                     eliminar.
     * @param <T>          Tipo del objeto que se va a editar o eliminar.
     */
    public static <T> void addPopupMenu(JTable tabla, int columna, Function<String, T> find, Consumer<T> editar,
            Consumer<T> eliminar, Consumer<Integer> eliminarFila, Runnable cargarTabla) {

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItemEditar = new JMenuItem("Editar");
        JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
        popupMenu.add(menuItemEditar);
        popupMenu.add(menuItemEliminar);

        // Agregar el listener a la tabla
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mostrarMenu(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mostrarMenu(e);
            }

            private void mostrarMenu(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int fila = tabla.rowAtPoint(e.getPoint());
                    if (fila >= 0 && fila < tabla.getRowCount()) {
                        tabla.setRowSelectionInterval(fila, fila);
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

        // Acción de editar
        menuItemEditar.addActionListener(evt -> {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                String valor = (String) tabla.getValueAt(fila, columna);
                T entidad = find.apply(valor);
                if (entidad != null) {
                    editar.accept(entidad);
                    cargarTabla.run();
                }
            }
        });

        // Acción de eliminar
        menuItemEliminar.addActionListener(evt -> {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                String valor = (String) tabla.getValueAt(fila, columna);
                T entidad = find.apply(valor);
                if (entidad != null) {
                    eliminar.accept(entidad);
                    eliminarFila.accept(fila);
                }
            }
        });
    }
}
