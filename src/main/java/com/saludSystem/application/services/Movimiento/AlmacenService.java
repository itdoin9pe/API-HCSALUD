package com.saludSystem.application.services.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.AlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearAlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarAlmacenDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface AlmacenService extends GenericService<
        AlmacenDTO,
        UUID,
        CrearAlmacenDTO,
        ActualizarAlmacenDTO> {
}