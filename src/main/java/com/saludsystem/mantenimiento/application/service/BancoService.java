package com.saludsystem.mantenimiento.application.service;

import com.saludsystem.mantenimiento.application.dto.get.BancoDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearBancoDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarBancoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface BancoService extends GenericService<
        BancoDTO,
        CrearBancoDTO,
        ActualizarBancoDTO,
        UUID> {
}