package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Tarifa;

public class TarifasRepository {
    private Connection connection;
    private final String TABLE_NAME = "tarifa";

    public TarifasRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Tarifa tarifa) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, precio, fecha) VALUES (?, ?, ?)";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tarifa.getNombre());
            preparedStatement.setDouble(2, tarifa.getPrecio());
            preparedStatement.setString(3, tarifa.getFecha());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Tarifa buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Tarifa(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getDouble("precio"),
                    resultSet.getString("fecha")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Tarifa> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Tarifa> tarifasList = new ArrayList<>();
        try (var statement = connection.createStatement();
             var resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                tarifasList.add(new Tarifa(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getDouble("precio"),
                    resultSet.getString("fecha")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tarifasList;
    }

    public boolean actualizar(Tarifa tarifa) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, precio = ?, fecha = ? WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tarifa.getNombre());
            preparedStatement.setDouble(2, tarifa.getPrecio());
            preparedStatement.setString(3, tarifa.getFecha());
            preparedStatement.setInt(4, tarifa.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   public boolean eliminar(int id) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}