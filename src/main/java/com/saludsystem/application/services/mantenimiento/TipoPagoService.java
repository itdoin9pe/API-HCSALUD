package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.TipoPagoDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTipoPagoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoPagoService extends GenericService<
        CrearTipoPagoDTO,
        TipoPagoDTO,
        UUID> {
}