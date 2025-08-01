package com.saludsystem.submodules.catalogo.model.dto.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AlergiaEditCommand extends BaseDTO {

    private UUID alergiaId;

    private String nombre;

    @Schema(description = "Estado (0=Inactivo, 1=Activo)", example = "1")
    private Integer estado;

}