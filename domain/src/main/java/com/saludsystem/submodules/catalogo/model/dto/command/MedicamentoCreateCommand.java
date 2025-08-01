package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoCreateCommand {
    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;
    @Schema(example = "0")
    private Integer estado;
}