package com.utp.karaoke.AbstracTablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.utp.karaoke.entities.Producto;

public class ProductoTabla extends AbstractTableModel {
    private String[] columnNames = {"Nombre", "Tipo", "Precio Unitario"};
    private List<Producto> data;

    public ProductoTabla(List<Producto> data) {
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
        Producto producto = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return producto.getNombre();
            case 1: return producto.getTipo();
            case 2: return producto.getPrecioUnitario();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}