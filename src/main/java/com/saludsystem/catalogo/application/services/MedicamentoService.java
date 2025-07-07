package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.MedicamentoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearMedicamentoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedicamentoService extends GenericService<
        CrearMedicamentoDTO,
        MedicamentoDTO,
        UUID> {
}