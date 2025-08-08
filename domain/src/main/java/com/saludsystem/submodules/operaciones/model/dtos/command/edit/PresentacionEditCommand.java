package com.saludsystem.submodules.operaciones.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PresentacionEditCommand extends BaseDTO {

    private UUID presentacionId;

    private String nombre;

    @Schema(description = "Estado de presentacion", example = "0")
    private Integer estado;
}
