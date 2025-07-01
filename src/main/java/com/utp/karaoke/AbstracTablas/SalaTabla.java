package com.utp.karaoke.AbstracTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.utp.karaoke.entities.Sala;

public class SalaTabla extends AbstractTableModel {
    private String[] columnNames = {"Numero", "Tipo", "Capacidad", "Tarifa", "Estado"};
    private List<Sala> data;

    public SalaTabla(List<Sala> data) {
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
        Sala sala = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return sala.getNombre();
            case 1: return sala.getTipo();
            case 2: return sala.getMesas();
            case 3: return sala.getTarifa() != null ? sala.getTarifa().getNombre() : "";
            case 4: return sala.getEstado();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void removeRow(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
