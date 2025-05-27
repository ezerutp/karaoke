package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Usuario;

public class UsuarioRepository {
    private Connection connection;
    private final String TABLE_NAME = "usuario";

    public UsuarioRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Usuario usuario) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, correo, pass, rol) VALUES (?, ?, ?, ?)";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getPass());
            preparedStatement.setString(4, usuario.getRol());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("pass"),
                        resultSet.getString("rol"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Usuario> usuarios = new ArrayList<>();
        try (var statement = connection.createStatement();
                var resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                usuarios.add(new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("pass"),
                        resultSet.getString("rol")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, correo = ?, pass = ?, rol = ? WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getPass());
            preparedStatement.setString(4, usuario.getRol());
            preparedStatement.setInt(5, usuario.getId());
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

    public Usuario buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE correo = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, correo);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("pass"),
                        resultSet.getString("rol"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Funciones adicionales para autenticar usuario
    public Usuario autenticar(String correo, String pass) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE correo = ? AND pass = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, pass);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("pass"),
                        resultSet.getString("rol"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}