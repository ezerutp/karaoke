package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Producto;

public class ProductoRepository {
    private Connection connection;
    public final static String TABLE_NAME = "producto";

    public ProductoRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Producto producto) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, tipo, precio_unitario) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipo());
            ps.setDouble(3, producto.getPrecioUnitario());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Producto buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapProducto(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Producto> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Producto> productosList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                productosList.add(mapProducto(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productosList;
    }

    public boolean actualizar(Producto producto) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, tipo = ?, precio_unitario = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipo());
            ps.setDouble(3, producto.getPrecioUnitario());
            ps.setInt(4, producto.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Producto mapProducto(ResultSet rs) throws Exception {
        Producto producto = new Producto();
        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setTipo(rs.getString("tipo"));
        producto.setPrecioUnitario(rs.getDouble("precio_unitario"));
        return producto;
    }
}