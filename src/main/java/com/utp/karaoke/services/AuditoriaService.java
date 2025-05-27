package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Auditoria;
import com.utp.karaoke.repositories.AuditoriaRepository;

public class AuditoriaService {
    private AuditoriaRepository auditoriaRepository;

    public AuditoriaService() {
        this.auditoriaRepository = new AuditoriaRepository();
    }

    public boolean registrarAuditoria(Auditoria auditoria) {
        return auditoriaRepository.guardar(auditoria);
    }

    public Auditoria obtenerAuditoriaPorId(int id) {
        return auditoriaRepository.buscarPorId(id);
    }

    public List<Auditoria> obtenerTodasAuditorias() {
        return auditoriaRepository.listarTodos();
    }

    public boolean actualizarAuditoria(Auditoria auditoria) {
        return auditoriaRepository.actualizar(auditoria);
    }

    public boolean eliminarAuditoria(int id) {
        return auditoriaRepository.eliminar(id);
    }
}