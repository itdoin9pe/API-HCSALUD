package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.TipoPagoResponse;
import com.saludsystem.mantenimiento.application.dto.req.TipoPagoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoPagoService extends GenericService<
        TipoPagoRequest,
        TipoPagoResponse,
        UUID> {
}