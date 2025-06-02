package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Auditoria;

public class AuditoriaRepository {
    private Connection connection;
    public final static String TABLE_NAME = "auditoria";

    public AuditoriaRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Auditoria auditoria) {
        String sql = "INSERT INTO " + TABLE_NAME + " (tabla_afectada, accion, usuario, fecha, descripcion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, auditoria.getTablaAfectada());
            ps.setString(2, auditoria.getAccion());
            ps.setString(3, auditoria.getUsuario());
            ps.setTimestamp(4, new java.sql.Timestamp(auditoria.getFecha().getTime()));
            ps.setString(5, auditoria.getDescripcion());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Auditoria buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapAuditoria(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Auditoria> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Auditoria> auditoriasList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                auditoriasList.add(mapAuditoria(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auditoriasList;
    }

    public boolean actualizar(Auditoria auditoria) {
        String sql = "UPDATE " + TABLE_NAME + " SET tabla_afectada = ?, accion = ?, usuario = ?, fecha = ?, descripcion = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, auditoria.getTablaAfectada());
            ps.setString(2, auditoria.getAccion());
            ps.setString(3, auditoria.getUsuario());
            ps.setTimestamp(4, new java.sql.Timestamp(auditoria.getFecha().getTime()));
            ps.setString(5, auditoria.getDescripcion());
            ps.setInt(6, auditoria.getId());
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

    private Auditoria mapAuditoria(ResultSet rs) throws Exception {
        Auditoria auditoria = new Auditoria();
        auditoria.setId(rs.getInt("id"));
        auditoria.setTablaAfectada(rs.getString("tabla_afectada"));
        auditoria.setAccion(rs.getString("accion"));
        auditoria.setUsuario(rs.getString("usuario"));
        auditoria.setFecha(rs.getTimestamp("fecha"));
        auditoria.setDescripcion(rs.getString("descripcion"));
        return auditoria;
    }
}