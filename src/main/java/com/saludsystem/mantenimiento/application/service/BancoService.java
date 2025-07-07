package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.res.BancoDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearBancoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface BancoService extends GenericService<
        CrearBancoDTO,
        BancoDTO,
        UUID> {
}