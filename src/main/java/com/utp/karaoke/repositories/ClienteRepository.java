package com.utp.karaoke.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utp.karaoke.config.DbConexion;
import com.utp.karaoke.entities.Cliente;
import com.utp.karaoke.interfaces.Repository;

public class ClienteRepository implements Repository<Integer, Cliente> {
    private Connection connection;
    public final static String TABLE_NAME = "cliente";

    public ClienteRepository() {
        this.connection = DbConexion.getInstance().getConnection();
    }

    @Override
    public boolean guardar(Cliente cliente) {
        String sql = "INSERT INTO " + TABLE_NAME + " (nombre, dni, telefono, correo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapCliente(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        List<Cliente> clientesList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                clientesList.add(mapCliente(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientesList;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        String sql = "UPDATE " + TABLE_NAME + " SET nombre = ?, dni = ?, telefono = ?, correo = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDni());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Cliente mapCliente(ResultSet rs) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setDni(rs.getString("dni"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setCorreo(rs.getString("correo"));
        return cliente;
    }
}