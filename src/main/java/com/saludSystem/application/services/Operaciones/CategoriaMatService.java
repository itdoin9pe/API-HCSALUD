package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarCategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.GET.CategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearCategotiaMatDTO;

import java.util.UUID;

public interface CategoriaMatService extends GenericService<
        CategoriaMatDTO,
        UUID,
        CrearCategotiaMatDTO,
        ActualizarCategoriaMatDTO> {
}