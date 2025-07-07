package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TipoPagoDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearTipoPagoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoPagoService extends GenericService<
        CrearTipoPagoDTO,
        TipoPagoDTO,
        UUID> {
}