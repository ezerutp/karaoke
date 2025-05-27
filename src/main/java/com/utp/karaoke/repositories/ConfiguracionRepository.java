package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Configuracion;

public class ConfiguracionRepository {
    private Connection connection;
    private final String TABLE_NAME = "configuracion";

    public ConfiguracionRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Configuracion configuracion) {
        String sql = "INSERT INTO " + TABLE_NAME + " (ruc, nombre, telefono, direccion, mensaje) VALUES (?, ?, ?, ?, ?)";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, configuracion.getRuc());
            preparedStatement.setString(2, configuracion.getNombre());
            preparedStatement.setString(3, configuracion.getTelefono());
            preparedStatement.setString(4, configuracion.getDireccion());
            preparedStatement.setString(5, configuracion.getMensaje());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Configuracion buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Configuracion(
                        resultSet.getInt("id"),
                        resultSet.getString("ruc"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion"),
                        resultSet.getString("mensaje"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Configuracion> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Configuracion> configuraciones = new ArrayList<>();
        try (var statement = connection.createStatement();
             var resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                configuraciones.add(new Configuracion(
                        resultSet.getInt("id"),
                        resultSet.getString("ruc"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion"),
                        resultSet.getString("mensaje")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configuraciones;
    }

    public boolean actualizar(Configuracion configuracion) {
        String sql = "UPDATE " + TABLE_NAME + " SET ruc = ?, nombre = ?, telefono = ?, direccion = ?, mensaje = ? WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, configuracion.getRuc());
            preparedStatement.setString(2, configuracion.getNombre());
            preparedStatement.setString(3, configuracion.getTelefono());
            preparedStatement.setString(4, configuracion.getDireccion());
            preparedStatement.setString(5, configuracion.getMensaje());
            preparedStatement.setInt(6, configuracion.getId());
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