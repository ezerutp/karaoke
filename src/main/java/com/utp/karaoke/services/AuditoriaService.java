package com.utp.karaoke.services;

import java.util.List;

import com.utp.karaoke.entities.Auditoria;
import com.utp.karaoke.entities.Usuario;
import com.utp.karaoke.repositories.AuditoriaRepository;
import com.utp.karaoke.repositories.UsuarioRepository;
import com.utp.karaoke.utils.SessionLogin;

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

    public boolean registrarAuditoriaRegistroUsuario(Usuario usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.setTablaAfectada(UsuarioRepository.TABLE_NAME);
        auditoria.setAccion("INSERT");
        auditoria.setUsuario(SessionLogin.getInstance().getUsuario().getCorreo()); // usuario que realiza la acción
        auditoria.setFecha(new java.util.Date());
        auditoria.setDescripcion("Registro de nuevo usuario: " + usuario.getCorreo());
        return registrarAuditoria(auditoria);
    }
}