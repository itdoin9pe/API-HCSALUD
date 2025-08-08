package com.saludsystem.submodules.principal.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstudioDTO {

    private UUID estudioId;

    @Schema(description = "Descripción de estudios", example = "string")
    private String descripcion;

}