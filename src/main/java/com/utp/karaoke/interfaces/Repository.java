package com.utp.karaoke.interfaces;

import java.util.List;

public interface Repository<T, U> {
    public boolean guardar(U entity);
    public U buscarPorId(T id);
    public List<U> listarTodos();
    public boolean actualizar(U entity);
    public boolean eliminar(T id);
}
