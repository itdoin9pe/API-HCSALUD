package com.saludSystem.application.services;

import com.saludSystem.domain.model.ServicioEntity;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    List<ServicioEntity> listarTodos();
    ServicioEntity guardar(ServicioEntity servicio);
    Optional<ServicioEntity> buscarPorId(Long id);
    void eliminar(Long id);
}