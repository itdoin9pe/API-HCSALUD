package com.saludsystem.submodules.catalogo.model.dto.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarCategoriaDTO extends BaseDTO {
    private UUID categoriaId;
    private String nombre;

    @Schema(description = "Estado de la Categoria (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}