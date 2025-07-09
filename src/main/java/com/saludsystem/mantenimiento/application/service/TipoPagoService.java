package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.get.TipoPagoDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTipoPagoDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTipoPagoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoPagoService extends GenericService<
        TipoPagoDTO,
        CrearTipoPagoDTO,
        ActualizarTipoPagoDTO,
        UUID> {
}