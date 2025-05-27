package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Sala;
import com.utp.karaoke.entities.Tarifa;
import com.utp.karaoke.services.TarifasService;
import com.utp.karaoke.utils.EnumKaraoke.EstadoSala;

public class SalasRepository {
    private Connection connection;
    private final String TABLE_NAME = "sala";

    public SalasRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Sala sala) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, tipo, mesas, id_tarifa, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sala.getNombre());
            ps.setString(2, sala.getTipo());
            ps.setInt(3, sala.getMesas());
            ps.setInt(4, sala.getTarifa().getId());
            ps.setString(5, sala.getEstado().name());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Sala buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapSala(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sala> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Sala> salasList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                salasList.add(mapSala(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salasList;
    }

    public boolean actualizar(Sala sala) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, tipo = ?, mesas = ?, id_tarifa = ?, estado = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sala.getNombre());
            ps.setString(2, sala.getTipo());
            ps.setInt(3, sala.getMesas());
            ps.setInt(4, sala.getTarifa().getId());
            ps.setString(5, sala.getEstado().name());
            ps.setInt(6, sala.getId());
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

    private Sala mapSala(ResultSet rs) throws Exception {
        Sala sala = new Sala();
        sala.setId(rs.getInt("id"));
        sala.setNombre(rs.getString("nombre"));
        sala.setTipo(rs.getString("tipo"));
        sala.setMesas(rs.getInt("mesas"));
        Tarifa tarifa = new TarifasService().obtenerTarifaPorId(rs.getInt("id_tarifa"));
        sala.setTarifa(tarifa);
        sala.setEstado(EstadoSala.valueOf(rs.getString("estado").toUpperCase()));
        return sala;
    }
}