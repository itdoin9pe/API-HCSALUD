package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.MonedaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearMonedaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface MonedaService extends GenericService<
        CrearMonedaDTO,
        MonedaDTO,
        UUID> {
}