package com.saludsystem.submodules.principal.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstudioEditCommand extends BaseDTO {

    private UUID estudioId;

    @Schema(description = "Descripción de estudio educativo", example = "string")
    private String descripcion;

}
