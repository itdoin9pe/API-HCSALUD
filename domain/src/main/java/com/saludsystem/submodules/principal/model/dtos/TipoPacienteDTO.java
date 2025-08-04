package com.saludsystem.submodules.principal.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoPacienteDTO {

    @Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer", defaultValue = "0")
    private Long tipoPacienteId;

    private String nombre;

    public TipoPacienteDTO(Long id, String nombre) {
        this.setTipoPacienteId(id);
        this.setNombre(nombre);
    }

}