package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.DetalleReserva;
import com.utp.karaoke.services.ReservaService;

public class DetalleReservaRepository {
    private Connection connection;
    private final String TABLE_NAME = "detalle_reserva";

    public DetalleReservaRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(DetalleReserva detalleReserva) {
        String sql = "INSERT INTO " + TABLE_NAME
                + " (nombre, precio, cantidad, comentario, id_reserva) VALUES (?, ?, ?, ?, ?)";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, detalleReserva.getNombre());
            preparedStatement.setDouble(2, detalleReserva.getPrecio());
            preparedStatement.setInt(3, detalleReserva.getCantidad());
            preparedStatement.setString(4, detalleReserva.getComentario());
            preparedStatement.setInt(5, detalleReserva.getReserva().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public DetalleReserva buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new DetalleReserva(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("cantidad"),
                        resultSet.getString("comentario"),
                        new ReservaService().obtenerReservaPorId(resultSet.getInt("id_reserva")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DetalleReserva> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<DetalleReserva> detalles = new ArrayList<>();
        try (var statement = connection.createStatement();
                var resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                detalles.add(new DetalleReserva(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("cantidad"),
                        resultSet.getString("comentario"),
                        new ReservaService().obtenerReservaPorId(resultSet.getInt("id_reserva"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detalles;
    }

    public boolean actualizar(DetalleReserva detalleReserva) {
        String sql = "UPDATE " + TABLE_NAME
                + " SET nombre = ?, precio = ?, cantidad = ?, comentario = ?, id_reserva = ? WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, detalleReserva.getNombre());
            preparedStatement.setDouble(2, detalleReserva.getPrecio());
            preparedStatement.setInt(3, detalleReserva.getCantidad());
            preparedStatement.setString(4, detalleReserva.getComentario());
            preparedStatement.setInt(5, detalleReserva.getReserva().getId());
            preparedStatement.setInt(6, detalleReserva.getId());
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
