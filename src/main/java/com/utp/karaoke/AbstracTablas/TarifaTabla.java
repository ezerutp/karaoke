package com.utp.karaoke.AbstracTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.utp.karaoke.entities.Tarifa;

public class TarifaTabla extends AbstractTableModel {
    private String[] columnNames = {"Nombre", "Precio", "Fecha"};
    private List<Tarifa> data;

    public TarifaTabla(List<Tarifa> data) {
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
        Tarifa tarifa = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return tarifa.getNombre();
            case 1: return tarifa.getPrecio();
            case 2: return tarifa.getFecha();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
