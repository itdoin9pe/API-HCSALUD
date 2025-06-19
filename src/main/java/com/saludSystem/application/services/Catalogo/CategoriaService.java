package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarCategoriaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.CategoriaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearCategoriaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface CategoriaService extends GenericService<CategoriaDTO, UUID,
        CrearCategoriaDTO, ActualizarCategoriaDTO> {
}