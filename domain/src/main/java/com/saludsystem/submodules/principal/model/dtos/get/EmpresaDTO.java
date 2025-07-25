package com.saludsystem.submodules.principal.model.dtos.get;

import com.saludsystem.submodules.principal.model.dtos.post.CrearEmpresaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpresaDTO extends CrearEmpresaDTO {

    private UUID empresaId;

    public EmpresaDTO(UUID empresaId, String descripcion, Integer estado) {
        this.setEmpresaId(empresaId);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}