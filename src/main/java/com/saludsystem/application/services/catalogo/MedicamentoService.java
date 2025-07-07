package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.req.MedicamentoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearMedicamentoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface MedicamentoService extends GenericService<
        CrearMedicamentoDTO,
        MedicamentoDTO,
        UUID> {
}