package com.saludSystem.application.services;

import com.saludSystem.domain.model.ServicioEntity;

import java.util.List;

public interface ServicioService {
    List<ServicioEntity> listarTodos();
    ServicioEntity guardar(ServicioEntity servicio);
}