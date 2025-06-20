package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Tarifa;
import com.utp.karaoke.interfaces.Repository;

public class TarifasRepository  implements Repository<Integer, Tarifa> {
    private Connection connection;
    public final static String TABLE_NAME = "tarifa";

    public TarifasRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    @Override
    public boolean guardar(Tarifa tarifa) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, precio, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, tarifa.getNombre());
            ps.setDouble(2, tarifa.getPrecio());
            ps.setTimestamp(3, new java.sql.Timestamp(tarifa.getFecha().getTime()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tarifa buscarPorId(Integer id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapTarifa(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tarifa> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Tarifa> tarifasList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                tarifasList.add(mapTarifa(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tarifasList;
    }

    @Override
    public boolean actualizar(Tarifa tarifa) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, precio = ?, fecha = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, tarifa.getNombre());
            ps.setDouble(2, tarifa.getPrecio());
            ps.setTimestamp(3, new java.sql.Timestamp(tarifa.getFecha().getTime()));
            ps.setInt(4, tarifa.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   @Override
   public boolean eliminar(Integer id) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Tarifa mapTarifa(ResultSet rs) throws Exception {
        Tarifa tarifa = new Tarifa();
        tarifa.setId(rs.getInt("id"));
        tarifa.setNombre(rs.getString("nombre"));
        tarifa.setPrecio(rs.getDouble("precio"));
        tarifa.setFecha(rs.getTimestamp("fecha"));
        return tarifa;
    }
}