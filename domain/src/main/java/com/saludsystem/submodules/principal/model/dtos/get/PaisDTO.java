package com.saludsystem.submodules.principal.model.dtos.get;

import com.saludsystem.submodules.principal.model.dtos.post.CrearPaisDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaisDTO extends CrearPaisDTO {

    @Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer paisId;

}