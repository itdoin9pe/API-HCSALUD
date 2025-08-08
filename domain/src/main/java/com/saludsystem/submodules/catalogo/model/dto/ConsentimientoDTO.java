package com.saludsystem.submodules.catalogo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsentimientoDTO {

    private UUID consentimientoId;

    private String nombre;

    private String observacion;

    private String texto;

    @Schema(description = "estado del consentimiento", example = "0")
    private Integer estado;

}