package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.get.MedicamentoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearMedicamentoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarMedicamentoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface MedicamentoService extends GenericService<
        MedicamentoDTO,
        CrearMedicamentoDTO,
        ActualizarMedicamentoDTO,
        UUID> {
}