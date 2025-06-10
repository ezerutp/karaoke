package com.utp.karaoke.AbstracTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.utp.karaoke.entities.Cliente;

public class CienteTabla extends AbstractTableModel {
    private String[] columnNames = {"Nombre", "Correo", "Teléfono"};
    private List<Cliente> data;

    public CienteTabla(List<Cliente> data) {
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
        Cliente cliente = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNombre();
            case 1: return cliente.getCorreo();
            case 2: return cliente.getTelefono();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
