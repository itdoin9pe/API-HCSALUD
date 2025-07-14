package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarCategoriaDTO;
import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.port.in.service.CategoriaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaEditHandler {

    private final CategoriaService categoriaService;

    public CategoriaEditHandler(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public void execute(UUID uuid, ActualizarCategoriaDTO dto) {
        categoriaService.update(uuid, CategoriaMapper.fromUpdateDto(uuid, dto));
    }
}
