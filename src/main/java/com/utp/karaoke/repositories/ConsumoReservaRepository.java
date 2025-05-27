package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.ConsumoReserva;
import com.utp.karaoke.services.ProductoService;
import com.utp.karaoke.services.ReservaService;

public class ConsumoReservaRepository {
    private Connection connection;
    private final String TABLE_NAME = "consumo_reserva";

    public ConsumoReservaRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(ConsumoReserva consumoReserva) {
        String sql = "INSERT INTO " + TABLE_NAME + " (id_reserva, id_producto, cantidad, comentario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, consumoReserva.getReserva().getId());
            ps.setInt(2, consumoReserva.getProducto().getId());
            ps.setInt(3, consumoReserva.getCantidad());
            ps.setString(4, consumoReserva.getComentario());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ConsumoReserva buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapConsumoReserva(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ConsumoReserva> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<ConsumoReserva> consumosList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                consumosList.add(mapConsumoReserva(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consumosList;
    }

    public boolean actualizar(ConsumoReserva consumoReserva) {
        String sql = "UPDATE " + TABLE_NAME + " SET id_reserva = ?, id_producto = ?, cantidad = ?, comentario = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, consumoReserva.getReserva().getId());
            ps.setInt(2, consumoReserva.getProducto().getId());
            ps.setInt(3, consumoReserva.getCantidad());
            ps.setString(4, consumoReserva.getComentario());
            ps.setInt(5, consumoReserva.getId());
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

    private ConsumoReserva mapConsumoReserva(ResultSet rs) throws Exception {
        ConsumoReserva consumoReserva = new ConsumoReserva();
        consumoReserva.setId(rs.getInt("id"));
        consumoReserva.setReserva(new ReservaService().obtenerReservaPorId(rs.getInt("id_reserva")));
        consumoReserva.setProducto(new ProductoService().obtenerProductoPorId(rs.getInt("id_producto")));
        consumoReserva.setCantidad(rs.getInt("cantidad"));
        consumoReserva.setComentario(rs.getString("comentario"));
        return consumoReserva;
    }
}