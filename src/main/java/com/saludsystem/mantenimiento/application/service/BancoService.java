package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.BancoResponse;
import com.saludsystem.mantenimiento.application.dto.req.BancoRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface BancoService extends GenericService<
        BancoRequest,
        BancoResponse,
        UUID> {
}