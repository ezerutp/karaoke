package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Reserva;
import com.utp.karaoke.services.ClienteService;
import com.utp.karaoke.services.SalasService;
import com.utp.karaoke.services.UsuarioService;
import com.utp.karaoke.utils.EnumKaraoke.EstadoReserva;

public class ReservaRepository {
    private Connection connection;
    public final static String TABLE_NAME = "reserva";

    public ReservaRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Reserva reserva) {
        String sql = "INSERT INTO " + TABLE_NAME + " (id_cliente, id_sala, id_usuario, fecha, total, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, reserva.getCliente().getId());
            ps.setInt(2, reserva.getSala().getId());
            ps.setInt(3, reserva.getUsuario().getId());
            ps.setTimestamp(4, new java.sql.Timestamp(reserva.getFecha().getTime()));
            ps.setDouble(5, reserva.getTotal());
            ps.setString(6, reserva.getEstado().name());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Reserva buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapReserva(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserva> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Reserva> reservasList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                reservasList.add(mapReserva(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservasList;
    }

    public boolean actualizar(Reserva reserva) {
        String sql = "UPDATE " + TABLE_NAME + " SET id_cliente = ?, id_sala = ?, id_usuario = ?, fecha = ?, total = ?, estado = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, reserva.getCliente().getId());
            ps.setInt(2, reserva.getSala().getId());
            ps.setInt(3, reserva.getUsuario().getId());
            ps.setTimestamp(4, new java.sql.Timestamp(reserva.getFecha().getTime()));
            ps.setDouble(5, reserva.getTotal());
            ps.setString(6, reserva.getEstado().name());
            ps.setInt(7, reserva.getId());
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

    private Reserva mapReserva(ResultSet rs) throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(rs.getInt("id"));
        reserva.setCliente(new ClienteService().obtenerClientePorId(rs.getInt("id_cliente")));
        reserva.setSala(new SalasService().obtenerSalaPorId(rs.getInt("id_sala")));
        reserva.setUsuario(new UsuarioService().obtenerUsuarioPorId(rs.getInt("id_usuario")));
        reserva.setFecha(rs.getTimestamp("fecha"));
        reserva.setTotal(rs.getDouble("total"));
        reserva.setEstado(EstadoReserva.valueOf(rs.getString("estado").toUpperCase()));
        return reserva;
    }
}