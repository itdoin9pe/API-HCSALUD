package com.saludsystem.submodules.catalogo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicamentoDTO {

    private UUID medicamentoId;

    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;

    @Schema(example = "0")
    private Integer estado;

}