package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.CajaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearCajaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface CajaService extends GenericService<
        CrearCajaDTO,
        CajaDTO,
        UUID> {
}