package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Configuracion;

public class ConfiguracionRepository {
    private Connection connection;
    public final static String TABLE_NAME = "configuracion";

    public ConfiguracionRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Configuracion configuracion) {
        String sql = "INSERT INTO " + TABLE_NAME + " (ruc, nombre, telefono, direccion, mensaje, fecha_registro) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, configuracion.getRuc());
            ps.setString(2, configuracion.getNombre());
            ps.setString(3, configuracion.getTelefono());
            ps.setString(4, configuracion.getDireccion());
            ps.setString(5, configuracion.getMensaje());
            ps.setTimestamp(6, new java.sql.Timestamp(configuracion.getFechaRegistro().getTime()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Configuracion buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapConfiguracion(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Configuracion> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Configuracion> configuraciones = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                configuraciones.add(mapConfiguracion(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return configuraciones;
    }

    public boolean actualizar(Configuracion configuracion) {
        String sql = "UPDATE " + TABLE_NAME + " SET ruc = ?, nombre = ?, telefono = ?, direccion = ?, mensaje = ?, fecha_registro = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, configuracion.getRuc());
            ps.setString(2, configuracion.getNombre());
            ps.setString(3, configuracion.getTelefono());
            ps.setString(4, configuracion.getDireccion());
            ps.setString(5, configuracion.getMensaje());
            ps.setTimestamp(6, new java.sql.Timestamp(configuracion.getFechaRegistro().getTime()));
            ps.setInt(7, configuracion.getId());
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

    private Configuracion mapConfiguracion(ResultSet rs) throws Exception {
        Configuracion configuracion = new Configuracion();
        configuracion.setId(rs.getInt("id"));
        configuracion.setRuc(rs.getString("ruc"));
        configuracion.setNombre(rs.getString("nombre"));
        configuracion.setTelefono(rs.getString("telefono"));
        configuracion.setDireccion(rs.getString("direccion"));
        configuracion.setMensaje(rs.getString("mensaje"));
        configuracion.setFechaRegistro(rs.getTimestamp("fecha_registro"));
        return configuracion;
    }
}