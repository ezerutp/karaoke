package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.utils.EnumKaraoke.RolUsuario;

public class UsuarioRepository {
    private Connection connection;
    private final String TABLE_NAME = "usuario";

    public UsuarioRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Usuario usuario) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, correo, pass, rol) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPass());
            ps.setString(4, usuario.getRol().name());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapUsuario(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Usuario> usuariosList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                usuariosList.add(mapUsuario(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuariosList;
    }

    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, correo = ?, pass = ?, rol = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPass());
            ps.setString(4, usuario.getRol().name());
            ps.setInt(5, usuario.getId());
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

    private Usuario mapUsuario(ResultSet rs) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setCorreo(rs.getString("correo"));
        usuario.setPass(rs.getString("pass"));
        usuario.setRol(RolUsuario.valueOf(rs.getString("rol").toUpperCase()));
        return usuario;
    }

    public Usuario buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE correo = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, correo);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapUsuario(resultSet);
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
                return mapUsuario(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}