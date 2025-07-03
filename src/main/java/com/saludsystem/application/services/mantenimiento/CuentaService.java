package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.CuentaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearCuentaDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarCuentaDTO;
import com.saludsystem.application.services.GenericService;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CuentaService extends GenericService<
        CuentaDTO,
        UUID,
        CrearCuentaDTO,
        ActualizarCuentaDTO> {
}