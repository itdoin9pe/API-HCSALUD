package com.saludsystem.domain.movimiento.port.in.service;

import com.saludsystem.movimientos.application.dto.post.CrearAlmacenDTO;
import com.saludsystem.movimientos.application.dto.get.AlmacenDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarAlmacenDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AlmacenService extends GenericService<
        AlmacenDTO,
        CrearAlmacenDTO,
        ActualizarAlmacenDTO,
        UUID> {
}