package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Sala;

public class SalasRepository {
    private Connection connection;
    private final String TABLE_NAME = "sala";

    public SalasRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Sala salas) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, mesas) VALUES (?, ?)";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, salas.getNombre());
            preparedStatement.setInt(2, salas.getMesas());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Sala buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Sala(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("mesas"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sala> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Sala> salasList = new ArrayList<>();
        try (var statement = connection.createStatement();
                var resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                salasList.add(new Sala(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("mesas")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salasList;
    }

    public boolean actualizar(Sala salas) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, mesas = ? WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, salas.getNombre());
            preparedStatement.setInt(2, salas.getMesas());
            preparedStatement.setInt(3, salas.getId());
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
