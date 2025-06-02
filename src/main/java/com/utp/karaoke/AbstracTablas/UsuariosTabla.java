package com.utp.karaoke.AbstracTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.utp.karaoke.entities.Usuario;

public class UsuariosTabla extends AbstractTableModel {
    private String[] columnNames = {"Nombre", "Correo", "Rol"};
    private List<Usuario> data;

    public UsuariosTabla(List<Usuario> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return usuario.getNombre();
            case 1: return usuario.getCorreo();
            case 2: return usuario.getRol();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
