package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.dtos.post.CrearEmpresaDTO;
import com.saludsystem.submodules.principal.dtos.put.ActualizarEmpresaDTO;

import java.util.UUID;

public class EmpresaMapper {

    public static Empresa fromCreateDto(CrearEmpresaDTO dto) {
        return new Empresa(null, dto.getDescripcion(), dto.getEstado());
    }

    public static Empresa fromUpdateDto(UUID uuid, ActualizarEmpresaDTO dto) {
        return new Empresa(uuid, dto.getDescripcion(), dto.getEstado());
    }

    public static EmpresaDTO toDto(Empresa model) {
        return new EmpresaDTO(
                model.getEmpresaId(),
                model.getDescripcion(),
                model.getEstado());
    }

}
