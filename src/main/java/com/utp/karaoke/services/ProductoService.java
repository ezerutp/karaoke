package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Producto;
import com.utp.karaoke.repositories.ProductoRepository;

public class ProductoService {
    private ProductoRepository productoRepository;

    public ProductoService() {
        this.productoRepository = new ProductoRepository();
    }

    public boolean registrarProducto(Producto producto) {
        return productoRepository.guardar(producto);
    }

    public Producto obtenerProductoPorId(int id) {
        return productoRepository.buscarPorId(id);
    }

    public List<Producto> obtenerTodosProductos() {
        return productoRepository.listarTodos();
    }

    public boolean actualizarProducto(Producto producto) {
        return productoRepository.actualizar(producto);
    }

    public boolean eliminarProducto(int id) {
        return productoRepository.eliminar(id);
    }
}