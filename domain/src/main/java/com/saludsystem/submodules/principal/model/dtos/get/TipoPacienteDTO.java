package com.saludsystem.submodules.principal.model.dtos.get;

import com.saludsystem.submodules.principal.model.dtos.post.CrearTipoPacienteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoPacienteDTO extends CrearTipoPacienteDTO {

    @Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer", defaultValue = "0")
    private Long tipoPacienteId;

    public TipoPacienteDTO(Long id, String nombre) {
        this.setTipoPacienteId(id);
        this.setNombre(nombre);
    }

}