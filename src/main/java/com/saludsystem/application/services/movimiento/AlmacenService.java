package com.saludsystem.application.services.movimiento;

import com.saludsystem.application.dtos.movimientos.get.AlmacenDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearAlmacenDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface AlmacenService extends GenericService<
        CrearAlmacenDTO,
        AlmacenDTO,
        UUID> {
}