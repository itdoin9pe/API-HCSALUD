package com.saludsystem.application.services.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.BancoDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearBancoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface BancoService extends GenericService<
        CrearBancoDTO,
        BancoDTO,
        UUID> {
}