package com.saludsystem.submodules.principal.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class EmpresaDTO {

    private UUID empresaId;

    private String descripcion;

    @Schema(description = "Estado de la empresa (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

    public EmpresaDTO(UUID empresaId, String descripcion, Integer estado) {
        this.setEmpresaId(empresaId);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}