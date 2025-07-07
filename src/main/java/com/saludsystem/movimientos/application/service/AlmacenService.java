package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.AlmacenDTO;
import com.saludsystem.movimientos.application.dto.req.CrearAlmacenDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AlmacenService extends GenericService<
        CrearAlmacenDTO,
        AlmacenDTO,
        UUID> {
}