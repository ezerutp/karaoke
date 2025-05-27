package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Reserva;
import com.utp.karaoke.services.SalasService;
import com.utp.karaoke.services.UsuarioService;

public class ReservaRepository {
    private Connection connection;
    private final String TABLE_NAME = "reserva";

    public ReservaRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    public boolean guardar(Reserva reserva) {
        String sql = "INSERT INTO " + TABLE_NAME + " (id_sala, num_mesa, fecha, total, id_usuario, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, reserva.getSala().getId());
            preparedStatement.setInt(2, reserva.getNum_mesa());
            preparedStatement.setString(3, reserva.getFecha());
            preparedStatement.setDouble(4, reserva.getTotal());
            preparedStatement.setInt(5, reserva.getUsuario().getId());
            preparedStatement.setString(6, reserva.getEstado());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Reserva buscarPorId(int id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Reserva(
                    resultSet.getInt("id"),
                    new SalasService().obtenerSalaPorId(resultSet.getInt("id_sala")),
                    resultSet.getInt("num_mesa"),
                    resultSet.getString("fecha"),
                    resultSet.getDouble("total"),
                    new UsuarioService().obtenerUsuarioPorId(resultSet.getInt("id_usuario")),
                    resultSet.getString("estado")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserva> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Reserva> reservas = new ArrayList<>();
        try (var statement = connection.createStatement();
             var resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                reservas.add(new Reserva(
                    resultSet.getInt("id"),
                    new SalasService().obtenerSalaPorId(resultSet.getInt("id_sala")),
                    resultSet.getInt("num_mesa"),
                    resultSet.getString("fecha"),
                    resultSet.getDouble("total"),
                    new UsuarioService().obtenerUsuarioPorId(resultSet.getInt("id_usuario")),
                    resultSet.getString("estado")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public boolean actualizar(Reserva reserva) {
        String sql = "UPDATE " + TABLE_NAME + " SET id_sala = ?, num_mesa = ?, fecha = ?, total = ?, id_usuario = ?, estado = ? WHERE id = ?";
        try (var preparedStatement = connection.prepareStatement(sql)) {
           preparedStatement.setInt(1, reserva.getSala().getId());
            preparedStatement.setInt(2, reserva.getNum_mesa());
            preparedStatement.setString(3, reserva.getFecha());
            preparedStatement.setDouble(4, reserva.getTotal());
            preparedStatement.setInt(5, reserva.getUsuario().getId());
            preparedStatement.setString(6, reserva.getEstado());
            preparedStatement.setInt(7, reserva.getId());
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
